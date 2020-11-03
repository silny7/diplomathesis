package silny7.uniba.sk.unity.sections;

import silny7.uniba.sk.unity.statements.VariableDeclaration;

import java.util.ArrayList;
import java.util.List;


/**
 * we are not interested in the variables as they are.
 * for now, all we have to do is get all the variable names in declare section
 * register them to the variables register with suitable type
 */

public class DeclareSection {
    List<VariableDeclaration> declarations;


    public List<VariableDeclaration> getDeclarations() { return declarations; }
    public void setDeclarations(List<VariableDeclaration> declarations) { this.declarations = declarations; }

    public void declareVariables(){
        //for each variable, register it to memory with correct type
        for (VariableDeclaration variableDeclaration : declarations){
            variableDeclaration.declare();
        }
    }


    public void add(VariableDeclaration variableDeclaration) {
        if (declarations == null) declarations = new ArrayList<VariableDeclaration>();
        declarations.add(variableDeclaration);
    }
}
