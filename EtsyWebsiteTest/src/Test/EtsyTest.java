package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.jdi.Locatable;

import Page.CategoriesPage;
import Page.FilterPage;
import Page.ItemsPage;
import Page.ReviewPage;
import Page.SignInPage;

public class EtsyTest {

//	attributes
	private WebDriver driver;
	private SignInPage signIn;
	private Actions actions;
	private FilterPage filter;
	private CategoriesPage category;
	private ReviewPage page;
	private ItemsPage item;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib//chromedriver.exe");
		this.driver = new ChromeDriver();

//		test executing in a full-screen window
		driver.manage().window().maximize();

//		setting the implicit waiters
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

//		Open Google Chrome and follow the link "https://www.etsy.com/"
		driver.get("https://www.etsy.com/");
		Thread.sleep(1000);

//		defining attributes
		signIn = new SignInPage(driver);
		actions = new Actions(driver);
		filter = new FilterPage(driver);
		category = new CategoriesPage(driver);
		page = new ReviewPage(driver);
		item = new ItemsPage(driver);
	}

	@Test
	public void registrationTestId1() throws InterruptedException {

//		Find the button "Sign in" in the upper right corner and click on it
		this.signIn.clickSignIn();

//		Using the condition statements because register/login window is not always the same
		String signInTitle = signIn.getSignInTitle().getText();

		if (signInTitle.equals("Sign in")) {

//			In the upper right corner of the pop-up window click on the button "Register"
			this.signIn.registerButton();

//			Calling the method for entering the email, first name and password
			this.signIn.submit("stojanovicmilica1303@yahoo.com", "Milica", "Milica@13");
			Thread.sleep(1000);

//			Click on the underlined text, "Show",  in the left side of the password field
			this.signIn.showPassword();

//			Click on the button "Register" under the fields	
			this.signIn.clickSubmitButton();
		}

		if (signInTitle.equals("Sign in to continue")) {

//			Calling the method for entering email and password
			this.signIn.enterEmail("stojanovicmilica1303@yahoo.com");

//			Click on the button "Register" under the fields	
			this.signIn.clickSubmitButton();

//			Calling the method for entering email and password
			this.signIn.submit2("stojanovicmilica1303@yahoo.com", "Milica@13");

//			Click on the underlined text, "Show",  in the left side of the password field
			this.signIn.showPassword();

//			Click on the button "Register" under the fields	
			this.signIn.clickSubmitButton();
		}
	}

	@Test
	public void loginTestId3() throws InterruptedException {

//		Find the button "Sign in" in the upper right corner and click on it
		this.signIn.clickSignIn();

		String signInTitle = signIn.getSignInTitle().getText();

		if (signInTitle.equals("Sign in")) {

//		Calling the method for entering email and password			
			this.signIn.submit1("stojanovicmilica1303@yahoo.com", "Milica@13");

//		Click on the button "Register" under the fields	
			this.signIn.clickSubmitButton();
		}

		if (signInTitle.contains("Sign in to continue")) {
			
			this.signIn.enterEmail("stojanovicmilica1303@yahoo.com");

//			Click on the button "Register" under the fields	
			this.signIn.clickSubmitButton();
			
//			Calling the method for entering name and password			
			this.signIn.submit2("Milica", "Milica@13");
			
//			Click on the button "Register" under the fields	
			this.signIn.clickSubmitButton();
		}

	}

	@Test
	public void testId4() throws InterruptedException {

//		Find the "Art & Collectibles" part on the timeline and hover it with a mouse																			
		Assert.assertTrue(exists(driver, this.category.art), "Art & Collectibles button doesn't exist.");
		this.actions.moveToElement(this.category.getArt()).build().perform();
		Thread.sleep(1000);

//		From the drop-down menu click on "Dolls & Miniatures" 
		Assert.assertTrue(exists(driver, this.category.dolls), "Dolls & Miniatures button doesn't exist.");
		this.category.getDolls().click();
		Thread.sleep(1000);

//		Click on the "Sort by" button and choose the "Highest price" from the drop-down menu	
		Assert.assertTrue(exists(driver, this.filter.sort), "Sort by button doesn't exist.");
		this.filter.getSort().click();
		Thread.sleep(1000);

		Assert.assertTrue(exists(driver, this.filter.price), "Highest Price option doesn't exist.");
		this.filter.getPrice().click();
		Thread.sleep(1000);

//		Define the price range by choosing on the radio button "USD 50 to USD 100" in the "Price ($)" section
		Assert.assertTrue(exists(driver, this.filter.filterPrice), "Price Range option doesn't exist.");
		this.filter.getFilterPrice().click();
		Thread.sleep(1000);

//		Find the "Home & Living" part on the timeline and hover it with a mouse																		
		Assert.assertTrue(exists(driver, this.category.home), "Home & Living button doesn't exist.");
		this.actions.moveToElement(this.category.getHome()).build().perform();
		Thread.sleep(1000);

//		From the drop-down menu hover with the mouse the "Pet Supplies" part and from the opened menu click on "Pet Bedding" button
		Assert.assertTrue(exists(driver, this.category.petSupplies), "Pet Supplies button doesn't exist.");
		this.actions.moveToElement(this.category.getPetSupplies()).build().perform();
		Thread.sleep(1000);

		Assert.assertTrue(exists(driver, this.category.petBedding), "Pet Bedding button doesn't exist.");
		this.category.getPetBedding().click();
		Thread.sleep(1000);

//		Click on the "Show more" button on the left side and click on the "Nesting Supplies"	
		Assert.assertTrue(exists(driver, this.filter.showMore), "Show More button doesn't exist.");
		this.filter.getShowMore().click();

		Assert.assertTrue(exists(driver, this.category.nestingSupplies), "Nesting Supplies button doesn't exist.");
		this.category.getNestingSupplies().click();

	}

	@Test
	public void testId5() throws InterruptedException {

//		Find the "Search for anything" input field,  enter the desired item (input: "Mugs") and click on the black search button on the right side
		this.category.searchInput("Mugs");
		Thread.sleep(1000);

//		Click on the "All Filters" button 
		Assert.assertTrue(exists(driver, this.filter.allFilters), "All Filters button doesn't exist.");
		this.filter.getAllFilters().click();
		Thread.sleep(5000);

//		Set the color by clicking on the "Blue" checkbox in the "Color" section and click the button "Apply"
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				this.driver.findElement(this.page.scrollTill2));
		Thread.sleep(1000);

		this.actions.moveToElement(this.filter.getBlue());
		this.actions.build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", this.filter.getBlue());
		Thread.sleep(1000);

