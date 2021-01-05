package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.variables.BaseType;
import silny7.uniba.sk.unity.expressions.Variable;
import silny7.uniba.sk.unity.variables.DeclaredVariable;

import java.util.List;

public class VariableDeclaration {
    List<DeclaredVariable> variables;
    BaseType type;

    public VariableDeclaration(List<DeclaredVariable> variables, BaseType type){
        this.variables = variables;
        this.type = type;
    }

    public List<DeclaredVariable> getVariables() {
        return variables;
    }

    public BaseType getType() {
        return type;
    }

    /**
     * saves variableName and type to program memory
     */
    public void declare() {
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        boolean first = true;
        for (DeclaredVariable variable : variables){
            if (!first) string.append(", ");
            else first = false;
            string.append(variable.toString());
        }
        string.append(" : ");
        string.append(type.toString());
        return string.toString();
    }
}
