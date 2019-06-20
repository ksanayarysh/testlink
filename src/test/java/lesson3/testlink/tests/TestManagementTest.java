package lesson3.testlink.tests;

import lesson3.testlink.models.LoginPage;
import lesson3.testlink.objects.Creds;
import org.junit.jupiter.api.Test;

public class TestManagementTest extends BaseTest {
    @Test
    public void testTestManagement() throws InterruptedException {
        boolean isTestPresent = new LoginPage(wd).init(baseURI)
                .login(Creds.login, Creds.password)
                .pressPlanManagement()
                .pressCreateButton()
                .createTestPlan()
                .checkPlanPresence();
        assert isTestPresent;
    }
}
