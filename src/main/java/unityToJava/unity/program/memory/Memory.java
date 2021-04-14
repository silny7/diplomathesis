package unityToJava.unity.program.memory;

public interface Memory {

    boolean containsVariable(String variableName);
    void initVariable(String variableName, Object variableValue);
    void destroyVariable(String variableName);
    Object getVariable(String variableName);
    void setVariable(String variableName, Object variableValue);

    void loadMemoryCopy(MemoryCopy memoryCopy);

    String print();
}
