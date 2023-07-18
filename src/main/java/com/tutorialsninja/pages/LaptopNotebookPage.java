package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaptopNotebookPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement actualTextLaptopNotebook;
    @CacheLookup
    @FindBy(xpath="//select[@id='input-sort']")
    WebElement sortBy;
    @CacheLookup
    @FindBy(xpath="//p[@class ='price']")
    List<WebElement> productListBefore;
    @CacheLookup
    @FindBy(xpath="//p[@class ='price']")
    List<WebElement> productListAfter;
    @CacheLookup
    @FindBy(xpath="//a[text()='MacBook']")
    WebElement selectProductMac;

    public String verifyTextLaptopNoteBook()
    {
        //2.3 Verify the text ‘Laptops & Notebooks’
        return getTextFromElement(actualTextLaptopNotebook);
    }
    public void sortByPrice(String selectOption)
    {
        selectByVisibleTextFromDropDown(sortBy,selectOption);
    }
    public void verifyProductHighTOLow(String selectOption, String failMessage)
    {
       listOfElementVerifyInReverse(productListBefore,sortBy,selectOption,productListAfter,failMessage);
    }
    public void selectProductMacBook()
    {
        //2.4 Select Product “MacBook”
        clickOnElement(selectProductMac);
    }

}
