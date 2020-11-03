package silny7.uniba.sk.unity.statements;

import java.util.List;

public class AssignmentStatement extends Statement {

    List<Assignment> assignments;
    public AssignmentStatement(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public void execute() {

    }
}
