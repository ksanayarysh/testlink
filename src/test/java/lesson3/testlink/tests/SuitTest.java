package lesson3.testlink.tests;


import org.junit.jupiter.api.Test;
import lesson3.testlink.models.*;

public class SuitTest extends BaseTest {
    @Test
    void testCreateTestCaseWithSteps() throws InterruptedException {
        new LoginPage(wd).init(baseURI)
                .login("admin", "admin")
                .pressTestSpecificationLink()
                .pressTestSuiteSettings()
                .createNewTestSuite(testSuiteName, "Details")
                .selectTestSuit(testSuiteName)
                .pressSuiteSettingsButton()
                .pressAddTestCaseButton()
                .createTestCase(testCase1)
                .selectTestCaseForEdit(testSuiteName, testCase1.getName())
                .createSteps(testCase1)
                .selectTestSuit(testSuiteName)
                .pressSuiteSettingsButton()
                .pressAddTestCaseButton()
                .createTestCase(testCase2)
                .selectTestCaseForEdit(testSuiteName, testCase2.getName())
                .createSteps(testCase2);
    }

}
