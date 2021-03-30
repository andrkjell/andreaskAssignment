package gluecode.enums;

public enum GuiEnums {

    URL("https://login.mailchimp.com/signup/");

    private final String guiPaths;

    GuiEnums(String guiEnums) {
        this.guiPaths = guiEnums;
    }

    public String getGuiEnums() {
        return this.guiPaths;
    }
}
