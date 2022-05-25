package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class SunumPractice10 extends TestBase {
    @Test
    public void test01() {

        //1) css = tagName[attribute name= 'value’ ];
        //driver.findElement(By.cssSelector("input[name='session[password]']"));
        //2 ) css="tagName#idValue" veya sadece css="#idValue" =>yalnızca id value ile çalışır
        //driver.findElement(By.cssSelector("input#session_password"));
        //3 ) css="tagName.classValue" veya sadece css=".classValue"=>yalnızca class value ile çalışır
        //driver.findElement(By.cssSelector(".form-control"));


        //1 ) Bir class oluşturun : Locators_css
        //2 ) Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
        //b. Locate email textbox
        WebElement emailBox = driver.findElement(By.cssSelector("input[type='email']"));
        //c. Locate password textbox ve
        WebElement passwordBox = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        //d. Locate signin button
        WebElement signInButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        //e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        //i. Username : testtechproed@gmail.com
        emailBox.sendKeys("testtechproed@gmail.com");
        //ii. Password : Test1234!
        passwordBox.sendKeys("Test1234!");
        signInButton.click();

        //NOT: cssSelector kullanarak elementleri locate ediniz.
    }
}