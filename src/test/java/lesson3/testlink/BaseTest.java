package lesson3.testlink;

import lesson3.testlink.objects.TestCaseObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
    public static WebDriver wd;

    protected final String baseURI = "http://localhost:12325/testlink/";
    protected final String testSuiteName = "TestSuite2";
    protected TestCaseObject testCase1 = new TestCaseObject("Проверка входа с правильными creds",
            "Преверяем возможность логина с верными логином и паролем",
            "Установлен тест-линк, существует пользователь с логин test пароль test");

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();

        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterAll
    public static void tearDown() {
        wd.quit();
    }
}
