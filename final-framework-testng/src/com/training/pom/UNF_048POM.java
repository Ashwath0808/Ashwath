package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_048POM {
	@SuppressWarnings("unused")
	private WebDriver driver;
	public UNF_048POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='catalog']/a[1]/i[1]")
	private WebElement catalog;//click on catalog
	
	@FindBy(xpath="//*[@id='catalog']/ul/li[1]/a")
	private WebElement categories;//Click on Categories link
	
	@FindBy(xpath="//*[@class='page-header']/div[1]/div[1]/a[1]/i[1]")
	private WebElement addnew;// Click on Add new icon
	
	@FindBy(xpath="//*[@id='input-name1']")
	private WebElement catagoryname;//Category Name text box of General tab
	
	@FindBy(xpath="//*[@class='note-editing-area']/div[2]/p")
	private WebElement descriptionbox;//Enter Valid credentials in Description textbox of General tab
	
	@FindBy(id="input-meta-title1")
	private WebElement metatagtitle;//Meta tag Title textbox of General tab
	
	@FindBy(id="input-meta-description1")
	private WebElement metadescbox;//Meta description 
	
	@FindBy(xpath="//*[@class='pull-right']/button[1]/i")
	private WebElement save;//click Save
	
	@FindBy(xpath="//*[@id='catalog']/ul/li[2]/a")
	private WebElement products;//select products option
	
	@FindBy(id="input-name1")
	private WebElement productname;//Enter Product name 
	
	@FindBy(id="input-meta-title1")
	private WebElement prodmetatag;//Enter Product Meta tag
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[2]/a[1]")
	private WebElement proddatatab;//Click on Products data tab
	
	@FindBy(id="input-model")
	private WebElement model;//Enter model
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[3]/a[1]")
	private WebElement prodlinktab;//Click Link Tab
	
	@FindBy(id="input-category")
	private WebElement ProdCategory;
	
	
	public void Catalog() {
		this.catalog.click();
	}
	public void Categories() {
		this.categories.click();


	}
	
	public void AddNew() {
		this.addnew.click();
	}
	
	public void CategoryName(String catname) throws Exception {
		this.catagoryname.sendKeys(catname);
		Thread.sleep(5000);
		
	}
	public void  DescriptiontextBox(String DestextBox)
	{
		this.descriptionbox.sendKeys(DestextBox);
	}
	
	public void MetaTagTitle(String Metatag) {
		this.metatagtitle.sendKeys(Metatag);
	}
	
	public void MetaTagDescription(String MetaDec) 
	{
		this.metadescbox.sendKeys(MetaDec);
		
	}
	public void Save() throws Exception {
		this.save.click();
		Thread.sleep(5000);
		String successmess=driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]")).getText();
		System.out.println(successmess);//Prints Success message
		
	}
	
	public void Products() {
		this.products.click();
		Actions act=new Actions(driver);
		act.moveToElement(products).build().perform();
	}
	
	
	public void ProductName(String prodname) {
		this.productname.sendKeys(prodname);
		
	}
	
	public void ProdMetaTag(String prodMetaTag) {
		this.prodmetatag.sendKeys(prodMetaTag);
		
	}
	public void ProdDataTag() {
		this.proddatatab.click();
	}
	public void Model(String prodModel) {
		this.model.sendKeys(prodModel);
	}
	
	public void ProdLinkTab() {
		this.prodlinktab.click();
	}
	
	public void ProdCategories(String prodCategory) {
		this.ProdCategory.clear();
		this.ProdCategory.sendKeys(prodCategory);
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
	}
	
	
}
