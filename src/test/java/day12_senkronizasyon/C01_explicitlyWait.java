package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_explicitlyWait extends TestBase {


    @Test
    public void test01() {

        //1. Bir class olusturun : WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //     Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneTextElement = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneTextElement.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBack = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBack.isDisplayed());
    }

    @Test
    public void test02() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //wait.until(ExpectedConditions.visibilityOf())
           /*
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


                yazının görünür olmasını beklerken yazının locate'ini kullanarak sorun oluşturur
                cünkü henüz görünmeyen bir yazını nlocateedilemesi de mumkun olmayabilir
                (html kodları yazan developer farklı uygulamalar yapabilir
                Bu durumda bekleme ismeli ve locate beraber yapılmalı
            */

        WebElement itsGoneYaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));

       // WebElement itsBack = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
       // Assert.assertTrue(itsBack.isDisplayed());


    }
}
