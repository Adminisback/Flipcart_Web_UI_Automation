package Utils;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ActionsOnElements {

	
	
	public static WebElement clickOnElement(WebDriver driver,String element) {
		WebElement e =driver.findElement(By.xpath(element));
		e.click();
		return e;
	}
	public static WebElement webElement(WebDriver driver,String element) {
		WebElement e =driver.findElement(By.xpath(element));
		return e;
	}

	public static List<WebElement> listOfElements(WebDriver driver, String elements){
		return driver.findElements(By.xpath(elements));
	}
	
	public static WebDriver switchToChild(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles(); // [ParentWindowsID[0] , ChildWindowsID[1]
		Iterator<String> iterateTheWindows = windows.iterator();
		String ParentWindowsID = iterateTheWindows.next(); // [ParentWindowsID]
		String ChildWindowsID = iterateTheWindows.next(); // [ChildWindowsID]
		return driver.switchTo().window(ChildWindowsID);
	}
	public static WebDriver switchToParent(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles(); // [ParentWindowsID[0] , ChildWindowsID[1]
		Iterator<String> iterateTheWindows = windows.iterator();
		String ParentWindowsID = iterateTheWindows.next(); // [ParentWindowsID]
		String ChildWindowsID = iterateTheWindows.next(); // [ChildWindowsID]
		return driver.switchTo().window(ParentWindowsID);
	}
}
