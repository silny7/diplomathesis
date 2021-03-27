package silny7.uniba.sk.unity.program.configuration;

import com.ibm.icu.impl.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ConfigurationTest {

    @BeforeAll
    public static void setup() throws IOException {
        Configuration.loadConfiguration();
    }

    @Test
    public void getDefaultConfiguration(){
        Assertions.assertFalse(Configuration.isLogDeclare());
        Assertions.assertFalse(Configuration.isLogInitially());
        Assertions.assertFalse(Configuration.isLogAlways());
        Assertions.assertFalse(Configuration.isLogAssign());

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
