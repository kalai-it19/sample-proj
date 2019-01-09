package com.tirebuyer.pageobjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

public class HomePage {

	public static By adSelector = By.id("monetate_lightbox_content");

	public static By tiresMenuSelector = By.className("at_fitment_tires");

	public static By shopByVehicleSelector = By.className("shop_by_vehicle");

	public static By launchYearSelector = By.xpath("//*[@id=\"shop-by-vehicle\"]/form/div[1]/button[1]");

	public static By button_ShopTires = By.className("at_shop_tires");
	public static By close_flyInAd = By.className("close-email-fly-in");
	//ShopByVehicle related section
	private static Map<Integer, String> yearClassMap = new HashMap<Integer, String>();
	private static Map<String, String> makeClassMap = new HashMap<String, String>();
	private static Map<String, String> modelClassMap = new HashMap<String, String>();
	
	static {
		// Populate the year and Class name mappings
		yearClassMap.put(2010, "at_fitment_year_2010");

		// Populate the make and Class name mappings
		makeClassMap.put("honda", "at_fitment_make_Honda");

		// Populate the model and Class name mappings
		modelClassMap.put("accord", "at_fitment_model_Accord");
	}

	public static By getYearSelector(int year) {
		return By.className(yearClassMap.get(year));
	}

	public static By getMakeSelector(String make) {
		return By.className(makeClassMap.get(make.toLowerCase()));
	}

	public static By getModelSelector(String model) {
		return By.className(modelClassMap.get(model.toLowerCase()));
	}
	
	public static By getStyleSelector(String style) {
		return By.xpath("//div[@class='fitment-panel fitment-panel-style']//a[@data-style='"+style+"']");
	}
	
	public static By getZipCodeSelector(int zipCode) {
		return By.className("at_fitment_zipcode");
	}

}
