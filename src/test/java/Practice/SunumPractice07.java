package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class SunumPractice07 extends TestBase {
    @Test
    public void test01() {

        //1. Bir class oluşturun: LoginTest
        //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //a. http://a.testaddressbook.com adresine gidiniz.

        driver.get("http://a.testaddressbook.com");
        //b. Sign in butonuna basin
        WebElement signInButton =driver.findElement(By.id("sign-in"));
        signInButton.click();
        //c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextBox = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@data-test='password']"));
        WebElement signInButton2 = driver.findElement(By.xpath("//input[@type='submit']"));

        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButton2.click();
        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        String expectedUser ="testtechproed@gmail.com";
        String actualUserText =driver.findElement(By.xpath("//span[@class='navbar-text']")).getText();

        Assert.assertEquals(expectedUser,actualUserText);

        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        Assert.assertTrue(driver.findElement(By.xpath("//a[@data-test='addresses']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@data-test='sign-out']")).isDisplayed());


        //3. Sayfada kac tane link oldugunu bulun.
        System.out.println("driver.findElements(By.tagName(\"a\")).size() = " + driver.findElements(By.tagName("a")).size());
    }
}
