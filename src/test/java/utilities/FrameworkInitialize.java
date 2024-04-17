package utilities;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;


public class FrameworkInitialize {
    public Page InitializePlaywright() {

        //Initialize the browser
        BrowserInitialize browserInitialize = new BrowserInitialize();

        //Set the launch Options
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.headless = false;
        launchOptions.devtools = false;

        //Get Browser
          Browser browser  = browserInitialize.GetBrowser(Config.getValue("browser"), launchOptions);

        //Get browserContext
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        //contextOptions.locale = "en/US";

         BrowserContext context = browserInitialize.GetBrowserContext(browser, contextOptions);

        //Get Page
        return browserInitialize.GetPage(context);
    }

}
