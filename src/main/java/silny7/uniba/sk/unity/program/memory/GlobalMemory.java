package silny7.uniba.sk.unity.program.memory;

import java.util.Hashtable;
import java.util.Map;

public class GlobalMemory implements Memory{

    Map<String, Object> memoryRead = new Hashtable<String, Object>();
    Map<String, Object> memoryWrite = new Hashtable<String, Object>();

    @Override
    public boolean containsVariable(String variableName){
        return memoryRead.containsKey(variableName) && memoryWrite.containsKey(variableName);
    }

    @Override
    public void initVariable(String variableName, Object variableValue) {
        memoryRead.put(variableName, variableValue);
        memoryWrite.put(variableName, variableValue);
    }

    @Override
    public void destroyVariable(String variableName) {
        memoryRead.remove(variableName);
        memoryWrite.remove(variableName);
    }

    @Override
    public Object getVariable(String variableName) {
        return memoryRead.get(variableName);
    }

    @Override
    public void setVariable(String variableName, Object variableValue) {
        memoryWrite.put(variableName, variableValue);
    }

    @Override
    public void loadMemoryCopy(MemoryCopy memoryCopy) {
        switch(memoryCopy.getMemoryType()){
            case READ:
                loadMemoryCopyIntoReadMemory(memoryCopy.getMemory());
                break;
            case WRITE:
                loadMemoryCopyIntoWriteMemory(memoryCopy.getMemory());
                break;

        }
    }

    private void loadMemoryCopyIntoWriteMemory(Map<String, Object> memoryCopy) {
        for (Map.Entry<String, Object> variable : memoryCopy.entrySet()){
            memoryRead.put(variable.getKey(), variable.getValue());
        }
    }

    private void loadMemoryCopyIntoReadMemory(Map<String, Object> memoryCopy) {
        for (Map.Entry<String, Object> variable : memoryCopy.entrySet()){
            memoryWrite.put(variable.getKey(), variable.getValue());
        }
    }

    public Map<String, Object> getWriteMemoryCopy() {
        Map<String, Object> map = new Hashtable<String, Object>();
        for (Map.Entry<String, Object> variable : memoryRead.entrySet()){
            map.put(variable.getKey(), variable.getValue());
        }
        return map;
    }

    public Map<String, Object> getReadMemoryCopy() {
        Map<String, Object> map = new Hashtable<String, Object>();
        for (Map.Entry<String, Object> variable : memoryWrite.entrySet()){
            map.put(variable.getKey(), variable.getValue());
        }
        return map;
    }
}
