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

public class EnumeratedAssignment extends Assignment {

    private List<Task> tasks;
    private final List<Variable> variables;
    private final List<Expression> expressions;

    public EnumeratedAssignment(List<Variable> vars, List<Expression> exprs){
        this.variables = vars;
        this.expressions = exprs;
        this.tasks = new ArrayList<>();
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
    public void executeAssignment() throws ProgramRunException {
        if (variables.size() != expressions.size()){
            throw new IllegalProgramStateException("Size of expressionsList (" + expressions.size() +") is not the same as variableList (" + variables.size() +")");
        }
        List<Object> valuesToSet = resolveExpressions();
        setValuesToVariables(valuesToSet);
    }

    private void setValuesToVariables(List<Object> valuesToSet) throws ProgramRunException {
        for (int index = 0; index < variables.size(); index++){
            Object value = valuesToSet.get(index);
            variables.get(index).setValue(value);
            log(variables.get(index).toString() + " = " + value);
        }
    }

    private List<Object> resolveExpressions() throws ProgramRunException {
        List<Object> valuesToSet = new ArrayList<>();
        for (Expression expression : expressions){
            valuesToSet.add(expression.resolve());
        }
        return valuesToSet;
    }

    @Override
    public Collection<? extends Task> getTasks() {
        return tasks;
    }
}
