package silny7.uniba.sk.unity;

import silny7.uniba.sk.unity.sections.AlwaysSection;
import silny7.uniba.sk.unity.sections.AssignSection;
import silny7.uniba.sk.unity.sections.DeclareSection;
import silny7.uniba.sk.unity.sections.InitiallySection;

/**
 * singleton class
 */
public class UnityProgram {

    private String programName;
    private DeclareSection declareSection;
    private AlwaysSection alwaysSection;
    private InitiallySection initiallySection;
    private AssignSection assignSection;

    private static UnityProgram instance = null;

    private UnityProgram(){

    }

    public void interpret(){

    }

    public static UnityProgram getUnityProgram(){
        if (instance == null) instance = new UnityProgram();
        return instance;
    }



    public void setProgramName(String programName) { this.programName = programName; }
    public String getProgramName() { return this.programName; }
    public void setDeclareSection(DeclareSection visitDeclare_section) { }
    public DeclareSection getDeclareSection() { return declareSection; }
    public AlwaysSection getAlwaysSection() { return alwaysSection; }
    public void setAlwaysSection(AlwaysSection alwaysSection) { this.alwaysSection = alwaysSection; }
    public InitiallySection getInitiallySection() { return initiallySection; }
    public void setInitiallySection(InitiallySection initiallySection) { this.initiallySection = initiallySection; }
    public AssignSection getAssignSection() { return assignSection; }
    public void setAssignSection(AssignSection assignSection) { this.assignSection = assignSection; }
}
