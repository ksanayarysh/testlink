package lesson3.testlink.models;

import lesson3.testlink.enums.TestStatus;
import lesson3.testlink.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Thread.sleep;

public class TestExecutePage extends BasePage {
    public TestExecutePage(WebDriver wd) {
        super(wd);
    }


    private void setTestStepResult(String result) {
        JavascriptExecutor jsx = (JavascriptExecutor) wd;
        jsx.executeScript("window.scrollBy(0, 450)", "");
        List<WebElement> status = wd.findElements(By.cssSelector("[class=step_status]"));
        for (WebElement s: status){
            Select sel = new Select(s);
            sel.selectByValue(result);
        }
    }

    private void setTestResult(By testResultLocator){
        clickElement(testResultLocator);
    }


    public TestExecutePage checkStatusByColor(TestStatus testStatus) throws InterruptedException {
        sleep(1000);
        switchToFrame(1);
        WebElement testElement;

        if (testStatus.equals(TestStatus.NOT_RUN)) {
            testElement = wd.findElements(Locators.executeHistoryNotRun).get(0);
        } else {
            testElement = wd.findElements(Locators.executeHistoryLastResult).get(0);
        }
        String backgroundColor = testElement.getCssValue("background-color");
        assert checkColor(backgroundColor, TestStatus.getTestColorByStatus(testElement.getText()));
        return this;
    }

    public NavigatorPage setTestStatusPassed() {
        setTestStepResult(TestStatus.PASSED.getShortName());
        setTestResult(Locators.testPassed);
        switchToParentFrame();
        return new NavigatorPage(wd);
    }

    public NavigatorPage setTestStatusFailed() {
        setTestStepResult(TestStatus.FAILED.getShortName());
        setTestResult(Locators.testFailed);
        switchToParentFrame();
        return new NavigatorPage(wd);
    }


}
