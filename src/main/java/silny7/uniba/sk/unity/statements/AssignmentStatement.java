package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.UnityProgram;
import silny7.uniba.sk.unity.program.UnityProgramMemory;
import silny7.uniba.sk.unity.program.memory.MemoryCopy;
import silny7.uniba.sk.unity.program.memory.MemoryType;

import java.util.List;

public class AssignmentStatement extends Statement {

    List<Assignment> assignments;
    public AssignmentStatement(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    @Override
    public void execute() throws ProgramRunException {
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();
        for (Assignment assignment : assignments){
            assignment.assign();
        }

        //after all assignments, copy changed WRITE memory into READ memory
        MemoryCopy memoryCopy = memory.createMemoryCopy(MemoryType.WRITE);
        memoryCopy.setMemoryType(MemoryType.READ);
        memory.loadMemoryCopy(memoryCopy);
    }

    @Override
    public void evaluateQuantifiers() throws ProgramRunException {
        for (Assignment assignment : assignments) {
            assignment.evaluateQuantifiers();
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Assignment assignment : assignments){
            string.append(assignment.toString()).append(" \n");
        }
        return string.toString();
    }
}
