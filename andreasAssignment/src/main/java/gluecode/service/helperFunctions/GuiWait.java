package gluecode.service.helperFunctions;

import gluecode.enums.GuiEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuiWait {

    private GuiWebDriverWrapper guiWebDriverWrapper;

    GuiWait{GuiWebDriverWrapper guiWebDriverWrapper}{
        this.guiWebDriverWrapper = guiWebDriverWrapper;
    }

    public WebElement waitAnderAssetElementExistInOneMinute(GuiEnums guiEnums){

        WebDriverWait webDriverWait = new WebDriverWait(guiWebDriverWrapper.getDriver(), Duration.ofSeconds(60).getSeconds());

        try {
           return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(guiEnums.getGuiEnums())));
        } catch (Exception e) {
            throw new AssertionError("The text " + guiEnums + " was not loaded in 60 seconds. \n" + e);
        }
        return webDriverWait.until()
    }
}
