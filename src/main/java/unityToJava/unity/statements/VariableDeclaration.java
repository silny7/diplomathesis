package unityToJava.unity.statements;

import unityToJava.unity.exceptions.MultipleDeclarationException;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.sections.Sections;
import unityToJava.unity.variables.BaseType;
import unityToJava.unity.variables.DeclaredVariable;

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
    public void declare() throws ProgramRunException {
        for (DeclaredVariable variable : variables) {
            if (UnityProgramMemory.getMemory().variableExists(variable.getVarName())) {
                throw new MultipleDeclarationException(variable.getVarName(), "Variable " + variable.getVarName() + " is already declared");
            }
            else {
                UnityProgram.programLog("Declaring variable: " + variable.getVarName() + " with type: " + type.toString(), Sections.DECLARE);
                UnityProgramMemory.getMemory().initGlobalVariable(variable.getVarName(), type.getNewTypeObject());
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
