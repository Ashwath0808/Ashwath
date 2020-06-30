package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Unf_018POM {
@SuppressWarnings("unused")
private WebDriver driver; 
	
	public Unf_018POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='menu']/li[5]/a/i")
	private WebElement cart;
	
    @FindBy(xpath="//*[@id='sale']/ul/li[3]/a")
    private WebElement returncart;
    
    @FindBy(xpath="//*[@id='input-return-id']")
    private WebElement returnid;
    
    @FindBy(id="button-filter")
    private WebElement filter;
    
    @FindBy(id="input-customer")
    private WebElement customerid;
    
    public void clickCart() {
		this.cart.click(); 
	}
   
    public void clickReturnOrd() {
		this.returncart.click();
		Actions act=new Actions(driver);
		act.moveToElement(returncart).build().perform();
	}
    
    public void enterReturnId(String returnid) {
		this.returnid.clear();
		this.returnid.sendKeys(returnid);
	}
    public void enterCustomerId(String customerid) {
    	this.returnid.clear();
		this.customerid.clear();
		this.customerid.sendKeys(customerid);
	}
    
    public void clickFilter() {
		this.filter.click();
    }
    

}
