package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C06_KeyboardActions extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        //facebook ana sayfaya gidip yeni kayıt oluştur button'una basalım
        //isim kutusunu locate edip, geriye kalan alanları TAB ile dolaşarak formu doldurn

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"))).sendKeys("Mehmet"+ Keys.TAB+"Magden"+Keys.TAB+0654654+Keys.TAB+Keys.TAB+"asdfsdaf456"+Keys.TAB+19+
                Keys.TAB+Keys.ARROW_DOWN+Keys.TAB+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+
                Keys.TAB+Keys.SPACE+Keys.SPACE+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.SPACE).perform();




        Thread.sleep(2000000);

    }
}
