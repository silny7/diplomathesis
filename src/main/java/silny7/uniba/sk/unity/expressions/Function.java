package silny7.uniba.sk.unity.expressions;

import java.util.List;

public class Function extends Expression{


    private String methodName;
    private List<Expression> args;

    public Function(String methodName, List<Expression> args) {
        this.methodName = methodName;
        this.args = args;
    }


    @Override
    public Object resolve() {
        return null;
    }
}
