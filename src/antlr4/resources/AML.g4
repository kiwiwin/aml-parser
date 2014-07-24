grammar AML;

aml: ;


product : 'puid' puid 'extends' productType '{'
            productProperty+
        '}';

puid : INT ;

productType : ID ;

productProperty : productPropertyKey '=' STRING ';' ;

productPropertyKey : ID ;


BOOLEAN : 'true' | 'false' ;

COLOR : 'Black' | 'Gray' | 'Orange' | 'Green' | 'Blue' | 'Yellow' ;

INT : DIGIT+ ;

STRING : '"' .*? '"' ;

DOUBLE : DIGIT+ '.' DIGIT*
         |       '.' DIGIT+
         ;

WS : [ \t\r\n]+ -> skip ;

ID : [a-zA-Z_0-9]+ ;

fragment
DIGIT : [0-9] ;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;