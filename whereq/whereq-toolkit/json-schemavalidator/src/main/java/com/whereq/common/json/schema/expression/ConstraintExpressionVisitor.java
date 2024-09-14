package com.whereq.common.json.schema.expression;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.whereq.common.json.schema.expression.ConstraintExprParser.AddRuleContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.AndRuleContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.ArgumentsContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.ArrayContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.BooleanTermContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.ComparisonRuleContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.Constraint_expressionContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.DatapathContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.DatapathTermContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.Datapath_elementContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.EqualRuleContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.ExpressionContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.FunctionContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.FunctionTermContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.InRuleContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.MultRuleContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.NumberTermContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.OptionpathContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.OptionpathTermContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.OrRuleContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.ParenTermContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.StringTermContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.TenaryRuleContext;
import com.whereq.common.json.schema.expression.ConstraintExprParser.UnaryRuleContext;

public class ConstraintExpressionVisitor extends ConstraintExprBaseVisitor<Object> {
    private static final Pattern pattern = Pattern.compile("^([a-zA-Z0-9$_]+)\\[([0-9\\s]*)\\]$");
    private JsonNode data;
    private String path;

    public ConstraintExpressionVisitor(JsonNode data, String path) {
        this.data = data;
        this.path = path;
    }

    public static final Map<String, Method> CONSTRAINT_FUNCTION_MAP = new HashMap<String, Method>();

    static {
        for (Method func : ConstraintFunctions.class.getMethods()) {
            CONSTRAINT_FUNCTION_MAP.put(func.getName() + '_' + func.getParameterTypes().length, func);
        }
    }

    @Override
    public Object visitFunction(FunctionContext ctx) {

        String methodName = ctx.IDENT().getText();

        Object[] args = visitArguments(ctx.arguments());

        Method func = CONSTRAINT_FUNCTION_MAP.get(methodName + "_" + args.length);

        if (func != null) {
            // for static methods we can use null as instance of class
            try {
                return func.invoke(null, args);
            } catch (Exception e) {
                throw new IllegalArgumentException(ctx.getText());
            }
        }

        throw new IllegalArgumentException("Method not found: " + methodName + " - " + ctx.getText());
    }

    @Override
    public Object visitDatapath(DatapathContext ctx) {
        return visitDatapath("", ctx);
    }

    private Object visitDatapath(String prefix, DatapathContext ctx) {
        String path = prefix;
        for (int i = 0; i < ctx.getChildCount(); i += 2) {
            path = path + (i > 0 ? "." : "") + visit(ctx.getChild(i));
        }
        String[] parts = path.split("\\.");
        JsonNode result = data;
        for (int i = 0; i < parts.length; i++) {
            Matcher m1 = pattern.matcher(parts[i]);
            if (m1.find()) {
                String key = m1.group(1);
                String idxstr = StringUtils.trim(m1.group(2));
                int idx = -1;
                if (StringUtils.isNotBlank(idxstr)) {
                    idx = Integer.parseInt(idxstr);
                } else {
                    Pattern pattern = Pattern.compile(key + "\\[(.*?)\\]");
                    Matcher matcher = pattern.matcher(this.path);
                    if (matcher.find()) {
                        idx = Integer.parseInt(matcher.group(1));
                    }
                }
                result = result.get(key).get(idx);
            } else {
                result = result.get(parts[i]);
            }
            if (result == null) {
                return null;
            }

        }
        if (result.isBoolean()) {
            return result.asBoolean();
        } else if (result.isNumber()) {
            return result.asDouble();
        } else if (result.isTextual()) {
            return result.asText();
        }
        throw new IllegalArgumentException(ctx.getText());
    }

    @Override
    public Object visitDatapath_element(Datapath_elementContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitConstraint_expression(Constraint_expressionContext ctx) {
        Object result = visit(ctx.getChild(0));
        if (result instanceof Boolean) {
            return result;
        } else {
            throw new IllegalArgumentException(ctx.toStringTree());
        }
    }

    @Override
    public Object visitArray(ArrayContext ctx) {
        Set<Object> result = new HashSet<Object>();
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            result.add(visit(ctx.getChild(i)));
        }
        return result;
    }

    @Override
    public Object[] visitArguments(ArgumentsContext ctx) {
        List<Object> argList = new ArrayList<Object>();
        for (ExpressionContext expressionContext : ctx.expression()) {
            argList.add(visitExpression(expressionContext));
        }
        return argList.toArray(new Object[argList.size()]);
    }

    @Override
    public Object visitNumberTerm(NumberTermContext ctx) {
        return Double.parseDouble(ctx.getChild(0).getText());
    }

    @Override
    public Object visitFunctionTerm(FunctionTermContext ctx) {
        // TODO Auto-generated method stub
        return super.visitFunctionTerm(ctx);
    }

