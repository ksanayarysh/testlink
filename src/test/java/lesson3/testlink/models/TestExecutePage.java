package lesson3.testlink.models;

import lesson3.testlink.Colors;
import lesson3.testlink.TestTestCase;
import lesson3.testlink.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Thread.sleep;

public class TestExecutePage extends BasePage {
    public TestExecutePage(WebDriver wd) {
        super(wd);
    }


    private void setTestStepResult(String result) {
        List<WebElement> status = wd.findElements(By.cssSelector("[class=step_status]"));
        for (WebElement s: status){
            Select sel = new Select(s);
            sel.selectByValue(result);
        }
    }

    private void setTestResult(By testResultLocator){
        clickElement(testResultLocator);
    }


    public TestExecutePage checkStatusByColor() throws InterruptedException {
        sleep(3000);
        switchToFrame(1);
        String backgroundColor = wd.findElements(Locators.executeHistoryLastResult).get(0)
                .getCssValue("background-color");
        List<WebElement> element = wd.findElements(Locators.executeHistoryLastResult);
        System.out.println(backgroundColor);

        for (WebElement e: element) {
            System.out.println(e.getText());
        }

        assert checkColor(backgroundColor, Colors.statusColor.get(element.get(0).getText()));
        return this;
//
//        setTestStatus("p", Locators.testPassed);
//
//
//        List<WebElement> actualStatus = wd.findElements(Locators.executeHistoryPassed);
//
//        if (actualStatus.size() > 0){
//            System.out.println("Ура!");
//            System.out.println(actualStatus.get(0).getCssValue("background-color"));
//        }
//        assert checkColor(backgroundColor, colorPassedRegExp);
//
//
//        setTestStatus("f", Locators.testFailed);
//        //assert
//        actualStatus = wd.findElements(Locators.executeHistoryFailed);
//
//        if (actualStatus.size() > 0){
//            System.out.println("Упс!");
//            System.out.println(actualStatus.get(0).getCssValue("background-color"));
//        }
//
//        assert checkColor(backgroundColor, colorFailedRegExp);

    }

    public NavigatorPage setTestStatus(String testResultValue, By testPassed) {
        setTestStepResult(testResultValue);
        setTestResult(testPassed);
        return new NavigatorPage(wd);
    }


}
