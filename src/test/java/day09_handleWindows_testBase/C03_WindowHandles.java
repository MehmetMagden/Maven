package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandles {

    /*
//    ● Tests package’inda yeni bir class olusturun: WindowHandle2
//● https://the-internet.herokuapp.com/windows adresine gidin.
//● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//● Click Here butonuna basın.
//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
//● Sayfadaki textin “New Window” olduğunu doğrulayın.
//● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */
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
        driver.quit();
    }
    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedYazi = "Opening a new window";
        String actualString = sayfadakiYaziElementi.getText();
        Assert.assertTrue(actualString.equals(expectedYazi));

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle ="The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        /*
            Eğer kontrolsüz açılan bir tab veya window varsa, o zaman sayfaların windowHandle değerlerini
            elde etmem gerekir.

            Öncelikle ikinci sayfa açılmadan önce ilk sayfanın windowHandle Değerini bir string'e
            atayalım.
         */
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();







        //● Click Here butonuna basın.

        driver.findElement(By.linkText("Click Here")).click();
        /*
            Switchto().newWindow() demeden link tıklayarak yeni tab veya window oluştuğunda, biz
            yeni sayfaya geç demedikçe, driver eski sayfada klaır ve yeni sayfa ile ilgili
            hiçbir işlem yapamaz
            yeni sayfada driver'i çalıştırmak isterseniz önce driver'i yeni sayfaya
            göndermelinisiniz
         */
        /*
            Yeni sayfaya geçebilmek için öncelikle ikinci windowHandleDegeri'ni bulmamız gerekiyor.
            Bunun için driver.getWindowHandles() method'unu kullanarak açık olan bütün sayfaların
            değerlerini alıp bir set'e assign ederiz

            İlk sayfanın windowHandle değerini zaten biliyoruz. Set'deki window handle değerlerini
            kontrol edip ilk sayfanın handle değerine eşit olmayan değere ikinci sayfanın window handle değeri deriz
         */

        Set<String> windowHandleSeti=  driver.getWindowHandles();
        System.out.println("windowHandleSeti = " + windowHandleSeti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String w : windowHandleSeti){
            if(!w.equals(ilkSayfaWindowHandleDegeri)){
                 ikinciSayfaWindowHandleDegeri=w;
            }
        }
        /*
            Artık ikinci sayfanın window handle değerini biliyoruz. Rahatlıkla sayfalar arası geçiş yapabiliriz.
         */
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedTitle2 ="New Window";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2,actualTitle2);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikincisayfayaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedIkinciYazi ="New Window";
        String actualIkinciYazi = ikincisayfayaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);


//● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        String actualTitle3 =  driver.getTitle();
        String expectedTitle3 = "The Internet";
        Assert.assertEquals(expectedTitle3,actualTitle3);

    }
}
