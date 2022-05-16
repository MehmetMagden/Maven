package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05DropDownOptions {
    /*
    amazon ana sayfaya gidip
    dropdown menuden books'u seçelim
    seçtiğimiz option'u yazdıralım

    dropdown'daki opsiyonların toplam sayısının
    23 olduğunu test edin
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");

        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");
        System.out.println("select.getOptions() = " + select.getFirstSelectedOption().getText());
        int actualListSize = select.getOptions().size();
        int beklenenSize = 28;
        Assert.assertTrue(actualListSize==beklenenSize);
    }
}
