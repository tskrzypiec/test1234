package pl.soflab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LandingPage extends AbstractPage {

	//private final By signInButton = By.xpath("//a[@title='Log in to your customer account']");
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public LogInPage navigateToLogInButton() {
			driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();	
		return new LogInPage(driver);
	}

	public CategoryPage pickCategory() throws InterruptedException {
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Blouses']")).click();

		Actions b = new Actions(driver);
		b.moveToElement(driver.findElement(By.xpath("//img[@title='Blouse']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='View']")).click();
		Thread.sleep(6000);
		
		return new CategoryPage(driver);
	}
	
	
	
	
}