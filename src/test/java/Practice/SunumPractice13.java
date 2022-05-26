package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class SunumPractice13 extends TestBase {

    @Test
    public void test01() {

        //1- https://www.amazon.com/ sayfasina gidelim

        driver.get("https://www.amazon.com");
        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
        String sonucSayisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println("sonucSayisi = " + sonucSayisi);
        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();
        //6- Sayfadaki tum basliklari yazdiralim
        List<WebElement> list = driver.findElements(By.xpath("//h1"));
        System.out.println("list = " + list);

    }
}
