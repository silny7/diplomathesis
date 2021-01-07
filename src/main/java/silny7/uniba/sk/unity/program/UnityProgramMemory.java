package silny7.uniba.sk.unity.program;

import java.util.Hashtable;
import java.util.Map;

public class UnityProgramMemory {

    Map<String, Object> varsMapWrite = new Hashtable<String, Object>();
    Map<String, Object> varsMapRead = new Hashtable<String, Object>();

    //bounded variables (quantified statements and assigns)
    Map<String, Object> varsMapBounded = new Hashtable<String, Object>();

    

}
