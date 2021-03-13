package silny7.uniba.sk.unity.expressions.operators;

public enum BinaryOperator {

    MINUS("-"),
    PLUS("+"),
    DIV("/"),
    MOD("%"),
    TIMES("*"),
    EQUAL("="),
    NOT_EQUAL("!="),
    OR("or"),
    AND("and"),
    POWER("^"),
    LESS_THAN("<"),
    GREATER_THAN(">"),
    LESS_OR_EQUAL("<="),
    GREATER_OR_EQUAL(">=");

    String operator;
    BinaryOperator(String operator){
        this.operator = operator;
    }

    @Override
    public String toString() {
        return operator;
    }


}
