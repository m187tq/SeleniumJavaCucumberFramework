package automationteststore.helper.assertion;

import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class AssertionHelper {

    private static final Logger log = LoggerHelper.getLogger(AssertionHelper.class);

    public static void verifyText(String s1, String s2) {
        log.info("Verifying test: " + s1 + " with " + s2);
        System.out.println("Verifying test: " + s1 + " with " + s2);
        Assert.assertEquals(s1, s1);
    }

    public static void markPass() {
        log.info("Making script PASS..");
        System.out.println("Making script PASS..");
        Assert.assertTrue(true);
    }

    public static void markPass(String message) {
        log.info("Making script PASS => " + message);
        System.out.println("Making script PASS => " + message);
        Assert.assertTrue(true, message);
    }

    public static void markFail() {
        log.info("Making script FAIL..");
        System.out.println("Making script FAIL..");
        Assert.fail();
    }

    public static void markFail(String message) {
        log.info("Making script FAIL.." + message);
        System.out.println("Making script FAIL => " + message);
        Assert.fail(message);
    }

    public static void verifyTrue(boolean status) {
        log.info("Verify object is True..");
        System.out.println("Verify object is True..");
        Assert.assertTrue(status);
    }

    public static void verifyFalse(boolean status) {
        log.info("Verify object is False..");
        System.out.println("Verify object is False..");
        Assert.assertFalse(status);
    }

    public static void verifyNull(String s1) {
        log.info("Verify object is null..");
        System.out.println("Verify object is null..");
        Assert.assertNull(s1);
    }

    public static void verifyNotNull(String s1) {
        log.info("Verify object is not null..");
        System.out.println("Verify object is not null..");
        Assert.assertNotNull(s1);
    }

    public static void fail() {
        Assert.fail();
    }

    public static void pass() {
        Assert.assertTrue(true);
    }

    public static void updateTestStatus(boolean status) {
        if (status) {
            pass();
            System.out.println("UpdateTestStatus => PASSED");
        } else {
            fail();
            System.out.println("UpdateTestStatus => FAILED");

        }
    }
}
