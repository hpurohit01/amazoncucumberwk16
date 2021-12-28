package com.amazon.pages;

import com.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedItemPage extends Utility {

    private static final Logger log = LogManager.getLogger(SelectedItemPage.class.getName());

    public SelectedItemPage() {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(id = "quantity")
    WebElement quantityBox;

    @CacheLookup
    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    public void selectQuantity(String quantity){
        selectByValueFromDropDown(quantityBox, quantity);
        log.info("Selecting quantity :" + quantity);

    }

    public void clickOnAddItemToCart(){
        clickOnElement(addToCartButton);
        log.info("Click on the add to cart button :" + addToCartButton + "<br>");

    }
}
