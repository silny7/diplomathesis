package unityToJava.unity.statements;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.thread.ThreadManager;

import java.util.List;

import static unityToJava.unity.program.UnityProgram.getUnityProgram;

public class QuantifiedStatement extends Statement {

    List<Statement> statements;
    Quantification quantification;


    public QuantifiedStatement(Quantification quantification, List<Statement> statements) {
        this.quantification = quantification;
        this.statements = statements;
    }

    @Override
    public void execute() throws ProgramRunException {
        ThreadManager threadManager = getUnityProgram().getThreadManager();
        quantification.initVariables();
        if (!quantification.isEvaluated()) {
            quantification.evaluate();
        }
        for (MemoryCopy memCopy : quantification.getMemorySnapshots()){
            memCopy.loadIntoProgramMemory();
            for (Statement statement : statements){
                if (!(statement instanceof QuantifiedStatement)) {
                    statement.execute();
                }
            }
        }

        for (Statement statement : statements){
            if (statement instanceof QuantifiedStatement) {
                statement.execute();
            }
        }

        waitForTaskToFinish(threadManager);

        //after execution copy writeMemory to readMemory
        UnityProgramMemory.getMemory().loadWriteToRead();

        quantification.destroyVariables();
    }

    @Override
    public void prepareExecution() throws ProgramRunException {
        quantification.initVariables();
        quantification.evaluate();
        for (MemoryCopy memCopy : quantification.getMemorySnapshots()){
            memCopy.loadIntoProgramMemory();
            for (Statement statement : statements){
                statement.prepareExecution();
            }
        }
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
}