    @Override
    public Object visitDatapathTerm(DatapathTermContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Object visitParenTerm(ParenTermContext ctx) {
        return visit(ctx.getChild(1));
    }

    @Override
    public Object visitStringTerm(StringTermContext ctx) {
        String text = ctx.getChild(0).getText();
        return text.substring(1, text.length() - 1);
    }

    @Override
    public Object visitBooleanTerm(BooleanTermContext ctx) {
        return "true".equals(ctx.getChild(0).getText());
    }

    @Override
    public Object visitUnaryRule(UnaryRuleContext ctx) {
        String operator = ctx.getChild(0).getText();
        Object right = visit(ctx.getChild(1));
        if ("!".equals(operator)) {
            if (right instanceof Boolean) {
                return !((Boolean) right);
            } else {
                throw new IllegalArgumentException(ctx.toStringTree());
            }
        } else if ("+".equals(operator)) {
            if (right instanceof Double) {
                return (Double) right;
            } else {
                throw new IllegalArgumentException(ctx.toStringTree());
            }
        } else {
            if (right instanceof Double) {
                return -((Double) right);
            } else {
                throw new IllegalArgumentException(ctx.toStringTree());
            }
        }
    }

    @Override
    public Object visitTenaryRule(TenaryRuleContext ctx) {
        Object cond = visit(ctx.getChild(0));
        Object val1 = visit(ctx.getChild(2));
        Object val2 = visit(ctx.getChild(4));
        if (cond instanceof Boolean) {
            if ((Boolean) cond) {
                return val1;
            } else {
                return val2;
            }
        } else {
            throw new IllegalArgumentException(ctx.toStringTree());
        }
    }

    @Override
    public Object visitComparisonRule(ComparisonRuleContext ctx) {
        String operator = ctx.getChild(1).getText();
        Object left = visit(ctx.getChild(0));
        Object right = visit(ctx.getChild(2));
        if (left instanceof String && right instanceof String) {
            String left1 = (String) left;
            String right1 = (String) right;
            if (">".equals(operator)) {
                return left1.compareTo(right1) > 0;
            } else if (">=".equals(operator)) {
                return left1.compareTo(right1) >= 0;
            } else if ("<".equals(operator)) {
                return left1.compareTo(right1) < 0;
            } else {
                return left1.compareTo(right1) >= 0;
            }
        } else if (left instanceof Double && right instanceof Double) {
            Double left1 = (Double) left;
            Double right1 = (Double) right;
            if (">".equals(operator)) {
                return left1 > right1;
            } else if (">=".equals(operator)) {
                return left1 >= right1;
            } else if ("<".equals(operator)) {
                return left1 < right1;
            } else {
                return left1 <= right1;
            }
        } else {
            throw new IllegalArgumentException(ctx.toStringTree());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object visitInRule(InRuleContext ctx) {
        Object left = visit(ctx.getChild(0));
        Set<Object> set = (Set<Object>) visit(ctx.getChild(2));
        return set.contains(left);
    }

    @Override
    public Object visitMultRule(MultRuleContext ctx) {
        Object result = visit(ctx.getChild(0));
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            Object right = visit(ctx.getChild(i + 1));
            String operator = ctx.getChild(i).getText();
            if (result instanceof Number && right instanceof Number) {
                Double left1 = (Double) result;
                Double right1 = (Double) right;
                if ("*".equals(operator)) {
                    result = left1 * right1;
                } else {
                    result = left1 / right1;
                }
            } else {
                throw new IllegalArgumentException(ctx.toStringTree());
            }
        }
        return result;
    }

    @Override
    public Object visitExpression(ExpressionContext ctx) {
        // TODO Auto-generated method stub
        return super.visitExpression(ctx);
    }

    @Override
    public Object visitOrRule(OrRuleContext ctx) {
        Object result = visit(ctx.getChild(0));
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            Object right = visit(ctx.getChild(i + 1));
            if (result instanceof Boolean && right instanceof Boolean) {
                Boolean left1 = (Boolean) result;
                Boolean right1 = (Boolean) right;
                result = left1 || right1;
            } else {
                throw new IllegalArgumentException(ctx.toStringTree());
            }
        }
        return result;
    }

    @Override
    public Object visitAndRule(AndRuleContext ctx) {
        Object result = visit(ctx.getChild(0));
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            Object right = visit(ctx.getChild(i + 1));
            if (result instanceof Boolean && right instanceof Boolean) {
                Boolean left1 = (Boolean) result;
                Boolean right1 = (Boolean) right;
                result = left1 && right1;
            } else {
                throw new IllegalArgumentException(ctx.toStringTree());
            }
        }
        return result;
    }

    @Override
    public Object visitEqualRule(EqualRuleContext ctx) {
        Object left = visit(ctx.getChild(0));
        Object right = visit(ctx.getChild(2));
        String oeprator = ctx.getChild(1).getText();
        if (left instanceof Double && right instanceof Double) {
            double delta = Math.abs((Double) left - (Double) right);
            if ("==".equals(oeprator)) {
                return delta < 1e-12;
            } else {
                return delta >= 1e-12;
            }
        } else if (left instanceof String && right instanceof String) {
            if ("==".equals(oeprator)) {
                return ((String) left).equals(right);
            } else {
                return !((String) left).equals(right);
            }
        } else if (left instanceof Boolean && right instanceof Boolean) {
            if ("==".equals(oeprator)) {
                return (Double) left == (Double) right;
            } else {
                return (Double) left != (Double) right;
            }
        } else {
            throw new IllegalArgumentException(ctx.toStringTree());
        }
    }

    @Override
    public Object visitAddRule(AddRuleContext ctx) {
        Object result = visit(ctx.getChild(0));
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            Object right = visit(ctx.getChild(i + 1));
            String operator = ctx.getChild(i).getText();
            if (result instanceof Number && right instanceof Number) {
                Double left1 = (Double) result;
                Double right1 = (Double) right;
                if ("+".equals(operator)) {
                    result = left1 + right1;
                } else {
                    result = left1 - right1;
                }
            } else if (result instanceof String && right instanceof String && "+".equals(operator)) {
                return (String) result + (String) right;
            } else {
                throw new IllegalArgumentException(ctx.toStringTree());
            }
        }
        return result;
    }

    @Override
    public Object visitOptionpath(OptionpathContext ctx) {
        return visitDatapath("#", (DatapathContext) ctx.getChild(1));
    }

    @Override
    public Object visitOptionpathTerm(OptionpathTermContext ctx) {
        return visit(ctx.getChild(0));
    }

}
