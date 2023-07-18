package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductDeskTopPage;
import com.tutorialsninja.pages.ShoppingCart;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class DesktopsTest extends BaseTest
{
    HomePage homePage;
    DesktopPage desktopPage;
    ProductDeskTopPage productPage;
    ShoppingCart shoppingCart;

    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage= new HomePage();
        desktopPage= new DesktopPage();
        productPage= new ProductDeskTopPage();
        shoppingCart= new ShoppingCart();
    }

    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException
    {
        //1.1 Mouse hover on Desktops Tab.and click
        homePage.hoverMouseToDesktopClick();
        Thread.sleep(1000);

        //1.2 Click on “Show All Desktops”
        homePage.callAllMenuBySelect("Show AllDesktops");
        Thread.sleep(1000);

        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.changeProductPosition("Name (Z - A)");
        Thread.sleep(1000);

        //1.4 Verify the Product will arrange in Descending order.
        //desktopPage.verifyProductInDescendingOrder("Name (Z - A)","Product not in decending order");
        Thread.sleep(1000);
    }

    // 2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test(groups = {"sanity", "smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException
    {
        // Convert the currency to pound
        homePage.currency();
        Thread.sleep(500);

        //2.1 Mouse hover on Desktops Tab. and click
        homePage.hoverMouseToDesktopClick();
        Thread.sleep(1000);

        //2.2 Click on “Show All Desktops”
        homePage.callAllMenuBySelect("Show AllDesktops");
        Thread.sleep(1000);

        //2.3 Select Sort By position "Name: A to Z"
        desktopPage.changeProductPosition("Name (A - Z)");
        Thread.sleep(1000);

        //2.4 Select product “HP LP3065”
        desktopPage.clickOnProductHp();
        Thread.sleep(1000);

        //2.5 Verify the Text "HP LP3065"
        Assert.assertEquals(productPage.verifyTextHp(),"HP LP3065","Hp text not found");
        Thread.sleep(1000);

        //2.6 Select Delivery Date "2022-11-30"
        productPage.selectDeliveryDate();
        Thread.sleep(2000);

        //2.7.Enter Qty "1” using Select class.
        productPage.enterQtyOne("1");
        Thread.sleep(1000);

        //2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCartButton();
        Thread.sleep(1000);

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        //Assert.assertEquals(productPage.verifyTextSuccess(),"Success: You have added HP LP3065 to your shopping cart!","Success message not found");
        Thread.sleep(1000);

        //2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartLink();
        Thread.sleep(1000);

        //2.11 Verify the text "Shopping Cart"
        Assert.assertEquals(shoppingCart.verifyTextShoppingCart(),"Shopping Cart","Shopping cart text not found");
        Thread.sleep(1000);

        //2.12 Verify the Product name "HP LP3065"
        Assert.assertEquals(shoppingCart.verifyTextProductName(),"HP LP3065","Product name text not found");
        Thread.sleep(1000);

        //2.13 Verify the Delivery Date "2022-11-30"
        // Assert.assertEquals(shoppingCart.verifyTextDeliveryDate(),"Delivery Date:2022-11-30","Delivery date text not found");
        Thread.sleep(1000);

        //2.14 Verify the Model "Product21"
        Assert.assertEquals(shoppingCart.verifyTextModel(),"Product21","Model text not found");
        Thread.sleep(1000);

        //2.15 Verify the Totat "£74.73"
        Assert.assertEquals(shoppingCart.verifyTextTotal(),"£74.73","Total text not found");
        Thread.sleep(3000);
    }


}
