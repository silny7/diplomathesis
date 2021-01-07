package silny7.uniba.sk.unity.program;

import silny7.uniba.sk.unity.sections.AlwaysSection;
import silny7.uniba.sk.unity.sections.AssignSection;
import silny7.uniba.sk.unity.sections.DeclareSection;
import silny7.uniba.sk.unity.sections.InitiallySection;

/**
 * singleton class
 */
public class UnityProgram {

    //program structure
    private String programName;
    private DeclareSection declareSection;
    private AlwaysSection alwaysSection;
    private InitiallySection initiallySection;
    private AssignSection assignSection;

    //flags
    private boolean fixedPoint = false;


    private static UnityProgram instance = null;

    private UnityProgram(){
    }

    public void interpret(){
        if (declareSection != null) declareSection.declareVariables();
        if (alwaysSection != null) alwaysSection.execute();
        if (initiallySection != null) initiallySection.execute();
        assignSection.execute();
    }

    public static UnityProgram getUnityProgram(){
        if (instance == null) instance = new UnityProgram();
        return instance;
    }



    public void setProgramName(String programName) { this.programName = programName; }
    public String getProgramName() { return this.programName; }
    public void setDeclareSection(DeclareSection declareSection) { this.declareSection = declareSection; }
    public DeclareSection getDeclareSection() { return declareSection; }
    public AlwaysSection getAlwaysSection() { return alwaysSection; }
    public void setAlwaysSection(AlwaysSection alwaysSection) { this.alwaysSection = alwaysSection; }
    public InitiallySection getInitiallySection() { return initiallySection; }
    public void setInitiallySection(InitiallySection initiallySection) { this.initiallySection = initiallySection; }
    public AssignSection getAssignSection() { return assignSection; }
    public void setAssignSection(AssignSection assignSection) { this.assignSection = assignSection; }
}
