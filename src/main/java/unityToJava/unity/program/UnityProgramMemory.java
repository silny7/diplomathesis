package unityToJava.unity.program;

import com.sun.org.apache.regexp.internal.RE;
import unityToJava.unity.exceptions.NonExistingVariableException;
import unityToJava.unity.program.memory.GlobalMemory;
import unityToJava.unity.program.memory.LocalMemory;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.program.memory.MemoryType;
import unityToJava.unity.sections.Section;

public class UnityProgramMemory {

    private volatile static UnityProgramMemory memoryInstance = null;

    //global memory
    volatile GlobalMemory globalMemory;

    //bounded memory
    volatile LocalMemory boundedMemory;

    private UnityProgramMemory() {
        globalMemory = new GlobalMemory();
        boundedMemory = new LocalMemory();
    }

    public static UnityProgramMemory getMemory(){
        if (memoryInstance == null) {
            synchronized (UnityProgramMemory.class) {
                if (memoryInstance == null) {
                    memoryInstance = new UnityProgramMemory();
                }
            }
        }
        return memoryInstance;
    }

    public static void discard() {
        memoryInstance = null;
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
            throw new NonExistingVariableException("Variable " + varName + " referenced before declaration");
        }
    }

    public void setVariable(String variableName, Object variableValue) {
        if (isBoundedVariable(variableName)) {
            //UnityProgram.programLog("Setting boundedVariable: " + variableName + " to value: " + (String) variableValue, Section.DECLARE);
            boundedMemory.setVariable(variableName, variableValue);
        } else {
            //UnityProgram.programLog("Setting globalVariable: " + variableName + " to value: " + (String) variableValue, Section.DECLARE);
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
                throw new IllegalStateException("Unknown memorytype: " + memoryType);
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
                throw new IllegalStateException("Unknown memorytype: " + memoryCopy.getMemoryType());
        }
    }

    public String print() {
        StringBuilder string = new StringBuilder();
        string.append(globalMemory.print());
        return string.toString();
    }

    public synchronized void loadWriteToRead() {
        MemoryCopy memoryCopy = createMemoryCopy(MemoryType.WRITE);
        memoryCopy.setMemoryType(MemoryType.READ);
        loadMemoryCopy(memoryCopy);
    }
}
