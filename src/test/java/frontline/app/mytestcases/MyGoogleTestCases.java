package frontline.app.mytestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import frontline.app.objectrepro.MyGooglePage;


public class MyGoogleTestCases {
	public WebDriver driver;
	MyGooglePage googlePage;
	
	
	@BeforeClass
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhineet Mishra\\Documents\\FrontLine\\chromedriver_win32\\chromedriver.exe");
		System.out.println("before:"+driver);
		driver= new ChromeDriver();
		System.out.println("after:"+driver);
		driver.get("https://www.google.com/");
		googlePage = new MyGooglePage(driver);
	}
	
	
	@Test
	public void verifyTitle(){
		String googleTitle = driver.getTitle();		
		Assert.assertEquals(googleTitle, "Google");
	}
	
	@Test
	public void verifyGoogleImage(){
		Assert.assertTrue(googlePage.googleImage.isDisplayed());
	}
	
	@Test
	public void verifyGmailLinkIsDisplayed(){
		Assert.assertTrue(googlePage.gmailLink.isDisplayed());

	}

}



