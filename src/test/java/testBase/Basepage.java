package testBase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class Basepage {
public Properties conpro;
    public static WebDriver driver;
    public Basepage()  {
    }
    public Basepage(WebDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @BeforeMethod(groups = {"Sanity","Regression","Master"})
    @Parameters({"browser"})
    public void setup(String br) throws IOException {
        FileInputStream file = new FileInputStream(".//src//test//resources//config.properties");
        conpro = new Properties();
        conpro.load(file);
        switch (br.toLowerCase(Locale.ROOT)){
    case "chrome": driver = new ChromeDriver(); break;
    case "edge": driver = new EdgeDriver(); break;
    case "firefox": driver = new FirefoxDriver(); break;
    default:System.out.println("invalid Broswer"); return;
}
        driver.manage().deleteAllCookies();
        driver.get(conpro.getProperty("appUrl"));
        driver.manage().window().maximize();
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'My Account')]")));
    }


    @AfterMethod(groups = {"Sanity","Regression","Master"})
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    public String captureScreen(String tName) throws IOException{

      String timeStamp =new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
File sourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);
String targetFilePath = System.getProperty("user.dir") +"\\screenshots\\" + tName  +"_" +timeStamp;
File targetPath = new File(targetFilePath);
sourceFile.renameTo(targetPath);
return targetFilePath;


        }


    public void waitExplicit(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
    }

}
