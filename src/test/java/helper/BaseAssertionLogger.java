package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;

public class BaseAssertionLogger {
    private static final Logger logger = LogManager.getLogger(BaseAssertionLogger.class);

    public static <T> void logAndAssert(T actual, org.hamcrest.Matcher<? super T> matcher,
                                        String passMessage, String failMessage, String valueName) {
        try {
            assertThat(failMessage,actual,matcher);
            logger.info("✅ Assertion Passed in {}: {} | Actual: {}", valueName, passMessage, actual);
        } catch (AssertionError e) {

            logger.error("❌ Assertion Failed in {}: {} | Actual: {}", valueName, failMessage, actual);
            throw e;
        }
    }


}
