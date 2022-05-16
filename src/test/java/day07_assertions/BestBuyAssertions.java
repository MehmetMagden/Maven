package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BestBuyAssertions {
    /*1) Bir class oluşturun: BestBuyAssertions
2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        ○ logoTest => BestBuy logosunun görüntülendigini test edin
        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

     */

    static WebDriver driver;

    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @After
    public  void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){

        String actualUrl= driver.getCurrentUrl();
        String beklenenUrl = "https://www.bestbuy.com/";
        Assert.assertEquals(actualUrl,beklenenUrl);

    }
    @Test
    public void test02(){
        String arananKlm="Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(arananKlm));


    }

    @Test
    public void test03(){

        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='https://www.bestbuy.com/~assets/bby/_com/header-footer/images/bby_logo-a7e90594729ed2e119331378def6c97e.png'][1]")).isDisplayed());
    }

    @Test
    public void test04(){
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Français']")).isDisplayed());
    }
}
