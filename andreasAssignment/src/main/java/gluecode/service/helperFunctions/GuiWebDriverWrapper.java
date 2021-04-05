package gluecode.service.helperFunctions;


import gluecode.enums.GuiBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GuiWebDriverWrapper {

    private WebDriver driver = null;
//här har jag skapat en metod som skickar ett enkelt felmeddelande ifall man har fel path till sin webdriver.
    public void createDriver(GuiBrowser browser) {

        String pathToWebDriver = "C:\\Users\\Kjell\\eclipse\\java-2020-12\\eclipse\\addons\\";
        if (pathToWebDriver == null){

            throw new IllegalStateException("ne Staffan, du måste definera din path först");
        }

        checkIfWebDriverIsStartedANdIgnoreErrors();

        try {
            switch (browser) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", pathToWebDriver + "chromedriver.exe");

                    driver = new ChromeDriver();
                    break;

                case FIREFOX:
                    System.setProperty("", "");
                    try {
                        driver = new FirefoxDriver();
                    } catch (Exception e) {
                        throw new Error("Was not able to start driver for firefox" + e);
                    }
                    break;
                default:

                    throw new Error("Browser was not implemented");

            }
        } catch (IllegalStateException ex) {
            throw new IllegalStateException("Webdriver config was not correct " + ex);
        }


        manageWebDrive();

    }

    public WebDriver getDriver() {

        if (driver == null) {
            throw new Error("Driver was null can't be used");
        }
        return this.driver;
    }

    public void closeDriver() {
        if (driver == null) {
            throw new Error("Driver was null can't be used");
        }
        driver.quit();
    }


    private void manageWebDrive() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    private void checkIfWebDriverIsStartedANdIgnoreErrors() {
        try {
            driver.getTitle();
            System.out.println("A browser window was already started, starting another one");
        } catch (Exception ignored) {
            // ignored
        }
    }

}
