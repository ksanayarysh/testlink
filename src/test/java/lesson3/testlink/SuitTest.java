package lesson3.testlink;


import org.junit.jupiter.api.Test;
import lesson3.testlink.models.*;
import lesson3.testlink.objects.TestCaseObject;

public class SuitTest extends BaseTest {


    private final TestCaseObject testCase2 = new TestCaseObject("Test Case 2",
            "Summary 2", "Preconditions 2");

//    @Test
//    void testCreateSuiteWithTestCases() throws InterruptedException {
//        new LoginPage(wd).init(baseURI)
//                .login("admin", "admin")
//                .pressTestSpecificationLink()
//                .pressTestSuiteSettings()
//                .createNewTestSuite(testSuiteName, "Details")
//                .selectTestSuit(testSuiteName)
//                .pressSuiteSettingsButton()
//                .pressAddTestCaseButton()
//                .createTestCase(testCase1)
//                .selectTestSuit("")
//                .pressSuiteSettingsButton()
//                .pressAddTestCaseButton()
//                .createTestCase(testCase2);
//    }


    @Test
    void test() throws InterruptedException {
        testCase1.addStep("Зайти по адресу localhost/testlink");
        testCase1.addStep("Ввести логин test");
        testCase1.addStep("Ввести пароль test");
        testCase1.addStep("Нажать кнопку войти");


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
                .createSteps(testCase1);
//                .selectTestSuit(testSuiteName)
//                .pressSuiteSettingsButton()
//                .pressAddTestCaseButton()
//                .createTestCase(testCase2)
//                .selectTestCaseForEdit(testSuiteName, testCase2.getName())
//                .createSteps();
    }

}
