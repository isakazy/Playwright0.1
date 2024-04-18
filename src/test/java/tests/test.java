package tests;

import com.microsoft.playwright.Page;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.SauceDemoLoginPage;
import pages.SauceDemoProductPage;
import utilities.Config;
import utilities.FrameworkConfiguration;
import utilities.FrameworkInitialize;

public class test {

    @Before
    public void setUpPlaywright(){
        FrameworkConfiguration.localPage =  new FrameworkInitialize().InitializePlaywright();
    }

    @After
    public void cleanUP(){
        FrameworkConfiguration.playwright.close();
    }


   @Test
    public void TestSauceDemo(){

       FrameworkConfiguration.localPage.navigate(Config.getValue("sauceDemo"));
       Assert.assertEquals(Config.getValue("sauceDemo"),FrameworkConfiguration.localPage.url() );
   }


   @Test
    public void LoginToSauceDemo(){
        FrameworkConfiguration.localPage.navigate(Config.getValue("sauceDemo"));
       SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
       sauceDemoLoginPage.logInToSauceDemo(Config.getValue("sauceUserName"), Config.getValue("saucePassword"));
       Assert.assertEquals(Config.getValue("sauceDemoProductPage"), FrameworkConfiguration.localPage.url());

   }

   @Test
    public void AddBackPackToCart(){
       SauceDemoProductPage sauceDemoProductPage = new SauceDemoProductPage();
       SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
        FrameworkConfiguration.localPage.navigate(Config.getValue("sauceDemo"));
        sauceDemoLoginPage.logInToSauceDemo("standard_user", "secret_sauce");
        sauceDemoProductPage.ClickAddBackPackToCart();
        Assert.assertTrue(FrameworkConfiguration.localPage.locator("//button[@id='remove-sauce-labs-backpack']").isVisible());
        Assert.assertTrue(FrameworkConfiguration.localPage.locator("//span[.='1']").isVisible());
   }


}
