package lesson3.testlink.models;

import org.openqa.selenium.WebDriver;
import lesson3.testlink.locators.Locators;

public class TestProjectPage extends BasePage {
    public TestProjectPage(WebDriver wd) {
        super(wd);
    }

    public void addTestSuite(){
        clickElement(Locators.newTestSuiteButton);
    }

    public AddTestSuitePage pressTestSuiteSettings(){
        log.info("pressTestSuiteSettings");
        switchToFrame(1);
        clickElement(Locators.settingsLink);
        addTestSuite();
        return new AddTestSuitePage(wd);
    }
}