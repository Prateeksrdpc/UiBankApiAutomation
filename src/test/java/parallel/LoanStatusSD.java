package parallel;

import static org.testng.Assert.assertTrue;

import com.uibank.factory.DriverFactory;
import com.uibank.pages.LoanStatusPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoanStatusSD {
	
		private LoanStatusPage statusPage=new LoanStatusPage(DriverFactory.getDriver());
	
	
	@When("User vist  loan status page")
	public void user_vist_loan_status_page() {
		statusPage.userVistExistLoan();
	    
	}

	@When("User enters Loan ID {string}")
	public void user_enters_loan_id(String string) {
		statusPage.userEnterTheId(string);;
	    
	}

	@When("User submits the loan status request")
	public void user_submits_the_loan_status_request() {
			statusPage.retriveButton();
	   
	}

	@Then("User should see loan details if Loan ID is valid")
	public void user_should_see_loan_details_if_loan_id_is_valid() {
		String res=statusPage.verifyLoan();
		 assertTrue(res.contains("Your Loan Details"));
	       
	}

	@Then("User should see error message for invalid Loan ID")
	public void user_should_see_error_message_for_invalid_loan_id() {
		String res=statusPage.verifyLoan();
		 assertTrue(res.contains("Sorry!"));
	}

}
