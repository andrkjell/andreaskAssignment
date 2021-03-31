package gluecode.enums;

public enum GuiEnums {

    URL("https://login.mailchimp.com/signup/"),

    //    User information,
    EMAIL("test@test.test"),
    PASS("NWB6tCxxQk4ps7Z!!!!"),
    //    path IDs
    ENTER_EMAIL_ID("email"),
    ENTER_USERNAME_ID("new_username"),
    ENTER_PASSWORD_ID("new_password"),
    SIGN_UP_BUTTON_ID("create-account"),
    //    get text path IDs
    FLASH_ERROR_BANNER_ID("av-flash-errors"),
    WELCOME_HEADER_XPATH("/html/body/div[2]/div[1]/div/main/div/div/h1"),
    INVALID_EMAIL_ERROR_XPATH("/html/body/div[2]/div[1]/div/main/div[2]/div/form/fieldset/div[1]/div/span"),
    INVALID_USERNAME_ERROR_XPATH("/html/body/div[2]/div[1]/div/main/div[2]/div/form/fieldset/div[2]/div/span"),
    VALID_PASS_XPATH("/html/body/div[2]/div[1]/div/main/div[2]/div/form/fieldset/div[3]/div/div[4]/div/div/div[2]/h4"),
    INVALID_PASSWORD_ERROR_XPATH("/html/body/div[2]/div[1]/div/main/div[2]/div/form/fieldset/div[3]/div/div[2]/span"),
    SIGNUP_CONTENT_ID("signup-content"),
    // Text to verify
    START_PAGE_HEADER_TEXT("Welcome to Mailchimp"),
    USERNAME_TO_LONG_ERROR_TEXT("Enter a value less than 100 characters long"),
    SUCCESS_PAGE_HEADER_TEXT("Check your email"),
    USERNAME_TAKEN_ERROR_TEXT("Another user with this username already exists. Maybe it's your evil twin. Spooky."),
    EMAIL_MISSING_ERROR_TEXT("Please enter a value")
    ;

    private final String guiPaths;

    GuiEnums(String guiEnums) {
        this.guiPaths = guiEnums;
    }

    public String getGuiEnums() {
        return this.guiPaths;
    }
}
