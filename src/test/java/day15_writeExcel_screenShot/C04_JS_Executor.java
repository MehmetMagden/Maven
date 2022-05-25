package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {


    @Test
    public void HSExecutorTest() throws InterruptedException {

        //amazon'a gidelim

        driver.get("https://www.amazon.com");
        //asağıdaki signIn buttonu görününceye kadar JS ile scrool yapalım

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //signIn buttonuna JS ile tıklayalım


        WebElement signInButton = driver.findElement(By.xpath("(//span[text()='Sign in'])[2]")); // //span[@class='action-inner'] nedense bu xpath çalışmadı
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButton);

        jse.executeScript("arguments[0].click();",signInButton);
        Thread.sleep(2000);

    }
}
