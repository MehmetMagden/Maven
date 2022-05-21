package Practice;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import utilities.TestBase;

public class SunumPractice04 extends TestBase {

    @Test
    public void test01() {
        //1. Yeni bir Class olusturalim.C07_ManageWindowSet
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setSize(new Dimension(900,600));
        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        //8. Sayfayi kapatin

    }
}
