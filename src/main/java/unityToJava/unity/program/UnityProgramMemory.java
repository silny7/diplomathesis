package unityToJava.unity.program;

import unityToJava.unity.exceptions.NonExistingVariableException;
import unityToJava.unity.program.memory.GlobalMemory;
import unityToJava.unity.program.memory.LocalMemory;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.program.memory.MemoryType;

public class UnityProgramMemory {

    //global memory
    GlobalMemory globalMemory;

    //bounded memory
    LocalMemory boundedMemory;

    public UnityProgramMemory() {
        globalMemory = new GlobalMemory();
        boundedMemory = new LocalMemory();
    }

    public void initGlobalVariable(String varName, Object value){
        globalMemory.initVariable(varName, value);
    }

    public void destroyGlobalVariable(String varName){
        globalMemory.destroyVariable(varName);
    }

    public void initBoundedVariable(String varName, Object value){
        boundedMemory.initVariable(varName, value);
    }

    public void destroyBoundedVariable(String varName){
        boundedMemory.destroyVariable(varName);
    }

    public boolean variableExists(String varName) {
        return globalMemory.containsVariable(varName) || boundedMemory.containsVariable(varName);
    }


    public boolean isBoundedVariable(String varName){
        return boundedMemory.containsVariable(varName);
    }

    public boolean isGlobalVariable(String varName) {
        return globalMemory.containsVariable(varName);
    }

    public Object getVariableValue(String varName) throws NonExistingVariableException {
        //first check bounded memory
        if (isBoundedVariable(varName)) {
            return boundedMemory.getVariable(varName);
        } else if (isGlobalVariable(varName)){
            return globalMemory.getVariable(varName);
        } else {
            throw new NonExistingVariableException("Variable " + varName + " does not exists");
        }
    }

    public void setVariable(String variableName, Object variableValue) {
        if (isBoundedVariable(variableName)) {
            boundedMemory.setVariable(variableName, variableValue);
        } else {
            globalMemory.setVariable(variableName, variableValue);
        }
    }

    public MemoryCopy createMemoryCopy(MemoryType memoryType){
        switch (memoryType){
            case READ:
                return new MemoryCopy(globalMemory.getReadMemoryCopy(), memoryType);
            case WRITE:
                return new MemoryCopy(globalMemory.getWriteMemoryCopy(), memoryType);
            case LOCAL:
                return new MemoryCopy(boundedMemory.getMemoryCopy(), memoryType);
            default:
                //todo better throw some exception
                return null;
        }
    }

    public void loadMemoryCopy(MemoryCopy memoryCopy){
        switch (memoryCopy.getMemoryType()){
            case READ:
            case WRITE:
                globalMemory.loadMemoryCopy(memoryCopy);
                break;
            case LOCAL:
                boundedMemory.loadMemoryCopy(memoryCopy);
                break;
            default:
                //todo better throw some exception
                break;
        }
    }

    public String print() {
        StringBuilder string = new StringBuilder();
        string.append(globalMemory.print());
        return string.toString();
    }
}
