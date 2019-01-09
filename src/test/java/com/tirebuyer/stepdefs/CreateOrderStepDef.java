package com.tirebuyer.stepdefs;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tirebuyer.framework.SeleniumUtil;
import com.tirebuyer.pageobjects.CartAndDeliveryPage;
import com.tirebuyer.pageobjects.HomePage;
import com.tirebuyer.pageobjects.PayPalLoginPage;
import com.tirebuyer.pageobjects.PaymentPage;
import com.tirebuyer.pageobjects.ShopTiresPage;
import com.tirebuyer.pageobjects.TireDetailsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateOrderStepDef {

	@Given("I launch tirebuyer.com")
	public void i_launch_tirebuyer_com() {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.get("https://www.tirebuyer.com");
		driver.manage().window().maximize();

		try {
			driver.findElement(HomePage.adSelector).click();
		} catch (Exception e) {
		}

		try {
			Thread.sleep(5000);
			driver.findElement(HomePage.close_flyInAd).click();
		} catch (Exception e) {
		}
	}

	@When("I click Tires tab")
	public void i_click_tires_tab() {
	}

	@And("I chose Shop By Vehicle section")
	public void i_chose_Shop_By_Vehicle_section() {
	}

	@And("Select year as {int}")
	public void select_year_as(Integer year) {
		WebDriver driver = SeleniumUtil.getWebDriver();

		SeleniumUtil.clickAsJavascript(driver, HomePage.launchYearSelector);
		driver.findElement(HomePage.getYearSelector(year)).click();
	}

	@And("Select {string} from Select Make section")
	public void select_from_Select_Make_section(String make) {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(HomePage.getMakeSelector(make)).click();
	}

	@And("Select {string} from Select Model section")
	public void select_from_Select_Model_section(String model) {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(HomePage.getModelSelector(model)).click();
	}

	@And("Select {string} from Select style section")
	public void select_from_Select_style_section(String style) {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(HomePage.getStyleSelector(style)).click();
	}

	@And("Enter zip code as {int}")
	public void enter_zip_code_as(Integer zipCode) {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(HomePage.getZipCodeSelector(zipCode)).sendKeys(zipCode.toString());
	}

	@And("I click on Shop tires button")
	public void i_click_on_Shop_tires_button() {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(HomePage.button_ShopTires).click();
	}

	@And("I click Shop all tires on the Recommendation page")
	public void i_click_Shop_all_tires_on_the_Recommendation_page() {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(ShopTiresPage.button_ShopAllTires).click();
	}

	@And("I click on More details for the second product in Tires Details page")
	public void i_click_on_More_details_for_the_nd_product_in_Tires_Details_page() {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(ShopTiresPage.moreDetails).click();
	}

	@And("I click on Add to cart in the details page")
	public void i_click_on_Add_to_cart_in_the_details_page() {
		WebDriver driver = SeleniumUtil.getWebDriver();
		SeleniumUtil.scrollBy(driver, 0, 500);
		SeleniumUtil.click(driver, TireDetailsPage.button_AddToCart);
	}

	@And("I click on Deliver to a local installer radio button on the cart page")
	public void i_click_on_Deliver_to_a_local_installer_radio_button_on_the_cart_page() {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(CartAndDeliveryPage.deliveryMethodInstaller).click();
	}

	@And("Select installer number {int} from the local installer list")
	public void select_installer_number_from_the_local_installer_list(Integer itemNo) {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(CartAndDeliveryPage.installerItem_2).click();
	}

	@And("I click on Save and continue button in the Delivery to Installer window.")
	public void i_click_on_Save_and_continue_button_in_the_Delivery_to_Installer_window() {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(CartAndDeliveryPage.button_SaveAndContinue).click();
	}

	@And("I Click on Continue to checkout button on the cart page")
	public void i_Click_on_Continue_to_checkout_button_on_the_cart_page() throws InterruptedException {
		WebDriver driver = SeleniumUtil.getWebDriver();
		SeleniumUtil.scrollBy(driver, 0, 500);
		Thread.sleep(5000);
		driver.findElement(CartAndDeliveryPage.button_ContinueToCheckout).click();
		/*
		 * WebDriverWait wait=new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.elementToBeClickable(HomePage.
		 * button_ContinueToCheckout)).click();
		 */ }

	@And("I Click on Checkout with PayPal button on the Payment page")
	public void i_Click_on_Checkout_with_PayPal_button_on_the_Payment_page() {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(PaymentPage.button_PaypalExpress).click();
	}

	@And("I Enter any dummy credential for PayPal")
	public void i_Enter_any_dummy_credential_for_PayPal() throws InterruptedException {
		WebDriver driver = SeleniumUtil.getWebDriver();
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		while (iterator.hasNext()) {
			String child_window = iterator.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				Thread.sleep(3000);
				driver.findElement(PayPalLoginPage.email).sendKeys("abc@gmail.com");
				driver.findElement(PayPalLoginPage.button_Next).click();
				driver.findElement(PayPalLoginPage.button_Password).sendKeys("xyz");
			}
		}
	}

	@And("I click on Log In button")
	public void i_click_on_Log_In_button() {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(PayPalLoginPage.button_Login).click();
	}

	@And("I click on Cancel and return to TireBuyer.com")
	public void i_click_on_Cancel_and_return_to_TireBuyer_com() {
		WebDriver driver = SeleniumUtil.getWebDriver();
		driver.findElement(PayPalLoginPage.link_Cancel).click();
	}

	@Then("exit")
	public void exit() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}
}
