package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
 @Test
    public void test01() throws InterruptedException {
     //amazon anasayfa'ya git
     //account menusünden create a list linkine tıklayalım
    driver.get("https://www.amazon.com");
     Actions actions = new Actions(driver);
     WebElement accountLink = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
     actions.moveToElement(accountLink).perform();

     driver.findElement(By.xpath("//*[text()='Create a List']")).click();
     Thread.sleep(2000);


 }

}
