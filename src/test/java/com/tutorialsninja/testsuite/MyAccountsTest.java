package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)

public class MyAccountsTest extends BaseTest
{
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage= new HomePage();
        registerPage= new RegisterPage();
        loginPage= new LoginPage();
    }

    //1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException
    {
        //1.1 Click on My Account Link.
        homePage.clickOnAccountLink();
        Thread.sleep(1000);

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.callMethodAndPassParameter("Register");
        Thread.sleep(1000);

        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(registerPage.verifyTextRegister(),"Register Account","Register text not verify");
        Thread.sleep(1000);
    }

    // 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    @Test(groups = {"sanity", "smoke","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException
    {
        //2.1 Click on My Account Link.
        homePage.clickOnAccountLink();
        Thread.sleep(1000);

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.callMethodAndPassParameter("Login");
        Thread.sleep(1000);

        //2.3 Verify the text “Returning Customer”.
        Assert.assertEquals(loginPage.verifyTextReturningCustomer(),"Returning Customer","Return customer text not found");
    }

    //3. Test name verifyThatUserRegisterAccountSuccessfully()
    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException
    {
        //3.1 Click on My Account Link.
        homePage.clickOnAccountLink();
        Thread.sleep(1000);

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.callMethodAndPassParameter("Register");

        //3.3 Enter First Name
        registerPage.firstName("Vishwa");
        Thread.sleep(1000);

        //3.4 Enter Last Name
        registerPage.lastName("Patel");
        Thread.sleep(1000);

        //3.5 Enter Email
        registerPage.email("vpa2341855@gmail.com");
        Thread.sleep(1000);

        //3.6 Enter Telephone
        registerPage.telephone("1234567885");
        Thread.sleep(1000);

        //3.7 Enter Password
        registerPage.setPassword("123456vv");
        Thread.sleep(1000);

        //3.8 Enter Password Confirm
        registerPage.setConfirmPassword("123456vv");
        Thread.sleep(1000);

        //3.9 Select Subscribe Yes radio button
        registerPage.clickOnSubscribe();

        //3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyBox();
        Thread.sleep(1000);

        //3.11 Click on Continue button
        registerPage.clickOnContinue();
        Thread.sleep(1000);

        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(registerPage.verifyAccountText(),"Your Account Has Been Created!", "Account text not found");
        Thread.sleep(1000);

        //3.13 Click on Continue button
        registerPage.clickOnContinueTwo();
        Thread.sleep(2000);

        // 3.14 Click on My Account Link.
        homePage.clickOnAccountLink();
        Thread.sleep(1000);

        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.callMethodAndPassParameter("Logout");
        Thread.sleep(1000);

        // 3.16 Verify the text “Account Logout”
        Assert.assertEquals(homePage.verifyTextLogOut(),"Account Logout","Logout text not found");
        Thread.sleep(1000);

        //3.17 Click on Continue button
        homePage.clickContinue();
        Thread.sleep(1000);
    }

    // 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        homePage.clickOnAccountLink();
        Thread.sleep(1000);

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.callMethodAndPassParameter("Login");
        Thread.sleep(1000);

        //4.3 Enter Email address
        loginPage.enterEmail("vpa12345@gmail.com");

        //4.5 Enter Password
        loginPage.enterPassword("123456vv");

        //4.6 Click on Login button
        loginPage.clickLoginButton();
        Thread.sleep(1000);

        //4.7 Verify text “My Account”
        Assert.assertEquals(loginPage.verifyMyAccountText(),"My Account","My account text not found");
        Thread.sleep(5000);

        //4.8 Click on My Account Link.
        homePage.clickOnAccountLink();
        Thread.sleep(1000);

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.callMethodAndPassParameter("Logout");
        Thread.sleep(1000);

        //4.10 Verify the text “Account Logout”
        homePage.verifyTextLogOut();
        Thread.sleep(1000);

        //4.11 Click on Continue button
        homePage.clickContinue();
        Thread.sleep(1000);
    }
}
