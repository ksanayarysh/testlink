package lesson3.testlink;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver wd;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","/home/ksenia/tools/chromedriver");

        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterAll
    public static void tearDown() {
        wd.quit();
    }
}
