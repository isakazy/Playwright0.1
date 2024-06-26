package utilities;

import com.microsoft.playwright.*;

public class BrowserInitialize {

    public Browser GetBrowser(String browserName, BrowserType.LaunchOptions launchOptions) {
        FrameworkConfiguration.playwright = Playwright.create();
        BrowserType browserType = null;

        if(browserName.equalsIgnoreCase("chromium"))
            browserType = FrameworkConfiguration.playwright.chromium();
        if(browserName.equalsIgnoreCase("firefox"))
            browserType = FrameworkConfiguration.playwright.firefox();
        if(browserName.equalsIgnoreCase("webkit"))
            browserType = FrameworkConfiguration.playwright.webkit();

        return browserType.launch(launchOptions);
    }

    public BrowserContext GetBrowserContext(Browser browser, Browser.NewContextOptions newContextOptions) {
        return browser.newContext(newContextOptions);
    }

    public Page GetPage(BrowserContext browserContext) {
        return browserContext.newPage();
    }
}
