package lesson3.testlink.locators;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;



public class Locators {
    public static By loginField = By.cssSelector("#tl_login");
    public static By passwordField = By.cssSelector("#tl_password");
    public static By submitButton = By.cssSelector("[type=\"submit\"]");


    public static By testSpecLink = By.partialLinkText("Test Specification");
    public static By testExecLink = By.partialLinkText("Execute Tests");

    public static By settingsLink = By.cssSelector("div.workBack [title=Actions]");

    public static By newTestSuiteButton = By.name("new_testsuite");
    public static By testSuiteName = By.cssSelector("#name");
    public static By saveTestSuiteButton = By.xpath("//input[@name='add_testsuite_button']");

    public static By textArea = By.cssSelector(".cke_editable");

    public static By createTestCaseButton = By.cssSelector("[name=create_tc]");

    public static By testCaseNameField = By.cssSelector("[name=testcase_name]");
    public static By testCaseCreateButton = By.id("do_create_button_2");

    public static By testCaseStepCreateButton = By.cssSelector("[name=create_step]");

    public static By testCaseStepSaveButton = By.id("do_update_step");
    public static By testCaseStepSaveAndExitButton = By.id("do_update_step_and_exit");


    public static By testPassed = By.cssSelector("div[class=resultBox] img[title=\"Click to set to passed\"]");
    public static By testFailed = By.cssSelector("div[class=resultBox] img[title=\"Click to set to failed\"]");

    public static By executeHistoryNotRun = By.cssSelector("#execution_history div[class=not_run]");
    public static By executeHistoryPassed = By.cssSelector("#execution_history tr td[class=passed]");
    public static By executeHistoryFailed = By.cssSelector("#execution_history tr td[class=failed]");

    public static By executeHistoryLastResult = By.cssSelector("#execution_history tr td[class][title]");

}
