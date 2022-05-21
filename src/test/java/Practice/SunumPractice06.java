package Practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class SunumPractice06 extends TestBase {

    @Test
    public void test01() {
        //1. Yeni bir class olusturun (TekrarTesti)
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        driver.get("https://youtube.com");
        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        System.out.println("driver.getTitle() youtube? = " + driver.getTitle()); //YouTube olması gerekiyor
        Assert.assertFalse(actualTitle.equals(expectedTitle));



        //(verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
        //URL'yi yazdırın.
        String expectedUrlWord="youtube";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("driver.getCurrentUrl() youtube? = " + driver.getCurrentUrl());
        Assert.assertTrue(actualUrl.contains(expectedUrlWord));


        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/

        driver.navigate().to("https://www.amazon.com");
        //5. Youtube sayfasina geri donun
        driver.navigate().back();
        //6. Sayfayi yenileyin
        driver.navigate().refresh();
        //7. Amazon sayfasina donun
        driver.navigate().forward();
        //8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa
        String expectedTitle1 = "Amazon";
        String actualTitle1 =driver.getTitle();
        Assert.assertTrue(actualTitle1.contains(expectedTitle1));

        //doğru başlığı(Actual Title) yazdırın.
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
        String expectedUrl1 ="https://www.amazon.com/";
        String actualUrl1 = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl1,actualUrl1);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        //11.Sayfayi kapatin

    }
}
