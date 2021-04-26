package unityToJava.parser.exceptions;

public class InvalidOperatorException extends Exception {
    String operator;

    public InvalidOperatorException(String operator){
        this.operator = operator;
    }
}
