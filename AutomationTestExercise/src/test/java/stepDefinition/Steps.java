package stepDefinition;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pl.soflab.PageObjects.CategoryPage;
import pl.soflab.PageObjects.ConfirmAccountPage;
import pl.soflab.PageObjects.CreateAnAccountPage;
import pl.soflab.PageObjects.LandingPage;
import pl.soflab.PageObjects.LogInPage;
import pl.soflab.PageObjects.ProductPage;

public class Steps {

	String expectedResult = "$56.00";
	WebDriver driver = null;
	LandingPage landingPage;
	LogInPage logInPage;
	ConfirmAccountPage confirmAccountPage;
	CreateAnAccountPage createAnAccountPage;
	String alias = "alias";
	CategoryPage categoryPage;
	ProductPage productPage;
	
	@Before
	public void beforeMethodTestSetUp() {

		System.setProperty("webdriver.chrome.driver", "src/test/resource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void afterMethodTestSetUp() {

		driver.quit();
	}

	@Given("^I am on the main page$")
	public void shouldNavigateToMainPage() throws Throwable {
	
		landingPage = new LandingPage(driver);
		landingPage.navigateToLogInPage();
	}

	@And("^I click on the log in button$")
	public void shouldClickOnSighInButton() throws Throwable {

		logInPage = landingPage.navigateToLogInButton();
	}

	@When("^I fill email address$")
	public void shouldFillEmailAddress(DataTable tableOne) throws Throwable {
	
		logInPage.setEmail(tableOne);
	}

	@And("^I click create an account button")
	public void shouldClickOnCreateAnAccountButton() throws Throwable {

		createAnAccountPage=logInPage.clickOnCreateButton();
	}

	@And("^I submit the form with valid data$")
	public void shouldSubmitTheFormWithValidData(DataTable tableTwo) throws Throwable {

		createAnAccountPage.fillInCreateAccountForm(tableTwo);
	}

	@And("^I set alias")
	public void shouldSetAlias(DataTable tableThree) throws Throwable {
		createAnAccountPage.setAlias(tableThree);
	}

	@And("^I submit new account")
	public void shouldPressRegisterButton() throws Throwable {
		confirmAccountPage = createAnAccountPage.submitNewAccount();
	}
 
/*	@Then("^I should be on the \"([^\"]*)\"$")
	public void shouldBeOnTheSignInPage(String signInPage) throws Throwable {

		String expectedWebUrl = new String(signInPage);
		// driver.get("https://www.soflab.pl");
		String actualWebUrl = driver.getCurrentUrl();
		// Assert.assertEquals(expectedWebUrl, actualWebUrl);
		Assert.assertEquals(expectedWebUrl, actualWebUrl);
		System.out.println("expectWebUrl ");
		driver.findElement(By.xpath("//a[@title='Log me out']")).click();
	}
*/
	/*@And("^I click on the \"([^\"]*)\"$")
	public void shouldBeOnALoginPage(String logInPage) throws Throwable {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(logInPage)).click();
	}*/

	@When("^I put email and password")
	public void shouldFillInEmailAddress(DataTable tableThree) throws Throwable {
	
		logInPage.setEmailAndPassword(tableThree);
	}

	@And("^I click signIn button")
	public void shouldClickSignInButton()
	{
		confirmAccountPage = logInPage.clickSignInButton();
	}
	
	@Then("^I should be on my account page")
	public void shouldBeOnMyAccountPage() throws Throwable {
		
		Thread.sleep(3000);
		Assert.assertTrue(confirmAccountPage.getAccountConfirmation().contains("Welcome to your account"));
	}

	@When("^I pick blouse category and pick the item")
	//public void shouldClickOnBlouseCategoryAndChooseAnItem(String womanCategory, String blouseCategory,String blouseItem, String clickMoreButton) throws Throwable {

		public void shouldClickOnBlouseCategoryAndChooseAnItem() throws Throwable {

		/*Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Blouses']")).click();

		Actions b = new Actions(driver);
		b.moveToElement(driver.findElement(By.xpath("//img[@title='Blouse']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='View']")).click();
		Thread.sleep(6000);*/
		categoryPage = landingPage.pickCategory();
		
	}
		
	/*	Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath(womanCategory))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(blouseCategory)).click();

		Actions b = new Actions(driver);
		b.moveToElement(driver.findElement(By.xpath(blouseItem))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(clickMoreButton)).click();/*
		
	//	 When I hover on "//a[@title='Women']" and click on "//a[@title='Blouses']"
	//	    When I hover on "//img[@title='Blouse']" and click "//a[@title='View']"
	}  */

//	@When("^I hover on \"([^\"]*)\" and click \"([^\"]*)\"$")
//	public void shouldHitmoreButtonOnSpecificItem(String blouseItem, String clickMoreButton) throws Throwable {

//	}

	@And("^I choose quantity and size of the item")
	//public void shouldAddQuantityAndPickASize(String quantity, String size, String select, String quantityBox)
	public void shouldAddQuantityAndPickASize()
			throws Throwable {
		/* Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("2");
		// Thread.sleep(2000);
		Select sizePick = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
		Thread.sleep(2000);
		sizePick.selectByValue("3");
//  And I pick a "//input[@id='quantity_wanted']" and put "2" and "//select[@id='group_1']" a "3"*/
	
		categoryPage.chooseQuantityAndSize();
	}

	@And("^I add the item to cart")
	//public void shouldAddAnItemToCart(String addItem) throws Throwable {
		public void shouldAddAnItemToCart() throws Throwable {

		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		Thread.sleep(3000);
			
		/*driver.findElement(By.xpath(addItem)).click();
		Thread.sleep(3000);*/
		
		//  And I "//button[@name='Submit']" an item to cart
	}

	@Then("^I check if Total price with shipping is correct")
	public void shouldCheckIfTheTotalPriceIsCorrect() throws Throwable {

		Thread.sleep(3000);
		String result = driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']")).getText();
		// @Then("^the result should be (.+)$")
		// public void the_result_should_be(String expectedResult) {
		// assertEquals(expectedResult, result);
		// }
		// expectedResult = "$56.00";
		assertEquals(expectedResult, result);
		// System.out.println("Suma wynosi
		// "+driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']")).getText());
		Assert.assertTrue("Total price is not correct",
		driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']")).getText().contains("56"));
	}

}
