package Tests;

import Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected final String BASE_URL = "https://commitquality.com/practice";
    protected GeneralComponents generalComponents;

    protected JavascriptExecutor js;
    @BeforeClass
    public void beforeClass() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        generalComponents = new GeneralComponents(driver, webDriverWait);
        js = (JavascriptExecutor) driver;
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}