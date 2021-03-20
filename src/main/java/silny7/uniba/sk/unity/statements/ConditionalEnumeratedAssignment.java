package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.exceptions.IllegalProgramStateException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.expressions.Expression;
import silny7.uniba.sk.unity.expressions.variables.Variable;

import java.util.ArrayList;
import java.util.List;

public class ConditionalEnumeratedAssignment extends Assignment {

    List<Variable> variableList;

    //if bool_expr_list[i] == True, then Variables from variableList are set to expressionsList[x]
    List<List<Expression>> expressionsList;
    List<Expression> bool_expr_list;

    public ConditionalEnumeratedAssignment(List<Variable> vars, List<List<Expression>> expressionsList, List<Expression> bool_expr){
        this.variableList = vars;
        this.expressionsList = expressionsList;
        this.bool_expr_list = bool_expr;
    }

    public ConditionalEnumeratedAssignment(){
        this.variableList = new ArrayList<Variable>();
        this.expressionsList = new ArrayList<List<Expression>>();
        this.bool_expr_list = new ArrayList<Expression>();
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
            string.append(variable.toString());
            if (!first) string.append(", ");
            first = false;
        }

        string.append(" := ");

        //expressions in format: expression_list if boolean expression
        for (Expression boolean_expr : bool_expr_list){
            for (List<Expression> simpleExpressionList : expressionsList) {
                for (Expression simpleExpression : simpleExpressionList){
                    string.append(simpleExpression.toString() + " ");
                }
            }
            string.append("if ");
            string.append(boolean_expr.toString()).append(" ");
        }
        return string.toString();
    }

    /**
     * does nothing
     */
    @Override
    public void evaluateQuantifiers() {}

    @Override
    public void assign() throws ProgramRunException {
        List<Integer> expressionSatisfiedIndexes = new ArrayList<Integer>();
        for (int index = 0; index < bool_expr_list.size(); index++){
            Boolean expressionResult = (Boolean) bool_expr_list.get(index).resolve();
            if (expressionResult) {
                expressionSatisfiedIndexes.add(index);
            }
        }

        if (expressionSatisfiedIndexes.isEmpty()) {
            //no boolean expression is true, tho no assignments are made
        } else {
            List<Expression> expressionsToResolve = expressionsList.get(expressionSatisfiedIndexes.get(0));
            List<Object> resolvedValues = new ArrayList<Object>();
            for (Expression expression : expressionsToResolve){
                resolvedValues.add(expression.resolve());
            }
            resultsCheck(expressionSatisfiedIndexes, resolvedValues);

            if (resolvedValues.size() != variableList.size()) {
                throw new IllegalProgramStateException("Size of resolvedValues (" + resolvedValues.size() +") is not the same as variableList (" + variableList.size() +")");
            } else {
                //assign resolved values to variable list
                for (int i = 0; i < variableList.size(); i++) {
                    variableList.get(i).setValue(resolvedValues.get(i));
                }
            }
        }
    }

    /**
     * If more than one boolean expression is true, then
     * all the corresponding simple-expr-lists must have the same value; hence any
     * one of them can be used for assignment.
     * @param expressionSatisfiedIndexes
     * @param resolvedValues
     */
    private void resultsCheck(List<Integer> expressionSatisfiedIndexes, List<Object> resolvedValues) throws ProgramRunException {
        for (int i = 1; i < expressionSatisfiedIndexes.size(); i++){
            List<Expression> expressionsCheck = expressionsList.get(i);
            for (int j = 0; j < resolvedValues.size(); j++){
                if (!resolvedValues.get(j).equals(expressionsCheck.get(j).resolve())) {
                    throw new IllegalProgramStateException("Resolved expressions in conditionalEnumeratedAssignment do not have the same value!");
                }
            }
        }
    }
}
