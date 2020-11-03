package silny7.uniba.sk.parser;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import silny7.uniba.sk.UnityGrammarBaseVisitor;
import silny7.uniba.sk.UnityGrammarParser;
import silny7.uniba.sk.parser.exceptions.InvalidStatementException;
import silny7.uniba.sk.parser.exceptions.InvalidVariableTypeException;
import silny7.uniba.sk.unity.UnityProgram;
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

        return null;
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
        List<Variable> variables = visitVariable_declaration_list(ctx.variable_declaration_list());
        BaseType baseType = visitBaseType(ctx.baseType());

        return new VariableDeclaration(variables, baseType);
    }

    @Override
    public List<Variable> visitVariable_declaration_list(UnityGrammarParser.Variable_declaration_listContext ctx) {
        List<Variable> variables = new ArrayList<Variable>();
        for (UnityGrammarParser.VariableIDContext variableIDContext : ctx.variableID()){
            variables.add(new Variable(visitVariableID(variableIDContext)));
        }
        return variables;
    }

    @Override
    public String visitVariableID(UnityGrammarParser.VariableIDContext ctx) {
        //add check on existence of variable name :?
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
    public Object visitAlways_section(UnityGrammarParser.Always_sectionContext ctx){
        List<Statement> statements = visitStatement_list(ctx.statement_list());

        return new AlwaysSection(statements);
    }

    @Override
    public Object visitInitially_section(UnityGrammarParser.Initially_sectionContext ctx){
        List<Statement> statements = visitStatement_list(ctx.statement_list());
        return new InitiallySection(statements);
    }

    @Override
    public Object visitAssign_section(UnityGrammarParser.Assign_sectionContext ctx){
        List<Statement> statements = visitStatement_list(ctx.statement_list());
        return new AssignSection(statements);
    }


    @Override
    public List<Statement> visitStatement_list(UnityGrammarParser.Statement_listContext ctx){
        List<Statement> statements = new ArrayList<Statement>();
        for (UnityGrammarParser.StatementContext sctx : ctx.statement()){
            statements.add(visitStatement(sctx));
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
        return null;
    }

    @Override
    public Assignment visitAssign_component(UnityGrammarParser.Assign_componentContext ctx){
        if (ctx.enumerated_assignment() != null) return visitEnumerated_assignment(ctx.enumerated_assignment());
        if (ctx.quantified_assignment() != null) return visitQuantified_assignment(ctx.quantified_assignment());

        errors.add(new UnityGrammarError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Invalid assignment definition"));
        throw new ParseCancellationException(new InvalidStatementException(ctx.getText()));
    }

    @Override
    public EnumeratedAssignment visitEnumerated_assignment(UnityGrammarParser.Enumerated_assignmentContext ctx){
        List<Variable> variableList = visitVariable_list(ctx.variable_list());


        return new EnumeratedAssignment();
    }

    @Override
    public QuantifiedAssignment visitQuantified_assignment(UnityGrammarParser.Quantified_assignmentContext ctx){
        return new QuantifiedAssignment();
    }

    @Override
    public List<Variable> visitVariable_list(UnityGrammarParser.Variable_listContext ctx){
        //may be variable name
        //may be also variableName[index]
        return null;
    }


    //region others

    @Override
    public String visitText(UnityGrammarParser.TextContext ctx) {
        return (String) super.visitText(ctx);
    }

    @Override
    public Integer visitNumber(UnityGrammarParser.NumberContext ctx){
        return Integer.valueOf(ctx.getText());
    }

}