//		Set the material by clicking on the "Porcelain" checkbox in the "Material" section
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				this.driver.findElement(this.page.scrollTill1));
		Thread.sleep(1000);

		this.actions.moveToElement(this.filter.getMaterial());
		this.actions.build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", this.filter.getMaterial());
		Thread.sleep(1000);

//		Set the Holiday by clicking on the "Easter" checkbox in the "Holiday" section
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				this.driver.findElement(this.page.scrollTill3));
		Thread.sleep(1000);

		this.actions.moveToElement(this.filter.getHoliday());
		this.actions.build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", this.filter.getHoliday());
		Thread.sleep(1000);

//		Set the ship country by clicking on the "Qatar" in the drop-down section "Ship to" and click the button "Apply"
		Assert.assertTrue(exists(driver, this.filter.shipping), "Shipping drop-down doesn't exist.");
		Select country = new Select(this.filter.getShipping());
		country.selectByVisibleText("Qatar");
		Thread.sleep(1000);

		Assert.assertTrue(exists(driver, this.filter.apply), "Apply button doesn't exist.");
		this.filter.getApply().click();
		Thread.sleep(1000);

//		Scroll at the end of the page and change the page number by clicking on one of the numbers (input: "2")
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				this.driver.findElement(this.page.scrollTill));
		Thread.sleep(1000);

		Assert.assertTrue(exists(driver, this.page.page2), "Page number doesn't exist.");
		this.page.getPage2().click();
		Thread.sleep(1000);

