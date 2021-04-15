package unityToJava.unity.statements.assignments;

import unityToJava.unity.exceptions.IllegalProgramStateException;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.expressions.Expression;
import unityToJava.unity.expressions.variables.Variable;

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
            if (!first) string.append(", ");
            string.append(variable.toString());
            first = false;
        }

        string.append(" := ");

        //expressions in format: expression_list if boolean expression
        first = true;
        for (Expression expression : expressions){
            if (!first) string.append(", ");
            string.append(expression.toString());
            first = false;
        }
        return string.toString();
    }

    /**
     * does nothing
     */
    @Override
    public void prepareExecution() {}

    @Override
    public void assign() throws ProgramRunException {
        if (variables.size() != expressions.size()){
            throw new IllegalProgramStateException("Size of expressionsList (" + expressions.size() +") is not the same as variableList (" + variables.size() +")");
        }

        for (int index = 0; index < variables.size(); index++){
            Object value = expressions.get(index).resolve();
            variables.get(index).setValue(value);
            log(variables.get(index).toString() + " = " + value);
        }
    }
}
