package lesson3.testlink.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

public class NavigatorPage extends BasePage {
    public NavigatorPage(WebDriver wd) {
        super(wd);
    }


    public TestSuitePage selectTestSuit(String testSuiteName) throws InterruptedException {
        switchToParentFrame();
        sleep(3000);
        switchToFrame(0);
        List<WebElement> testSuites = wd.findElements(By.cssSelector("ul[class=x-tree-node-ct] li"));
        for (WebElement testSuite : testSuites) {
            if (testSuite.getText().contains(testSuiteName + " (")) {
                testSuite.findElement(By.cssSelector("li  a span span")).click();
            }

        }
        return new TestSuitePage(wd);
    }


    public TestCasePage selectTestCase(String testSuiteName, String testCaseName) throws InterruptedException {
        log.info("selectTestCase");
        switchToParentFrame();
        WebDriverWait wait = new WebDriverWait(wd,15);
        sleep(3000);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        List<WebElement> testSuites = wd.findElements(By.cssSelector("ul[class=x-tree-node-ct] li"));
        for (WebElement testSuite : testSuites) {
            if (testSuite.getText().contains(testSuiteName + " (")) {
                List<WebElement> arrow = testSuite.findElements(By.cssSelector("img[class*=\"-plus\"]"));
                if (arrow.size() > 0) {
                    arrow.get(0).click();
                }

                List<WebElement> testCases = testSuite.findElements(By.cssSelector("ul li a span"));
                for (WebElement testCase : testCases) {
                    if (testCase.getText().contains(testCaseName)) {
                        testCase.click();
                    }
                }

            }
        }


        switchToParentFrame();
        return new TestCasePage(wd);
    }

}

