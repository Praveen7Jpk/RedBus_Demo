package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	@Given("^Open the chrome browser and launch the application$")
	public void Open_the_chrome_browser_and_launch_the_application() {
		System.out.println("This Step 1 test");
	}
	
	@When("^When Enter the username and Password$")
	public void When_Enter_the_username_and_Password() {
		System.out.println("This Step 2 test");
	}
	
	@Then("^Verify the credential$")
	public void Verify_the_credential() {
		System.out.println("This Step 3 test");
	}
}
