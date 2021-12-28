package com.amazon.cucumber.steps;

import com.amazon.pages.HomePage;
import com.amazon.pages.SearchResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps {

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String productName) {
        new HomePage().sendTextToSearchInputField(productName);
    }

    @And("^I click on search button$")
    public void iClickOnSearchButton() {
        new HomePage().clickOnSearchButton();
    }


    @Then("^I should see message$")
    public void iShouldSeeMessage() {
        System.out.println("this is message");
    }


    @And("^I update the quantity \"([^\"]*)\"$")
    public void iUpdateTheQuantity(String qty) {
       // new SelectedProductPage().selectQuantity(qty);
    }

    @And("^I click on add to cart button$")
    public void iClickOnAddToCartButton() {
        //new SelectedProductPage().clickOnAddItemToCart();
    }

    @Then("^I should be able to verify add to cart message \"([^\"]*)\"$")
    public void iShouldBeAbleToVerifyAddToCartMessage(String expectedMessage) throws InterruptedException {
       // new AddToCartPage().verifyTheAddToCartMessage(expectedMessage);
    }

    @And("^I search for item from pages \"([^\"]*)\"$")
    public void iSearchForItemFromPages(String item) throws InterruptedException {
        new SearchResultPage().searchItem(item);
    }
    }