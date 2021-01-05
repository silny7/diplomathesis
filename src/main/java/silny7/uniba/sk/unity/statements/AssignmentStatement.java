package silny7.uniba.sk.unity.statements;

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
    public void execute() {

    }

    @Override
    public String toString() {
        return null;
    }
}
