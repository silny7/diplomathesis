package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.expressions.Expression;
import silny7.uniba.sk.unity.expressions.Variable;

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
    public void evaluateQuantifiers() {

    }

    @Override
    public void assign() {

    }
}
