package lesson3.testlink.models;

import lesson3.testlink.locators.Locators;
import lesson3.testlink.objects.TestPlan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPlanPage extends BasePage {
    public TestPlanPage(WebDriver wd) {
        super(wd);
    }

    public PlanManagementPage createTestPlan() throws InterruptedException {
        setTextValue(Locators.testPlanName, testPlan.getName());
        //sleep(1000);
        new WebDriverWait(wd, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        setTextValue(Locators.textArea, testPlan.getDescription());
        switchToParentFrame();
        clickElement(Locators.isPublic);
        clickElement(Locators.saveTestPlan);
        return new PlanManagementPage(wd);
    }


}
