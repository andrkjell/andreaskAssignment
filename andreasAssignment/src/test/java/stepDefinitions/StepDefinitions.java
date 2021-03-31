package stepDefinitions;

import gluecode.enums.GuiBrowser;
import gluecode.enums.ValidInvalidTaken;
import gluecode.enums.Validinvalid;
import gluecode.service.GuiSelenium;
import gluecode.service.helperFunctions.GuiWebDriverWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public final class StepDefinitions {

    private final GuiWebDriverWrapper guiWebDriverWrapper;
    private final GuiSelenium guiSelenium;

    public StepDefinitions(GuiWebDriverWrapper guiWebDriverWrapper, GuiSelenium guiSelenium) {
        this.guiWebDriverWrapper = guiWebDriverWrapper;
        this.guiSelenium = guiSelenium;
    }

    @Given("^open a new (.*?) browser")
    public void openBrowser(GuiBrowser browser) {
        guiWebDriverWrapper.createDriver(browser);
    }

    @And("^navigate to website")
    public void navigateToWebsite() {
        guiSelenium.navigateToWebsite();
    }

    @And("^we are on the correct webpage")
    public void weAreOnTheCorrectWebpage() {
        guiSelenium.validateCurrentURL();
    }

    @And("^header text is correct")
    public void headerTextIsCorrect() {
    guiSelenium.validateCurrentPageHeader();
    }

    @When("^enter (.*?) email")
    public void enterValidEmail(Validinvalid validinvalid) {
        guiSelenium.enterValidInvalidEmail(validinvalid);
    }

    @And("^enter (.*?) username")
    public void enterUsername(ValidInvalidTaken validInvalidTaken) {
        guiSelenium.enterUsername(validInvalidTaken);

    }

    @And("^enter password")
    public void enterPassword() {
        guiSelenium.enterPassword();
    }

    @Then("^press sign up button")
    public void pressSignUpButton() {
        guiSelenium.pressButton();

    }

    @And("^verify you are on completed signup page")
    public void verifyYouAreOnCompletedSignupPage() {
        guiSelenium.verifyYouAreOnCompletedSignupPage();
    }

    @And("^close browser")
    public void closeBrowser() {
        guiWebDriverWrapper.closeDriver();
    }

    @And("^verify error (.*?)")
    public void verifyError(String obj) {
        guiSelenium.verifyError(obj);
    }
}
