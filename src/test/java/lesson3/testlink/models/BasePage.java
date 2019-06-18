package lesson3.testlink.models;

import lesson3.testlink.Colors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BasePage {

    protected WebDriver wd;

    protected Logger log = LogManager.getLogger(BasePage.class);
    public BasePage(WebDriver wd) {
        new Colors();
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

    protected boolean checkColor(String actualColor, String patternColor) {
        Pattern pattern = Pattern.compile(patternColor);
        Matcher match = pattern.matcher(actualColor);
        return match.find();
    }
}
