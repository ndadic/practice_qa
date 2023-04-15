package Tests;

import Pages.DragAndDropPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest{

    DragAndDropPage dragAndDropPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        dragAndDropPage = new DragAndDropPage(driver, webDriverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        generalComponents.getPractice().click();
        generalComponents.getDragAndDrop().click();
    }

    //https://www.linkedin.com/pulse/javascriptexecutor-selenium-gaurav-gupta/
    @Test
    public void dragAndDrop(){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", dragAndDropPage.getSmallBox(), dragAndDropPage.getBigBox());


        webDriverWait.until(ExpectedConditions.textToBePresentInElement(dragAndDropPage.getBigBox(), "Success!"));
        Assert.assertEquals(dragAndDropPage.boxText(), "Success!");
    }

    @AfterClass
    @Override
    public void afterClass() {
        super.afterClass();
    }
}
