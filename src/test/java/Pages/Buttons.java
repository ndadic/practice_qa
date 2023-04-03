package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buttons extends BasePage {

    Actions actions = new Actions(driver);

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/button[1]")
    private WebElement basicClick;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/button[2]")
    private WebElement doubleClick;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/button[3]")
    private WebElement rightClick;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/p[1]")
    private WebElement clickText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/p[1]")
    private WebElement doubleClickMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/p")
    private WebElement rightClickMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/input")
    private WebElement radioButtonOne;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/input")
    private WebElement radioButtonTwo;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div[2]/div/p")
    private WebElement radioButtonText;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div[3]/div/select")
    private WebElement selectOption;

    Select select = new Select(selectOption);


    public Buttons(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void oneClick() {
        basicClick.click();
    }

    public void twoClicks() {
        actions.doubleClick(doubleClick).perform();

    }

    public void rightButtonClick() {
        actions.contextClick(rightClick).perform();
    }

    public String oneClickMessage() {
        String message = clickText.getText();
        return message;
    }

    public String doubleClickMessage() {
        String message = doubleClickMessage.getText();
        return message;
    }

    public String rightClickMessage() {
        String message = rightClickMessage.getText();
        return message;
    }

    public void clickOne (){
        radioButtonOne.click();
    }

    public void clickTwo (){
        radioButtonTwo.click();
    }

    public String radioButtonTextMsg (){
        String message = radioButtonText.getText();
        return message;
    }

    public WebElement getRadioButtonText() {
        return radioButtonText;
    }

    public void clickSelect(){
        selectOption.click();
    }
}
