package AmazonOrderHistoryPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utils.ReadExcel;
import Utils.TakeScreenshots;
import Utils.Constants;

@SuppressWarnings("unused")

 	public class SearchOrderResults {
	
	private WebDriver driver;
	//private int ScreenShotNum;
	// TakeScreenshots TS;
	 
	//Webelemnt of search result text
	@FindBy(xpath="//*[@id=\"ordersContainer\"]/div[1]/label")private WebElement SearchResultText;
	
	//Order number
	 @FindBy(xpath="//*[@id=\"ordersContainer\"]/div[1]/div[1]/div/div/div/div[2]/div[1]/span[2]") private WebElement SerachResultforOrderNumber;
	
	 //If search text is incorrect below text will print
	 @FindBy(xpath="//*[@id=\"ordersContainer\"]/div[2]") private WebElement SearchResultforincorrecttext ;
	//*[@id="ordersContainer"]/div[2]/text()
	 
	 //For Filter searchtext
	 @FindBy(xpath="//span[@class=\"num-orders\"]")private WebElement SearchResultForFilter;
	 
	 public SearchOrderResults(WebDriver driver) 
		
		{ 
			this.driver=driver;
		
			PageFactory.initElements(driver, this);
			
			
		}
	 
	 public String  SearchResult(String OrderText) {
		// String SearchResultArray [] = new String [2];
		 String SearchResult;
		
		 String s = OrderText;
	        Pattern p = Pattern.compile("[0-9][^A-Za-z]");
	        Matcher m = p.matcher(s);
	        
	        if (m.find()) {
	        	 SearchResult =  SerachResultforOrderNumber.getText();
	        }
	        else
	        {
				 
				 SearchResult = SearchResultText.getText(); 
				 
			 }
	        //	TS= new TakeScreenshots();
			//System.out.println(String.format("%02d",  Constants.ScreenShotNum));
			TakeScreenshots.CaptureScreenshots(driver, "TC004_"+ String.format("%02d",  Constants.ScreenShotNum)  + "_Search Result"); 
			Constants.ScreenShotNum ++;
	    
		return SearchResult;
		
		
		 
	 }
	 public String  incorrectOrderText()  { 
		 	
		//TS= new TakeScreenshots();
		 
		String IncorrectSearch = SearchResultforincorrecttext.getText();
		TakeScreenshots.CaptureScreenshots(driver, "TC003_01_ To check incorrect Search criteria");
		return IncorrectSearch;
	 }
	 
	 public String FilterResult(String Filter) {
		 System.out.println("Select Filter");
			// String SearchResultArray [] = new String [2];
			 String OrderFilterResult =null;
			 String F = Filter;
			
			 for (int i = 0; i < Filter.length(); i++) {
				
				 //System.out.println(OrderFilterResult[i]); 
				 
				 OrderFilterResult =SearchResultForFilter.getText();
				i++; 
			}
			 
			  
		       
				//System.out.println(String.format("%02d",  Constants.ScreenShotNum));
				TakeScreenshots.CaptureScreenshots(driver, "TC005_"+ String.format("%02d",  Constants.ScreenShotfilterNum)  + "_Filter Result"); 
				Constants.ScreenShotfilterNum ++;
		    
			return OrderFilterResult;
						
			
			
			
			 		 }
	 
	 }
	
	 

