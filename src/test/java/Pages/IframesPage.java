package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.util.List;

public class IframesPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/iframe")
    private WebElement iframe;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/input")
    private WebElement filterField;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/button[1]")
    private WebElement filterButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/button[2]")
    private WebElement resetButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/table/tbody/tr")
    private List<WebElement> productTable;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/p[1]/button")
    private WebElement showMoreBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/p[1]/button")
    private List<WebElement> showMoreBtns;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/p[2]/a")
    private WebElement addProductBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/nav/div[2]/a[2]")
    private WebElement addProduct;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/h1")
    private WebElement addProductHeader;

    @FindBy(id = "name")
    private WebElement productName;

    @FindBy(id = "price")
    private WebElement productPrice;

    @FindBy(id = "dateStocked")
    private WebElement dateStocked;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div[4]/button")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/table/tbody/tr[1]/td[2]")
    private WebElement addedProduct;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div[4]/a")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/nav/div[2]/a[3]")
    private WebElement practiceBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/p")
    private WebElement practiceBtnNote;

    @FindBy(xpath = "//*[@id=\"root\"]/div/nav/div[2]/a[4]")
    private WebElement learnBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/nav/div[2]/a[5]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/h1")
    private WebElement loginBtnTxt;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div[1]/input")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div[2]/input")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/button")
    private WebElement loginConfirm;

    @FindBy(xpath = "//*[@id=\"root\"]/div/nav/div[2]/a[5]")
    private WebElement myAcc;
    public IframesPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    // getters
    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getPracticeBtn() {
        return practiceBtn;
    }

    public WebElement getLearnBtn() {
        return learnBtn;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getFilterButton() {
        return filterButton;
    }

    public WebElement getShowMoreBtn() {
        return showMoreBtn;
    }

    public WebElement getResetButton() {
        return resetButton;
    }

    public WebElement getAddProductBtn() {
        return addProductBtn;
    }

    public WebElement getAddedProduct() {
        return addedProduct;
    }

    public WebElement getCancelBtn() {
        return cancelBtn;
    }

    public WebElement getMyAcc() {
        return myAcc;
    }

    public WebElement getAddProduct() {
        return addProduct;



    }

    // Method to look for products
    public void filterSearch(String txt) {
        filterField.clear();
        filterField.sendKeys(txt);
        filterButton.click();
    }

    // Method to check if filtered product name is visible in the table
    public boolean containsProduct(String product) {
        for (WebElement name : productTable) {
            WebElement productNumber = name.findElement(By.cssSelector("td:nth-child(2)"));
            if (!productNumber.getText().contains(product)) {
                return false;
            }
        }
        return true;
    }

    // Method to verify that show more button is not displayed after being clicked
    public boolean listSize() {
        if (showMoreBtns.size() == 0) {
            return true;
        }
        return false;
    }

    // Method to verify that add product buttons lead to the right page
    public String addProductHeader() {
        String header = addProductHeader.getText();
        return header;
    }

    // Method to add name of the product

    public void addProductName(String name) {
        productName.clear();
        if (name.length() < 2) {
            System.out.println("Name must be at least two characters!");
        } else {
            productName.sendKeys(name);

        }
    }

    // Method to add the price od the product
    public void addPrice(String number) {
        productPrice.clear();
        if (0 > number.length() && number.length() <= 999999999) {
            System.out.println("Number has to be bigger than 0 and smaller than 999999999");
        } else {
            productPrice.sendKeys(number);
        }
    }

    // Method to add date of the creation of the product
    public void selectDate(String date) {
        //todo  LocalDate currentdate = LocalDate.now();
        dateStocked.sendKeys(date);
    }

    // Method to add all elements needed to create the product
    public void addNewProduct() {
        addProductName("name");
        addPrice("number");
        selectDate("date");
        submitBtn.click();
    }

    // Method to verify that practice button leads to the good page
    public String practiceBtn() {
        String headerNote = practiceBtnNote.getText();
        return headerNote;
    }

    // Method to verify that practice login leads to the good page
    public String loginBtn() {
        String loginHeader = loginBtnTxt.getText();
        return loginHeader;
    }

    // Method for login
    public void login (String name, String pass) {
        loginBtn.click();
        username.sendKeys(name);
        password.sendKeys(pass);
        loginBtn.click();
    }
}
