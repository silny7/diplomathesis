package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.expressions.Expression;
import silny7.uniba.sk.unity.expressions.Variable;

import java.util.List;

public class EnumeratedAssignment extends Assignment {

    private final List<Variable> vars;
    private final List<Expression> exprs;

    public EnumeratedAssignment(List<Variable> vars, List<Expression> exprs){
        this.vars = vars;
        this.exprs = exprs;
    }

    public List<Variable> getVars() {
        return vars;
    }

    public List<Expression> getExprs() {
        return exprs;
    }
}
