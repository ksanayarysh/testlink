package lesson3.testlink.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lesson3.testlink.locators.Locators;

import static java.lang.Thread.sleep;

public class TestCasePage extends BasePage {
    public TestCasePage(WebDriver wd) {
        super(wd);
    }

    private void createOneStep(String stepName, By saveStepButton) throws InterruptedException {
        log.info("createOneStep  " + stepName);
        sleep(3000);
        WebDriverWait wait = new WebDriverWait(wd,15);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        setTextValue(Locators.textArea, stepName);
        switchToParentFrame();
        clickElement(saveStepButton);
    }

    public NavigatorPage createSteps() throws InterruptedException {
        log.info("create Steps");

        switchToFrame(1);
        clickElement(Locators.testCaseStepCreateButton);
        createOneStep("first step", Locators.testCaseStepSaveButton);
        createOneStep("second step", Locators.testCaseStepSaveButton);
        createOneStep("third  step", Locators.testCaseStepSaveAndExitButton);
        return new NavigatorPage(wd);
    }



}
