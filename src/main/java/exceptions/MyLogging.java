package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogging {
    protected static void log(Exception e, String className) {
        final Logger logger = Logger.getLogger(className);
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        logger.log(Level.SEVERE,stringWriter.toString());
    }
}

