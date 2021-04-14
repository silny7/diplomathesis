package unityToJava.unity.expressions.operators;

public enum UnaryOperator {
    MINUS("-"),
    PLUS("+"),
    NOT("!");

    String operator;
    UnaryOperator(String operator){
        this.operator = operator;
    }

    @Override
    public String toString() {
        return operator;
    }
}
