package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.Basepage;
import utilities.RandomString;

public class TC001_UserRegistrationTest extends Basepage {

    @Test(groups = {"Regression", "Master"})
    public void Registration() throws InterruptedException {

        HomePage homePage= new HomePage(driver);
        homePage.clickMyAccount(); //Click on My account link
        homePage.clickRegister();
        Thread.sleep(2000);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RandomString rs = new RandomString();
        registrationPage.enterFirstName(rs.randomstring());
        registrationPage.enterLastName(rs.randomstring());
        registrationPage.enterEmail(rs.randomstring()+"@gmail.com");
        registrationPage.enterPhnNumber("9325847584");
        registrationPage.enterPassword("Ishaan@1234");
        registrationPage.reEnterPassword("Ishaan@1234");
        registrationPage.agreeBtn();
        registrationPage.clickContinue();
        Thread.sleep(3000);
       String successMsg= registrationPage.getConfirmationmessage();
        Assert.assertEquals(successMsg, "Your Account Has Been Created!");

    }

}
