package Practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class SunumPractice05 extends TestBase {

    @Test
    public void test01() {

        //1.Yeni bir class olusturalim (Homework)
        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        String expectedWord =  "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedWord));


        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.
        String expectedUrlWord="facebook";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlWord));

        //4.https://www.walmart.com/ sayfasina gidin.

        driver.navigate().to("https://www.walmart.com/");

        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedTitle= "Walmart.com";
        String actualTitle1 = driver.getTitle();

        Assert.assertFalse(expectedTitle.equals(actualTitle1));
        //6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //7. Sayfayi yenileyin
        driver.navigate().refresh();
        //8. Sayfayi tam sayfa (maxizze) yapin
        driver.manage().window().maximize();
        //9.Browser’i kapatin



    }
}
