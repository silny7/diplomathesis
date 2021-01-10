package silny7.uniba.sk.unity.program;

import silny7.uniba.sk.unity.exceptions.NonExistingVariableException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;

import java.util.Hashtable;
import java.util.Map;

public class UnityProgramMemory {

    //unbounded variables
    Map<String, Object> varsTableUnbounded = new Hashtable<String, Object>();

    //bounded variables (quantified statements and assigns)
    Map<String, Object> varsTableBounded = new Hashtable<String, Object>();

    public boolean unboundedVariableExists(String varName){
        return varsTableUnbounded.containsKey(varName);
    }

    public boolean boundedVariableExists(String varName){
        return varsTableBounded.containsKey(varName);
    }

    public void addNewUnboundedVariableWithValue(String varName, Object value){
        varsTableUnbounded.put(varName, value);
    }


    public Map<String, Object> getVarsTableUnbounded() { return varsTableUnbounded; }

    public Map<String, Object> getVarsTableBounded() { return varsTableBounded; }

    public Object getUnboundedVariable(String varName) throws ProgramRunException {
        Object variableValue = varsTableUnbounded.get(varName);
        if (variableValue == null) throw new NonExistingVariableException("Variable " + varName + " does not exists");
        return varsTableUnbounded.get(varName);
    }
}
