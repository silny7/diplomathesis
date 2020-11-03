package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.variables.BaseType;
import silny7.uniba.sk.unity.variables.Variable;

import java.util.List;

public class VariableDeclaration {
    List<Variable> variables;
    BaseType type;

    public VariableDeclaration(List<Variable> variables, BaseType type){
        this.variables = variables;
        this.type = type;
    }

    /**
     * saves variableName and type to program memory
     */
    public void declare() {
    }
}
