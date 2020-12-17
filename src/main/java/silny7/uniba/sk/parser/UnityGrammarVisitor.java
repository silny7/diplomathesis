package silny7.uniba.sk.parser;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import silny7.uniba.sk.UnityGrammarBaseVisitor;
import silny7.uniba.sk.UnityGrammarParser;
import silny7.uniba.sk.parser.exceptions.InvalidExpressionException;
import silny7.uniba.sk.parser.exceptions.InvalidOperatorException;
import silny7.uniba.sk.parser.exceptions.InvalidStatementException;
import silny7.uniba.sk.parser.exceptions.InvalidVariableTypeException;
import silny7.uniba.sk.unity.UnityProgram;
import silny7.uniba.sk.unity.expressions.*;
import silny7.uniba.sk.unity.expressions.operators.BinaryOperator;
import silny7.uniba.sk.unity.expressions.UnaryExpression;
import silny7.uniba.sk.unity.expressions.operators.UnaryOperator;
import silny7.uniba.sk.unity.sections.AlwaysSection;
import silny7.uniba.sk.unity.sections.AssignSection;
import silny7.uniba.sk.unity.sections.DeclareSection;
import silny7.uniba.sk.unity.sections.InitiallySection;
import silny7.uniba.sk.unity.statements.*;
import silny7.uniba.sk.unity.variables.*;

import java.util.ArrayList;
import java.util.List;

public class UnityGrammarVisitor extends UnityGrammarBaseVisitor {

    private final List<UnityGrammarError> errors = new ArrayList();

    public List<UnityGrammarError> getErrors() { return errors; }
    public boolean hasErrors() { return !errors.isEmpty(); }

    public UnityGrammarVisitor(){
    }

    public UnityProgram transform(ParseTree pt){

            return (UnityProgram) visit(pt);
    }

    @Override
    public Object visitProgram(UnityGrammarParser.ProgramContext ctx) {
        UnityProgram unityProgram = UnityProgram.getUnityProgram();

        if (ctx.program_name != null) unityProgram.setProgramName(visitText(ctx.program_name));

        if (ctx.declare_section() != null) unityProgram.setDeclareSection(visitDeclare_section(ctx.declare_section()));
        if (ctx.always_section() != null) unityProgram.setAlwaysSection(visitAlways_section(ctx.always_section()));
        if (ctx.initially_section() != null) unityProgram.setInitiallySection(visitInitially_section(ctx.initially_section()));

        unityProgram.setAssignSection(visitAssign_section(ctx.assign_section()));

        return unityProgram;
    }

//region declare section

    @Override
    public DeclareSection visitDeclare_section(UnityGrammarParser.Declare_sectionContext ctx){
        DeclareSection declareSection = new DeclareSection();
        for (UnityGrammarParser.Declare_componentContext dcContext : ctx.declare_component()) {
            VariableDeclaration variableDeclaration = visitDeclare_component(dcContext);
            declareSection.add(variableDeclaration);
        }

        return declareSection;
    }

    @Override
    public VariableDeclaration visitDeclare_component(UnityGrammarParser.Declare_componentContext ctx){
        //format:
        //variable, variable : variable_type
        //return List<Variable> -> each will have type included in this declareComponent
        List<DeclaredVariable> variables = visitVariable_declaration_list(ctx.variable_declaration_list());
        BaseType baseType = visitBaseType(ctx.baseType());

        return new VariableDeclaration(variables, baseType);
    }

    @Override
    public List<DeclaredVariable> visitVariable_declaration_list(UnityGrammarParser.Variable_declaration_listContext ctx) {
        List<DeclaredVariable> variables = new ArrayList<DeclaredVariable>();
        for (UnityGrammarParser.VariableIDContext variableIDContext : ctx.variableID()){
            variables.add(new DeclaredVariable(visitVariableID(variableIDContext)));
        }
        return variables;
    }

