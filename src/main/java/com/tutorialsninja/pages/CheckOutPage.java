package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//a[text()='Checkout']")
    WebElement actualTextCheckOut;
    @CacheLookup
    @FindBy(xpath="//h2[contains(text(),'New Customer')]")
    WebElement actualTextNewCustomer;
    @CacheLookup
    @FindBy(xpath="//input[@value='guest']")
    WebElement clickOnGuest;
    @CacheLookup
    @FindBy(xpath="//input[@id='button-account']")
    WebElement clickOnContinue;
    @CacheLookup
    @FindBy(xpath="//input[@id='input-payment-firstname']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath="//input[@id='input-payment-lastname']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath="//input[@id='input-payment-email']")
    WebElement email;
    @CacheLookup
    @FindBy(xpath="//input[@id='input-payment-telephone']")
    WebElement phoneNumber;
    @CacheLookup
    @FindBy(xpath="//input[@id='input-payment-address-1']")
    WebElement address;
    @CacheLookup
    @FindBy(xpath="//input[@id='input-payment-city']")
    WebElement city;
    @CacheLookup
    @FindBy(xpath="//input[@id='input-payment-postcode']")
    WebElement postCode;
    @CacheLookup
    @FindBy(xpath="//select[@id='input-payment-country']")
    WebElement country;
    @CacheLookup
    @FindBy(xpath="//select[@id='input-payment-zone']")
    WebElement zone;
    @CacheLookup
    @FindBy(xpath="//input[@id='button-guest']")
    WebElement clickOnContinueTwo;
    @CacheLookup
    @FindBy(xpath="//textarea[@class='form-control']")
    WebElement addComment;
    @CacheLookup
    @FindBy(xpath="//input[@name='agree']")
    WebElement clickTermCondition;
    @CacheLookup
    @FindBy(xpath="//input[@id='button-payment-method']")
    WebElement clickOnContinueThree;
    @CacheLookup
    @FindBy(xpath="//div[text()='Warning: Payment method required!']")
    WebElement actualErrorText;
    public String verifyTextCheckOut()
    {
        //2.16 Verify the text “Checkout”
        return getTextFromElement(actualTextCheckOut);
    }
    public String verifyTextNewCustomer()
    {
        //2.17 Verify the Text “New Customer”
        return getTextFromElement(actualTextNewCustomer);
    }
    public void clickOnGuestCheckOut()
    {
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(clickOnGuest);
    }
    public void clickOnContinue()
    {
        //2.19 Click on “Continue” tab
        clickOnElement(clickOnContinue);
    }
    public void fillAllField()
    {
        //2.20 Fill the mandatory fields
        sendTextToElement(firstName,"Vishwa");

        sendTextToElement(lastName,"patel");

        sendTextToElement(email,"vp@gmail.com");

        sendTextToElement(phoneNumber,"1234567893");

        sendTextToElement(address,"Asking");

        sendTextToElement(city,"Windsor");

        sendTextToElement(postCode,"123456");

        selectByVisibleTextFromDropDown(country,"United Kingdom");

        selectByVisibleTextFromDropDown(zone,"Anglesey");
    }
    public void clickOnContinueTwo()
    {
        //2.21 Click on “Continue” Button
        clickOnElement(clickOnContinueTwo);
    }
    public void addComment()
    {
        //2.22 Add Comments About your order into text area
        sendTextToElement(addComment,"Please call before you deliver the package");
    }
    public void clickOnCheckBoxTerm()
    {
        //2.23 Check the Terms & Conditions check box
        clickOnElement(clickTermCondition);
    }
    public void clickOnContinueThree()
    {
        //2.24 Click on “Continue” button
        clickOnElement(clickOnContinueThree);
    }
    public String verifyErrorText()
    {
        //2.25 Verify the message “Warning: Payment method required!”
        return getTextFromElement(actualErrorText);
        /** assertVerifyText(actualErrorText,"Warning: Payment method required!\n" +
                "×","Warning message not found");*/
    }

}
