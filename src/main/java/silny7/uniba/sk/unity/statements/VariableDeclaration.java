package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.exceptions.MultipleDeclarationException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.UnityProgram;
import silny7.uniba.sk.unity.program.UnityProgramMemory;
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
     * @param memory
     */
    public void declare(UnityProgramMemory memory) throws ProgramRunException {
        for (DeclaredVariable variable : variables) {
            if (memory.unboundedVariableExists(variable.getVarName())) {
                throw new MultipleDeclarationException(variable.getVarName(), "Variable " + variable.getVarName() + " is already declared");
            }
            else {
                UnityProgram.programLog("Declaring variable: " + variable.getVarName() + " with type: " + type.toString());
                memory.addNewUnboundedVariableWithValue(variable.getVarName(), type.getNewTypeObject());
            }
        }
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
