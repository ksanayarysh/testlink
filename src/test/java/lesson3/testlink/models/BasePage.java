package lesson3.testlink.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasePage {

    protected WebDriver wd;

    protected Logger log = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver wd) {

        this.wd = wd;

    }

    protected LoginPage init(String url){
        wd.get(url);
        return new LoginPage(wd);
    }

    protected void setTextValue(By textField, String value) {
        wd.findElement(textField).clear();
        wd.findElement(textField).sendKeys(value);
    }

    protected void clickElement(By element) {
        wd.findElement(element).click();
    }

    protected void switchToFrame(int i){
        wd.switchTo().frame(i);
    }

    protected void switchToParentFrame(){
        wd.switchTo().parentFrame();
    }
}
