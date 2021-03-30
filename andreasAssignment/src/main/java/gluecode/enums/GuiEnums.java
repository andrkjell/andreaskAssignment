package gluecode.enums;

public enum GuiEnums {

    URL("https://login.mailchimp.com/signup/"),

            //    User information,
            EMAIL("test@test.test"),
            PASS("NWB6tCxxQk4ps7Z!!!!"),
//    path IDs
            EMAIL_ID("email"),
            USERNAME_ID("new_username"),
            PASSWORD_ID("new_password"),
            SIGN_UP_ID("create-account"),
//    get text path IDs
            INVALID_EMAIL_ERROR_XPATH("/html/body/div[2]/div[1]/div/main/div[2]/div/form/fieldset/div[1]/div/span"),
            INVALID_USERNAME_ERROR_XPATH("/html/body/div[2]/div[1]/div/main/div[2]/div/form/fieldset/div[2]/div/span"),
            VALID_PASS_XPATH("/html/body/div[2]/div[1]/div/main/div[2]/div/form/fieldset/div[3]/div/div[4]/div/div/div[2]/h4"),

    ;

    private final String guiPaths;

    GuiEnums(String guiEnums) {
        this.guiPaths = guiEnums;
    }

    public String getGuiEnums() {
        return this.guiPaths;
    }
}
