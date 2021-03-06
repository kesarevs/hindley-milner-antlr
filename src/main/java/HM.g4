// Define a grammar called HM
grammar HM;
expr : '(' expr ')' # Parenthesis
     | 'let' ID '=' expr 'in' expr  # Let
     | expr expr    # App
     | ID   # Var
     | '\\' ID '.' expr    # Abs
     ;
ID : ID_LETTER (ID_LETTER | DIGIT)* ;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

fragment DIGIT : [0-9] ;
fragment ID_LETTER : [a-zA-Z] ;