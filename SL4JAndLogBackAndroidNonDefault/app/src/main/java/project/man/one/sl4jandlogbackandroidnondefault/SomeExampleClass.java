package project.man.one.sl4jandlogbackandroidnondefault;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rafal on 4.3.16.
 */
public class SomeExampleClass {

    private Logger logger = LoggerFactory.getLogger(SomeExampleClass.class);


    public SomeExampleClass() {
        logger.debug("Enter");

    }

    public void testMetod() {
        logger.error("Some error");
    }
}
