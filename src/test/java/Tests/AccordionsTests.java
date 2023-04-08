package Tests;

import Pages.AccordionsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccordionsTests extends BaseTest {

    protected AccordionsPage accordionsPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        accordionsPage = new AccordionsPage(driver, webDriverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        generalComponents.getPractice().click();
        generalComponents.getAccordions().click();
    }

    @Test
    public void accordionOneTests() {
        accordionsPage.clickAccordionOne();
        accordionsPage.oneClick();
        Assert.assertEquals(accordionsPage.oneClickMsg(), "Button clicked");

        accordionsPage.doubleClick();
        Assert.assertEquals(accordionsPage.doubleClickMsg(), "Button double clicked");

        accordionsPage.rightClick();
        Assert.assertEquals(accordionsPage.rightClickMsg(), "Button right mouse clicked");
    }

    @Test
    public void accordionTwoTests() {
        accordionsPage.getAccordionTwo().click();

        accordionsPage.getOptionOne().click();
        Assert.assertEquals(accordionsPage.getAccordionTwoMsg().getText(), "option1 clicked");

        accordionsPage.getOptionTwo().click();
        Assert.assertEquals(accordionsPage.getAccordionTwoMsg().getText(), "option2 clicked");
    }

    @Test
    public void accordionThreeTests(){
        accordionsPage.getAccordionThree().click();

        accordionsPage.clickCheckboxOne();
        Assert.assertEquals(accordionsPage.checkboxOneMsg(), "Checkbox 1 checked");

        accordionsPage.clickCheckboxTwo();
        Assert.assertEquals(accordionsPage.checkboxTwoMsg(), "Checkbox 2 checked");

        accordionsPage.clickCheckboxThree();
        Assert.assertEquals(accordionsPage.checkboxThreeMsg(), "Checkbox 3 checked");
    }

    @AfterClass
    @Override
    public void afterClass() {
        super.afterClass();
    }
}

