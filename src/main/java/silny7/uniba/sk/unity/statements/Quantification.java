package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.expressions.Expression;
import silny7.uniba.sk.unity.expressions.Variable;

import java.util.List;

public class Quantification {

    List<Variable> boundedVars;
    Expression boolExpr;

    public Quantification(List<Variable> boundedVars, Expression boolExpr) {
        this.boolExpr = boolExpr;
        this.boundedVars = boundedVars;
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        boolean first = true;
        for (Variable var : boundedVars){
            if (!first) string.append(", ");
            else first = false;
            string.append(var.toString());
        }
        string.append(" ");
        string.append(boolExpr.toString());
        return string.toString();
    }

}
