package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralComponents extends BasePage {

    @FindBy (xpath = "//*[@id=\"root\"]/div/nav/div[2]/a[3]")
    private WebElement practice;
    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div[1]")
    private WebElement buttons;

    public GeneralComponents(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getButtons() {
        return buttons;
    }

    public WebElement getPractice() {
        return practice;
    }
}
