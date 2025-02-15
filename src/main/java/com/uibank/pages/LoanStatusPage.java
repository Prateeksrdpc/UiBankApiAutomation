package com.uibank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanStatusPage {
	
	private WebDriver driver;
	
	private By dropdownMenuLink=By.id("dropdownMenuLink");
	
	private By selectLoan=By.linkText("Loans");
	
	private By existaccount=By.id("existingButton");
	
	private By logId=By.id("quoteID");
	private By retriveButton=By.cssSelector("button[type='submit']");
	private By result=By.xpath("//app-loan-details");
	public LoanStatusPage(WebDriver driver) {
		super();
		this.driver = driver;
	}


	
	public void userVistExistLoan()
	{
		driver.findElement(dropdownMenuLink).click();
		driver.findElement(selectLoan).click();
		driver.findElement(existaccount).click();
	}
	
	
	public void userEnterTheId(String id)
	{
		driver.findElement(logId).sendKeys(id);	
	}
	
	public void retriveButton()
	{
		driver.findElement(retriveButton).click();
	}
	
	public String verifyLoan()
	{
		return driver.findElement(result).getText();
	}
	
	
	
}
