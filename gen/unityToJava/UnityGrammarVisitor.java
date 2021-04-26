// Generated from C:/Users/boris/OneDrive/Po��ta�/mAIN 2019-20/Diplomov� pr�ca/unityToJava/src/main/antlr4\UnityGrammar.g4 by ANTLR 4.9
package unityToJava;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UnityGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UnityGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(UnityGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#declare_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_section(UnityGrammarParser.Declare_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#declare_component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_component(UnityGrammarParser.Declare_componentContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#variable_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration_list(UnityGrammarParser.Variable_declaration_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#variableID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableID(UnityGrammarParser.VariableIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(UnityGrammarParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleType(UnityGrammarParser.SimpleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(UnityGrammarParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#listRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListRange(UnityGrammarParser.ListRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#rangeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeDeclaration(UnityGrammarParser.RangeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#rangeElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeElement(UnityGrammarParser.RangeElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#always_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlways_section(UnityGrammarParser.Always_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#initially_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitially_section(UnityGrammarParser.Initially_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#assign_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_section(UnityGrammarParser.Assign_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_list(UnityGrammarParser.Statement_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(UnityGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#assignment_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_statement(UnityGrammarParser.Assignment_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#assign_component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_component(UnityGrammarParser.Assign_componentContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#enumerated_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerated_assignment(UnityGrammarParser.Enumerated_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#variable_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_list(UnityGrammarParser.Variable_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#simple_expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_expression_list(UnityGrammarParser.Simple_expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#conditional_expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_expression_list(UnityGrammarParser.Conditional_expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#quantified_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantified_statement(UnityGrammarParser.Quantified_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#quantified_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantified_assignment(UnityGrammarParser.Quantified_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#quantification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantification(UnityGrammarParser.QuantificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(UnityGrammarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(UnityGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#simple_value_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_value_expression(UnityGrammarParser.Simple_value_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#relational_operator_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_operator_expression(UnityGrammarParser.Relational_operator_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#complex_relational_operator_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplex_relational_operator_expression(UnityGrammarParser.Complex_relational_operator_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#boolean_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_expression(UnityGrammarParser.Boolean_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#add_minus_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_minus_or_expression(UnityGrammarParser.Add_minus_or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#mul_div_mod_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul_div_mod_and_expression(UnityGrammarParser.Mul_div_mod_and_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#power_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower_expression(UnityGrammarParser.Power_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expression(UnityGrammarParser.Unary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_expression(UnityGrammarParser.Primary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(UnityGrammarParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#expressionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionDeclaration(UnityGrammarParser.ExpressionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#quantificationDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantificationDeclaration(UnityGrammarParser.QuantificationDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#elementListDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementListDeclaration(UnityGrammarParser.ElementListDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(UnityGrammarParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#element_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_list(UnityGrammarParser.Element_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#relational_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_operator(UnityGrammarParser.Relational_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#add_minus_or_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_minus_or_operator(UnityGrammarParser.Add_minus_or_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#times_div_mod_and_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimes_div_mod_and_operator(UnityGrammarParser.Times_div_mod_and_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator(UnityGrammarParser.Unary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#quantification_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantification_operator(UnityGrammarParser.Quantification_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(UnityGrammarParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(UnityGrammarParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link UnityGrammarParser#booleanValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(UnityGrammarParser.BooleanValueContext ctx);
}