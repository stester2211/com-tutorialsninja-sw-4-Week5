package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility
{
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement actualReturningCxText;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement clickLoginButton;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement actualTextMyAccount;

    public String verifyTextReturningCustomer()
    {
        //2.3 Verify the text “Returning Customer”.
        return getTextFromElement(actualReturningCxText);
    }
    public void enterEmail(String enteremail)
    {
        //4.3 Enter Email address
        sendTextToElement(email,enteremail);
    }
    public void enterPassword(String enterpassword)
    {
        //4.3 Enter Password
        sendTextToElement(password,enterpassword);
    }
    public void clickLoginButton()
    {
        //4.6 Click on Login button
        clickOnElement(clickLoginButton);
    }
    public String verifyMyAccountText()
    {
        //4.7 Verify text “My Account”
        return getTextFromElement(actualTextMyAccount);
    }
}
