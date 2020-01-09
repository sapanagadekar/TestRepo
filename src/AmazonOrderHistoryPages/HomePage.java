package AmazonOrderHistoryPages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utils.TakeScreenshots;
@SuppressWarnings("unused") 
public class HomePage {
	
 private WebDriver driver;
 //TakeScreenshots TS;
 //WebElemnts for testcase1 -Login
  @FindBy(id="nav-orders")private WebElement Orderlink;
  @FindBy(id="ap_email")private WebElement UserName;
  @FindBy(id="ap_password")private WebElement Password;
  //continue button
  @FindBy(xpath="//*[@id=\"continue\"]")private WebElement Continuebutton;
  @FindBy(id="signInSubmit")private WebElement SubmitButton;
 
  //WebElemnts for test case2 - Available Tabs(Containers) 
  @FindBy(xpath="//*[@id=\"orderTypeMenuContainer\"]/ul/li[2]/span/span")private WebElement OrderFrame;
  @FindBy(xpath="//*[@id=\"orderTypeMenuContainer\"]/ul/li[3]/span/a")private WebElement BuyAgainFrame;
  @FindBy(xpath="//*[@id=\"orderTypeMenuContainer\"]/ul/li[4]/span/a")private WebElement OpenOrdersFrame;
  @FindBy(xpath="//*[@id=\"orderTypeMenuContainer\"]/ul/li[5]/span/a")private WebElement CancelledOrdersFrame;
  
  //Webelemnts for test case 3 - Order details search text box
   @FindBy(id="searchOrdersInput")private WebElement SearchOrderInput;
  // @FindBy(id="//*[@id=\"a-autoid-0\"]/span/input")private WebElement SearchOrderButton;
  
	
   
  public HomePage(WebDriver driver) 
	
	{ 
		this.driver=driver;
	
		PageFactory.initElements(driver, this);
	}
	
  //Loging through Orderlink availble on Home page
	public void LoginthroughOrderlink() throws InterruptedException
	{  
		//TS= new TakeScreenshots();
		TakeScreenshots.CaptureScreenshots(driver, "TC001_01_Click On OrderLink");	
		
		Thread.sleep(1500);
		Orderlink.click();
		
		UserName.sendKeys("9890606666");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	    Continuebutton.click();
	    
		Password.sendKeys("Amazon1234567");
		
		TakeScreenshots.CaptureScreenshots(driver, "TC001_02_Click On Login Button");	
		SubmitButton.click();
			
	
		
	}
	
	//Tabs(Containers) availble on Your Order page
	public String[] Tabs() {
	
	String TabArray [] = new String [4];
	 TabArray [0] =  OrderFrame.getText();
	 System.out.println("Available  Section : " + " " + TabArray [0]);
	 
	 TabArray [1] = BuyAgainFrame.getText();
	 System.out.println("Available  Section : " + " " + TabArray [1]);
	 
	 TabArray [2] = OpenOrdersFrame.getText();
	 System.out.println("Available  Section : " + " " + TabArray [2]);
	
	 TabArray [3] = CancelledOrdersFrame.getText();
	 System.out.println("Available  Section : " + " " + TabArray [3]);
	
	return TabArray;
	
	}
	
	//To iptut the Order details in search text box 
	public void SearchOrder(String OrderText) {
		
		 System.out.println("Enter Orderdetails");
		 SearchOrderInput.clear();	
		 SearchOrderInput.sendKeys(OrderText + Keys.ENTER);
		 
		 
	 }
	
	public void incorrectsearch() {
		
		System.out.println("Enter incorrect text");
		 SearchOrderInput.sendKeys("@#$%"+ Keys.ENTER);
		 
		 
	 }
	
	public void YourOrdersPage() {
						
		Orderlink.click();
	}
	
	
}
