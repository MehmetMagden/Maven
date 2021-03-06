package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {

    @Test
    public void webElementSS() throws IOException {

        //amazon'a gidip Nutella aratalım ve sonuç sayısının olduğu webelementin fotografını ss
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonuycYaziElementi =driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        File sonucYaziElementSS= new File("target/ekranGoruntuleri/conucYazisiSS.jpeg");
        File Temp = sonuycYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(Temp,sonucYaziElementSS);

    }
}
