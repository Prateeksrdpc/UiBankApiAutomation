package com.uibank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

public class ApplyLoanPage {
	
	private WebDriver driver;
	
	
	private By dropdownMenuLink=By.id("dropdownMenuLink");
	private By selectLoan=By.linkText("Loans");
	private By applybutton=By.id("applyButton");
	private By emaile=By.id("email");
	private By amounte=By.id("amount");
	private By year=By.xpath("//select");
	private By incomel=By.id("income");
	private By agel=By.id("age");
	private By submit=By.id("submitButton");
	
	private By result=By.xpath("//app-loan-result");
	public ApplyLoanPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
	}
	
	
	public void  userVistLoanPage()
	{
		driver.findElement(dropdownMenuLink).click();
		driver.findElement(selectLoan).click();
		driver.findElement(applybutton).click();
	}
	
	public void userEmail(String email)
	{
		driver.findElement(emaile).sendKeys(email);
	}
	
	public void userAmount(String amount)
	{
		driver.findElement(amounte).sendKeys(amount);
	}
	
	public void userYear(String ye)
	{
		Select sel=new Select(driver.findElement(year));
		sel.selectByVisibleText(ye);

		JavascriptExecutor js= (JavascriptExecutor)driver;
		//down
		js.executeScript("window.scrollBy(0,1000)");
		
	}
	
	public void userIncome(String income)
	{
		driver.findElement(incomel).sendKeys(income);
	}
	
	public void userAge(String age)
	{
		driver.findElement(agel).sendKeys(age);
	}
	
	public void applysubmit()
	{
		driver.findElement(submit).click();
	}
	
	public String verfiyResult()
	{
		return driver.findElement(result).getText();
	}

}
