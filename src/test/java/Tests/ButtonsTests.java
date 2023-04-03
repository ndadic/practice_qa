package Tests;


import Pages.Buttons;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class ButtonsTests extends BaseTest{

    protected Buttons buttons;
    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        buttons = new Buttons(driver, webDriverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        generalComponents.getButtons().click();
    }

    @Test
    public void oneClick(){
        buttons.oneClick();
        Assert.assertEquals(buttons.oneClickMessage(), "Button clicked");
    }

    @Test
    public void doubleClick(){
        buttons.twoClicks();
        Assert.assertEquals(buttons.doubleClickMessage(), "Button double clicked");
    }

    @Test
    public void rightButtonClick(){
        buttons.rightButtonClick();
        Assert.assertEquals(buttons.rightClickMessage(), "Button right mouse clicked");
    }

    @Test
    public void radioButtonOptionOne(){
        buttons.clickOne();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(buttons.getRadioButtonText(), "option1 clicked"));
        Assert.assertEquals(buttons.radioButtonTextMsg(), "option1 clicked");
    }

    @Test
    public void radioButtonOptionTwo(){
        buttons.clickTwo();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(buttons.getRadioButtonText(), "option2 clicked"));
        Assert.assertEquals(buttons.radioButtonTextMsg(), "option2 clicked");
    }
    @Override
    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
}
