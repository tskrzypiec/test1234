package pl.soflab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class CategoryPage extends AbstractPage {

final String setQuantityXpatch = new String ("//input[@id='quantity_wanted']");

protected By bySetQuantity = By.xpath(setQuantityXpatch);
	
final String quantityValue = new String ("2");

final String selectSizeXpatch = new String ("//select[@id='group_1']");

protected By bySetSize = By.xpath(selectSizeXpatch);

final String sizeValue = new String ("3");


	public CategoryPage(WebDriver driver) {
		super(driver);
	}

	public ProductPage chooseQuantityAndSize() throws InterruptedException {
		
		 Thread.sleep(3000);
			
			driver.findElement(bySetQuantity).clear();

			// Thread.sleep(2000);
			
			driver.findElement(bySetQuantity).sendKeys(quantityValue);

			// Thread.sleep(2000);
			
			Select sizePick = new Select(driver.findElement(bySetSize));

			Thread.sleep(2000);
			sizePick.selectByValue(sizeValue);
		
		return new ProductPage(driver);
	}
	
}

/*private final By byLoanValue = By.name("value");
private final By byLoanDuration = By.name("period");

private final By byInstallmentRate = By.xpath("//span[@data-value='installment_str']");

final String acceptCookiesCreditsPageXpath = new String("//div[@class='cookie-policy-content']//span[contains(@class,'js-cookie-policy-main-accept-button') and text()='Zaakceptuj']");

protected By byAcceptCookies = By.xpath(acceptCookiesCreditsPageXpath);  */
