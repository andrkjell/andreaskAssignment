package gluecode.service;


import gluecode.enums.GuiEnums;
import gluecode.enums.ValidInvalidTaken;
import gluecode.enums.Validinvalid;
import gluecode.service.helperFunctions.*;
import org.apache.commons.lang3.RandomStringUtils;

import static org.assertj.core.api.Assertions.*;

public class GuiSelenium {

    private final GuiWebDriverWrapper guiWebDriverWrapper;
    private final GuiRead guiRead;
    private final GuiWait guiWait;
    private final GuiWrite guiWrite;
    private final GuiClick guiClick;
    String username = null;

    public GuiSelenium(GuiWebDriverWrapper guiWebDriverWrapper, GuiRead guiRead, GuiWait guiWait, GuiWrite guiWrite, GuiClick guiClick) {
        this.guiWebDriverWrapper = guiWebDriverWrapper;
        this.guiRead = guiRead;
        this.guiWait = guiWait;
        this.guiWrite = guiWrite;

        this.guiClick = guiClick;
    }


    public void navigateToWebsite() {
        guiWebDriverWrapper.getDriver().get(GuiEnums.URL.getGuiEnums());

    }

    public void validateCurrentURL() {
        String currentURL = guiRead.getUrlOnPage();
        String correctURL = GuiEnums.URL.getGuiEnums();
        assertThat(currentURL).as("Current URL on page was not equal to the expected URL").isEqualTo(currentURL);

    }

    public void validateCurrentPageHeader() {
        String headerOnPage = guiRead.getTextFromElementXPATH(GuiEnums.WELCOME_HEADER_XPATH);
        String correctTextOnPage = GuiEnums.START_PAGE_HEADER_TEXT.getGuiEnums();
        assertThat(headerOnPage).as
                ("The start header text was not correct").isEqualTo(correctTextOnPage);
    }

    public void enterValidInvalidEmail(Validinvalid validInvalid) {
        String email;

        switch (validInvalid){
            case VALID:
            email = GuiEnums.EMAIL.getGuiEnums();
            break;

            case INVALID:
                email = "";
                break;
            default:
                throw new IllegalStateException("you done goofed it here");
        }

        guiWrite.writeInElementID(GuiEnums.ENTER_EMAIL_ID, email);
    }

    public void enterUsername(ValidInvalidTaken validInvalidTaken) {

        switch (validInvalidTaken){
            case VALID:
                username = RandomStringUtils.randomAlphabetic(5, 15);
                break;
            case INVALID:
                username = RandomStringUtils.randomAlphabetic(101);
                break;
            case TAKEN:
                username = "test";
                break;
        }
        guiWrite.writeInElementID(GuiEnums.ENTER_USERNAME_ID, username);
    }

    public void enterPassword() {
        guiWrite.writeInElementID(GuiEnums.ENTER_PASSWORD_ID, GuiEnums.PASS.getGuiEnums());

    }

    public void pressButton() {
        guiClick.clickElementID(GuiEnums.SIGN_UP_BUTTON_ID);

    }

    public void verifyYouAreOnCompletedSignupPage() {
        verifyURLSuccessPage();
        verifyEmailOnSuccessPage();
    }


    public void verifyError(String obj){
        if(obj.equals("username to long")){
            verifyUsernameToLongError();
        }else if(obj.equals("username taken")){
            verifyUserNameTaken();
        }else if (obj.equals("email missing")){
            verifyEmailMissing();
        }else{
        throw new IllegalStateException("error");
        }
    }


    private void verifyURLSuccessPage() {
        String currentURL = guiRead.getUrlOnPage();
        assertThat(currentURL).as("Base URL was not in page").containsIgnoringCase(GuiEnums.URL.getGuiEnums() + "success/");
        assertThat(currentURL).as("username was not in URL path").containsIgnoringCase(username);

    }

    private void verifyEmailOnSuccessPage() {
        String textOnCurrentPage = guiRead.getTextFromElementID(GuiEnums.SIGNUP_CONTENT_ID);
        assertThat(textOnCurrentPage).as("Page did not include correct email").containsIgnoringCase(GuiEnums.EMAIL.getGuiEnums());
        assertThat(textOnCurrentPage).as("Page did not include correct header").containsIgnoringCase(GuiEnums.SUCCESS_PAGE_HEADER_TEXT.getGuiEnums());
    }
    private void verifyUsernameToLongError(){
    String usernameErrorText = guiRead.getTextFromElementXPATH(GuiEnums.INVALID_USERNAME_ERROR_XPATH);
    assertThat(usernameErrorText).as("The error text was not correct").containsIgnoringCase(GuiEnums.USERNAME_TO_LONG_ERROR_TEXT.getGuiEnums());

    }
    private void verifyUserNameTaken(){
    String usernameErrorText = guiRead.getTextFromElementXPATH(GuiEnums.INVALID_USERNAME_ERROR_XPATH);
    assertThat(usernameErrorText).as("The error text was not correct").containsIgnoringCase(GuiEnums.USERNAME_TAKEN_ERROR_TEXT.getGuiEnums());
    }
    private void verifyEmailMissing(){
    String emailMissingErrorText = guiRead.getTextFromElementXPATH(GuiEnums.INVALID_EMAIL_ERROR_XPATH);
    assertThat(emailMissingErrorText).as("The error text was not correct").containsIgnoringCase(GuiEnums.EMAIL_MISSING_ERROR_TEXT.getGuiEnums());
    }
}




