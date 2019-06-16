package lesson3.testlink.models;

import org.openqa.selenium.WebDriver;
import lesson3.testlink.locators.Locators;
import lesson3.testlink.objects.TestCaseObject;

public class AddTestCasePage extends NavigatorPage {

    public AddTestCasePage(WebDriver wd) {
        super(wd);
    }

    public NavigatorPage createTestCase(TestCaseObject testCase) {
        log.info("test case create");
        setTextValue(Locators.testCaseNameField, testCase.getName());
        switchToFrame(0);
        setTextValue(Locators.textArea, testCase.getSummary());
        switchToParentFrame();
        switchToFrame(1);
        setTextValue(Locators.textArea, testCase.getPreconditions());
        switchToParentFrame();;
        clickElement(Locators.testCaseCreateButton);
        return new NavigatorPage(wd);
    }
}
