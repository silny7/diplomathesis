package unityToJava.unity.statements;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.thread.ThreadManager;
import unityToJava.unity.thread.tasks.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

public class QuantifiedStatement extends Statement {

    List<Task> tasks;
    List<Statement> statements;
    Quantification quantification;


    public QuantifiedStatement(Quantification quantification, List<Statement> statements) {
        this.quantification = quantification;
        this.statements = statements;
        this.tasks = new ArrayList<>();
    }

    @Override
    public void execute() throws ProgramRunException {
        for (Statement statement : statements){
            statement.execute();
        }
        //after all assignments, copy changed WRITE memory into READ memory
        UnityProgramMemory.getMemory().loadWriteToRead();
    }

    @Override
    public void prepareExecution(List<MemoryCopy> memorySnapshots) throws ProgramRunException {
        tasks = new ArrayList<>();
        evaluateQuantification();
        for (Statement statement : statements){
            statement.prepareExecution(quantification.getMemorySnapshots());
            tasks.addAll(statement.getTasks());
        }
    }

    private void evaluateQuantification() throws ProgramRunException {
        quantification.initVariables();
        quantification.evaluate();
        quantification.destroyVariables();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("<< [] ")
              .append(quantification.toString());
        for (Statement statement : statements){
            string.append(statement.toString()).append(" ");
        }
        string.append(">>");
        return string.toString();
    }

    @Override
    protected Collection<? extends Task> getTasks() {
        return tasks;
    }
}
