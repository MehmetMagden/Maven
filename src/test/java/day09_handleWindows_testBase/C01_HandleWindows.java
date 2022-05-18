package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
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
        //driver.quit();
    }
    @Test
    public void test01(){
        //1- amazon ana sayfaya gidin

        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        //2- nutella için arama yaptırın

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        /*
        CDwindow-47FA3C2C42350CF725C16788F3362490
        Bu kod açılan sayfanın unique hash kodudur.
        selenium sayfalar arası geçişte bu window handle değerini kullanır.

        eğer sayfalar arasında driver'ımızı gezdiriyorsak ve herhangi bir sayfadan şu anda bulunduğumuz
        sayfaya geçmek istiyorsak

        driver.switchTo().window("CDwindow-47FA3C2C42350CF725C16788F3362490");

        şeklinde yazarız ve geçiş sağlarız
         */

        //3- ilk ürünün resmini tıklayarak farklı bir tab olarak açın

        //WebElement ilkUrunResmi =driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));

        String url =driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        /*
            Bu komutu kullandığımızda driver otomatik olarak oluşturulan new tab'a geçer.
            yeni tab'da görevi gerçekleştirmek için adımları baştan almamız gerekir.
         */
        //driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        //4- yeni tabda açılan ürünün fiyatını yazdırın
        WebElement urunTitleElement = driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']"));
        System.out.println("urunTitleElement.getText() = " + urunTitleElement.getText());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
    }

}
