package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class SunumPractice11 extends TestBase {


    //1) css = tagName[attribute name= 'value’ ];
    //driver.findElement(By.cssSelector("input[name='session[password]']"));
    //2 ) css="tagName#idValue" veya sadece css="#idValue" =>yalnızca id value ile çalışır
    //driver.findElement(By.cssSelector("input#session_password"));
    //3 ) css="tagName.classValue" veya sadece css=".classValue"=>yalnızca class value ile çalışır
    //driver.findElement(By.cssSelector(".form-control"));

    @Test
    public void test01() throws InterruptedException {

        //1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();
        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
        driver.manage().window().maximize();
        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedTitlePiece = "Spend less";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitlePiece));
        //6- Gift Cards sekmesine basin
        driver.findElement(By.cssSelector("a[data-csa-c-slot-id='nav_cs_3'")).click();
        //7- Birthday butonuna basin
        driver.findElement(By.cssSelector("img[alt='Birthday gift cards'")).click();
        //8- Best Seller bolumunden ilk urunu tiklayin
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='Amazon.com eGift Card']")).click();
        //9- Gift card details’den 25 $’i secin
        driver.findElement(By.cssSelector("#a-autoid-28")).click();
        //10-Urun ucretinin 25$ oldugunu test edin
        String expectedAmount ="$25.00";
        String actualAomunt = driver.findElement(By.cssSelector("span[class='a-color-price a-text-bold']")).getText();
        Assert.assertEquals(expectedAmount,actualAomunt);
        //10-Sayfayi kapatin


    }
}
