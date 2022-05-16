package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {

    /*
    amazona gidip
    dropdown'dan books seçeneğini seçip
    Java aratalım
    ve arama sonuçlarının java içerdiğini test edelim

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
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

        //dropdown'dan bir option seçmek için 3 adım vardır
        //1- dropdown'u locate edelim
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));


        //2- bir select objesi oluşturup parametre olarak önceki adımda oluşturduğumuz elementi girelim
        Select select = new Select(dropdown);

        //3- var olan optionlardan istediğimiz bir tane yi seçelim

        select.selectByVisibleText("Books");
        //select.selectByIndex();
        //select.selectByValue();

        //arama kutusuna Java yazdıralım

        WebElement aramaKutusu =driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement sonucYaizisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisi = sonucYaizisi.getText();
        String arananKelime ="Java";

        Assert.assertTrue(sonucYazisi.contains(arananKelime));

    }
}
