package pages;

import com.microsoft.playwright.Page;
import utilities.FrameworkConfiguration;

public class SauceDemoLoginPage {
    Page page = FrameworkConfiguration.localPage;
    String userNameInputField = "//input[@id='user-name']";
    String passwordInputField = "//input[@id='password']";
    String logInButton = "//input[@id='login-button']";


    public void logInToSauceDemo(String username, String password ){
        page.fill(userNameInputField, username);
        page.fill(passwordInputField, password);
        page.click(logInButton);

    }
}
