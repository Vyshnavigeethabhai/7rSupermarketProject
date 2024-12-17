package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;

	public void selectByIndex(WebElement dropdown, int index) {
		Select drop = new Select(dropdown);
		drop.selectByIndex(index);
	}

	public void selectByVisibleText(WebElement dropdown, String text) {
		Select drop1 = new Select(dropdown);
		drop1.selectByVisibleText(text);
	}
}
