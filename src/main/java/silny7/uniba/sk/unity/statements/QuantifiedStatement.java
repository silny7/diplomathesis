package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.UnityProgram;
import silny7.uniba.sk.unity.program.UnityProgramMemory;
import silny7.uniba.sk.unity.program.memory.MemoryCopy;
import silny7.uniba.sk.unity.program.memory.MemoryType;

import java.util.List;

public class QuantifiedStatement extends Statement {

    List<Statement> statements;
    Quantification quantification;


    public QuantifiedStatement(Quantification quantification, List<Statement> statements) {
        this.quantification = quantification;
        this.statements = statements;
    }

    @Override
    public void execute() throws ProgramRunException {
        quantification.initVariables();
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

        //after execution copy writeMemory to readMemory
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();
        MemoryCopy memoryCopy = memory.createMemoryCopy(MemoryType.WRITE);
        memoryCopy.setMemoryType(MemoryType.READ);
        memoryCopy.loadIntoProgramMemory();

        quantification.destroyVariables();
    }

    @Override
    public void evaluateQuantifiers() throws ProgramRunException {
        quantification.initVariables();
        quantification.evaluate();
        for (MemoryCopy memCopy : quantification.getMemorySnapshots()){
            memCopy.loadIntoProgramMemory();
            for (Statement statement : statements){
                statement.evaluateQuantifiers();
            }
        }
        quantification.destroyVariables();
    }

    @Override
    public String toString() {
        return null;
    }
}
