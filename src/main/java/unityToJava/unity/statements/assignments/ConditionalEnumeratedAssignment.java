package unityToJava.unity.statements.assignments;

import unityToJava.unity.exceptions.IllegalProgramStateException;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.expressions.Expression;
import unityToJava.unity.expressions.variables.Variable;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.thread.tasks.TaskCreator;
import unityToJava.unity.thread.tasks.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ConditionalEnumeratedAssignment extends Assignment {

    List<Variable> variableList;

    //if bool_expr_list[i] == True, then Variables from variableList are set to expressionsList[x]
    List<List<Expression>> expressionsList;
    List<Expression> bool_expr_list;

    List<Task> tasks;

    public ConditionalEnumeratedAssignment(List<Variable> vars, List<List<Expression>> expressionsList, List<Expression> bool_expr){
        this.variableList = vars;
        this.expressionsList = expressionsList;
        this.bool_expr_list = bool_expr;
        this.tasks = new ArrayList<>();
    }

    public ConditionalEnumeratedAssignment(){
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public void addCondition(List<Expression> expressions, Expression boolExpr){
        this.expressionsList.add(expressions);
        this.bool_expr_list.add(boolExpr);
    }

    public void setVariableList(List<Variable> vars){
        this.variableList = vars;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        //variables:
        boolean first = true;
        for (Variable variable : variableList){
            if (!first) string.append(", ");
            first = false;
            string.append(variable.toString());
        }

        string.append(" := ");

        //expressions in format: expression_list if boolean expression
        first = true;
        for (Expression boolean_expr : bool_expr_list){
            for (List<Expression> simpleExpressionList : expressionsList) {
                for (Expression simpleExpression : simpleExpressionList){
                    if (!first) string.append(", ");
                    first = false;
                    string.append(simpleExpression.toString() + " ");
                }
            }
            string.append("if ");
            string.append(boolean_expr.toString()).append(" ");
        }
        return string.toString();
    }

    /**
     * @param memorySnapshots
     */
    @Override
    public void prepareExecution(List<MemoryCopy> memorySnapshots) {
        tasks = new ArrayList<>();
        if (memorySnapshots != null) {
            for (MemoryCopy memoryCopy : memorySnapshots){
                tasks.add(TaskCreator.createAssignmentTask(memoryCopy, this));
            }
        }
        else {
            tasks.add(TaskCreator.createAssignmentTask(null, this));
        }
    }

    @Override
    public void executeAssignment(MemoryCopy boundedMemoryToInject) throws ProgramRunException {
        List<List<Expression>> expressionsToSet = getSatisfiedExpressions();
        if (!expressionsToSet.isEmpty()) {
            List<Expression> expressionsToResolve = expressionsToSet.get(0);
            List<Object> resolvedValues = resolveExpressions(expressionsToResolve);
            resultsCheck(expressionsToSet, resolvedValues);
            assign(resolvedValues);
        }

    }

    private void assign(List<Object> resolvedValues) throws ProgramRunException {
        if (resolvedValues.size() != variableList.size()) {
            throw new IllegalProgramStateException("Size of resolvedValues (" + resolvedValues.size() +") is not the same as variableList (" + variableList.size() +")");
        } else {
            //assign resolved values to variable list
            for (int i = 0; i < variableList.size(); i++) {
                variableList.get(i).setValue(resolvedValues.get(i));
                log(variableList.get(i).toString() + " = " + resolvedValues.get(i));
            }
        }
    }

    private List<Object> resolveExpressions(List<Expression> expressionsToResolve) throws ProgramRunException {
        List<Object> resolvedValues = new ArrayList<>();
        for (Expression expression : expressionsToResolve){
            resolvedValues.add(expression.resolve());
        }
        return resolvedValues;
    }

    /**
     *
     * @returns List of List<Expression> for which is bool_expr[index] true
     */
    private List<List<Expression>> getSatisfiedExpressions() throws ProgramRunException {
        List<List<Expression>> expressionsToSet = new ArrayList<>();
        for (int index = 0; index < bool_expr_list.size(); index++){
            Boolean expressionResult = (Boolean) bool_expr_list.get(index).resolve();
            if (expressionResult) {
                expressionsToSet.add(expressionsList.get(index));
            }
        }
        return expressionsToSet;
    }

    @Override
    public Collection<? extends Task> getTasks() {
        return tasks;
    }

    /**
     * If more than one boolean expression is true, then
     * all the corresponding simple-expr-lists must have the same value; hence any
     * one of them can be used for assignment.
     * @param expressionsToSet
     * @param resolvedValues
     */
    private void resultsCheck(List<List<Expression>> expressionsToSet, List<Object> resolvedValues) throws ProgramRunException {
        for (List<Expression> expressions : expressionsToSet) {
            for (int i = 0; i < resolvedValues.size(); i++) {
                if (!resolvedValues.get(i).equals(expressions.get(i).resolve())) {
                    throw new IllegalProgramStateException("Resolved expressions in conditionalEnumeratedAssignment do not have the same value!");
                }
            }
        }
    }
}
