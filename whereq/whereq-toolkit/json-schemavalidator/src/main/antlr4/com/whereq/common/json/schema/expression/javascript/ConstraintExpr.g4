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
  : or ('?' or ':' or)?
  ;

or
  : and ('||' and)*
  ;

and
  : equal ('&&' equal)*
  ;

equal
  : relation (('==' | '!=') relation)?
  ;

relation
  : add (('<' | '<=' | '>' | '>=' ) add)? (IN_OPERATOR array)?
  ;

add
  : mult (('+' | '-') mult)*
  ;

mult
  : unary (('*' | '/') unary)*
  ;

unary
  : ('!' | '+' | '-')? term
  ;

term
  : datapath
  | optionpath
  | '(' expression ')'
  | INTEGER
  | FLOAT
  | BOOLEAN
  | STRING
  | function
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
  : IDENT ('[' INTEGER ']')?
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
