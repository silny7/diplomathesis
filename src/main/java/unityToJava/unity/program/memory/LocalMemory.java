package unityToJava.unity.program.memory;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Memory for bounded variables such as those in Quantified assignments
 */
public class LocalMemory implements Memory{

    Map<String, Object> boundedMemory = new ConcurrentHashMap<>();

    @Override
    public boolean containsVariable(String variableName) {
        return boundedMemory.containsKey(variableName);
    }

    @Override
    public void initVariable(String variableName, Object variableValue) {
        boundedMemory.put(variableName, variableValue);
    }

    @Override
    public void destroyVariable(String variableName) {
        boundedMemory.remove(variableName);
    }

    @Override
    public Object getVariable(String variableName) {
        return boundedMemory.get(variableName);
    }

    @Override
    public void setVariable(String variableName, Object variableValue) {
       boundedMemory.put(variableName, variableValue);
    }

    @Override
    public void loadMemoryCopy(MemoryCopy memoryCopy) {
        for (Map.Entry<String, Object> variable : memoryCopy.getMemory().entrySet()){
            setVariable(variable.getKey(), variable.getValue());
        }
    }

    @Override
    public String print() {
        StringBuilder string = new StringBuilder();
        if (boundedMemory.isEmpty()) {
            string.append("BOUNDED VARIABLES MEMORY IS EMPTY");
        } else {
            string.append("BOUNDED VARIABLES MEMORY: ").append("\n");
            for (Map.Entry mapEntry : boundedMemory.entrySet()){
                string.append("VariableName: " + mapEntry.getKey() + " variableValue: " + mapEntry.getValue().toString()).append("\n");
            }
        }

        return string.toString();
    }

    public Map<String, Object> getMemoryCopy() {
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        for (Map.Entry<String, Object> variable : boundedMemory.entrySet()){
            map.put(variable.getKey(), variable.getValue());
        }
        return map;
    }
}
