package com.amazon.pages;

import com.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends Utility {

    private static final Logger log = LogManager.getLogger(SearchResultPage.class.getName());

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']//div//div//div//div//div//div//div//div//div//h2//a")
    List<WebElement> searchResultAllTexts;

    @FindBy(linkText = "//span[@class='a-size-medium a-color-base a-text-normal'])")
    List<WebElement> productsList;

      @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Next']")
    WebElement nextPageButtonByXpath;

    @FindBy(css = ".s-pagination-item.s-pagination-next.s-pagination-button.s-pagination-separator")
    WebElement nextPageButtonByCss;

    @CacheLookup
    @FindBy(linkText = "Next")
    WebElement nextByttonByLinkedText;

    public void clickOnNextPageButton() {
        clickOnElement(nextPageButtonByCss);
    }

    public boolean searchFirstPageIteam(String item) {
        boolean result = false;
        for (WebElement element : searchResultAllTexts) {
            if (element.getText().trim().equals(item)) {
                result = true;
                System.out.println("item found: " + element.getText().trim());
                break;
            }
        }
        return result;
    }

    public void searchItem(String item) throws InterruptedException {
        boolean myBreak = true;
        boolean selection = false;
        while (myBreak) {
            for (WebElement element : productsList) {
                if (element.getText().equalsIgnoreCase(item)) {
                    System.out.println("Product found= " + element.getText());
                    clickOnElement(element);
                    log.info("Clicking on item: "+element.getText());
                    selection = true;
                    myBreak = false;
                    break;
                }
            }
            if (myBreak) {
                if (!driver.getCurrentUrl().contains("page=20")) {
                    waitUntilVisibilityOfElementLocatedAndthenClickOnElement(By.linkText("Next"), 100);
                    log.info("Clicking on next button: "+ By.linkText("Next").toString());
                } else {
                    selection = false;
                    myBreak = false;
                }
                PageFactory.initElements(driver, this);
                Thread.sleep(5000);
            }
        }
        //  return selection;
    }

    public void SearchItemUsingForLoop(String item) {
        System.out.println("size of items list: " + searchResultAllTexts.size());
        String actualItem = "";
        String actual2 = "";
        int s = 4;
        boolean mybreak = false;
        for (int i = 0; i <= s; i++) {
            for (int j = 1; j < searchResultAllTexts.size(); j++) {
                if (searchResultAllTexts.get(j).getText().contains("\"")) {
                    actual2 = searchResultAllTexts.get(j).getText().replace("\"", "inch").trim();
                    if (actual2.equals(item)) {
                        actualItem = actual2;
                        System.out.println("item with problem quote=" + actualItem);
                        log.info("finiding item:= " + actual2);
                        mybreak = true;
                        break;
                    }
                } else if (searchResultAllTexts.get(j).getText().trim().equals(item)) {
                    actualItem = searchResultAllTexts.get(j).getText();
                    System.out.println("Item without quote=" + actualItem);
                    mybreak = true;
                    break;
                }
                if (mybreak) {
                    break;
                }
            }
        }
        boolean expected = actualItem.contains(item);
        log.info("Asserting item by name: " + item);
        Assert.assertTrue(expected);



}

    }

