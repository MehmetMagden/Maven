package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {

//        1- Yeni bir class olusturalim: MouseActions1
//        2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
//        3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement cizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        Thread.sleep(2000);
        actions.contextClick(cizgiliAlanElementi).perform();
        Thread.sleep(2000);

//        4- Alert’te cikan yazinin “You selected a context menu” oldugunu
//        test edelim.
        String expectedString ="You selected a context menu";
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedString,actualText);
//        5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
//        6- Elemental Selenium linkine tiklayalim
        String ilkSayfamHandleDegeri = driver.getWindowHandle();
                driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSeti = driver.getWindowHandles();
        String ikinciSayfaHandleDegeri ="";
        for (String w : handleSeti){
            if(!w.equals(ilkSayfamHandleDegeri)){
                ikinciSayfaHandleDegeri=w;
            }
        }

//        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        WebElement yaziElementi = driver.findElement(By.tagName("h1"));

        String expectedString2 = "Elemental Selenium";
        String actualString2=yaziElementi.getText();
        Assert.assertEquals(expectedString2,actualString2);

    }
}
