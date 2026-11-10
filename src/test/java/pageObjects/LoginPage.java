package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.Basepage;

public class LoginPage extends Basepage {
    public LoginPage(WebDriver driver)
    {
       super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath="//input[@value='Login']")
    WebElement btnLogin;

    public void enterEmail(String emailId){
        txtEmail.sendKeys(emailId);
    }
    public void enterPassword(String password){
        txtPassword.sendKeys(password);
    }
    public void clickLogin(){
        btnLogin.click();
    }
}
