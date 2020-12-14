// Generated from C:/Users/boris/OneDrive/Poèítaè/mAIN 2019-20/Diplomová práca/unityToJava/src/main/antlr4\UnityGrammar.g4 by ANTLR 4.9
package silny7.uniba.sk;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UnityGrammarParser}.
 */
public interface UnityGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(UnityGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(UnityGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#declare_section}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_section(UnityGrammarParser.Declare_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#declare_section}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_section(UnityGrammarParser.Declare_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#declare_component}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_component(UnityGrammarParser.Declare_componentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#declare_component}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_component(UnityGrammarParser.Declare_componentContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#variable_declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration_list(UnityGrammarParser.Variable_declaration_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#variable_declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration_list(UnityGrammarParser.Variable_declaration_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#variableID}.
	 * @param ctx the parse tree
	 */
	void enterVariableID(UnityGrammarParser.VariableIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#variableID}.
	 * @param ctx the parse tree
	 */
	void exitVariableID(UnityGrammarParser.VariableIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBaseType(UnityGrammarParser.BaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBaseType(UnityGrammarParser.BaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterSimpleType(UnityGrammarParser.SimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitSimpleType(UnityGrammarParser.SimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(UnityGrammarParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(UnityGrammarParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#listRange}.
	 * @param ctx the parse tree
	 */
	void enterListRange(UnityGrammarParser.ListRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#listRange}.
	 * @param ctx the parse tree
	 */
	void exitListRange(UnityGrammarParser.ListRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#rangeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRangeDeclaration(UnityGrammarParser.RangeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#rangeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRangeDeclaration(UnityGrammarParser.RangeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#rangeElement}.
	 * @param ctx the parse tree
	 */
	void enterRangeElement(UnityGrammarParser.RangeElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#rangeElement}.
	 * @param ctx the parse tree
	 */
	void exitRangeElement(UnityGrammarParser.RangeElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#always_section}.
	 * @param ctx the parse tree
	 */
	void enterAlways_section(UnityGrammarParser.Always_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#always_section}.
	 * @param ctx the parse tree
	 */
	void exitAlways_section(UnityGrammarParser.Always_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#initially_section}.
	 * @param ctx the parse tree
	 */
	void enterInitially_section(UnityGrammarParser.Initially_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#initially_section}.
	 * @param ctx the parse tree
	 */
	void exitInitially_section(UnityGrammarParser.Initially_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#assign_section}.
	 * @param ctx the parse tree
	 */
	void enterAssign_section(UnityGrammarParser.Assign_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#assign_section}.
	 * @param ctx the parse tree
	 */
	void exitAssign_section(UnityGrammarParser.Assign_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void enterStatement_list(UnityGrammarParser.Statement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void exitStatement_list(UnityGrammarParser.Statement_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(UnityGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(UnityGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_statement(UnityGrammarParser.Assignment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_statement(UnityGrammarParser.Assignment_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#assign_component}.
	 * @param ctx the parse tree
	 */
	void enterAssign_component(UnityGrammarParser.Assign_componentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#assign_component}.
	 * @param ctx the parse tree
	 */
	void exitAssign_component(UnityGrammarParser.Assign_componentContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#enumerated_assignment}.
	 * @param ctx the parse tree
	 */
	void enterEnumerated_assignment(UnityGrammarParser.Enumerated_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#enumerated_assignment}.
	 * @param ctx the parse tree
	 */
	void exitEnumerated_assignment(UnityGrammarParser.Enumerated_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#variable_list}.
	 * @param ctx the parse tree
	 */
	void enterVariable_list(UnityGrammarParser.Variable_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#variable_list}.
	 * @param ctx the parse tree
	 */
	void exitVariable_list(UnityGrammarParser.Variable_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#simple_expression_list}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expression_list(UnityGrammarParser.Simple_expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#simple_expression_list}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expression_list(UnityGrammarParser.Simple_expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#conditional_expression_list}.
	 * @param ctx the parse tree
	 */
	void enterConditional_expression_list(UnityGrammarParser.Conditional_expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#conditional_expression_list}.
	 * @param ctx the parse tree
	 */
	void exitConditional_expression_list(UnityGrammarParser.Conditional_expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#quantified_statement}.
	 * @param ctx the parse tree
	 */
	void enterQuantified_statement(UnityGrammarParser.Quantified_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#quantified_statement}.
	 * @param ctx the parse tree
	 */
	void exitQuantified_statement(UnityGrammarParser.Quantified_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#quantified_assignment}.
	 * @param ctx the parse tree
	 */
	void enterQuantified_assignment(UnityGrammarParser.Quantified_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#quantified_assignment}.
	 * @param ctx the parse tree
	 */
	void exitQuantified_assignment(UnityGrammarParser.Quantified_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#quantification}.
	 * @param ctx the parse tree
	 */
	void enterQuantification(UnityGrammarParser.QuantificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#quantification}.
	 * @param ctx the parse tree
	 */
	void exitQuantification(UnityGrammarParser.QuantificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(UnityGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(UnityGrammarParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(UnityGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(UnityGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#simple_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_value_expression(UnityGrammarParser.Simple_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#simple_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_value_expression(UnityGrammarParser.Simple_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#relational_operator_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational_operator_expression(UnityGrammarParser.Relational_operator_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#relational_operator_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational_operator_expression(UnityGrammarParser.Relational_operator_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#complex_relational_operator_expression}.
	 * @param ctx the parse tree
	 */
	void enterComplex_relational_operator_expression(UnityGrammarParser.Complex_relational_operator_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#complex_relational_operator_expression}.
	 * @param ctx the parse tree
	 */
	void exitComplex_relational_operator_expression(UnityGrammarParser.Complex_relational_operator_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_expression(UnityGrammarParser.Boolean_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_expression(UnityGrammarParser.Boolean_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#add_minus_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd_minus_or_expression(UnityGrammarParser.Add_minus_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#add_minus_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd_minus_or_expression(UnityGrammarParser.Add_minus_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#mul_div_mod_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterMul_div_mod_and_expression(UnityGrammarParser.Mul_div_mod_and_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#mul_div_mod_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitMul_div_mod_and_expression(UnityGrammarParser.Mul_div_mod_and_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#power_expression}.
	 * @param ctx the parse tree
	 */
	void enterPower_expression(UnityGrammarParser.Power_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#power_expression}.
	 * @param ctx the parse tree
	 */
	void exitPower_expression(UnityGrammarParser.Power_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(UnityGrammarParser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(UnityGrammarParser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(UnityGrammarParser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(UnityGrammarParser.Primary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(UnityGrammarParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(UnityGrammarParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#expressionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExpressionDeclaration(UnityGrammarParser.ExpressionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#expressionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExpressionDeclaration(UnityGrammarParser.ExpressionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#quantificationDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterQuantificationDeclaration(UnityGrammarParser.QuantificationDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#quantificationDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitQuantificationDeclaration(UnityGrammarParser.QuantificationDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#elementListDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterElementListDeclaration(UnityGrammarParser.ElementListDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#elementListDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitElementListDeclaration(UnityGrammarParser.ElementListDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(UnityGrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(UnityGrammarParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#element_list}.
	 * @param ctx the parse tree
	 */
	void enterElement_list(UnityGrammarParser.Element_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#element_list}.
	 * @param ctx the parse tree
	 */
	void exitElement_list(UnityGrammarParser.Element_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational_operator(UnityGrammarParser.Relational_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational_operator(UnityGrammarParser.Relational_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#add_minus_or_operator}.
	 * @param ctx the parse tree
	 */
	void enterAdd_minus_or_operator(UnityGrammarParser.Add_minus_or_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#add_minus_or_operator}.
	 * @param ctx the parse tree
	 */
	void exitAdd_minus_or_operator(UnityGrammarParser.Add_minus_or_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#times_div_mod_and_operator}.
	 * @param ctx the parse tree
	 */
	void enterTimes_div_mod_and_operator(UnityGrammarParser.Times_div_mod_and_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#times_div_mod_and_operator}.
	 * @param ctx the parse tree
	 */
	void exitTimes_div_mod_and_operator(UnityGrammarParser.Times_div_mod_and_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(UnityGrammarParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(UnityGrammarParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#quantification_operator}.
	 * @param ctx the parse tree
	 */
	void enterQuantification_operator(UnityGrammarParser.Quantification_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#quantification_operator}.
	 * @param ctx the parse tree
	 */
	void exitQuantification_operator(UnityGrammarParser.Quantification_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(UnityGrammarParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(UnityGrammarParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(UnityGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(UnityGrammarParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link UnityGrammarParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(UnityGrammarParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link UnityGrammarParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(UnityGrammarParser.BooleanValueContext ctx);
}