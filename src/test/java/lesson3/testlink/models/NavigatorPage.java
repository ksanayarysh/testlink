package lesson3.testlink.models;

import lesson3.testlink.locators.Locators;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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

    public String selectTestCase(String testSuiteName, String testCaseName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(wd, 15);
        sleep(3000);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        List<WebElement> testSuites = wd.findElements(By.cssSelector("ul[class=x-tree-node-ct] li"));
        String backgroundColor = "";
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
                        backgroundColor = testCase.getCssValue("background-color");
                    }
                }

            }
        }


        switchToParentFrame();
        return backgroundColor;
    }


    public TestCasePage selectTestCaseForEdit(String testSuiteName, String testCaseName) throws InterruptedException {
        log.info("selectTestCaseForEdit");
        switchToParentFrame();
        selectTestCase(testSuiteName, testCaseName);
        return new TestCasePage(wd);
    }

    public TestExecutePage selectTestCaseForExecute(String testSuiteName, String testCaseName) throws InterruptedException, IOException {
        log.info("selectTestCaseForExecute");
        String backgroundColor = selectTestCase(testSuiteName, testCaseName);
        System.out.println(backgroundColor);
        //assert backgroundColor.equals(Locators.colorNotRunRegExp);

        File srcFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("screenshot.png"));
        return new TestExecutePage(wd);
    }


}

