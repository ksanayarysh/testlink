package lesson3.testlink.models;

import org.openqa.selenium.WebDriver;
import lesson3.testlink.locators.Locators;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver wd) {
        super(wd);
    }

    public LoginPage init(String url) {
        wd.get(url);
        return this;
    }

    private void setUserName(String userName){
        setTextValue(Locators.loginField, userName);

    }

    private void setPassword(String password){
        setTextValue(Locators.passwordField, password);

    }

    private void pressLoginButton(){
        clickElement(Locators.submitButton);

    }

    public DashboardPage login(String userName, String password){
        setUserName(userName);
        setPassword(password);
        pressLoginButton();
        return new DashboardPage(wd);
    }

}
