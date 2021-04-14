package unityToJava.parser.exceptions;

public class InvalidExpressionException extends Exception{
    String expression;

    public InvalidExpressionException(String expression){
        this.expression = expression;
    }
}
