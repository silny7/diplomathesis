package silny7.uniba.sk.unity.program.configuration;

import java.util.Arrays;
import java.util.List;

public class ConfigurationFields {


    //LOGGING
    public static final String LOG_DECLARATIONS = "log.declarations";
    public static final String LOG_INITIALIZATIONS = "log.initializations";
    public static final String LOG_ASSIGNMENTS = "log.assignments";
    public static final String LOG_ALL = "log.all";

    //threads
    public static final String MULTITHREAD = "multithread.enabled";

    public static final List<String> CONFIGURATION_FIELDS = Arrays.asList(LOG_ALL, LOG_DECLARATIONS, LOG_INITIALIZATIONS, LOG_ASSIGNMENTS, MULTITHREAD);


}
