package day08_Allerts_iframe;

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

public class C04_IFrame {

    //
    // ● Bir class olusturun: IframeTest
    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //   ● Bir metod olusturun: iframeTest
    //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
    //        ○ Text Box’a “Merhaba Dunya!” yazin.
    //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.
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
    public void IframeTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslikElementi =driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println("baslikElementi.getText() = " + baslikElementi.getText());


        /*
        Xpath'ı doğru şekilde yazmış olmamıza rağmen locate edemedik. Kodları inceleyince aradığımız text box'un iframe
        içinde olduğunu gördük. Bu durumda önce iframe'mi locate edip switchTo ile o iframe'e geçmeliyiz
         */
        WebElement iFrameElementi =driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(100); //bunu koymazsam textKutusu.clear() çalışmıyor. Nedenini çözemedim.
        textKutusu.clear();

        textKutusu.sendKeys("Merhaba Dunya");

        driver.switchTo().parentFrame();    //Bir frame yukarı çıkar
       // driver.switchTo().defaultContent();       //En üst frame'ye çıkar

        WebElement linkYaziElementi=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());

        Thread.sleep(1000); //bunu koymazsam text

    }
}
