package day08_Allerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
       // driver.close();
    }

    @Test
    public void test01(){
        /*
        // Herhangi bir web sitesine gidince veya bir websitesinde herhangi birişlem yaptığımızda ortaya çıkan
        // uyarılara alert denir
                Eğer bir alert inspect yapılabiliyorsa o alert otomasyon ile kullanılabilir.
                bu tür alertlere HTML alert denir ve bunlar için ekstra işlem yapmaya gerek yoktur.
                tüm webelement'ler gibi locate edip istediğimiz işlemleri yapabiliriz
                driver.get("https://www.facebook.com"); vb. alertler

                Ancak web uygulamalarında HTML alert yanında java script alert de bulunabilir ve
                js alert'ler locate edilemez

                Selenium'da JS alertler için çok güzel bir yöntem geliştirilmiştir
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        // alert'te okay tuşuna basın ve result kısmında "you succesfully clicked an alert" yazdığını test edelim

        String expectedString ="You successfully clicked an alert";
        String actualString= driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualString.equals(expectedString)); //İkiside yazılabilir
        Assert.assertEquals(actualString,expectedString);       //İkiside yazılabilir

    }


}
