package pl.soflab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmAccountPage extends AbstractPage {

	public ConfirmAccountPage(WebDriver driver) {
		super(driver);
	}
	public String getAccountConfirmation() {
		
		return driver.findElement(By.xpath("//p[@class='info-account']")).getText();
	}
}
