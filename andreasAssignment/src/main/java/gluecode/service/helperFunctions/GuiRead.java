package gluecode.service.helperFunctions;

import gluecode.enums.GuiEnums;
import org.openqa.selenium.WebElement;

public class GuiRead {

    private GuiWait guiWait;
    private GuiWebDriverWrapper guiWebDriverWrapper;

    public GuiRead(GuiWait guiWait, GuiWebDriverWrapper guiWebDriverWrapper){

        this.guiWait = guiWait;
        this.guiWebDriverWrapper = guiWebDriverWrapper;
    }

    public String getTextFromElement(GuiEnums guiEnums){
        WebElement element = guiWait.waitAnderAssetElementExistInOneMinute(guiEnums);
        return  element.getText();
    }

    public String getUrlOnPage() {
        return guiWebDriverWrapper.getDriver().getCurrentUrl();
    }

}