    @Override
    public String visitVariableID(UnityGrammarParser.VariableIDContext ctx) {
        return ctx.variableName.getText();
    }

    @Override
    public BaseType visitBaseType(UnityGrammarParser.BaseTypeContext ctx) {
        if (ctx.simpleType() != null) {
            return visitSimpleType(ctx.simpleType());
        }

        if (ctx.arrayType() != null){
            return visitArrayType(ctx.arrayType());
        }

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid variable type"));
        throw new ParseCancellationException(new InvalidVariableTypeException(ctx.getText()));
    }

    @Override
    public BaseType visitSimpleType(UnityGrammarParser.SimpleTypeContext ctx){
        if (ctx.BOOLEAN() != null) {
            SimpleType simpleType = new SimpleType();
            simpleType.setValueTypeToBoolean();
            return simpleType;
        }
        if (ctx.INTEGER() != null) {
            SimpleType simpleType = new SimpleType();
            simpleType.setValueTypeToInteger();
            return simpleType;
        }
        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid variable type"));
        throw new ParseCancellationException(new InvalidVariableTypeException(ctx.getText()));
    }

    @Override
    public BaseType visitArrayType(UnityGrammarParser.ArrayTypeContext ctx){

        //ak je simple type, vyber ranges a vrat sa
        if (ctx.simpleType() != null) {
            BaseType valuesType = visitSimpleType(ctx.simpleType());
            List<ArrayRange> arrayRange = visitListRange(ctx.listRange());
            return new ArrayType(valuesType, arrayRange);
        }

        //ak je arrayType
        //vnor sa (bude sa vnarat dokym nebude niekde simpleType (musi byt, nastavit limit? )
        //vrat sa s nastavenym simpleTypom a ranges
        //tento simple type nastav aj novemu arrayType
        //pridaj ranges

        if (ctx.arrayType() != null){
            ArrayType arrayType = (ArrayType) visitArrayType(ctx.arrayType());
            List<ArrayRange> arrayRange =  visitListRange(ctx.listRange());
            arrayType.addRanges(arrayRange);
            return arrayType;
        }

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid type of array."));
        throw new ParseCancellationException(new InvalidVariableTypeException(ctx.getText()));
    }

    @Override
    public List<ArrayRange> visitListRange(UnityGrammarParser.ListRangeContext ctx){
        List<ArrayRange> arrayRangeList = new ArrayList<ArrayRange>();
        for (UnityGrammarParser.RangeDeclarationContext rctx : ctx.rangeDeclaration()){
            arrayRangeList.add(visitRangeDeclaration(rctx));
        }
        return arrayRangeList;
    }

    @Override
    public ArrayRange visitRangeDeclaration(UnityGrammarParser.RangeDeclarationContext ctx){
        RangeElement lowerBound = visitRangeElement(ctx.rangeElement(0));
        RangeElement upperBound = visitRangeElement(ctx.rangeElement(1));

        return new ArrayRange(lowerBound, upperBound); //return both
    }

    @Override
    public RangeElement visitRangeElement(UnityGrammarParser.RangeElementContext ctx){
        if (ctx.IDENTIFIER() != null) return new RangeElement(ctx.IDENTIFIER().getText());
        if (ctx.number() != null) return new RangeElement(visitNumber(ctx.number()));
        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid range element"));
        throw new ParseCancellationException(new InvalidVariableTypeException(ctx.getText()));
    }


    //region other sections (they have many common things)


    @Override
    public AlwaysSection visitAlways_section(UnityGrammarParser.Always_sectionContext ctx){
        List<Statement> statements = visitStatement_list(ctx.statement_list());
        return new AlwaysSection(statements);
    }

    @Override
    public InitiallySection visitInitially_section(UnityGrammarParser.Initially_sectionContext ctx){
        List<Statement> statements = visitStatement_list(ctx.statement_list());
        return new InitiallySection(statements);
    }

