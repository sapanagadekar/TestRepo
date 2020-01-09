package AmazonOrderHistoryPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utils.TakeScreenshots;

public class OrderPage {

	private WebDriver driver;
	 TakeScreenshots TS;
	  //Webelemts for testcase 4/5 - FilterDropdown

	  @FindBy(xpath="//Select[@id=\"orderFilter\"]")private WebElement Orderdropdown;
	  
	  //Buyitagain Button
	  @FindBy(xpath="//input[@aria-labelledby=\"a-autoid-3-announce\"]")private WebElement BuyAgainButton;
	 
	  //BuyNow
	  @FindBy(xpath="//input[@aria-label=\"Buy Now\"]")private WebElement BuyNowButton;
	  @FindBy(xpath="//*[@id=\"checkoutDisplayPage\"]/div/div[2]/div[1]/h1")private WebElement SelectPaymentMethodtext;
	 
	  //AddtoCartButton
	  @FindBy(xpath="//input[@aria-label=\"Add to Cart\"]")private WebElement AddtoCartButton;
	  @FindBy(xpath="//h1[contains(text(),\"Added to Cart\")]")private WebElement AddtoCartResultText;
	   @FindBy(id="searchOrdersInput")private WebElement SearchOrderInput;
	
	  public OrderPage(WebDriver driver) 
		
		{ 
			this.driver=driver;
		
			PageFactory.initElements(driver, this);
		}
	  
	  //Select year from Dropdown
	  public void Orderfilter() {
			//TS= new TakeScreenshots();
			Select dropdown = new Select(Orderdropdown);
			
			dropdown.selectByVisibleText("2018");
			TakeScreenshots.CaptureScreenshots(driver, "TC005 _01_Selected 2018 from dropdown");
			
		}
	  
	  public void Orderfilter2(String Filter) {
			//TS= new TakeScreenshots();
		    SearchOrderInput.clear();
			Select dropdown = new Select(Orderdropdown);
			dropdown.selectByVisibleText(Filter);
		
			
		}
	  
		
		//TC005_Add to cart 
		
		public String  AddtoCart() {
			
			//TS= new TakeScreenshots();
			System.out.println("Click on Buy Again Button");
			TakeScreenshots.CaptureScreenshots(driver, "TC006_01_ Click On Buy Again button");
			BuyAgainButton.click();
			System.out.println("Click on Add to Cart Button");
			TakeScreenshots.CaptureScreenshots(driver, "TC006_02_Click On Add to Cart button");
			AddtoCartButton.click();
			
			String addtocarttext= AddtoCartResultText.getText();
			TakeScreenshots.CaptureScreenshots(driver, "TC006_03_Product is added in Cart");
			
			return addtocarttext;
			 
		}
		
		//TC006_Buy Now
		public String  BuyNow() {
			//TS= new TakeScreenshots();
			
			System.out.println("Click on Buy Again Button");
			TakeScreenshots.CaptureScreenshots(driver, "TC007_01_ Click On Buy Again button");
			BuyAgainButton.click();
			System.out.println("Click on Buy Now Button");
			TakeScreenshots.CaptureScreenshots(driver, "TC007_02_ Click On Buy now button");
			BuyNowButton.click();
					
			String paymentmethodtext= SelectPaymentMethodtext.getText();
			TakeScreenshots.CaptureScreenshots(driver, "TC007_03_ User is on Payment page");
			
			return paymentmethodtext;
			 
		}
		
}
