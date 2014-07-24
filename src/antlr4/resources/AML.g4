grammar AML;

aml:  object* ;

object : qualifier objectId 'extends' objectClass '{'
            property+
        '}';

qualifier : ID ;

objectId : INT | ID ;

objectClass : ID ;


property : propertyKey '=' propertyValue ';' ;

propertyKey : ID ;

propertyValue : value | array ;


array : value (',' value)* ;

value : STRING | INT | COLOR | DOUBLE ;


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