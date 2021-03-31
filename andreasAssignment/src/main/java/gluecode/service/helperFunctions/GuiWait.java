package gluecode.service.helperFunctions;

import gluecode.enums.GuiEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuiWait {

    private GuiWebDriverWrapper guiWebDriverWrapper;

  public GuiWait(GuiWebDriverWrapper guiWebDriverWrapper){
        this.guiWebDriverWrapper = guiWebDriverWrapper;
    }

    public WebElement waitAnderAssetElementExistInOneMinuteID(GuiEnums guiEnums){

        WebDriverWait webDriverWait = new WebDriverWait(guiWebDriverWrapper.getDriver(), Duration.ofSeconds(60).getSeconds());

        try {
           return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(guiEnums.getGuiEnums())));
        } catch (Exception e) {
            throw new AssertionError("The text " + guiEnums + " was not loaded in 60 seconds. \n" + e);
        }

    }
    public WebElement waitAnderAssetElementExistInOneMinuteXPATH(GuiEnums guiEnums){

        WebDriverWait webDriverWait = new WebDriverWait(guiWebDriverWrapper.getDriver(), Duration.ofSeconds(60).getSeconds());

        try {
            return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(guiEnums.getGuiEnums())));
        } catch (Exception e) {
            throw new AssertionError("The text " + guiEnums + " was not loaded in 60 seconds. \n" + e);
        }

    }
}