//		Find the "Search for anything" input field and click on the "X" button to erase the previous search text	
		Assert.assertTrue(exists(driver, this.category.search), "Search input field doesn't exist.");
		this.category.getXSearch().click();
	}

	@Test
	public void testId6() throws InterruptedException {

//		Find the "Jewelry & Accessories" and hover it with a mouse
		Assert.assertTrue(exists(driver, this.category.jewelry), "Jewelry button doesn't exist.");
		this.actions.moveToElement(this.category.getJewelry()).build().perform();
		Thread.sleep(1000);

//		From the drop-down menu choose "Necklaces"
		Assert.assertTrue(exists(driver, this.category.necklace), "Necklace button doesn't exist.");
		this.actions.moveToElement(this.category.getNecklace());
		this.actions.build().perform();
		Thread.sleep(1000);

//		From the necklace category choose "Chrystal Necklaces"
		Assert.assertTrue(exists(driver, this.category.chrystal), "Chrystal Necklace button doesn't exist.");
		this.category.getChrystal().click();
		Thread.sleep(5000);

//		To filter items, from the section "Special offers" choose "FREE shipping" checkbox	
		Assert.assertTrue(exists(driver, this.filter.freeShip), "Free Shipping checkbox doesn't exist.");
		this.actions.moveToElement(this.filter.getFreeShip());
		this.actions.build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", this.filter.getFreeShip());
		Thread.sleep(1000);

//		From the section "Price ($)" choose "Over USD 100" radio button	
		Assert.assertTrue(exists(driver, this.filter.filterPrice), "Price Range option doesn't exist.");
		this.filter.getFilterPrice().click();
		Thread.sleep(1000);

//		From the section "Recipient" choose "Women" radio button
		Assert.assertTrue(exists(driver, this.filter.women), "Women checkbox option doesn't exist.");
		this.actions.moveToElement(this.filter.getWomen());
		this.actions.build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", this.filter.getWomen());
		Thread.sleep(1000);
	}

	@Test
	public void testId9() throws InterruptedException {

//		Hover the "Toys & Entertainment" with a mouse and from "Movies & Music" choose "Musical Insrtuments"
		Assert.assertTrue(exists(driver, this.category.toys), "Jewelry button doesn't exist.");
		this.actions.moveToElement(this.category.getToys()).build().perform();
		Thread.sleep(1000);

//		From the menu choose "Musical Instruments"
		Assert.assertTrue(exists(driver, this.category.instruments), "Chrystal Necklace button doesn't exist.");
		this.category.getInstruments().click();
		Thread.sleep(1000);

//		From the catgories choose "Pianos & Keyboards"
		Assert.assertTrue(exists(driver, this.category.piano), "Pianos & Keyboards option doesn't exist.");
		this.category.getPiano().click();
		Thread.sleep(1000);

//		Hover the first item photo with the mouse
		Assert.assertTrue(existElements(driver, this.item.pianoPhoto), "First piano photo doesn't exist.");
		this.actions.moveToElement(this.item.getFirstPianoPhoto()).build().perform();
		Thread.sleep(1000);

//		Click on the white heart on the photo	
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOf(this.item.getFirstFavorite()));

		boolean heart = this.item.getFirstFavorite().isDisplayed();
		Assert.assertTrue(heart);

		this.item.getFirstFavorite().click();
		Thread.sleep(2000);

//		Click on the white heart on the second and third item photo
		// second item
		Assert.assertTrue(existElements(driver, this.item.pianoPhoto), "First piano photo doesn't exist.");
		this.actions.moveToElement(this.item.getSecondPianoPhoto()).build().perform();
		Thread.sleep(1000);

		waiter.until(ExpectedConditions.visibilityOf(this.item.getSecondFavorite()));

		heart = this.item.getSecondFavorite().isDisplayed();
		Assert.assertTrue(heart);
		Thread.sleep(1000);

		this.item.getSecondFavorite().click();
		Thread.sleep(2000);

		// third item
		Assert.assertTrue(existElements(driver, this.item.pianoPhoto), "First piano photo doesn't exist.");
		this.actions.moveToElement(this.item.getThirdPianoPhoto()).build().perform();
		Thread.sleep(1000);

		waiter.until(ExpectedConditions.visibilityOf(this.item.getThirdFavorite()));

		heart = this.item.getThirdFavorite().isDisplayed();
		Assert.assertTrue(heart);
		Thread.sleep(1000);

		this.item.getThirdFavorite().click();
		Thread.sleep(2000);

//		Click on the "Add to list" button
		waiter.until(ExpectedConditions.visibilityOf(this.item.getAddToList()));

		Assert.assertTrue(existElements(driver, this.item.pianoPhoto), "Add To List doesn't exist.");
		this.item.getListButton().click();
		Thread.sleep(1000);

//		Click on the empty field "Name" and enter the list name (input: "Gifts")
		Assert.assertTrue(existElements(driver, this.item.newList), "Create New List window doesn't exist.");
		this.item.getNewList().sendKeys("Gifts");
		Thread.sleep(1000);

//		From the section "Make this list private" click on the button next to it to make the list private
		Assert.assertTrue(existElements(driver, this.item.toggleSwitch), "Toggle switch doesn't exist.");
		this.item.getToggleSwitch().click();
		Thread.sleep(1000);

//		Click on the button "Create list"		
		Assert.assertTrue(existElements(driver, this.item.createList), "Create List button doesn't exist.");
		this.item.getCreateList().click();
		Thread.sleep(1000);
	}

	@AfterMethod
	public void cleanup() {
		this.driver.quit();
	}

//	method for checking if the elements exists on the page
	public boolean exists(WebDriver driver, By by) {
		boolean exist = true;
		try {
			driver.findElement(by);
		} catch (Exception e) {
			exist = false;
		}
		return exist;
	}

//	method for checking if the list of elements exists on the page
	public boolean existElements(WebDriver driver, By by) {
		boolean exist = true;
		try {
			driver.findElements(by);
		} catch (Exception e) {
			exist = false;
		}
		return exist;
	}
}
