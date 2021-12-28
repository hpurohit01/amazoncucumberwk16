package com.amazon.pages;

import com.amazon.propertyreader.PropertyReader;
import com.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@id='nav-main']//div[contains(@class,'nav-fill')]//div//div//a[2]")
    WebElement custServ;

    @CacheLookup
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchInputBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='nav-main']//div//a")
    List<WebElement> menuBar;


    public void clickOnCustomerServiceMenu() {
        waitUntilVisibilityOfElementLocatedAndthenClickOnElement(By.xpath("//div[@id='nav-main']//div[contains(@class,'nav-fill')]//div//div//a[2]"),2);
        clickOnElement(custServ);
        log.info("clicking on customer service from menu.");
    }

    public void clickOnMenu(String menu) {
        for (WebElement element : menuBar) {
            if (element.getText().trim().equalsIgnoreCase(menu)) {
                element.click();
                log.info("Clicking on menu: "+element.getText());
                break;
            }
        }
    }

    public void verifyHomePage() {
        String expected = PropertyReader.getInstance().getProperty("baseUrl");
        String actual = driver.getCurrentUrl();
        log.info("verifying homepage.");
        AssertJUnit.assertEquals(expected, actual);
    }

    public void sendTextToSearchInputField(String text) {
        sendTextToElement(searchInputBox, text);
        log.info("Sending text to search box. '" + text + "'");
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }
}




