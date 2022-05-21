package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

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
}
