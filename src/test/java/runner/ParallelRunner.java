package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/resources/Parallel/ApplyLoan.feature"},
		glue = {"parallel"},
		dryRun = true,
		monochrome = true,
		tags = "@Sanity",
		plugin = { "pretty"}
		
		
		
		)
	

public class ParallelRunner extends AbstractTestNGCucumberTests{
	
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		
		return super.scenarios();
	}
	
	

}