    @Override
    public AssignSection visitAssign_section(UnityGrammarParser.Assign_sectionContext ctx){
        List<Statement> statements = visitStatement_list(ctx.statement_list());
        return new AssignSection(statements);
    }


    @Override
    public List<Statement> visitStatement_list(UnityGrammarParser.Statement_listContext ctx){
        List<Statement> statements = new ArrayList<Statement>();
        for (UnityGrammarParser.StatementContext statementCtx : ctx.statement()){
            statements.add(visitStatement(statementCtx));
        }
        return statements;
    }

    @Override
    public Statement visitStatement(UnityGrammarParser.StatementContext ctx){
        if (ctx.assignment_statement() != null) return visitAssignment_statement(ctx.assignment_statement());
        if (ctx.quantified_statement() != null) return visitQuantified_statement(ctx.quantified_statement());

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid statement definition"));
        throw new ParseCancellationException(new InvalidStatementException(ctx.getText()));
    }

    @Override
    public AssignmentStatement visitAssignment_statement(UnityGrammarParser.Assignment_statementContext ctx){
        List<Assignment> assignments = new ArrayList<Assignment>();
        for (UnityGrammarParser.Assign_componentContext componentContext : ctx.assign_component()){
            assignments.add(visitAssign_component(componentContext));
        }
        return new AssignmentStatement(assignments);
    }

    @Override
    public QuantifiedStatement visitQuantified_statement(UnityGrammarParser.Quantified_statementContext ctx){
        Quantification quantification = visitQuantification(ctx.quantification());
        List<Statement> statements = visitStatement_list(ctx.statement_list());
        return new QuantifiedStatement(quantification, statements);
    }

    @Override
    public Assignment visitAssign_component(UnityGrammarParser.Assign_componentContext ctx){
        if (ctx.enumerated_assignment() != null) return visitEnumerated_assignment(ctx.enumerated_assignment());
        if (ctx.quantified_assignment() != null) return visitQuantified_assignment(ctx.quantified_assignment());

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid assignment definition"));
        throw new ParseCancellationException(new InvalidStatementException(ctx.getText()));
    }

    @Override
    public Assignment visitEnumerated_assignment(UnityGrammarParser.Enumerated_assignmentContext ctx){
        List<Variable> variableList = visitVariable_list(ctx.variable_list());

        List<Expression> expressions = null;
        if (ctx.simple_expression_list() != null) {
            expressions = visitSimple_expression_list(ctx.simple_expression_list());
            return new EnumeratedAssignment(variableList, expressions);
        }
        if (ctx.conditional_expression_list() != null) {
            ConditionalEnumeratedAssignment conditionalEnumeratedAssignment = visitConditional_expression_list(ctx.conditional_expression_list());
            conditionalEnumeratedAssignment.setVariableList(variableList);
            return conditionalEnumeratedAssignment;
        }

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid enumerated assignment definition"));
        throw new ParseCancellationException(new InvalidStatementException(ctx.getText()));
    }

    @Override
    public QuantifiedAssignment visitQuantified_assignment(UnityGrammarParser.Quantified_assignmentContext ctx){
        Quantification quantification = visitQuantification(ctx.quantification());
        AssignmentStatement assignmentStatement = visitAssignment_statement(ctx.assignment_statement());
        return new QuantifiedAssignment(quantification, assignmentStatement);
    }

    @Override
    public List<Variable> visitVariable_list(UnityGrammarParser.Variable_listContext ctx){
        List<Variable> variables = new ArrayList<Variable>();
        //may be variable name
        //may be also variableName[index]
        variables.add(visitVariable(ctx.variable()));
        if (ctx.variable_list() != null) variables.addAll(visitVariable_list(ctx.variable_list()));
        return variables;
    }

    @Override
    public List<Expression> visitSimple_expression_list(UnityGrammarParser.Simple_expression_listContext ctx) {
        List<Expression> expressions = new ArrayList<Expression>();
        expressions.add(visitExpression(ctx.expression()));
        if (ctx.simple_expression_list() != null) expressions.addAll(visitSimple_expression_list(ctx.simple_expression_list()));
        return expressions;
    }

