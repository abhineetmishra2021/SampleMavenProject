package frontline.app.objectrepro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyGooglePage {
	public MyGooglePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//img[@alt='Google']")
	public WebElement googleImage;
	
	@FindBy(xpath="//a[contains(text(),'Gmail')]")
	public WebElement gmailLink;

}


