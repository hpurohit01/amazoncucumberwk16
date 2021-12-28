package com.amazon.cucumber.steps;

import com.amazon.pages.CustomerServicesPage;
import com.amazon.pages.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class SelectMenuSteps {
    @Given("^I am on homepage$")
    public void iAmOnHomepage() {
        new HomePage().verifyHomePage();
    }

    @When("^I select menu item$")
    public void iSelectMenuItem(DataTable dataTable) {
        List<String> rows = dataTable.asList(String.class);
        for (String name : rows) {
            new HomePage().clickOnMenu(name);
            System.out.println("clicked on menu= '" + name + "'");
            break;
        }
    }

    @Then("^I should be on item page$")
    public void iShouldBeOnItemPage() {
        new CustomerServicesPage().verifyHeadingText();
    }

    @When("^I select customer service menu$")
    public void iSelectCustomerServiceMenu() {
        new HomePage().clickOnCustomerServiceMenu();
    }

    @Then("^I should be on customer service page$")
    public void iShouldBeOnCustomerServicePage() {
        new CustomerServicesPage().verifyHeadingText();
    }
}

