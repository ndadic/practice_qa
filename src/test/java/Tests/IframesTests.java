package Tests;

import Pages.IframesPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class IframesTests extends BaseTest {

    protected IframesPage iframesPage;
    protected String productNumber = "Product 2";

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        iframesPage = new IframesPage(driver, webDriverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        generalComponents.getPractice().click();
        generalComponents.getIframes().click();
        driver.switchTo().frame(iframesPage.getIframe());
    }

    @Test
    public void testFilterSearch() {
        iframesPage.filterSearch(productNumber);
        Assert.assertTrue(iframesPage.containsProduct(productNumber));
        iframesPage.getResetButton().click();
    }

    @Test
    public void showMoreBtnNotVisible() {
        js.executeScript("window.scrollBy(0,1500)");
        iframesPage.getShowMoreBtn().click();
        Assert.assertTrue(iframesPage.listSize());
    }


    @Test
    public void addProductBtns() {
        iframesPage.getAddProductBtn().click();
        Assert.assertEquals(iframesPage.addProductHeader(), "Add Product");

        iframesPage.getAddProduct().click();
        Assert.assertEquals(iframesPage.addProductHeader(), "Add Product");
    }

    @Test
    public void addNewProduct() {
        iframesPage.getAddProduct().click();
        js.executeScript("window.scrollBy(0,1500)");
        iframesPage.addProductName("Product 3");
        iframesPage.addPrice("2369");
        iframesPage.selectDate("01092022");
        Assert.assertEquals(iframesPage.getAddedProduct().getText(), "Product 3");
    }

    @Test
    public void cancelBtn() {
        iframesPage.getAddProductBtn().click();
        iframesPage.getCancelBtn().click();
        Assert.assertTrue(iframesPage.getFilterButton().isDisplayed());
    }

    @Test
    public void practiceBtn() {
        iframesPage.getPracticeBtn().click();
        Assert.assertEquals(iframesPage.practiceBtn(), "Note to user: This page is likely to be updated - Things may move around and extra items will be added.");
    }

    @Test
    public void learnBtn(){
        iframesPage.getLearnBtn().click();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(driver.getTitle(), "CommitQuality - YouTube");
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void loginBtn(){
        iframesPage.getLoginBtn().click();
        Assert.assertEquals(iframesPage.loginBtn(), "Login");
    }

    @Test
    public void loginForm(){
        iframesPage.login("test", "test");
        Assert.assertTrue(iframesPage.getMyAcc().isDisplayed());
    }
    @Override
    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
}
