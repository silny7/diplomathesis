package unityToJava.unity.program.memory;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalMemory implements Memory{

    private final Map<String, Object> globalMemory = new ConcurrentHashMap<>();

    @Override
    public boolean containsVariable(String variableName){
        return globalMemory.containsKey(variableName);
    }

    @Override
    public void initVariable(String variableName, Object variableValue) {
        globalMemory.put(variableName, variableValue);
    }

    @Override
    public void destroyVariable(String variableName) {
        globalMemory.remove(variableName);
    }

    @Override
    public Object getVariable(String variableName) {
        return globalMemory.get(variableName);
    }

    @Override
    public void setVariable(String variableName, Object variableValue) {
        globalMemory.put(variableName, variableValue);
    }

    @Override
    public void loadMemoryCopy(MemoryCopy memoryCopy) {
        switch(memoryCopy.getMemoryType()){
            case GLOBAL:
                loadMemoryCopyIntoGlobalMemory(memoryCopy.getMemory());
                break;
            default: break;
        }
    }

    @Override
    public String print() {
        StringBuilder string = new StringBuilder();
        if (globalMemory.isEmpty()) {
            string.append("PROGRAM MEMORY IS EMPTY");
        } else {
            string.append("PROGRAM MEMORY: ").append("\n");
            for (Map.Entry mapEntry : globalMemory.entrySet()){
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


    private void loadMemoryCopyIntoGlobalMemory(Map<String, Object> memoryCopy) {
        for (Map.Entry<String, Object> variable : memoryCopy.entrySet()){
            globalMemory.put(variable.getKey(), variable.getValue());
        }
    }


    public Map<String, Object> getGlobalMemoryCopy() {
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        for (Map.Entry<String, Object> variable : globalMemory.entrySet()){
            map.put(variable.getKey(), variable.getValue());
        }
        return map;
    }
}
