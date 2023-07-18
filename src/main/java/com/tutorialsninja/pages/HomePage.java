package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//span[contains(text(),'Currency')]")
    WebElement currency;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'£Pound Sterling')]")
    WebElement currencyPound;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'£Pound Sterling')]")
    List<WebElement> allListOfTopMenu;
    @CacheLookup
    @FindBy(xpath="//a[text()='Desktops']")
    WebElement mouseHoverToDesktopClick;
    @CacheLookup
    @FindBy(xpath="//a[text()='Laptops & Notebooks']")
    WebElement getMouseHoverToLaptop;
    @CacheLookup
    @FindBy(xpath="//a[text()='Components']")
    WebElement mouseHoverToComponents;
    @CacheLookup
    @FindBy(xpath="//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> getListForAccountDropdown;
    @CacheLookup
    @FindBy(xpath="//i[@class='fa fa-user']")
    WebElement clickOnMyAccountLink;
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Account Logout')]")
    WebElement actuallogoutText;
    @CacheLookup
    @FindBy(xpath="//a[contains(text(),'Continue')]")
    WebElement clickOnContinue;
    public void currency()
    {
        clickOnElement(currency);
        clickOnElement(currencyPound);
    }
    public void selectMenu(String menu)
    {
        // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
        // 1.2 This method should click on the menu whatever name is passed as parameter. Write the following Test:
        List<WebElement> topMenuList = getListOfElements(allListOfTopMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = getListOfElements(allListOfTopMenu);
        }
        clickOnElement(By.linkText(menu));
    }

    public void hoverMouseToDesktopClick()
    {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElement(mouseHoverToDesktopClick);
    }
    public void callAllMenuBySelect(String desktopText)
    {
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu(desktopText);
    }
    public void mouseHoverToLapTop()
    {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElement(getMouseHoverToLaptop);
    }
    public void mouseHoverToComponents()
    {
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElement(mouseHoverToComponents);
    }

    //***********************************My Account***********************************************
    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = getListOfElements(getListForAccountDropdown);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(getListForAccountDropdown);
        }
    }
    public void clickOnAccountLink()
    {
        //1.1 Click on My Account Link.
        clickOnElement(clickOnMyAccountLink);
    }
    public void callMethodAndPassParameter(String accountText)
    {
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions(accountText);
    }

    public String verifyTextLogOut()
    {
        // 3.16 Verify the text “Account Logout”
        return getTextFromElement(actuallogoutText);
    }
    public void clickContinue()
    {
        //3.17 Click on Continue button
        clickOnElement(clickOnContinue);
    }
}
