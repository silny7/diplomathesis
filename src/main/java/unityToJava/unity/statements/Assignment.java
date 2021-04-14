package unityToJava.unity.statements;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;

public abstract class Assignment {

    public abstract String toString();

    public abstract void evaluateQuantifiers() throws ProgramRunException;

    public abstract void assign() throws ProgramRunException;

    public void log(String logMessage){
        UnityProgram.programLog(logMessage, UnityProgram.getCurrentSection());
    }

}
