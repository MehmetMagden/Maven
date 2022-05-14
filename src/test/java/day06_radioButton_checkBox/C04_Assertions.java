package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
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
        driver.close();

    }

    @Test
    public void test01(){
        /*
        Eğer test metodumuzda hiçbir test yoksa, test çalıştıktan sonra hiç bir problemle
        karşılaşılmadığını raporlamak için Test passed yazısı çıkar

        eğer testleri if yaparsak
        test failed olsa bile kodlar problemsiz çalışacağı için
        kod çalıması bittiğinde e
        ekranın sol alt kısmında test passed yazacaktır.
         */
        driver.get("https://www.amazon.com");

        //url'in https://www.facebook.com olduğunu test edin

//        if(driver.getCurrentUrl().equals("https://www.facebook.com")){
//            System.out.println("Url Test PASSED");
//        }else System.out.println("URL Test FAILED");

        String expectedUrl="https://www.facebook.com";
        String actualUrl =driver.getCurrentUrl();
        Assert.assertEquals("bbbbbbbb",expectedUrl, actualUrl);

        /*
        assert ile yaptığımız testlerde assertion failed olursa java
        kodların çalışmasını durdurur ve assert class'ı bizi hata konusunda bilgilendirir

            org.junit.ComparisonFailure: bbbbbbbb
            Expected :https://www.facebook.com
            Actual   :https://www.amazon.com/
            <Click to see difference>

            böylece hatanın ne olduğunu araştırmadan JUnit bize raporlamış olur
         */

    }
}
