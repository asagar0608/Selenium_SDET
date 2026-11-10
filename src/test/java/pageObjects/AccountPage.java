package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.Basepage;

public class AccountPage extends Basepage {

    public AccountPage(WebDriver driver) {
        super(driver);

    }
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccount;
    @FindBy(xpath ="//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logoutLink;

    public boolean myAccountExist() {
        try {
            return (myAccount.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }
    public void logout()
    {
        logoutLink.click();
    }
}


