package Tests;


import Pages.Buttons;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ButtonsTests extends BaseTest {

    protected Buttons buttons;


    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        buttons = new Buttons(driver, webDriverWait);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        generalComponents.getPractice().click();
        generalComponents.getButtons().click();
    }

    //Tests for checking clicks
    @Test
    public void oneClick() {
        buttons.oneClick();
        Assert.assertEquals(buttons.oneClickMessage(), "Button clicked");
    }

    @Test
    public void doubleClick() {
        buttons.twoClicks();
        Assert.assertEquals(buttons.doubleClickMessage(), "Button double clicked");
    }

    @Test
    public void rightButtonClick() {
        buttons.rightButtonClick();
        Assert.assertEquals(buttons.rightClickMessage(), "Button right mouse clicked");
    }

    //Tests for checking radio buttons
    @Test
    public void radioButtonOptionOne() {
        buttons.clickOne();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(buttons.getRadioButtonText(), "option1 clicked"));
        Assert.assertEquals(buttons.radioButtonTextMsg(), "option1 clicked");
    }

    @Test
    public void radioButtonOptionTwo() {
        buttons.clickTwo();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(buttons.getRadioButtonText(), "option2 clicked"));
        Assert.assertEquals(buttons.radioButtonTextMsg(), "option2 clicked");
    }

    //Tests for checking select in drop-down menu
    @Test
    public void checkSelectFirstOption() {
        js.executeScript("window.scrollBy(0,1000)");
        buttons.getSelectOption().click();
        buttons.selectOption("option1");
        Assert.assertEquals(buttons.getSelectOption().getAttribute("value"), "option1");
    }

    @Test
    public void checkSelectSecondOption() {
        js.executeScript("window.scrollBy(0,1000)");
        buttons.getSelectOption().click();
        buttons.selectOption("option2");
        Assert.assertEquals(buttons.getSelectOption().getAttribute("value"), "option2");
    }

    @Test
    public void checkSelectThirdOption() {
        js.executeScript("window.scrollBy(0,1000)");
        buttons.getSelectOption().click();
        buttons.selectOption("option3");
        Assert.assertEquals(buttons.getSelectOption().getAttribute("value"), "option3");
    }

    //Tests for checkboxes

    @Test
    public void checkboxOne() {
        js.executeScript("window.scrollBy(0,1500)");
        buttons.clickCheckboxOne();
        Assert.assertEquals(buttons.getCheckboxOneMsg().getText(), "Checkbox 1 checked");
    }

    @Test
    public void checkboxTwo() {
        js.executeScript("window.scrollBy(0,1500)");
        buttons.clickCheckboxTwo();
        Assert.assertEquals(buttons.getCheckboxTwoMsg().getText(), "Checkbox 2 checked");

    }

    @Test
    public void checkboxThree() {
        js.executeScript("window.scrollBy(0,1500)");
        buttons.clickCheckboxThree();
        Assert.assertEquals(buttons.getCheckboxThreeMsg().getText(), "Checkbox 3 checked");

    }

    //Test for checking links
    @Test
    public void checkYouTubeLink() {
        js.executeScript("window.scrollBy(0,1500)");
        buttons.getYouTube().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/@commitquality");
    }

    @Test
    public void checkYouTubeInNewTab() {
        js.executeScript("window.scrollBy(0,1500)");
        buttons.getYouTubeNewTab().click();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(driver.getTitle(), "CommitQuality - YouTube");
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void checkLinkPracticePage() {
        js.executeScript("window.scrollBy(0,1500)");
        buttons.getPracticePage().click();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://commitquality.com/practice");
        driver.close();
        driver.switchTo().window(browserTabs.get(0));

    }


    @Override
    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
}
