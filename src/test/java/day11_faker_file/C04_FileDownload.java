package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    //    //1. Tests packagenin altina bir class oluşturalim
    //    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //    //3. dummy.txt dosyasını indirelim
    //    //4. dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void test01() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='dummy.txt']")).click();
        Thread.sleep(5000);
        //dosya downloads'a indirilecektir. bizde downloads'ın dosya yolu gerekiyo
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim ="\\Downloads\\dummy.txt";
        String arananDosyaYolu = farkliKisim+ ortakKisim;

        //geriye o dosya yolundaki dosyanın var olduğunu Assert edelim

        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));

    }
}
