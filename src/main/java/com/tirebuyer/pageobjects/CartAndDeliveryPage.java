package com.tirebuyer.pageobjects;

import org.openqa.selenium.By;

public class CartAndDeliveryPage {
	public static By deliveryMethodInstaller = By
			.xpath("//div[@class='delivery-method delivery-method-installer ']//div[@class=\"delivery-radio\"]");

	public static By installerItem_2 = By.xpath("//div[@id='InstallerList']//div[@class='installer-item installer-item-2 ']//div[@class='selector-radio']");
	
	public static By button_SaveAndContinue = By.id("InstallerSubmit");
	
	public static By button_ContinueToCheckout = By.className("continue-to-checkout");
}
