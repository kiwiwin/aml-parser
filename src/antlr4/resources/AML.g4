grammar AML;

aml: ;

BOOLEAN : 'true' | 'false' ;

INT : DIGIT+ ;

STRING : '"' .*? '"' ;

DOUBLE : DIGIT+ '.' DIGIT*
         |       '.' DIGIT+
         ;

ID : [a-zA-Z_0-9]+ ;

fragment
DIGIT : [0-9] ;