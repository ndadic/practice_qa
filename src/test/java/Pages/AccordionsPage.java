package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccordionsPage extends BasePage {

    Actions actions = new Actions(driver);

    //Accordion 1 elements
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button[1]")
    private WebElement accordionOne;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/button[1]")
    private WebElement oneClick;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/p")
    private WebElement oneClickMsg;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div/button[2]")
    private WebElement doubleClick;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div/p[2]")
    private WebElement doubleClickMsg;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div/button[3]")
    private WebElement rightClick;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div/p[3]")
    private WebElement rightClickMsg;

    //Accordion 2 elements

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button[2]")
    private WebElement accordionTwo;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[1]/input")
    private WebElement optionOne;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/input")
    private WebElement optionTwo;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/p")
    private WebElement accordionTwoMsg;

    //Accordion three elements

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/button[3]")
    private WebElement accordionThree;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/div[1]/input")
    private WebElement checkboxOne;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/div[1]/p")
    private WebElement checkboxOneMsg;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/input")
    private WebElement checkboxTwo;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/p")
    private WebElement checkboxTwoMsg;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/div[3]/input")
    private WebElement checkboxThree;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/div[3]/p")
    private WebElement checkboxThreeMsg;

    public AccordionsPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    //Methods for accordion 1
    public void clickAccordionOne() {
        accordionOne.click();
    }

    public void oneClick() {
        oneClick.click();
    }

    public String oneClickMsg() {
        String messageOne = oneClickMsg.getText();
        return messageOne;
    }

    public void doubleClick() {
        actions.doubleClick(doubleClick).perform();
    }

    public String doubleClickMsg() {
        String messageTwo = doubleClickMsg.getText();
        return messageTwo;
    }

    public void rightClick() {
        actions.contextClick(rightClick).perform();
    }

    public String rightClickMsg() {
        String messageThree = rightClickMsg.getText();
        return messageThree;
    }

    //Methods for accordion two
    public WebElement getAccordionTwo() {
        return accordionTwo;
    }

    public WebElement getOptionOne() {
        return optionOne;
    }

    public WebElement getOptionTwo() {
        return optionTwo;
    }

    public WebElement getAccordionTwoMsg() {
        return accordionTwoMsg;
    }

    //Methods for accordion three


    public WebElement getAccordionThree() {
        return accordionThree;
    }

    public void clickCheckboxOne(){
        checkboxOne.click();
    }

    public String checkboxOneMsg(){
        String messageCheckboxOne = checkboxOneMsg.getText();
        return messageCheckboxOne;
    }

    public void clickCheckboxTwo(){
        checkboxTwo.click();
    }

    public String checkboxTwoMsg(){
        String messageCheckboxTwo = checkboxTwoMsg.getText();
        return messageCheckboxTwo;
    }

    public void clickCheckboxThree(){
        checkboxThree.click();
    }

    public String checkboxThreeMsg(){
        String messageCheckboxThree = checkboxThreeMsg.getText();
        return messageCheckboxThree;
    }
}
