package unityToJava.unity.expressions.operators;

import unityToJava.unity.exceptions.IllegalProgramStateException;

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

    public static Object getDefaultOperatorValue(BinaryOperator operator) throws IllegalProgramStateException {
        switch (operator){
            case TIMES:
            case POWER:
            case MINUS:
                return 1;
            case PLUS:
            case DIV:
            case MOD:
                return 0;
            case LESS_OR_EQUAL:
            case LESS_THAN:
            case GREATER_OR_EQUAL:
            case GREATER_THAN:
            case EQUAL:
            case AND:
                return true;
            case OR:
            case NOT_EQUAL:
                return false;
        }
        throw new IllegalProgramStateException("Illegal binary operator: " + operator);
    }


}
