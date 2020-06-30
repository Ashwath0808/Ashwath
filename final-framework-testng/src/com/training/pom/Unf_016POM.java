package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Unf_016POM {
@SuppressWarnings("unused")
private WebDriver driver; 
	
	public Unf_016POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='menu']/li[5]/a/i")
	private WebElement cart;
	
	@FindBy(xpath="//*[@id='sale']/ul/li[1]/a")
	private WebElement order;
	
	@FindBy(xpath="//*[@id=\"form-order\"]/div/table/tbody/tr[1]/td[1]/input[1]")
	private WebElement ordernum;
	
	@FindBy(id="button-delete469")
	private WebElement deleteOrder;
	
	public void clickCart() {
		this.cart.click(); 
	}
	
	public void clickOrder() {
		this.order.click();
		Actions act=new Actions(driver);
		act.moveToElement(order).build().perform();	
	}
	
	public void selectOrdernum() {
		this.ordernum.isSelected();
	}
	
	public void clickDeleteorder() {
		this.deleteOrder.click(); 
	}
		
}
