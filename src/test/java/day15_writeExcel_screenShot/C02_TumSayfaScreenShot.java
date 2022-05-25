package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_TumSayfaScreenShot extends TestBase {

    @Test
    public void screenShotTesti() throws IOException {

        //amazon sayfasına gidip tüm sayfanın fotoğrafını çekelim
        driver.get("https://www.amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;

        File tumSayfaResim = new File("target/ekranGoruntuleri/tumSayfa.jpeg");
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,tumSayfaResim);
    }
}
