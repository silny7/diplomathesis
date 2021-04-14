package unityToJava.unity.variables;

public class DeclaredVariable {
    String varName;

    public DeclaredVariable(String varName){
        this.varName = varName;
    }

    public String getVarName() {
        return varName;
    }

    public String toString(){
        return getVarName();
    }
}
