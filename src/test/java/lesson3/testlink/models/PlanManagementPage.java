package lesson3.testlink.models;

import lesson3.testlink.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlanManagementPage extends BasePage{
    public PlanManagementPage(WebDriver wd) {
        super(wd);
    }

    public TestPlanPage pressCreateButton(){
        clickElement(Locators.createTestPlanButton);
        return new TestPlanPage(wd);
    }

    public boolean checkPlanPresence() {
        List<WebElement> tableRows = wd.findElements(By.cssSelector("#item_view tbody tr"));
        for (WebElement row:tableRows) {
            List<WebElement> td = row.findElements(By.cssSelector("td"));

            if (td.get(0).getText().equals(testPlan.getName())
                    && td.get(1).getText().equals(testPlan.getDescription())
                    && td.get(5).findElement(By.cssSelector("img")).getAttribute("title").equals("Public")){
                return true;
            }
        }
        return false;
    }
}
