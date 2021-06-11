package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewPage {
	private WebDriver driver;
	public By scrollTill = By.xpath("//nav[@aria-label='Review Page Results']");
	public By page2 = By.xpath("//nav[@aria-label='Review Page Results']/ul/li[3]");
	public By scrollTill1 = By.partialLinkText("Material");
	public By scrollTill2 = By.partialLinkText("Color");
	public By scrollTill3 = By.partialLinkText("Holiday");
	
	public ReviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getPage2() {
		return this.driver.findElement(page2);
	}
	
	
}
