package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.expressions.Expression;
import silny7.uniba.sk.unity.expressions.Variable;
import silny7.uniba.sk.unity.expressions.functions.Functions;
import silny7.uniba.sk.unity.program.UnityProgram;
import silny7.uniba.sk.unity.program.UnityProgramMemory;
import silny7.uniba.sk.unity.program.memory.MemoryCopy;

import java.util.List;

import static silny7.uniba.sk.unity.expressions.functions.Functions.*;

public class Quantification {

    List<Variable> boundedVars;
    Expression boolExpr;
    List<MemoryCopy> memorySnapshots;

    public Quantification(List<Variable> boundedVars, Expression boolExpr) {
        this.boolExpr = boolExpr;
        this.boundedVars = boundedVars;
    }

    public void initVariables(){
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();
        for (Variable var : boundedVars){
            memory.initBoundedVariable(var.getVariableName(), 0);
        }
    }

    public void evaluate(){

    }

    public void destroyVariables(){
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();
        for (Variable var : boundedVars) {
            memory.destroyBoundedVariable(var.getVariableName());
        }
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        boolean first = true;
        for (Variable var : boundedVars){
            if (!first) string.append(", ");
            else first = false;
            string.append(var.toString());
        }
        string.append(": ");
        string.append(boolExpr.toString());
        return string.toString();
    }


}
