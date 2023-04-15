package Tests;

import Pages.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseTest {

    ContactUsPage contactUsPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        contactUsPage = new ContactUsPage(driver, webDriverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        generalComponents.getPractice().click();
        generalComponents.getContactUs().click();
    }

    // Adding information in the needed fields one by one
    @Test
    public void contactUsForm() {
        contactUsPage.addName("Marie");
        contactUsPage.addEmail("marie356@mail.com");

        contactUsPage.getQueryType().click();
        contactUsPage.selectQuery("General");

        contactUsPage.getDateOfBirth().click();
        contactUsPage.addBirthYear("01121991");

        contactUsPage.getCheckBox().click();
        contactUsPage.getSubmit().click();

        Assert.assertEquals(contactUsPage.note(), "Thanks for contacting us, we will never respond!");
    }

    // Adding information in the needed fields using only one method
    @Test
    public void contactUSForm() {
        contactUsPage.contactUs("Dane", "dane3@mail.com", "Billing", "08021990");

        Assert.assertEquals(contactUsPage.note(), "Thanks for contacting us, we will never respond!");

    }

    @AfterClass
    @Override
    public void afterClass() {
        super.afterClass();
    }
}
