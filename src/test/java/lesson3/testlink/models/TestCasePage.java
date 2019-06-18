package lesson3.testlink.models;

import lesson3.testlink.objects.TestCaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import lesson3.testlink.locators.Locators;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;



public class TestCasePage extends BasePage {

    public TestCasePage(WebDriver wd) {
        super(wd);
    }

    private void createOneStep(String stepName, By saveStepButton) throws InterruptedException {
        log.info("createOneStep  " + stepName);
        sleep(3000);
        WebDriverWait wait = new WebDriverWait(wd, 15);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        setTextValue(Locators.textArea, stepName);
        switchToParentFrame();
        clickElement(saveStepButton);
    }

    public NavigatorPage createSteps(TestCaseObject testCase1) throws InterruptedException {
        log.info("create Steps");

        switchToFrame(1);
        clickElement(Locators.testCaseStepCreateButton);
        for (int i = 0; i < testCase1.getStepCount() - 1; i++) {
            createOneStep(testCase1.getStep(i), Locators.testCaseStepSaveButton);
        }
        createOneStep(testCase1.getStep(testCase1.getStepCount() - 1), Locators.testCaseStepSaveAndExitButton);
        return new NavigatorPage(wd);
    }



}
