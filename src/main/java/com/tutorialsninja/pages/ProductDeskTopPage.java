package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDeskTopPage extends Utility
{
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement actualTextHP;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement enterQty;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement clickOnAddToCart;
    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement actualMessageSuccess;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement clickOnShoppingCart;

    public String verifyTextHp()
    {
        //2.5 Verify the Text "HP LP3065"
        return getTextFromElement(actualTextHP);
    }
    public void selectDeliveryDate()
    {
        //2.6 Select Delivery Date "2023-11-30"
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }
    public void enterQtyOne(String enterQtyInBox)
    {
        //2.7.Enter Qty "1” using Select class.
        //driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        enterQty.clear();
        sendTextToElement(enterQty,enterQtyInBox);
    }
    public void clickOnAddToCartButton()
    {
        //2.8 Click on “Add to Cart” button
        clickOnElement(clickOnAddToCart);
    }
    public String verifyTextSuccess()
    {
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        return getTextFromElement(actualMessageSuccess);
    }
    public void clickOnShoppingCartLink()
    {
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(clickOnShoppingCart);
    }
}
