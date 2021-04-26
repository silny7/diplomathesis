package unityToJava.unity.exceptions;

public class ProgramRunException extends Exception{
    String message;

    public ProgramRunException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
