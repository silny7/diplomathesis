/*
* author: boris.silny
*/

grammar UnityGrammar;


/*
* section PARSER RULES
*/

program : PROGRAM program_name=text?
              declare_section?
              always_section?
              initially_section?
              assign_section
          END;

//declare section:
declare_section: DECLARE COLON? declare_component+;

declare_component: variable_declaration_list COLON baseType (SEMI_COLON | COMMA)?;

variable_declaration_list: variableID (COMMA variableID)*;

variableID: variableName=IDENTIFIER;

baseType: simpleType | arrayType;

simpleType : BOOLEAN | INTEGER;
arrayType  : ARRAY OPEN_BRACKET listRange CLOSE_BRACKET OF arrayType |
             ARRAY OPEN_BRACKET listRange CLOSE_BRACKET OF simpleType;

listRange: range=rangeDeclaration (COMMA range=rangeDeclaration)*;

rangeDeclaration: rangeElement DOUBLE_DOT rangeElement;

//range element in [x..x] may be INT, or VARIABLE
rangeElement: expression;


//other sections:
always_section: ALWAYS COLON? statement_list;
initially_section: INITIALLY COLON? statement_list;
assign_section: ASSIGN COLON? statement_list;

//statement definition
statement_list: statement (NONDETERM_SEPARATOR statement)*;

statement: assignment_statement | quantified_statement;


//ASSIGNMENT STATEMENT
assignment_statement: assign_component (DETERM_SEPARATOR assign_component)*;

assign_component: enumerated_assignment | quantified_assignment;

//always section + innitially section uses = sign, assign_section uses := sign
enumerated_assignment: variable_list (ASSIGN_SIGN | EQUAL) (simple_expression_list | conditional_expression_list);

quantified_assignment: QUANTIFICATION_OPEN DETERM_SEPARATOR quantification assignment_statement QUANTIFICATION_CLOSE;


variable_list: variable |
               (variable COMMA variable_list);

simple_expression_list: expression |
                        (expression COMMA simple_expression_list);


conditional_expression_list: simple_expression_list IF boolean_expression (TILDE simple_expression_list IF boolean_expression)*;


//QUANTIFIED STATEMENT

quantified_statement: QUANTIFICATION_OPEN NONDETERM_SEPARATOR quantification statement_list QUANTIFICATION_CLOSE;

quantification: variable_list COLON boolean_expression DOUBLE_COLON;

//VARIABLE, EXPRESSION
variable: variableID | (variableID OPEN_BRACKET simple_expression_list CLOSE_BRACKET);

//three types:
//VALUE (may be variable, constant or mathematical expression)
//VALUE RELATIONAL_OPERATOR VALUE
//VALUE RELATIONAL_OPERATOR VALUE RELATIONAL_OPERATOR (e.g. 1 <= x <= N)
expression: simple_value_expression |
            relational_operator_expression |
            complex_relational_operator_expression;

simple_value_expression: add_minus_or_expression;
relational_operator_expression: add_minus_or_expression relational_operator add_minus_or_expression;
complex_relational_operator_expression: add_minus_or_expression relational_operator add_minus_or_expression relational_operator add_minus_or_expression (relational_operator add_minus_or_expression)?;


boolean_expression: expression;

add_minus_or_expression: (mul_div_mod_and_expression add_minus_or_operator add_minus_or_expression) | mul_div_mod_and_expression;

mul_div_mod_and_expression: (power_expression times_div_mod_and_operator mul_div_mod_and_expression) | power_expression;

power_expression: (unary_expression POWER power_expression) | unary_expression;

unary_expression: (unary_operator unary_expression) | primary_expression;

primary_expression: variable |
                    booleanValue  |
                    number  |
                    methodDeclaration |
                    expressionDeclaration |
                    quantificationDeclaration |
                    elementListDeclaration;

//methodName(inputArgs);
methodDeclaration: function OPEN_PARENTHESES simple_expression_list? CLOSE_PARENTHESES;

expressionDeclaration: OPEN_PARENTHESES expression CLOSE_PARENTHESES;

quantificationDeclaration: QUANTIFICATION_OPEN quantification_operator quantification expression QUANTIFICATION_CLOSE;

elementListDeclaration: OPEN_BRACKET element_list CLOSE_BRACKET;

//className.methodName ....
function: text (DOT text)*;

element_list: simple_expression_list?;


//OPERATORS
relational_operator: LESS_THAN | GREATER_THAN | LESS_OR_EQUAL | GREATER_OR_EQUAL | EQUAL | NOT_EQUAL;
add_minus_or_operator: PLUS | MINUS | OR ;
times_div_mod_and_operator: TIMES | DIV | MOD | AND;
unary_operator: PLUS | MINUS | NOT;
quantification_operator: function | PLUS | TIMES | AND | OR;

text                    : STRING |
                          IDENTIFIER;

number                  : INT;

booleanValue : BOOL;


/*
* section LEXER RULES
*/

//PROGRAM KEYWORDS
PROGRAM :   'PROGRAM'   | 'program' | 'Program';
DECLARE :   'DECLARE'   | 'declare';
ALWAYS  :   'ALWAYS'    | 'always';
INITIALLY:  'INITIALLY' | 'initially';
ASSIGN  :   'ASSIGN'    | 'assign';
END     :   'END'       | 'end';
BOOLEAN :   'BOOLEAN'   | 'boolean';
INTEGER :   'INTEGER'   | 'integer';
ARRAY   :   'ARRAY'     | 'array';
OF      :   'OF'        | 'of';
IF      :   'IF'        | 'if';


//SIGNS:
COLON : ':';
DOUBLE_COLON : '::';
SEMI_COLON : ';';
COMMA : ',';
OPEN_PARENTHESES: '(';
CLOSE_PARENTHESES: ')';
OPEN_BRACKET: '[';
CLOSE_BRACKET:']';
DOT: '.';
DOUBLE_DOT : '..';
NONDETERM_SEPARATOR: '[]';
DETERM_SEPARATOR: '||';
QUANTIFICATION_OPEN: '<<';
QUANTIFICATION_CLOSE: '>>';
ASSIGN_SIGN: ':=';
TILDE: '~';


//MATH SIGNS AND KEYWORDS
LESS_THAN : '<';
GREATER_THAN : '>';
LESS_OR_EQUAL : '<=';
GREATER_OR_EQUAL : '>=';
EQUAL : '=';
NOT_EQUAL : '!=';
AND : 'AND' | 'and';
OR  : 'OR'  | 'or';
NOT : 'NOT' | 'not';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/' | 'DIV' | 'div';
POWER: '^';
MOD: 'MOD' | 'mod' | '%';




fragment DIGIT		: '0'..'9' ;
fragment LETTER	: 'a'..'z' | 'A'..'Z' | '_' ;

INT                     : DIGIT+;
BOOL                    : 'true' | 'false' | 'TRUE' | 'FALSE';
IDENTIFIER              : LETTER (LETTER | DIGIT)*;

//whitespace
WS                      : [ \t\r\n]+ -> skip;

//code comments
//format: -- for inline comment
LINE_COMMENT            : '--' ~( '\r' | '\n' )* -> skip;
// /*
// // block comment
// */
BLOCK_COMMENT           : '/*' .*? '*/' -> skip;

STRING                  : '"' (ESC | .)*? '"';
fragment ESC            : '\\' [btnr"\\] ;