package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {


/*
Bir Class olusturalim YanlisEmailTesti
http://automationpractice.com/index.php sayfasina gidelim
Sign in butonuna basalim
Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
 */





    static WebDriver driver;

    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.automationpractice.com/index.php");
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());
    }

    @After
    public  void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){

        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account']")).click();
        WebElement mailKutusu = driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("mehmetgmail.com"+ Keys.ENTER);


    }
}
