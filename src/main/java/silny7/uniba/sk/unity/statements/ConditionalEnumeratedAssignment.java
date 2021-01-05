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
        return null;
    }
}
