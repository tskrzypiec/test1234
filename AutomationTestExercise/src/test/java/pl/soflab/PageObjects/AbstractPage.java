package pl.soflab.PageObjects;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {

		this.driver = driver;
	}

	public LandingPage navigateToLogInPage() {

		driver.get("http://automationpractice.com/index.php");
		return new LandingPage(driver);
	}

	public void closeDriver() {
		
		driver.close();
		
	}
	
}
