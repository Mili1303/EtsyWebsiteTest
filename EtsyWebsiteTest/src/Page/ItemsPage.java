package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemsPage {
	private WebDriver driver;
	public By pianoPhoto = By.cssSelector(".v2-listing-card__img");
	public By favorite = By.cssSelector(".favorite-listing-button-icon-container");
	public By addToList = By.id("confirmation-toast");
	public By listBtn = By.partialLinkText("Add to list");
	public By newList = By.id("edit-list");
	public By createList = By.partialLinkText("Create list");
	public By toggleSwitch = By.xpath("//*[@data-selector=\"toggle-switch\"]/label");
	
	public ItemsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> getPianoPhotos() {
		return this.driver.findElements(pianoPhoto);
	}
	
	public WebElement getFirstPianoPhoto() {
		return this.getPianoPhotos().get(0);
	}
	
	public WebElement getSecondPianoPhoto() {
		WebElement second = this.getPianoPhotos().get(0);
		for (int i = 0; i < this.getPianoPhotos().size(); i++) {
			second = this.getPianoPhotos().get(2);
		}
		return second;
	}
	
	public WebElement getThirdPianoPhoto() {
		WebElement third = this.getPianoPhotos().get(0);
		for (int i = 0; i < this.getPianoPhotos().size(); i++) {
			third = this.getPianoPhotos().get(3);
		}
		return third;
	}
	
	public List<WebElement> getFavorite() {
		return this.driver.findElements(favorite);
	}
	
	public WebElement getFirstFavorite() {
		return this.getFavorite().get(0);
	}
	
	public WebElement getSecondFavorite() {
		WebElement second = this.getFavorite().get(0);
		for (int i = 0; i < this.getFavorite().size(); i++) {
			second = this.getFavorite().get(2);
		}
		return second;
	}
	
	public WebElement getThirdFavorite() {
		WebElement third = this.getFavorite().get(0);
		for (int i = 0; i < this.getFavorite().size(); i++) {
			third = this.getFavorite().get(3);
		}
		return third;
	}
	
	public WebElement getAddToList() {
		return this.driver.findElement(addToList);
	}
	
	public WebElement getListButton() {
		return this.driver.findElement(listBtn);
	}
	
	public WebElement getNewList() {
		return this.driver.findElement(newList);
	}
	
	public WebElement getCreateList() {
		return this.driver.findElement(createList);
	}
	
	public WebElement getToggleSwitch() {
		return this.driver.findElement(toggleSwitch);
	}
	
	
	
	
	
	

}
