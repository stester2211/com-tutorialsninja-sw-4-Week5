package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductLaptopPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'MacBook')]")
    WebElement actualMacBookText;
    @CacheLookup
    @FindBy(xpath="//button[@id='button-cart']")
    WebElement clickAddToCart;
    @CacheLookup
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement actualTextSuccessMessage;
    @CacheLookup
    @FindBy(xpath="//a[contains(text(),'shopping cart')]")
    WebElement clickOnShoppingCartLink;

    public String verifyTextMacBook()
    {
        //2.5 Verify the text “MacBook”
        return getTextFromElement(actualMacBookText);
        //assertVerifyText(actualMacBookText,"MacBook","MacBook text not found");
    }
    public void clickOnAddToCartLink()
    {
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(clickAddToCart);
    }
    public String verifyTextSuccess()
    {
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        return getTextFromElement(actualTextSuccessMessage);
    }
    public void clickOnShoppingCartLink()
    {
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(clickOnShoppingCartLink);
    }

}
