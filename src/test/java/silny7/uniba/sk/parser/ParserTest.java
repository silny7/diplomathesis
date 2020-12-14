package silny7.uniba.sk.parser;

import org.junit.jupiter.api.Test;
import silny7.uniba.sk.unity.Unity;

public class ParserTest {


    @Test
    public void simpleInputTest(){
        Unity unity = new Unity();
        String program = "Program testProgram \n declare A:integer; \n assign A = 5 + 5 \n END";
        try {
            unity.createProgramFromString(program);
            String h = "";
        } catch (UnityGrammarException e) {
            e.printStackTrace();
        }
    }
}
