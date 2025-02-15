package parallel;



import static org.testng.Assert.assertTrue;



import com.uibank.factory.DriverFactory;
import com.uibank.pages.ApplyLoanPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplyLoanSD {
	
	
	private  ApplyLoanPage applyPage=new ApplyLoanPage(DriverFactory.getDriver());

	
	@Given("baseurl")
	public void baseurl() {
		DriverFactory.getDriver().get("https://uibank.uipath.com/welcome");
	    
	}

	@When("User vist apply loan page")
	public void user_vist_apply_loan_page() {
	   applyPage.userVistLoanPage();
	}
	@When("User enters email {string}")
	public void user_enters_email(String string) {
		
		applyPage.userEmail(string);
	   
	}

	@When("User enters loan amount {string}")
	public void user_enters_loan_amount(String string) {
		applyPage.userAmount(string);
	    
	}

	@When("User selects loan term {string}")
	public void user_selects_loan_term(String string) {
	   applyPage.userYear(string);
	}

	@When("User enters yearly income {string}")
	public void user_enters_yearly_income(String string) {
		applyPage.userIncome(string);
	   
	}

	@When("User enters age {string}")
	public void user_enters_age(String string) {
	    applyPage.userAge(string);
	}

	@When("User submits the loan application")
	public void user_submits_the_loan_application() {
		applyPage.applysubmit();
	   
	}

	@Then("User should see approval message if eligible")
	public void user_should_see_approval_message_if_eligible() {
		String res=applyPage.verfiyResult();
		 assertTrue(res.contains("Congrats!"));
	   
	}

	@Then("User should see rejection message if ineligible")
	public void user_should_see_rejection_message_if_ineligible() {
		String res=applyPage.verfiyResult();
		 assertTrue(res.contains("Sorry"));
	}

}