    @Override
    public ConditionalEnumeratedAssignment visitConditional_expression_list(UnityGrammarParser.Conditional_expression_listContext ctx) {
        ConditionalEnumeratedAssignment condEnumAssignment = new ConditionalEnumeratedAssignment();

        for (int i = 0; i < ctx.simple_expression_list().size(); i++){
            condEnumAssignment.addCondition(visitSimple_expression_list(ctx.simple_expression_list(i)),
                                            visitBoolean_expression(ctx.boolean_expression(i)));
        }
        return condEnumAssignment;
    }

    @Override
    public Quantification visitQuantification(UnityGrammarParser.QuantificationContext ctx) {
        List<Variable> variables = visitVariable_list(ctx.variable_list());
        Expression boolExpr = visitBoolean_expression(ctx.boolean_expression());
        return new Quantification(variables, boolExpr);
    }

    @Override
    public Variable visitVariable(UnityGrammarParser.VariableContext ctx) {
        String varName = visitVariableID(ctx.variableID());
        if (ctx.simple_expression_list() != null) {
            List<Expression> expression = visitSimple_expression_list(ctx.simple_expression_list());
            return new ArrayVariable(varName, expression);
        }
        return new SimpleVariable(varName);
    }

    @Override
    public Expression visitExpression(UnityGrammarParser.ExpressionContext ctx) {
        if (ctx.simple_value_expression() != null) return visitSimple_value_expression(ctx.simple_value_expression());
        else if (ctx.relational_operator_expression() != null) return visitRelational_operator_expression(ctx.relational_operator_expression());
        else if (ctx.complex_relational_operator_expression() != null) return visitComplex_relational_operator_expression(ctx.complex_relational_operator_expression());

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid expression definition"));
        throw new ParseCancellationException(new InvalidExpressionException(ctx.getText()));

    }

    @Override
    public Expression visitSimple_value_expression(UnityGrammarParser.Simple_value_expressionContext ctx) {
        return visitAdd_minus_or_expression(ctx.add_minus_or_expression());
    }

    @Override
    public Expression visitRelational_operator_expression(UnityGrammarParser.Relational_operator_expressionContext ctx) {
        Expression expr1 = visitAdd_minus_or_expression(ctx.add_minus_or_expression(0));
        Expression expr2 = visitAdd_minus_or_expression(ctx.add_minus_or_expression(1));
        BinaryOperator operator = visitRelational_operator(ctx.relational_operator());
        return new BinaryExpression(operator, expr1, expr2);
    }

    @Override
    public Expression visitComplex_relational_operator_expression(UnityGrammarParser.Complex_relational_operator_expressionContext ctx) {
        Expression expr1 = visitAdd_minus_or_expression(ctx.add_minus_or_expression(0));
        Expression expr2 = visitAdd_minus_or_expression(ctx.add_minus_or_expression(1));
        Expression expr3 = visitAdd_minus_or_expression(ctx.add_minus_or_expression(2));

        BinaryOperator operator1 = visitRelational_operator(ctx.relational_operator(0));
        BinaryOperator operator2 = visitRelational_operator(ctx.relational_operator(1));

        BinaryExpression binaryExpression1 = new BinaryExpression(operator1, expr1, expr2);
        BinaryExpression binaryExpression2 = new BinaryExpression(operator2, expr2, expr3);

        return new BinaryExpression(BinaryOperator.AND, binaryExpression1, binaryExpression2);
    }

    @Override
    public Expression visitBoolean_expression(UnityGrammarParser.Boolean_expressionContext ctx) {
        return visitExpression(ctx.expression());
    }

