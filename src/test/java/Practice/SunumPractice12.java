package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SunumPractice12 extends TestBase {
    @Test
    public void test01() {

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        //2 ) Berlin’i 3 farkli relative locator ile locate edin
        WebElement nyc = driver.findElement(By.id("pid3_thumb"));
        WebElement boston = driver.findElement(By.id("pid6_thumb"));
        WebElement berlin =driver.findElement(with(By.tagName("li")).below(nyc).toRightOf(boston));


        WebElement byArea = driver.findElement(By.id("pid6_thumb"));
        WebElement sailor = driver.findElement(By.id("pid11_thumb"));
        WebElement berlin2 = driver.findElement(with(By.tagName("li")).toLeftOf(byArea).above(sailor));

        WebElement berlin3 = driver.findElement(with(By.tagName("li")).toRightOf(boston).above(sailor));
        //3 ) Relative locator’larin dogru calistigini test edin
        Assert.assertTrue(berlin.isDisplayed());
        Assert.assertTrue(berlin2.isDisplayed());
        Assert.assertTrue(berlin3.isDisplayed());


    }
}
