package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.Basepage;

public class RegistrationPage extends Basepage {

    public RegistrationPage (WebDriver driver){
        super(driver);
    }
    @FindBy(xpath ="//input[@id='input-firstname']")
    WebElement txtFirstname;
    @FindBy(xpath ="//input[@id='input-lastname']")
    WebElement txtLastname;
    @FindBy(xpath ="//input[@id='input-email']")
    WebElement txtemail;
    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txtPhoneNumber;
    @FindBy(xpath ="//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement txtcfmPassword;
    @FindBy(xpath="//input[@name='agree']")
    WebElement chkBoxAgree;
    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement confirmationMsg;

    public void enterFirstName(String fName){
        txtFirstname.sendKeys(fName);
    }
    public void enterLastName(String lName){
     txtLastname.sendKeys(lName);
    }
  public void enterEmail(String email){
        txtemail.sendKeys(email);
  }
  public void enterPhnNumber(String phnNum){
        txtPhoneNumber.sendKeys(phnNum);
  }
  public void enterPassword(String pwd){
        txtPassword.sendKeys(pwd);
  }
  public void reEnterPassword(String pwd){
        txtcfmPassword.sendKeys(pwd);
  }
  public void agreeBtn(){
        chkBoxAgree.click();
  }
  public void clickContinue(){
        btnContinue.click();
  }
  public String getConfirmationmessage(){
        try {
            return (confirmationMsg.getText());
        }
        catch (Exception e){
           return( e.getMessage());
        }

        }

}
