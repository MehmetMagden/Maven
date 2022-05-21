package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class SunumPractice08 extends TestBase {

    @Test
    public void test01() {
        //1. Bir class oluşturun : AmazonSearchTest
        //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //a.web sayfasına gidin. https://www.amazon.com/

        driver.get("https://www.amazon.com/");
        //b. Search(ara) “city bike”

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("city bike"+ Keys.ENTER);
        //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> list1= driver.findElements(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']"));
        System.out.println("list.size() = " + list1.size());
        //d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        WebElement firstPicture = list1.get(0);
        firstPicture.click();

    }
}
