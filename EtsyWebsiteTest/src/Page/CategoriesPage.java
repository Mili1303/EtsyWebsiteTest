package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CategoriesPage {

	private WebDriver driver;
	public By art = By.xpath("//*[@data-ui='top-nav-category-list']/li[6]/a");
	public By dolls = By.linkText("Dolls & Miniatures");
	public By home = By.xpath("//*[@data-ui=\"top-nav-category-list\"]/li[3]/a");
	public By petSupplies = By.xpath("//li[@data-node-id='4440']");
	public By petBedding = By.id("catnav-l3-4442");
	public By nestingSupplies = By.linkText("Nesting Supplies");
	public By search = By.name("search_query");
	public By xSearch = By.xpath("//form[@id=\"gnav-search\"]/button");
	public By jewelry = By.xpath("//*[@data-ui=\"top-nav-category-list\"]/li[1]");
	public By necklace = By.xpath("//*[@data-node-id=\"10873\"]");
	public By chrystal = By.xpath("//*[@id=\"catnav-l3-10877\"]");
	public By toys = By.xpath("//ul[@data-ui=\"top-nav-category-list\"]/li[5]");
	public By instruments = By.xpath("//*[@data-node-id=\"11077\"]");
	public By piano = By.partialLinkText("Pianos & Keyboards");
	
	public CategoriesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getArt() {
		return this.driver.findElement(art);
	}
	
	public WebElement getDolls() {
		return this.driver.findElement(dolls);
	}
	
	public WebElement getHome() {
		return this.driver.findElement(home);
	}
	
	public WebElement getPetSupplies() {
		return this.driver.findElement(petSupplies);
	}
	
	public WebElement getPetBedding() {
		return this.driver.findElement(petBedding);
	}
	
	public WebElement getNestingSupplies() {
		return this.driver.findElement(nestingSupplies);
	}
	
	public WebElement getSearch() {
		return this.driver.findElement(search);
	}
	
	public WebElement getXSearch() {
		return this.driver.findElement(xSearch);
	}
	
	public WebElement getJewelry() {
		return this.driver.findElement(jewelry);
	}
	
	public WebElement getNecklace() {
		return this.driver.findElement(necklace);
	}
	
	public WebElement getChrystal() {
		return this.driver.findElement(chrystal);
	}
	
	public WebElement getToys() {
		return this.driver.findElement(toys);
	}
	
	public WebElement getInstruments() {
		return this.driver.findElement(instruments);
	}
	
	public WebElement getPiano() {
		return this.driver.findElement(piano);
	}
	
	
	public void searchInput(String input) {
		Assert.assertTrue(exists(driver, this.search), "Search field doesn't exist.");
		this.getSearch().sendKeys(input);
		this.getSearch().sendKeys(Keys.ENTER);
	}
	
	
//	method for checking if the elements exist on the page
	public boolean exists(WebDriver driver, By by) {
		boolean exist = true;
		try {
			driver.findElement(by);
		} catch (Exception e) {
			exist = false;
		}
		return exist;

	}
}
