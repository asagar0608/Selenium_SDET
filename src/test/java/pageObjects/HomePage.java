package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.Basepage;

public class HomePage extends Basepage {


    public HomePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath="//span[contains(text(), 'My Account')]")
    WebElement lnkMyAccount;
    @FindBy(xpath ="//a[contains(text(), 'Register')]")
    WebElement lnkRegister;
    @FindBy(xpath="//a[normalize-space()='Login']")
    WebElement linkLogin;

    public void clickMyAccount()
    {
        lnkMyAccount.click();
    }
    public void clickRegister(){
        lnkRegister.click();
    }
    public void clickLogin(){
        linkLogin.click();
    }
}
