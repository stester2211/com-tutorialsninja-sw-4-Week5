package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComponentPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//h2[contains(text(),'Components')]")
    WebElement actualTextComponent;
    public String verifyTextComponents()
    {
        //3.3 Verify the text ‘Components’
        return getTextFromElement(actualTextComponent);
    }
}
