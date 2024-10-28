package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMClass {
	
	public static WebDriver driver;
	
	public POMClass(WebDriver driver) {		
			this.driver=driver;
			PageFactory.initElements(driver, this);	
	}
	@FindBy(id="user-name")
	private WebElement userName;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'error-message')]/h3")
	private WebElement errorMessage;

	public WebElement getErrorMessage() {
		return errorMessage;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}

}
