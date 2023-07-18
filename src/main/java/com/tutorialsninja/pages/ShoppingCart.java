package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends Utility
{
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Shopping Cart')]")
    WebElement actualShoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']//a[text()='HP LP3065']")
    WebElement actualProductName;
    @CacheLookup
    @FindBy(xpath = "//small[contains(text(),'Delivery Date:2022-11-30')]")
    WebElement actualDeliveryDate;
    @CacheLookup
    @FindBy(xpath = "//td[contains(text(),'Product 21')]")
    WebElement actualModel;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement actualTotalText;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement actualTextMacbook;
    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group btn-block']//input[@class='form-control']")
    WebElement changeQtyToTwo;
    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-refresh']")
    WebElement clickOnUpdate;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement actualTextCartModify;
    @CacheLookup
    @FindBy(xpath = "//div[@class='col-sm-4 col-sm-offset-8']//td[text()='£737.45']")
    WebElement actualTotalLaptop;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement clickOnCheckOutButton;

    public String verifyTextShoppingCart()
    {
        //2.11 Verify the text "Shopping Cart"------------------- DesktopPage
        // 2.9 Verify the text "Shopping Cart"-----------------LaptopAndNotebookPage
        return getTextFromElement(actualShoppingCartText);
    }
    public String verifyTextProductName()
    {
        //2.12 Verify the Product name "HP LP3065"
        return getTextFromElement(actualProductName);
    }
    public String verifyTextDeliveryDate()
    {
        //2.13 Verify the Delivery Date "2022-11-30"
        return getTextFromElement(actualDeliveryDate);
    }
    public String verifyTextModel()
    {
        //2.14 Verify the Model "Product21"
        return getTextFromElement(actualModel);
    }
    public String verifyTextTotal()
    {
        //2.15 Verify the Todat "£74.73"
        return getTextFromElement(actualTotalText);
    }
    public String verifyProductMacBook()
    {
        //2.10 Verify the Product name "MacBook"
        return getTextFromElement(actualTextMacbook);
    }
    public void changeQty(String enterQuantity)
    {
        //2.11 Change Quantity "2"
        //driver.findElement(By.xpath("//div[@class='input-group btn-block']//input[@class='form-control']")).clear();
        changeQtyToTwo.clear();
        sendTextToElement(changeQtyToTwo,enterQuantity);
    }
    public void clickOnUpdateButton()
    {
        //2.12 Click on “Update” Tab
        clickOnElement(clickOnUpdate);
    }
    public String verifyTextSuccess()
    {
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        return getTextFromElement(actualTextCartModify);
    }
    public String verifyTotalOfLaptop()
    {
        //2.14 Verify the Total £737.45
        return getTextFromElement(actualTotalLaptop);
    }
    public void checkoutButton()
    {
        //2.15 Click on “Checkout” button
        clickOnElement(clickOnCheckOutButton);
    }
}
