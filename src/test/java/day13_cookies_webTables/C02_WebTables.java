package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    @Test
    public void name() {


        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.

        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //            ○ Username : manager
        //            ○ Password : Manager1!
        girisYap();

        //● table( ) metodu oluşturun
        //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        List<WebElement> stunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("stunBasliklariListesi.size() = " + stunBasliklariListesi.size());

    /*
    Tüm bodyi string olarak yazdırmak isterseniz tBody elementini locate edip, getText()
    methodu ile yazdırabilirsiniz.
     */
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println("tumBody.getText() = " + tumBody.getText());
        //● printRows( ) metodu oluşturun //tr
        //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satirlarListesi.size() = " + satirlarListesi.size());

        //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w : satirlarListesi) {
            System.out.println("w = " + w);
        }
        //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement w : cellList) {
            System.out.println("w.getText() = " + w.getText());
            System.out.println();

        }

        //○ Email baslığındaki tüm elementleri yadırın
        //önce Email başlığının kaçıncı stunda olduğunu bulalım
        List<WebElement> basliklarList = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailStunNo = 0;
        for (int i = 0; i < basliklarList.size(); i++) {
            if (basliklarList.get(i).getText().equals("Email")) {
                emailStunNo = i;
            }
        }

        List<WebElement> emailStunList = driver.findElements(By.xpath("//tbody//td[" + (emailStunNo + 1) + "]"));
        for (WebElement m : emailStunList) {
            System.out.println("w.getText() = " + m.getText());
        }


    }


    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

    }
}
