package com.whereq.common.json.schema.expression;

/**
 * @author Justin Rao
 */
public class ConstraintFunctions {

    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        }

        if (value instanceof String) {
            return ((String) value).isEmpty();
        }

        return false;
    }

    public static String substring(String value, Number start) {
        return substring(value, start, Integer.MAX_VALUE);
    }

    public static String substring(String value, Number start, Number end) {
        if (isEmpty(value)) {
            return "";
        }

        int startInt = start.intValue();
        int endInt = end.intValue();

        if (startInt > value.length()) {
            return "";
        }

        if (endInt > value.length()) {
            return value.substring(startInt);
        }

        return value.substring(startInt, endInt);
    }

    public static boolean matchPattern(Object value, String pattern) {
        String valueStr = value == null ? null : value.toString();
        return valueStr != null && valueStr.matches(pattern);
    }
}
