import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.JUnitSystem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyJunit {
    WebDriver driver;


    @Before
    public void setup(){

        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops=new FirefoxOptions();
        ops.addArguments("--headed");
        driver=new FirefoxDriver(ops);
        driver.manage().window().maximize();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void getTitle(){
        driver.get("https://demoqa.com");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("ToolsQA"));
    }
    @After
    public void finishTest(){
       // driver.close();
    }
@Test
    public void checkifElementExists(){
        driver.get("https://demoqa.com");
      Boolean status=driver.findElement(By.className("banner-image")).isDisplayed();
      Assert.assertTrue (status);
    //wait= new WebDriverWait(driver, Duration.ofSeconds(40));
    //Boolean status = wait.until(ExpectedConditions.elementToBeClickable(By.className("banner-image"))) .isDisplay();
    //Assert.assertTrue(status);



    }
    @Test
    public void fillupForm(){
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Md.Nerob");
        driver.findElement(By.id("userEmail")).sendKeys("imamnerob@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("House-21, Road-31, Sector-07, Uttara-1230.");
        driver.findElement(By.id("submit")).click();

    }

}
