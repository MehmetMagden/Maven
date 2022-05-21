package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class SunumPractice01 extends TestBase {
    @Test
    public void name() {


    //1. Yeni bir package olusturalim : day01
    //2. Yeni bir class olusturalim : C03_GetMethods
    //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https:/www.amazon.com");


    //4. Sayfa basligini(title) yazdirin
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    //6. Sayfa adresini(url) yazdirin
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        //7. Sayfa url’inin “amazon” icerdigini test edin.
        String expectedWord = "amazon";
        String actualURL = driver.getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedWord));


    //8. Sayfa handle degerini yazdirin
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        //9. Sayfa HTML kodlarinda “shopping” kelimesi gectigini test edin // div[contains(., 'My Button')]
        String sourceCode =driver.getPageSource();
        Assert.assertTrue(sourceCode.contains("shopping"));
    //10. Sayfayi kapatin.
        //ototmatik
    }

}