    @Override
    public Expression visitAdd_minus_or_expression(UnityGrammarParser.Add_minus_or_expressionContext ctx) {
        if (ctx.add_minus_or_operator() != null){
            Expression expr1 = visitMul_div_mod_and_expression(ctx.mul_div_mod_and_expression());
            Expression expr2 = visitAdd_minus_or_expression(ctx.add_minus_or_expression());
            BinaryOperator operator = visitAdd_minus_or_operator(ctx.add_minus_or_operator());
            return new BinaryExpression(operator, expr1, expr2);
        }
        else return visitMul_div_mod_and_expression(ctx.mul_div_mod_and_expression());
    }

    @Override
    public Expression visitMul_div_mod_and_expression(UnityGrammarParser.Mul_div_mod_and_expressionContext ctx) {
        if (ctx.times_div_mod_and_operator() != null) {
            Expression expr1 = visitPower_expression(ctx.power_expression());
            Expression expr2 = visitMul_div_mod_and_expression(ctx.mul_div_mod_and_expression());
            BinaryOperator operator = visitTimes_div_mod_and_operator(ctx.times_div_mod_and_operator());
            return new BinaryExpression(operator, expr1, expr2);
        }
        else return visitPower_expression(ctx.power_expression());
    }

    @Override
    public Expression visitPower_expression(UnityGrammarParser.Power_expressionContext ctx) {
        if (ctx.POWER() != null) {
            Expression expr1 = visitUnary_expression(ctx.unary_expression());
            Expression expr2 = visitPower_expression(ctx.power_expression());
            return new BinaryExpression(BinaryOperator.POWER, expr1, expr2);
        }
        return visitUnary_expression(ctx.unary_expression());
    }

    @Override
    public Expression visitUnary_expression(UnityGrammarParser.Unary_expressionContext ctx) {
        if (ctx.unary_operator() != null) {
            UnaryOperator operator = visitUnary_operator(ctx.unary_operator());
            Expression expression = visitUnary_expression(ctx.unary_expression());
            return new UnaryExpression(operator, expression);
        }
        else return visitPrimary_expression(ctx.primary_expression());
    }

    @Override
    public Expression visitPrimary_expression(UnityGrammarParser.Primary_expressionContext ctx) {
        if (ctx.variable() != null) return visitVariable(ctx.variable());
        else if (ctx.booleanValue() != null) return new Constant(visitBooleanValue(ctx.booleanValue()));
        else if (ctx.number() != null) return new Constant(visitNumber(ctx.number()));
        else if (ctx.methodDeclaration() != null) return visitMethodDeclaration(ctx.methodDeclaration());
        else if (ctx.expressionDeclaration() != null) return visitExpressionDeclaration(ctx.expressionDeclaration());
        else if (ctx.quantificationDeclaration() != null) return visitQuantificationDeclaration(ctx.quantificationDeclaration());
        else if (ctx.elementListDeclaration() != null) return visitElementListDeclaration(ctx.elementListDeclaration());

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid primary expression definition"));
        throw new ParseCancellationException(new InvalidExpressionException(ctx.getText()));
    }

    @Override
    public Expression visitMethodDeclaration(UnityGrammarParser.MethodDeclarationContext ctx) {
        String methodName = visitFunction(ctx.function());
        List<Expression> args = visitSimple_expression_list(ctx.simple_expression_list());
        return new Function(methodName, args);
    }

    @Override
    public Expression visitExpressionDeclaration(UnityGrammarParser.ExpressionDeclarationContext ctx) {
        return visitExpression(ctx.expression());
    }

    @Override
    public Expression visitQuantificationDeclaration(UnityGrammarParser.QuantificationDeclarationContext ctx) {
        Object operator = visitQuantification_operator(ctx.quantification_operator());
        Quantification quantification = visitQuantification(ctx.quantification());
        Expression expression = visitExpression(ctx.expression());
        return new QuantifiedExpression(operator, quantification, expression);
    }

    @Override
    public Expression visitElementListDeclaration(UnityGrammarParser.ElementListDeclarationContext ctx) {
        return new ExpressionListExpression(visitElement_list(ctx.element_list()));
    }

