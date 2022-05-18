package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {

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
        //1- amazon ana sayfaya gidin

        driver.get("https://www.amazon.com");

        //2- Url'in amazon içerdiğini test edelim
        String birinciSayfaHandle = driver.getWindowHandle();
        String currentUrl = driver.getCurrentUrl();
        String istenenKelime = "amazon";
        Assert.assertTrue(currentUrl.contains(istenenKelime));
        //3- yeni bir pencere açıp bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        String ikinciSayfaHandle = driver.getWindowHandle();
        driver.get("https://www.bestbuy.com");


        //4- title'ın  BestBuy içerdiğini kontrol edelim
        String currentUrlBestbuy = driver.getTitle();
        String istenenKelimeBestBuy = "Best Buy";
        Assert.assertTrue(currentUrlBestbuy.contains(istenenKelimeBestBuy));

        //5- ilk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(birinciSayfaHandle);
        WebElement aramakutur = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutur.sendKeys("Java"+ Keys.ENTER);
        //6- arama sonuçlarının Java içerdiğini test edelim
        WebElement aramaSonuc = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actuelString= aramaSonuc.getText();
        String arananKelime = "Java";
        Assert.assertTrue(actuelString.contains(arananKelime));


        //7- yeniden bestbuy'in açık olduğu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaHandle);


        //8- logonun göründüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());

    }
}
