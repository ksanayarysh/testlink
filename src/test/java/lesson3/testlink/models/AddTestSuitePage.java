package lesson3.testlink.models;

import org.openqa.selenium.WebDriver;
import lesson3.testlink.locators.Locators;

public class AddTestSuitePage extends BasePage {
    public AddTestSuitePage(WebDriver webDriver) {
        super(webDriver);
    }

    private void setSuiteName(String name){
        setTextValue(Locators.testSuiteName, name);

    }

    private void setSuiteDetails(String details){
        setTextValue(Locators.textArea, details);

    }

    private void saveSuite(){
        clickElement(Locators.saveTestSuiteButton);

    }

    public NavigatorPage createNewTestSuite(String testSuiteName, String details){
        log.info("createNewTestSuite");
        setSuiteName(testSuiteName);
        switchToFrame(0);
        setSuiteDetails(details);
        switchToParentFrame();
        saveSuite();
        return new NavigatorPage(wd);
    }

}
