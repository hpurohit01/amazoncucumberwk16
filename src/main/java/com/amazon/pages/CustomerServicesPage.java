package com.amazon.pages;

import com.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

public class CustomerServicesPage extends Utility {

    private static final Logger log = LogManager.getLogger(CustomerServicesPage.class.getName());

    public CustomerServicesPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Hello. What can we help you with?']")
    WebElement headingText;

    public void verifyHeadingText(){
        String expected = "Hello. What can we help you with?";
        String actual = headingText.getText().trim();
        log.info("verifying the customer service page heading text."+headingText.getText());
        AssertJUnit.assertEquals(expected,actual);
    }
}
