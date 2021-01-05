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

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(methodName);
        boolean first = true;
        for (Expression arg : args){
            if (!first) string.append(", ");
            else first = false;
            string.append(arg.toString());
        }
        return string.toString();
    }
}
