package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //facebook görevini fake isimlerle yapalım
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Actions actions = new Actions(driver);

        Faker faker = new Faker();

        actions.click(driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"))).sendKeys(faker.name().firstName()+ Keys.TAB+faker.name().lastName()+Keys.TAB+faker.phoneNumber()+Keys.TAB+faker.internet().password()+Keys.TAB+Keys.TAB+19+
                Keys.TAB+Keys.ARROW_DOWN+Keys.TAB+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+
                Keys.TAB+Keys.TAB+Keys.TAB+Keys.SPACE+Keys.SPACE+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.SPACE).perform();




        Thread.sleep(2000000);


    }
}
