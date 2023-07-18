package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.ComponentPage;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopNotebookPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)

public class TopMenuTest extends BaseTest
{
    HomePage homePage;
    DesktopPage desktopClass;
    LaptopNotebookPage laptopNotebookPage;
    ComponentPage componentPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage= new HomePage();
        desktopClass= new DesktopPage();
        laptopNotebookPage= new LaptopNotebookPage();
        componentPage= new ComponentPage();
    }

    @Test(groups = {"sanity","regression"})
    // 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.hoverMouseToDesktopClick();
        Thread.sleep(1000);

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.callAllMenuBySelect("Show AllDesktops");
        Thread.sleep(1000);

        //1.3 Verify the text ‘Desktops’
        desktopClass.verifyTextDesktop();
        Thread.sleep(1000);
    }

    //2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    @Test(groups = {"sanity", "smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException
    {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverToLapTop();
        Thread.sleep(1000);

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.callAllMenuBySelect("Show AllLaptops & Notebooks");
        Thread.sleep(1000);

        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(laptopNotebookPage.verifyTextLaptopNoteBook(),"Laptops & Notebooks","Not navigated to laptop page");
        Thread.sleep(1000);
    }

    //3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException
    {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverToComponents();
        Thread.sleep(1000);

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.callAllMenuBySelect("Show AllComponents");
        Thread.sleep(1000);

        //3.3 Verify the text ‘Components’
        Assert.assertEquals(componentPage.verifyTextComponents(),"Components","Not navigated to components page");
        Thread.sleep(1000);
    }
}
