package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UNF_047POM {
	
	private WebDriver driver;
	public UNF_047POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
			@FindBy(xpath="//ul[@id='menu']/li[5]/a/i")
			private WebElement cart;//Clicking on Cart
			
			@FindBy(xpath="//*[@id='sale']/ul/li[1]/a")
			private WebElement order;//clicking on order link
			
			@FindBy(id="input-order-id")
			private WebElement orderid;//OrderID
			
			@FindBy(id="button-filter")
			private WebElement filter;//click filter
			
			@FindBy(id="input-order-status")
			private WebElement orderstatus;//select order status
			
			@FindBy(id="input-date-added")
			private WebElement dateadded;//Select Date Added
			
			@FindBy(id="input-customer")
			private WebElement customername;//Filter by Customer Name
			
			@FindBy(id="input-total")
			private WebElement total; //Filter by Total
			
			@FindBy(id="input-date-modified")
			private WebElement datemodified; //Filter by Date modified
			
			
			public void clickCart() {
				this.cart.click(); //click on cart
			}
			
			public void clickOrder() {
				this.order.click();
				Actions act=new Actions(driver);
				act.moveToElement(order).build().perform();//click on order	
			}
			
			public void enterOrder(String orderId) throws Exception {
				this.orderid.clear();
				this.orderid.sendKeys(orderId);	//Enter OrderID
				this.filter.click();//Click on Filter
				Thread.sleep(5000);
				this.orderid.clear();
			}
			public void fiLter() throws Exception {
				this.filter.click();//Click on Filter
				
			}
			
			public void orderStatus() throws Exception {
				this.orderstatus.click();
				Select status=new Select(orderstatus);
				status.selectByIndex(9);//Selecting Order status as Pending
				this.filter.click();
				Thread.sleep(5000);
				status.selectByIndex(0);
				
			}
			
			public void dateAdded(String DateAdded) throws Exception {
				this.dateadded.clear();
				this.dateadded.sendKeys(DateAdded);//Selecting the Date in "Date Added"
				this.filter.click();
				Thread.sleep(5000);
				this.dateadded.clear();	
			}
			public void customerName(String customer) throws Exception {
				this.customername.clear();
				this.customername.sendKeys(customer);//Entering Customer Name
				this.filter.click();
				Thread.sleep(5000);
				this.customername.clear();
				
			}
			
			public void TotalAmount(String Total) throws Exception {
				this.total.clear();
				this.total.sendKeys(Total);
				this.filter.click();
				Thread.sleep(5000);
				this.total.clear();
				
			}
			
			public void DateModified(String DateMod) throws Exception {
				this.datemodified.clear();
				this.datemodified.sendKeys(DateMod);
				this.filter.click();
				Thread.sleep(5000);
				this.datemodified.clear();
			}
		}




