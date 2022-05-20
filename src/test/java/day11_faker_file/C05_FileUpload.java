package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2.https://the-internet.herokuapp.com/upload adresine gidelim


        driver.get("https://the-internet.herokuapp.com/upload");

        //3.chooseFile butonuna basalim
        WebElement dosyaSecButtonu = driver.findElement(By.id("file-upload"));
        //dosyaSecButtonu.click();
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\text.txt";
        String dosyaYolu = farkliKisim+ortakKisim;
        // send keys ile dosyamızı gönderelim
        Thread.sleep(1000);
        dosyaSecButtonu.sendKeys(dosyaYolu);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@class='button']")).click();


        //4.Yuklemek istediginiz dosyayi secelim.
        /*
        Bu işlemi selenium ile yapma şansımız yok çünkü web tabanlı bir uygulama değil
        bu durumda sendKeys() imdadımıza yetişir
        Eğer chooseFile buttonuna var olan bir dosyanın dosya yolunu yollarsanız
        Seçme işlemi otomatik olarak yapılmış olacaktır.
         */


        //5.Upload butonuna basalim.
        //6.“File Uploaded!” textinin goruntulendigini test edelim.

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());
    }
}
