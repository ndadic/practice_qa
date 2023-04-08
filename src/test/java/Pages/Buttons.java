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

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/p")
    private WebElement radioButtonText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/select")
    private WebElement selectOption;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[4]/div/div[1]/input")
    private WebElement checkboxOne;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[4]/div/div[1]/p")
    private WebElement checkboxOneMsg;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[4]/div/div[2]/input")
    private WebElement checkboxTwo;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[4]/div/div[2]/p")
    private WebElement checkboxTwoMsg;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[4]/div/div[3]/input")
    private WebElement checkboxThree;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[4]/div/div[3]/p")
    private WebElement checkboxThreeMsg;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[5]/div[1]/a")
    private WebElement youTube;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[5]/div[2]/a")
    private WebElement youTubeNewTab;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div[5]/div[3]/a")
    private WebElement practicePage;

    public Buttons(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }


    //Methods used for checking buttons
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

    //Methods used for checking radio buttons
    public void clickOne() {
        radioButtonOne.click();
    }

    public void clickTwo() {
        radioButtonTwo.click();
    }

    public String radioButtonTextMsg() {
        String message = radioButtonText.getText();
        return message;
    }

    public WebElement getRadioButtonText() {
        return radioButtonText;
    }

    //Methods used for checking select option

    public void selectOption(String text) {
        Select drop = new Select(selectOption);
        drop.selectByValue(text);
    }

    public WebElement getSelectOption() {
        return selectOption;
    }

    //Methods used for checkboxes
    public void clickCheckboxOne() {
        checkboxOne.click();
    }

    public WebElement getCheckboxOneMsg() {
        return checkboxOneMsg;
    }

    public void clickCheckboxTwo() {
        checkboxTwo.click();
    }

    public WebElement getCheckboxTwoMsg() {
        return checkboxTwoMsg;
    }

    public void clickCheckboxThree() {
        checkboxThree.click();
    }

    public WebElement getCheckboxThreeMsg() {
        return checkboxThreeMsg;
    }

    //Methods used for checking links
    public WebElement getYouTube() {
        return youTube;
    }

    public WebElement getYouTubeNewTab() {
        return youTubeNewTab;
    }

    public WebElement getPracticePage() {
        return practicePage;
    }
}
