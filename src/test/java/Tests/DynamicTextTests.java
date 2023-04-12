package Tests;

import Pages.DynamicTextPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicTextTests extends BaseTest {

    DynamicTextPage dynamicTextPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        dynamicTextPage = new DynamicTextPage(driver, webDriverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        generalComponents.getPractice().click();
        generalComponents.getDynamicTexts().click();
    }

    @Test
    public void checkDynamicText(){
        dynamicTextPage.getButton().click();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(dynamicTextPage.getButton(), "I am visible after 5 seconds"));

        Assert.assertEquals(dynamicTextPage.buttonText(), "I am visible after 5 seconds");
    }

    @Override
    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
}
