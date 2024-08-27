package Inputs;

import org.openqa.selenium.By;

public interface Values {

	final String productNameToAdd = "Hustle V2 Sneakers For Men";

	final String serachProductsToAdd = "Puma Shoes for Men";

	final String enterProductsInInput = "//input[@type='text']";

	final String listOfProducts = "//div[@class='DOjaWF gdgoEp']/div[@class='cPHDOP col-12-12']/div/div/div/div";

	final String addTocart = "//div[div[div[ul[li[button[text()='Add to cart']]]]]]/div[2]/div/ul/li[1]/button";
	final String addProductwithPlus = "//div[div[div[div[div[button[text()='+']]]]]]/div/div[2]/div[1]/div/button[2]";
	
	By waitForProductsToAppear = By.xpath("//div[@class='DOjaWF gdgoEp']/div[@class='cPHDOP col-12-12']/div/div/div/div");
	By clickOnSelectedProduct = By.xpath("//div[div[div[div[a[text()='" + productNameToAdd + "']]]]]/div[3]/div/div[1]");
	By waitForAddToCartButtonAppear = By.xpath("//div[div[div[ul[li[button[text()='Add to cart']]]]]]/div[2]/div/ul/li[1]/button");
	By waitForButtonToAppear = By.xpath("//div[div[div[div[div[button[text()='+']]]]]]/div/div[2]/div[1]/div/button[2]");
	String purchaseDetailsInfo = "//div[@class='_3j-e05']";
}
