grammar ConstraintExpr;

options {
}

constraint_expression
  : expression
  ;

expression
  : cond
  ;

cond
  : or #condPassthrough
  | or '?' or ':' or #tenaryRule
  ;

or
  : and #orPassthrough
  | and ('||' and)+ #orRule
  ;

and
  : equal #andPassthrough
  | equal ('&&' equal)+ #andRule
  ;

equal
  : relation #equalPassthrough
  | relation ('==' | '!=') relation #equalRule
  ;

relation
  : add #relationPassthrough
  | add ('<' | '<=' | '>' | '>=' ) add # comparisonRule
  | add IN_OPERATOR array # inRule
  ;

add
  : mult #addPassthrough
  | mult (('+' | '-') mult)+ #addRule
  ;

mult
  : unary #multPassthrough
  | unary (('*' | '/') unary)+ #multRule
  ;

unary
  : term #unaryPassthrough
  | ('!' | '+' | '-') term #unaryRule
  ;

term
  : datapath #datapathTerm
  | optionpath #optionpathTerm
  | '(' expression ')' #parenTerm
  | INTEGER #numberTerm
  | FLOAT #numberTerm
  | BOOLEAN #booleanTerm
  | STRING #stringTerm
  | function #functionTerm
  ;

array
  : '[' expression (',' expression)* ']'
  ;

function
  : '#' IDENT arguments
  ;

arguments
  : '(' ( expression (',' expression)*)? ')'
  ;

datapath
  : datapath_element ('.' datapath_element )*
  ;

datapath_element
  : IDENT ('[' (INTEGER)?  ']')?
  ;

optionpath
  : '#' datapath
  ;


fragment LETTER : ('a'..'z' | 'A'..'Z');
fragment DIGIT : '0'..'9';
fragment QUOTE : '\'';
IN_OPERATOR : 'in';
BOOLEAN: ('true' | 'false');
IDENT : LETTER (LETTER | DIGIT)*;
INTEGER : DIGIT+;
FLOAT : INTEGER '.' INTEGER;
STRING: QUOTE .*? QUOTE;
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ -> skip;
