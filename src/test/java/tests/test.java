package tests;

import com.microsoft.playwright.Page;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.Config;
import utilities.FrameworkConfiguration;
import utilities.FrameworkInitialize;

public class test {
   @Before
    public void setUpPlaywright(){
       FrameworkConfiguration.localPage =  new FrameworkInitialize().InitializePlaywright();
   }

   @Test
    public void TestSauceDemo(){
      Page page =  FrameworkConfiguration.localPage;
       FrameworkConfiguration.localPage.navigate(Config.getValue("sauceDemo"));
       Assert.assertEquals(Config.getValue("sauceDemo"),page.url() );
   }


}
