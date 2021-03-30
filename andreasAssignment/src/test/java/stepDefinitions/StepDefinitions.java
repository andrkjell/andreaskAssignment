package stepDefinitions;

import gluecode.enums.GuiBrowser;
import gluecode.service.helperFunctions.GuiWebDriverWrapper;
import io.cucumber.java.en.Given;

public final class StepDefinitions {

    private final GuiWebDriverWrapper guiWebDriverWrapper;


    public StepDefinitions(GuiWebDriverWrapper guiWebDriverWrapper) {
        this.guiWebDriverWrapper = guiWebDriverWrapper;
    }

    @Given("^open a new (.*?) browser")
    public void openBrowser(GuiBrowser browser) {
        guiWebDriverWrapper.createDriver(browser);
    }

}
