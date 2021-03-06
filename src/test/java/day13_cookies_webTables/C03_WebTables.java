package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void dinamikYazici() {
        //Öncekiclass'daki adrese gidip
        //giriş yap methodunu kullanarak sayfaya giriş yapın
//        input olarak verilen satir sayisi ve stun sayisina sahip
//        celldeki text'i yazdıran bir method yazdırın

        int satir = 3;
        int sutun =5;

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();


        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr["+(satir)+"]//td["+(sutun)+"]"));
        System.out.println("arananCell.getText() = " + arananCell.getText());
    }
}
