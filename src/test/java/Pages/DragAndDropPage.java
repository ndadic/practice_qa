package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"small-box\"]")
    private WebElement smallBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]")
    private WebElement bigBox;
    public DragAndDropPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getSmallBox() {
        return smallBox;
    }

    public WebElement getBigBox() {
        return bigBox;
    }

    public String boxText(){
        String successTxt = bigBox.getText();
        return successTxt;
    }
}
