package pl.soflab.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class CreateAnAccountPage extends AbstractPage{
	
	//private final String alias ="aliase";
	
	public CreateAnAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public CreateAnAccountPage fillInCreateAccountForm(DataTable tableTwo) {
		
		List<List<String>> data = tableTwo.raw();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(data.get(1).get(1));
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(data.get(2).get(1));
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(data.get(3).get(1));
		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue(data.get(4).get(1));
		Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		month.selectByValue(data.get(5).get(1));
		Select years = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		years.selectByValue(data.get(6).get(1));
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys(data.get(7).get(1));
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(data.get(8).get(1));
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(data.get(9).get(1));
		Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByValue(data.get(10).get(1));
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(data.get(11).get(1));
		Select country = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		country.selectByValue(data.get(12).get(1));
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(data.get(13).get(1));
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(data.get(14).get(1));
		
		return new CreateAnAccountPage(driver);
	}
	
	public CreateAnAccountPage setAlias(DataTable tableThree) throws InterruptedException {
		
		List<List<String>> dataAlias = tableThree.raw();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='alias']")).clear();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(dataAlias.get(1).get(1));  //popraw to z tym alisaem
		
		return new CreateAnAccountPage(driver);
	}
	
	public ConfirmAccountPage submitNewAccount() {
		
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		
		return new ConfirmAccountPage(driver);
	}	
	
}
