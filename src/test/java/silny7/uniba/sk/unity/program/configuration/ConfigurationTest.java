package silny7.uniba.sk.unity.program.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ConfigurationTest {

    @BeforeAll
    public static void setup() {
        Configuration.loadDefaultConfig();
    }

    @Test
    public void getDefaultConfiguration(){
        Assertions.assertFalse(Configuration.isLogDeclarations());
        Assertions.assertFalse(Configuration.isLogInitializations());
        Assertions.assertFalse(Configuration.isLogAssignments());
        Assertions.assertTrue(Configuration.isLogAll());
        Assertions.assertFalse(Configuration.isMultithreading());
    }

    @Test
    public void changeProperty() throws IOException {
        Configuration.setProperty("testProperty", "test");
        Configuration.saveProperties();
        Configuration.loadConfiguration();
        Assertions.assertEquals("test", Configuration.getProperty("testProperty"));
    }
}
