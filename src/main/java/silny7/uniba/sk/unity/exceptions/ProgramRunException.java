package silny7.uniba.sk.unity.exceptions;

public class ProgramRunException extends Exception{
    String message;

    public ProgramRunException(String message){
        this.message = message;
    }
}