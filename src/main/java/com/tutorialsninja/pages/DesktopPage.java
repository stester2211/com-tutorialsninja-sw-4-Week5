package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DesktopPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//h2[contains(text(),'Desktops')]")
    WebElement actualTextDesktop;
    @CacheLookup
    @FindBy(xpath="//select[@id='input-sort']")
    WebElement position;
    @CacheLookup
    @FindBy(xpath="//h4/a")
    List<WebElement> productListBefore;
    @CacheLookup
    @FindBy(xpath="//h4/a")
    List<WebElement> productListAfter;
    @CacheLookup
    @FindBy(xpath="//a[contains(text(),'HP LP3065')]")
    WebElement clickOnProductHp;
    public String verifyTextDesktop()
    {
        //1.3 Verify the text ‘Desktops’
        return getTextFromElement(actualTextDesktop);
        //assertVerifyText(actualTextDesktop,"Desktops","Desktop text not found");
    }
    public void changeProductPosition(String textPosition)
    {
        // 1.3 Select Sort By position "Name: Z to A" ---- for desktop page
        selectByVisibleTextFromDropDown(position,textPosition);
    }
    public void verifyProductInDescendingOrder(String productName,String failMessage)
    {
        //1.4 Verify the Product will arrange in Descending order.
        listOfElementVerifyInReverse(productListBefore,position,productName,productListAfter,failMessage);
    }
    public void clickOnProductHp()
    {
        clickOnElement(clickOnProductHp);
    }

}
