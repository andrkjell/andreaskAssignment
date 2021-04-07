package gluecode.service.helperFunctions;

import gluecode.enums.GuiEnums;
import org.openqa.selenium.WebElement;

public class GuiWrite {

    private GuiWait guiWait;

    public GuiWrite(GuiWait guiWait){
        this.guiWait = guiWait;

    }
    public void writeInElementID(GuiEnums guiEnums, String inputText) {
        WebElement element = guiWait.waitAndAssetElementExistInOneMinuteID(guiEnums);
        element.sendKeys(inputText);
    }
    public void writeInElementXPATH(GuiEnums guiEnums, String inputText){
        WebElement element = guiWait.waitAndAssetElementExistInOneMinuteXPATH(guiEnums);
        element.sendKeys(inputText);

    }
}
