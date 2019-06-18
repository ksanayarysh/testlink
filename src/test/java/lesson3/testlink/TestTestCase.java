package lesson3.testlink;

import lesson3.testlink.locators.Locators;
import lesson3.testlink.models.LoginPage;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

public class TestTestCase extends BaseTest {


    @Test
    public void test() throws InterruptedException, IOException {
        new Colors();
        new LoginPage(wd).init(baseURI)
                .login("admin", "admin")
                .pressTestExecute()
                .selectTestCaseForExecute("TestSuite2", "Проверка входа с правильными creds")
                .checkStatusByColor();
                //.setTestStatus("p", Locators.testPassed);
                //.selectTestCaseForExecute(testSuiteName, testCase1.getName())
                //.setTestStatus("f", Locators.testFailed);
    }


    @Test
    public void color()  {
        new Colors();
        System.out.println(Colors.statusColor);
    }
}
