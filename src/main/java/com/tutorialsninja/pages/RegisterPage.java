package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility
{
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement actualTextRegister;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(xpath = "//input[@type='radio'][@name='newsletter'][@value='1']")
    WebElement clickRadioSubscription;
    @CacheLookup
    @FindBy(xpath = "//input[@type='checkbox'][@name='agree'][@value='1']")
    WebElement clickOnPrivacyBox;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement clickOnContinue;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement actualAccountCreatedText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement clickContinueTwo;

    public String verifyTextRegister()
    {
        //1.3 Verify the text “Register Account”.
        return getTextFromElement(actualTextRegister);
    }
    public void firstName(String enterFname)
    {
        //3.3 Enter First Name
        sendTextToElement(firstName,enterFname);
    }
    public void lastName(String enterLname)
    {
        //3.4 Enter Last Name
        sendTextToElement(lastName,enterLname);
    }
    public void email(String enterEmail)
    {
        //3.5 Enter Email
        sendTextToElement(email,enterEmail);
    }
    public void telephone(String enterTelephone)
    {
        //3.6 Enter Telephone
        sendTextToElement(telephone,enterTelephone);
    }
    public void setPassword(String enterPassword)
    {
        //3.7 Enter Password
        sendTextToElement(password,enterPassword);
    }
    public void setConfirmPassword(String enterConfirmPassword)
    {
        //3.8 Enter Password Confirm
        sendTextToElement(confirmPassword,enterConfirmPassword);
    }
    public void clickOnSubscribe()
    {
        //3.9 Select Subscribe Yes radio button
        clickOnElement(clickRadioSubscription);
    }
    public void clickOnPrivacyBox()
    {
        //3.10 Click on Privacy Policy check box
        clickOnElement(clickOnPrivacyBox);
    }
    public void clickOnContinue()
    {
        //3.11 Click on Continue button
        clickOnElement(clickOnContinue);
    }
    public String verifyAccountText()
    {
        //3.12 Verify the message “Your Account Has Been Created!”
        return getTextFromElement(actualAccountCreatedText);
    }
    public void clickOnContinueTwo()
    {
        //3.13 Click on Continue button
        clickOnElement(clickContinueTwo);
    }


}
