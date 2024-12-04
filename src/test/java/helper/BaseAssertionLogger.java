package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.hamcrest.MatcherAssert.assertThat;

public class BaseAssertionLogger {
    private static final Logger logger = LogManager.getLogger(BaseAssertionLogger.class);

    public static <T> void logAndAssert(T actual, org.hamcrest.Matcher<? super T> matcher,
                                        String passMessage, String failMessage) {
        try {
            assertThat(failMessage, actual, matcher);
            logger.info("✅ Assertion Passed: {} | Actual: {}", passMessage, actual);
        } catch (AssertionError e) {
            logger.error("❌ Assertion Failed: {} | Actual: {}", failMessage, actual);
            throw e; // AssertionError'ı tekrar fırlatıyoruz
        }
    }
}
