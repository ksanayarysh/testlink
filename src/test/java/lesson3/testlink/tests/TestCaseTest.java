package lesson3.testlink.tests;

import lesson3.testlink.enums.TestStatus;
import lesson3.testlink.models.LoginPage;
import lesson3.testlink.objects.Creds;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestCaseTest extends BaseTest {


    @Test
    public void testMarkingTests() throws InterruptedException, IOException {
        new LoginPage(wd).init(baseURI)
                .login(Creds.login, Creds.password)
                .pressTestExecute()
                .selectTestCaseForExecute(
                        testSuiteName,
                        testCase1.getName(),
                        "")
                .checkStatusByColor(TestStatus.NOT_RUN)
                .setTestStatusPassed()
                .selectTestCaseForExecute(
                        testSuiteName,
                        testCase1.getName(),
                        TestStatus.PASSED.getColorMaskInTree())
                .checkStatusByColor(TestStatus.PASSED)
                .setTestStatusFailed()
                .selectTestCaseForExecute(
                        testSuiteName,
                        testCase1.getName(),
                        TestStatus.FAILED.getColorMaskInTree())
                .checkStatusByColor(TestStatus.FAILED);
    }

}
