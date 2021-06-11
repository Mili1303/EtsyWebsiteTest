package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SignInPage {

	private WebDriver driver;
	public By signInButton = By.xpath("//div[@class='wt-flex-shrink-xs-0']/nav/ul/li[1]/button");
	public By signInTitle = By.id("join-neu-overlay-title");
	public By register = By.className("select-register");
	public By email = By.name("email");
	public By firstName = By.name("first_name");
	public By password = By.name("password");
	public By show = By.id("showHidePassword");
	public By regButton = By.name("submit_attempt");
	public By xButton = By.xpath("//*[@id=\"join-neu-overlay\"]/div[1]/button");
	public By error = By.id("aria-join_neu_email_field-error");
	public By error1 = By.className("wt-validation__message");

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignInButton() {
		return this.driver.findElement(signInButton);
	}

	public WebElement getSignInTitle() {
		return this.driver.findElement(signInTitle);
	}

	public WebElement getRegister() {
		return this.driver.findElement(register);
	}

	public WebElement getEmail() {
		return this.driver.findElement(email);
	}

	public WebElement getFirstName() {
		return this.driver.findElement(firstName);
	}

	public WebElement getPassword() {
		return this.driver.findElement(password);
	}

	public WebElement getShow() {
		return this.driver.findElement(show);
	}

	public WebElement getRegButton() {
		return this.driver.findElement(regButton);
	}

	public WebElement getXButton() {
		return this.driver.findElement(xButton);
	}

	public WebElement getError() {
		return this.driver.findElement(error);
	}

	public WebElement getError1() {
		return this.driver.findElement(error1);
	}

//	method for entering email, first name and password
	public void submit(String email1, String firstName1, String password1) throws InterruptedException {
		Assert.assertTrue(exists(driver, this.email), "The email field doesn't exist on the pop-up window.");
		this.getEmail().sendKeys(email1);
		Thread.sleep(1000);

		Assert.assertTrue(exists(driver, this.firstName), "The first name field doesn't exist on the pop-up window");
		this.getFirstName().sendKeys(firstName1);
		Thread.sleep(1000);

		Assert.assertTrue(exists(driver, this.password), "Password field doesn't exist on the pop-up window.");
		this.getPassword().sendKeys(password1);
		Thread.sleep(1000);
	}

//	method for entering email and password
	public void submit1(String email1, String password1) throws InterruptedException {
		Assert.assertTrue(exists(driver, this.email), "The email field doesn't exist on the pop-up window.");
		this.getEmail().sendKeys(email1);
		Thread.sleep(1000);

		Assert.assertTrue(exists(driver, this.password), "Password field doesn't exist on the pop-up window.");
		this.getPassword().sendKeys(password1);
		Thread.sleep(1000);
	}

//	method for entering first name and password
	public void submit2(String firstName1, String password1) throws InterruptedException {
		Assert.assertTrue(exists(driver, this.firstName), "The first name field doesn't exist on the pop-up window");
		this.getFirstName().sendKeys(firstName1);
		Thread.sleep(1000);

		Assert.assertTrue(exists(driver, this.password), "Password field doesn't exist on the pop-up window.");
		this.getPassword().sendKeys(password1);
		Thread.sleep(1000);
	}

	public void enterEmail(String email1) throws InterruptedException {
		Assert.assertTrue(exists(driver, this.email), "The email field doesn't exist on the pop-up window.");
		this.getEmail().sendKeys(email1);
		Thread.sleep(1000);
	}

	public void registerButton() throws InterruptedException {
		Assert.assertTrue(exists(driver, this.register), "Register button doesn't exist on the pop-up window.");
		this.getRegister().click();
		Thread.sleep(1000);
	}

	public void clickSubmitButton() throws InterruptedException {
		Assert.assertTrue(exists(driver, this.regButton), "Register button doesn't exist.");
		this.getRegButton().click();
		Thread.sleep(1000);
	}

	public void showPassword() throws InterruptedException {
		Assert.assertTrue(exists(driver, this.show), "Show button doesn't exist in the password field.");
		this.getShow().click();
		Thread.sleep(1000);
	}

	public void clickSignIn() throws InterruptedException {
		Assert.assertTrue(exists(driver, this.signInButton),
				"Sign in button doesn't exist, which means that user is already signed in.");
		this.getSignInButton().click();
		Thread.sleep(1000);
	}

// method for checking if the element exists on the page
	public boolean exists(WebDriver driver, By by) {
		boolean exist = true;
		try {
			this.driver.findElement(by);
		} catch (Exception e) {
			exist = false;
		}
		return exist;
	}
}
