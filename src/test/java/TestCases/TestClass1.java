package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestClass1 {
    WebDriver driver;

    @BeforeTest
    public void LaunchApp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://testauto8-dev-ed.develop.my.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void LoginToApplication()  {
        driver.findElement(By.id("username")).sendKeys("testing@zensar.com.testauto");
        driver.findElement(By.id("password")).sendKeys("Automation1"+ Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void VerifyPageTitle(){
        String expectedTitle="Home | Salesforce";
        String actualTitle=  driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
