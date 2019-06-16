package lesson3.testlink;


import org.junit.jupiter.api.Test;
import lesson3.testlink.models.*;
import lesson3.testlink.objects.TestCaseObject;

public class SuitTest extends BaseTest {
    private final String baseURI = "http://localhost/testlink/";
    private final String testSuiteName = "TestSuite1";
    private final TestCaseObject testCase1 = new TestCaseObject("Test Case 1",
            "Summary 1", "Preconditions 1");
    private final TestCaseObject testCase2 = new TestCaseObject("Test Case 2",
            "Summary 2", "Preconditions 2");

    @Test
    void testCreateSuiteWithTestCases() throws InterruptedException {
        new LoginPage(wd).init(baseURI)
                .login("admin", "admin")
                .pressTestSpecificationLink()
                .pressTestSuiteSettings()
                .createNewTestSuite(testSuiteName, "Details")
                .selectTestSuit(testSuiteName)
                .pressSuiteSettingsButton()
                .pressAddTestCaseButton()
                .createTestCase(testCase1)
                .selectTestSuit("")
                .pressSuiteSettingsButton()
                .pressAddTestCaseButton()
                .createTestCase(testCase2);
    }


    @Test
    void test() throws InterruptedException {
        new LoginPage(wd).init(baseURI)
                .login("admin", "admin")
                .pressTestSpecificationLink()
                .pressTestSuiteSettings()
                .createNewTestSuite(testSuiteName, "Details")
                .selectTestSuit(testSuiteName)
                .pressSuiteSettingsButton()
                .pressAddTestCaseButton()
                .createTestCase(testCase1)
                .selectTestCase(testSuiteName, testCase1.getName())
                .createSteps()
                .selectTestSuit(testSuiteName)
                .pressSuiteSettingsButton()
                .pressAddTestCaseButton()
                .createTestCase(testCase2)
                .selectTestCase(testSuiteName, testCase2.getName())
                .createSteps();
    }

}
