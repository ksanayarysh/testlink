package lesson3.testlink.models;

import org.openqa.selenium.WebDriver;
import lesson3.testlink.locators.Locators;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver wd) {
        super(wd);
    }

    public TestProjectPage pressTestSpecificationLink(){
        switchToFrame(1);
        clickElement(Locators.testSpecLink);
        return new TestProjectPage(wd);
    }

    public NavigatorPage pressTestExecute(){
        switchToFrame(1);
        clickElement(Locators.testExecLink);
        return new NavigatorPage(wd);
    }
}
