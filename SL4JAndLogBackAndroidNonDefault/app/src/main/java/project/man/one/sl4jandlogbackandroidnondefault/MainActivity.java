package project.man.one.sl4jandlogbackandroidnondefault;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class MainActivity extends AppCompatActivity {

    private Logger logger = LoggerFactory.getLogger(MainActivity.class);

    private SomeExampleClass exampleClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureLogging();

        logger.debug("Enter");

        exampleClass = new SomeExampleClass();

        doSomeWork();

        logger.info("Some info !!!");

    }

    private void configureLogging() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.reset();

        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(loggerContext);
            configurator.doConfigure(getApplicationContext().getResources().openRawResource(
                    R.raw.logback));
        } catch (JoranException ignored) {
            /* The following call to StatusPrinter handles this more appropriately */
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
    }

    private void doSomeWork() {
        if (exampleClass != null) {
            exampleClass.testMetod();
        }
    }

}
