package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.Basepage;

public class TC002_LoginTest extends Basepage {

    @Test(dataProvider = "loginData", groups = {"Sanity", "Master"})
    public void loginTest(String email, String password)
            throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickLogin();
        Thread.sleep(3000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String actualtitle =driver.getTitle();
        System.out.println(actualtitle);
        String expectedTitle = "My Account";
        Assert.assertEquals(actualtitle, expectedTitle);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"chakradharsagar@gmail.com", "Ishaan@1234ex"}
        };
    }
}
