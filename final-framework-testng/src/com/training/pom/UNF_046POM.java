/*To verify whether application allows admin to change order placed by the customer*/

package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_046POM{
	@SuppressWarnings("unused")
	private WebDriver driver;
	public UNF_046POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@id='menu']/li[5]/a/i")
	private WebElement cart;//Clicking on Cart
	
	@FindBy(xpath="//*[@id='sale']/ul/li[1]/a")
	private WebElement order;//clicking on order link
	
	@FindBy(xpath="//td[@class='text-center'] //input[@value='473']")
	private WebElement ordernum;//Selecting the order
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[2]/td[8]/a[2]/i")
	private WebElement edit;//Click on Edit icon
	
	@FindBy(xpath="//*[@class='panel-body'] //button[@id='button-customer']")
	private WebElement btncustomer;
	
	@FindBy(xpath="//*[@id='cart']/tr[1]/td/button")
	private WebElement remove;//remove Order
	
	@FindBy(xpath="//*[@id='input-product']")
	private WebElement chooseproduct;//Choose Product
	
	@FindBy(xpath="//*[@id='input-quantity']")
	private WebElement enterQuantity;//EnterQuantity
	
	@FindBy(xpath="//*[@id='button-product-add']")
	private WebElement addProduct;//Add Product
	
	@FindBy(xpath="//*[@id='button-cart']")
	private WebElement continue1;//Continue cart
	
	@FindBy(xpath="//*[@id='button-payment-address']")
	private WebElement continue2;//Continue payment address
	
	@FindBy(xpath="//*[@id='button-shipping-address']")
	private WebElement Continue3;//shipping address
	
	@FindBy(xpath="//*[@id='button-save']")
	private WebElement saveCart;
	
	
	public void clickCart() {
		this.cart.click(); 
	}
	
	public void clickOrder() {
		this.order.click();
		Actions act=new Actions(driver);
		act.moveToElement(order).build().perform();	
	}
	
	public void selectOrdernum() {
		this.ordernum.click();
	}
	
	public void clickEdit() {
		this.edit.click();
	}
	public void continuecustomer() {
		this.btncustomer.click();
	}
	public void removeorder() {
		this.remove.click();
		}
	public void chooseProduct(String chooseproduct) {
		this.chooseproduct.clear();
		this.chooseproduct.sendKeys(chooseproduct);
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
			
		}
	public void EnterQuantity(String enterQuantity) {
		this.enterQuantity.clear();
		this.enterQuantity.sendKeys(enterQuantity);
	}
	public void AddProduct() throws Exception {
		Thread.sleep(3000);
		this.addProduct.click();
	}
	public void Continue1() {
		this.continue1.click();
	}
	
	public void paymentAddress() {
		this.continue2.click();
	}
	
	public void shippingAddress() {
		this.Continue3.click();
	}
	public void SaveCart() throws Exception  {
		this.saveCart.click();
		Thread.sleep(3000);
		String Successmessage= driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]']")).getText();
		System.out.println(Successmessage);//Prints Success message
		
	}
	
}

