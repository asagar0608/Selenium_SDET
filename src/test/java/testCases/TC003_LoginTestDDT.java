package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.Basepage;
import utilities.DataProviders;

public class TC003_LoginTestDDT extends Basepage {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"DataDriven","Master"})
    public void loginTest(String email, String password, String exp)
            throws InterruptedException {
        try {

            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();
            Thread.sleep(3000);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLogin();
            AccountPage accountPage = new AccountPage(driver);
            Boolean res = accountPage.myAccountExist();

            if (exp.equalsIgnoreCase("valid")) {
                if (res == true) {
                    accountPage.logout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("invalid")) {
                if (res == true) {
                    accountPage.logout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (Exception e){

        }

    }
}
