package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicTextPage extends BasePage{

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/div/button")
    private WebElement button;
    public DynamicTextPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getButton() {
        return button;
    }

    public String buttonText(){
        String txt = button.getText();
        return txt;
    }
}
