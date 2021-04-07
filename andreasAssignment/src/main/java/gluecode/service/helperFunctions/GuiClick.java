package gluecode.service.helperFunctions;

import gluecode.enums.GuiEnums;
import org.openqa.selenium.WebElement;

public class GuiClick {

    private GuiWait guiWait;
    private GuiWebDriverWrapper guiWebDriverWrapper;

    public GuiClick(GuiWait guiWait, GuiWebDriverWrapper guiWebDriverWrapper){

        this.guiWait = guiWait;
        this.guiWebDriverWrapper = guiWebDriverWrapper;
    }

    public void clickElementID(GuiEnums guiEnums){
        WebElement element = guiWait.waitAnderAssetElementExistInOneMinuteID(guiEnums);
        element.click();
    }
}
