package lesson3.testlink.models;

import org.openqa.selenium.WebDriver;
import lesson3.testlink.locators.Locators;

public class MainPage extends BasePage {
    public MainPage(WebDriver wd) {
        super(wd);
    }

    public TestProjectPage pressTestSpecificationLink(){
        switchToFrame(1);
        clickElement(Locators.testSpecLink);
        return new TestProjectPage(wd);
    }
}
