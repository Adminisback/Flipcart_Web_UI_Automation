package E2E.Flipcart;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import Inputs.Values;
import Utils.ActionsOnElements;
import Utils.CommonLogin;

public class TestCases extends ActionsOnElements implements Values {

	static String filePath;
    static String propertyName1;
	WebDriver driver;
	WebDriver driver1;
	CommonLogin i = new CommonLogin();
	@Test
	public void e2e() throws InterruptedException, IOException {
		driver1 = i.commonLoginPage(driver);
		WebElement searchInput = clickOnElement(driver1, enterProductsInInput);
		searchInput.sendKeys(serachProductsToAdd, Keys.ENTER);
		CommonWait.waitForElementsToBeVisible(driver1, waitForProductsToAppear);
		List<WebElement> products = listOfElements(driver1, listOfProducts);

		for (WebElement listP : products) {
			try {
				String p = listP.getText();
				if (p.contains(productNameToAdd)) {

					WebElement productFound = listP.findElement(clickOnSelectedProduct);
					productFound.click();
					break;
				}
			} catch (Exception e1) {
				e1.printStackTrace();

			}
		}
		switchToChild(driver1);
		Thread.sleep(1000);
		CommonWait.waitForWebElementBy(driver1, waitForAddToCartButtonAppear);
		WebElement addToCart = webElement(driver1, addTocart);
		JavascriptExecutor js = (JavascriptExecutor) driver1;
		js.executeScript("arguments[0].scrollIntoView(true);", addToCart);
		addToCart.click();
		CommonWait.waitForWebElementBy(driver1, waitForButtonToAppear);
		clickOnElement(driver1, addProductwithPlus);
		String purchaseDetails = webElement(driver1, purchaseDetailsInfo).getText();
		System.out.println("Details of the products to be order-");
		System.out.println(purchaseDetails);
		switchToParent(driver1);
	}
    @Test
	public void selectdDropdowns(WebDriver driver) throws IOException { // test2
		driver1 = i.commonLoginPage(driver);
		WebElement dropdown = driver1.findElement(By.xpath("//span[text()='Fashion']"));
		Actions act = new Actions(driver1);
		act.moveToElement(dropdown).build().perform();
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Men Footwear")));
		WebElement selectOptio = driver1.findElement(By.linkText("Men Footwear"));
		act.moveToElement(selectOptio).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Men's Sports Shoes")));
		WebElement select = driver1.findElement(By.linkText("Men's Sports Shoes"));
		act.moveToElement(select).click().build().perform();

	}

	public static void loginToFlipCart(WebDriver driver) { // Faling this test as flipcart not given access to automate
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement loginClick = driver.findElement(By.xpath("//div[@class='H6-NpN _3N4_BX']"));
		loginClick.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='_2IX_2- VJZDxU']")));
		WebElement enterNumber = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
		enterNumber.sendKeys("9834033511");
		WebElement requestOTP = driver.findElement(By.xpath("//button[text()='Request OTP']"));
		requestOTP.click();
	}

}
