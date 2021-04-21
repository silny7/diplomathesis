package unityToJava.unity.program.memory;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalMemory implements Memory{

    private final Map<String, Object> memoryRead = new ConcurrentHashMap<>();
    private final Map<String, Object> memoryWrite = new ConcurrentHashMap<>();

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
        memoryRead.put(variableName, variableValue);
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

    @Override
    public String print() {
        StringBuilder string = new StringBuilder();
        if (memoryRead.isEmpty()) {
            string.append("PROGRAM MEMORY IS EMPTY");
        } else {
            string.append("PROGRAM MEMORY: ").append("\n");
            for (Map.Entry mapEntry : memoryRead.entrySet()){
                String variableName = (String) mapEntry.getKey();
                Object variableValue = mapEntry.getValue();
                if (variableValue.getClass().isArray()){
                    variableValue = "\n" + Arrays.deepToString((Object[]) variableValue).replace("]",  "]\n");
                }
                string.append("VariableName: " + variableName + " variableValue: " + variableValue).append("\n");
            }
        }
        return string.toString();
    }

    private void loadMemoryCopyIntoWriteMemory(Map<String, Object> memoryCopy) {
        for (Map.Entry<String, Object> variable : memoryCopy.entrySet()){
            memoryWrite.put(variable.getKey(), variable.getValue());
        }
    }

    private void loadMemoryCopyIntoReadMemory(Map<String, Object> memoryCopy) {
        for (Map.Entry<String, Object> variable : memoryCopy.entrySet()){
            memoryRead.put(variable.getKey(), variable.getValue());
        }
    }

    public Map<String, Object> getWriteMemoryCopy() {
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        for (Map.Entry<String, Object> variable : memoryWrite.entrySet()){
            map.put(variable.getKey(), variable.getValue());
        }
        return map;
    }

    public Map<String, Object> getReadMemoryCopy() {
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        for (Map.Entry<String, Object> variable : memoryRead.entrySet()){
            map.put(variable.getKey(), variable.getValue());
        }
        return map;
    }
}
