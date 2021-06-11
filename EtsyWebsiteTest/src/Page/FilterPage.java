package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterPage {

	private WebDriver driver;
	public By sort = By.xpath("//*[@id='sortby']/button");
	public By price = By.xpath("//*[contains(text(), 'Highest Price')]");
	public By filterPrice = By.xpath("//div[@aria-label='Select a price range']/div[4]");
	public By showMore = By.xpath("//*[@aria-label='Show more']");
	public By allFilters = By.id("search-filter-button");
	public By blue = By.id("attr_1-2");
	public By material = By.id("attr_357-215");
	public By holiday = By.id("attr_4-37");
	public By shipping = By.name("ship_to");
	public By apply = By.xpath("//*[@aria-label='Apply']");
	public By freeShip = By.id("special-offers-free-shipping");
	public By women = By.id("attr_342-2310");

	public FilterPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSort() {
		return this.driver.findElement(sort);
	}

	public WebElement getPrice() {
		return this.driver.findElement(price);
	}

	public WebElement getFilterPrice() {
		return this.driver.findElement(filterPrice);
	}

	public WebElement getShowMore() {
		return this.driver.findElement(showMore);
	}

	public WebElement getAllFilters() {
		return this.driver.findElement(allFilters);
	}

	public WebElement getBlue() {
		return this.driver.findElement(blue);
	}

	public WebElement getMaterial() {
		return this.driver.findElement(material);
	}

	public WebElement getHoliday() {
		return this.driver.findElement(holiday);
	}

	public WebElement getShipping() {
		return this.driver.findElement(shipping);
	}

	public WebElement getApply() {
		return this.driver.findElement(apply);
	}
	
	public WebElement getFreeShip() {
		return this.driver.findElement(freeShip);
	}
	
	public WebElement getWomen() {
		return this.driver.findElement(women);
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
