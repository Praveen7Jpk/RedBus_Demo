package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ExcelData.ReadExcel;

import ExcelData.ReadExcel;

public class Redbus_Home {

	public WebDriver driver;
	
	public Redbus_Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="src")
	public WebElement source_place;
	
	@FindBy(tagName="li")
	public List<WebElement> source_list;
	
	@FindBy(id="dest")
	public WebElement dest;
	
	@FindBy(className="autoFill")
	public WebElement dest_place;
	
	@FindBy(tagName="li")
	public List<WebElement> dest_list;
	
	@FindBy(xpath="//*[@id='search']/div/div[3]/div/label")
	public WebElement Onward_Date;
	
	@FindBy(xpath="//*[@id='rb-calendar_onward_cal']/table")
	public WebElement date_table;
	
	@FindBy(tagName="td")
	public WebElement date_list;
	
	@FindBy(id="search_btn")
	public WebElement search_button;
	
	//Methods
	public void source_place() {
		source_place.sendKeys(ReadExcel.onp);
		
	}
	
	public void source_list() {
		for(WebElement ss:source_list) {		
			if (ss.getText().equals("Coimbatore Airport")){
			System.out.println("The Onwards List are:"+ss.getText());
			ss.click();
			break;
			}
		}
	}
	
	public void dest() {
		dest.sendKeys(ReadExcel.dsp);
	}
	
	public void dest_place() {
		List<WebElement> dest_list=dest_place.findElements(By.tagName("li"));
		for(WebElement dl:dest_list) {
			if(dl.getText().equals("Chennai")) {
				System.out.println("The Return List are:"+dl.getText());
				dl.click();
				break;
			}
		}
	}
	
	public void Onward_Date() {
		Onward_Date.click();
	}
	
	public void date_table() {
		List<WebElement> date_list=date_table.findElements(By.tagName("td"));
		for(WebElement dtl:date_list) {
			if(dtl.getText().equals("7")) {
				System.out.println("The Onward Date are:"+dtl.getText());
				dtl.click();
				break;
			}
			
		}
	}
	
	
	public void search_button() {
		search_button.click();
	}
	
	
	public void Home_page() throws InterruptedException {
		source_place();
		source_list();
		dest();
		Thread.sleep(3000);
		dest_place();
		Onward_Date();
		date_table();
		Thread.sleep(3000);
		search_button();
	}
}
