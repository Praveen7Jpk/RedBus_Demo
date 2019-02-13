package PageObject;

import java.security.PublicKey;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ExcelData.ReadExcel;

public class Login_Page {

	public WebDriver driver;
	
	public Login_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="signin-block")
	public WebElement Sign_menu;
	
	@FindBy(id="signInLink")
	public WebElement Sign_button;
	
	@FindBy(css="iframe.modalIframe")
	public WebElement iframeModel;
	
	@FindBy(id="mobileNoInp")
	public List<WebElement> mobileinput;
	
	@FindBy(className="modalCloseSmall")
	public WebElement Close_button;
	
	public void Sign_menu() {
		Sign_menu.click();
	}
	
	public void Sign_button() {
		Sign_button.click();
	}
	
	public void iframeModel() {
		driver.switchTo().frame(iframeModel);
	}
	
	public void mobileinput() {
		List<WebElement> mobilenumber= mobileinput;		
		for(WebElement ids:mobilenumber) {
			ids.click();
			ids.sendKeys(ReadExcel.mobilenumber);
		}
	}
	
	public void Close_button() {
		driver.switchTo().parentFrame();
		Close_button.click();
	}
	
	
	public void sign_function() {
		Sign_menu();
		Sign_button();
		iframeModel();
		mobileinput();
		Close_button();
	}
}
