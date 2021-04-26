package unityToJava.unity.program.memory;

import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;

import java.util.Map;

public class MemoryCopy {

    Map<String, Object> variables;
    MemoryType memoryType;

    public MemoryCopy(Map<String, Object> variables, MemoryType memoryType) {
        this.variables = variables;
        this.memoryType = memoryType;
    }

    public MemoryType getMemoryType() {
        return memoryType;
    }

    public Map<String, Object> getMemory(){
        return variables;
    }

    public void setMemoryType(MemoryType memoryType) {
        this.memoryType = memoryType;
    }

    public void loadIntoProgramMemory(){
        UnityProgramMemory.getMemory().loadMemoryCopy(this);
    }

    public boolean containsVariable(String varName) {
        return variables.keySet().contains(varName);
    }

    public Object getVariable(String varName) {
        return variables.get(varName);
    }
}
