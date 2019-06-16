package lesson3.testlink.models;

import org.openqa.selenium.WebDriver;
import lesson3.testlink.locators.Locators;


public class TestSuitePage extends BasePage {
    public TestSuitePage(WebDriver wd) {
        super(wd);
    }

    public TestSuitePage pressSuiteSettingsButton() {
        switchToParentFrame();
        switchToFrame(1);
        clickElement(Locators.settingsLink);
        return this;

    }

    public AddTestCasePage pressAddTestCaseButton() {
        clickElement(Locators.createTestCaseButton);
        return new AddTestCasePage(wd);
    }


}
