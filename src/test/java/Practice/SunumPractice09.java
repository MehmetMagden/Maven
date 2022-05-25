package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class SunumPractice09 extends TestBase {

    @Test
    public void test01() {

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        //3- Delete butonu’nun gorunur oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).isDisplayed());
        //4- Delete tusuna basin
        driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']")).isDisplayed());


    }
}
