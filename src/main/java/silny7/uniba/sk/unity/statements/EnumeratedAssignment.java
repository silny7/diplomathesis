package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.expressions.Expression;
import silny7.uniba.sk.unity.expressions.Variable;

import java.util.List;

public class EnumeratedAssignment extends Assignment {

    private final List<Variable> variables;
    private final List<Expression> expressions;

    public EnumeratedAssignment(List<Variable> vars, List<Expression> exprs){
        this.variables = vars;
        this.expressions = exprs;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        //variables:
        boolean first = true;
        for (Variable variable : variables){
            string.append(variable.toString());
            if (!first) string.append(", ");
            first = false;
        }

        string.append(" := ");

        //expressions in format: expression_list if boolean expression
        for (Expression expression : expressions){
            string.append(expression.toString());
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
    public void assign() {}
}
