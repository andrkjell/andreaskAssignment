package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.UUID;


public class StepDefinition {	
	
	@Given("I have opened the Mailchimp login page")
	public void i_have_opened_the_Mailchimp_login_page() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kjell\\eclipse\\java-2020-12\\eclipse\\addons\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://login.mailchimp.com/signup/");
	}
	@Given ("I have entered {string}")
	public void i_have_entered(String email) {
		System.out.println("Email" +email);
		
		
	}
	@Given ("i check for the {int} in step")
	public void i_check_for_the_in_step(int userName) {
		System.out.println("Username" +userName);
		
	}
	@Then ("i verify the success in step")
	public void i_verify_the_success_in_step() {
		System.out.println("Verify");
		
	}
	
}
