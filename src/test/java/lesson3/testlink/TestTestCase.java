package lesson3.testlink;

import lesson3.testlink.enums.TestStatus;
import lesson3.testlink.locators.Locators;
import lesson3.testlink.models.LoginPage;
import lesson3.testlink.objects.Creds;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestTestCase extends BaseTest {


    @Test
    public void test() throws InterruptedException, IOException {
        new LoginPage(wd).init(baseURI)
                .login(Creds.login, Creds.password)
                .pressTestExecute()
                .selectTestCaseForExecute(
                        testSuiteName,
                        testCase1.getName(),
                        "")
                .checkStatusByColor()
                .setTestStatusPassed()
                .selectTestCaseForExecute(
                        testSuiteName,
                        testCase1.getName(),
                        TestStatus.PASSED.getColorMaskInTree())
                .checkStatusByColor()
                .setTestStatusFailed()
                .selectTestCaseForExecute(
                        testSuiteName,
                        testCase1.getName(),
                        TestStatus.FAILED.getColorMaskInTree());
    }


    @Test
    public void color() {
        for (TestStatus ts : TestStatus.values())
            System.out.println(ts + "   " + ts.getShortName());
    }


    @Test
    public void ets() {
        System.out.println(Creds.login);
    }
}
