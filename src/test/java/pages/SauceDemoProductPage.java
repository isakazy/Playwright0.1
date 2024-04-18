package pages;

import com.microsoft.playwright.Page;
import utilities.FrameworkConfiguration;

public class SauceDemoProductPage {

    Page page = FrameworkConfiguration.localPage;
    public  String productBackPack = "//button[@name='add-to-cart-sauce-labs-backpack']";
    public String oneItemInCart = "//span[.='1']";

    public void ClickAddBackPackToCart(){
        page.click(productBackPack);
    }



}