    @Override
    public String visitFunction(UnityGrammarParser.FunctionContext ctx) {
        StringBuilder func = new StringBuilder();
        boolean first = true;
        for (UnityGrammarParser.TextContext textC : ctx.text()){
            if (!first) func.append(".");
            first = false;
            func.append(visitText(textC));
        }
        return func.toString();
    }

    @Override
    public List<Expression> visitElement_list(UnityGrammarParser.Element_listContext ctx) {
        return visitSimple_expression_list(ctx.simple_expression_list());
    }

    @Override
    public BinaryOperator visitRelational_operator(UnityGrammarParser.Relational_operatorContext ctx) {
        if (ctx.EQUAL() != null) return BinaryOperator.EQUAL;
        if (ctx.NOT_EQUAL() != null) return BinaryOperator.NOT_EQUAL;
        if (ctx.GREATER_OR_EQUAL() != null) return BinaryOperator.GREATER_OR_EQUAL;
        if (ctx.GREATER_THAN() != null) return BinaryOperator.GREATER_THAN;
        if (ctx.LESS_OR_EQUAL() != null) return BinaryOperator.LESS_OR_EQUAL;
        if (ctx.LESS_THAN() != null) return BinaryOperator.LESS_THAN;

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid relational operator"));
        throw new ParseCancellationException(new InvalidOperatorException(ctx.getText()));
    }

    @Override
    public BinaryOperator visitAdd_minus_or_operator(UnityGrammarParser.Add_minus_or_operatorContext ctx) {
        if (ctx.PLUS() != null) return BinaryOperator.PLUS;
        if (ctx.MINUS() != null) return BinaryOperator.MINUS;
        if (ctx.OR() != null) return BinaryOperator.OR;

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid relational operator"));
        throw new ParseCancellationException(new InvalidOperatorException(ctx.getText()));
    }

    @Override
    public BinaryOperator visitTimes_div_mod_and_operator(UnityGrammarParser.Times_div_mod_and_operatorContext ctx) {
        if (ctx.AND() != null) return BinaryOperator.AND;
        if (ctx.DIV() != null) return BinaryOperator.DIV;
        if (ctx.TIMES() != null) return BinaryOperator.TIMES;

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid relational operator"));
        throw new ParseCancellationException(new InvalidOperatorException(ctx.getText()));
    }

    @Override
    public UnaryOperator visitUnary_operator(UnityGrammarParser.Unary_operatorContext ctx) {
        if (ctx.MINUS() != null) return UnaryOperator.MINUS;
        if (ctx.PLUS() != null) return UnaryOperator.PLUS;
        if (ctx.NOT() != null) return UnaryOperator.NOT;

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid relational operator"));
        throw new ParseCancellationException(new InvalidOperatorException(ctx.getText()));
    }

    @Override
    public Object visitQuantification_operator(UnityGrammarParser.Quantification_operatorContext ctx) {
        if (ctx.function() != null) return visitFunction(ctx.function());
        else {
            if (ctx.PLUS() != null) return BinaryOperator.PLUS;
            if (ctx.TIMES() != null) return BinaryOperator.TIMES;
            if (ctx.AND() != null) return BinaryOperator.AND;
            if (ctx.OR() != null) return BinaryOperator.OR;

            errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid relational operator"));
            throw new ParseCancellationException(new InvalidOperatorException(ctx.getText()));
        }
    }

    //region others

    @Override
    public String visitText(UnityGrammarParser.TextContext ctx) {
        return ctx.getText();
    }

    @Override
    public Integer visitNumber(UnityGrammarParser.NumberContext ctx){
        return Integer.valueOf(ctx.getText());
    }

    @Override
    public Boolean visitBooleanValue(UnityGrammarParser.BooleanValueContext ctx) {
        return Boolean.getBoolean(ctx.BOOL().getText());
    }



}
