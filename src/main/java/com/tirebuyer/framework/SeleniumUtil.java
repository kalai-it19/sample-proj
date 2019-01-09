package com.tirebuyer.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUtil {

	static {
		// TODO: Read from a config file
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\E329222\\Desktop\\VS2017\\Selenium\\chromedriver.exe");
	}

	private static WebDriver webdriver = null;

	public static WebDriver getWebDriver() {
		if (webdriver == null) {
			webdriver = new ChromeDriver();
			webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return webdriver;
	}

	public static void click(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}

	public static void clickAsJavascript(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor executor = ((JavascriptExecutor) driver);
		executor.executeScript("arguments[0].click();", element);
	}

	public static void sendKeys(WebDriver driver, By by, String data) {
		WebElement element = driver.findElement(by);
		element.sendKeys(data);
	}

	public static void scrollBy(WebDriver driver, int x, int y) {
		JavascriptExecutor executor = ((JavascriptExecutor) driver);
		executor.executeScript("window.scrollBy(" + x + "," + y + ")");
	}
}
