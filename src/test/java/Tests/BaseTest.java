package Tests;

import Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected final String BASE_URL = "https://commitquality.com";
    protected GeneralComponentsPage generalComponents;
    protected JavascriptExecutor js;

    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        generalComponents = new GeneralComponentsPage(driver, webDriverWait);
        js = (JavascriptExecutor) driver;
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://commitquality.com");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}