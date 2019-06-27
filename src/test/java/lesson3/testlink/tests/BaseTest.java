package lesson3.testlink.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson3.testlink.objects.TestCaseObject;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static WebDriver wd;

    protected final String baseURI = "http://localhost:12325/testlink/";
    protected final String testSuiteName = "TestSuite3";
    private static ProxyServer server;
    protected TestCaseObject testCase1 = new TestCaseObject();


    protected TestCaseObject testCase2 = new TestCaseObject("Test Case 2",
            "Summary 2", "Preconditions 2");


    @BeforeAll
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();

        server = new ProxyServer(4444);
        server.start();

        Proxy proxy = server.seleniumProxy();
        proxy.setHttpProxy("localhost:4444");


        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PROXY, proxy);
        wd = new ChromeDriver(options);

        server.newHar("testlink");

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterAll
    public static void tearDown() throws IOException {
        Har har = server.getHar();
        har.writeTo(new File( System.getProperty("user.dir") + "/logs.json"));
        wd.quit();

    }
}
