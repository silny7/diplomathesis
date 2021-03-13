package silny7.uniba.sk.unity.program.memory;

import java.util.Hashtable;
import java.util.Map;

/**
 * Memory for bounded variables such as those in Quantified assignments
 */
public class LocalMemory implements Memory{

    Map<String, Object> boundedMemory = new Hashtable<String, Object>();

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

    public Map<String, Object> getMemoryCopy() {
        Map<String, Object> map = new Hashtable<String, Object>();
        for (Map.Entry<String, Object> variable : boundedMemory.entrySet()){
            map.put(variable.getKey(), variable.getValue());
        }
        return map;
    }
}
