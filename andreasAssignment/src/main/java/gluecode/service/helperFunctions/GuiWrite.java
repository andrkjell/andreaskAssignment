package gluecode.service.helperFunctions;

import gluecode.enums.GuiEnums;
import org.openqa.selenium.WebElement;

public class GuiWrite {

    private GuiWait guiWait;

    GuiWrite(GuiWait guiWait){
        this.guiWait = guiWait;

    }
    public void writeInElement(GuiEnums guiEnums, String inputText){
        WebElement element = guiWait.waitAnderAssetElementExistInOneMinute(guiEnums);
        element.sendKeys(inputText);

    }
}
