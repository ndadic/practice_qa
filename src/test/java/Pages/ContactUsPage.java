package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage {

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"query-type\"]")
    private WebElement queryType;

    @FindBy(id = "dob")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/div[5]/label/input")
    private WebElement checkBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/button")
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]")
    private WebElement message;

    public ContactUsPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    // Method to add your name in the name filed
    public void addName(String yourName) {
        name.clear();
        name.sendKeys(yourName);
    }

    // Method to add your email in the mail field
    public void addEmail(String yourEmail) {
        email.clear();
        email.sendKeys(yourEmail);
    }

    // Method to select query
    public void selectQuery(String text) {
        queryType.click();
        Select drop = new Select(queryType);
        drop.selectByValue(text);
    }

    // Method to add birth year
    public void addBirthYear(String year) {
        dateOfBirth.click();
        dateOfBirth.sendKeys(year);
    }

    // Method to fill contact us form
    public void contactUs(String yourName, String yourEmail, String text, String year) {
        addName(yourName);
        addEmail(yourEmail);
        selectQuery(text);
        addBirthYear(year);
        checkBox.click();
        submit.click();

    }

    // Method to get a message after completing contact us form
    public String note() {
        String messageContactUs = message.getText();
        return messageContactUs;

    }

    public WebElement getQueryType() {
        return queryType;
    }

    public WebElement getDateOfBirth() {
        return dateOfBirth;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public WebElement getSubmit() {
        return submit;
    }
}
