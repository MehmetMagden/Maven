package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        // bana içinde olduğumprojenin dosya yolunu verir

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.home"));
        //benim bilgisayarın bana özel kısmını verir

        //"C:\Users\Maden\Desktop\text.txt"
        String dosyaYolu =System.getProperty("user.home")+"\\Desktop";
        System.out.println("dosyaYolu = " + dosyaYolu);

        /*

        Bilgisayarımızdaki bir dosyanın varlığını test etmek için önce o dosyaya ulaşmamız
        gerekir. Java'da dosyaya erişim için dosya yoluna ihtiyaç vardır.
        Her bilgisayarın kullanıcı adı farklı olacağından masaüstü dosya yolu da birbirinden
        farklı olacaktır.
        Testlerimizin bütün bilgisayarlarda çalışması için dosya yolunu dinamik yapma zorundayız.

        Bunun için her bilgisayarın birbirinden farklı olan yolunu bulmak için
        String farkliKisim = System.getProperty("user.home");

        herkesin bilgisayarında ortak olan kisim ise
        String ortakKisim ="\\Desktop\text.txt";

        String dosyaYolu = farkliKisim + ortakKisim;


         */

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim ="\\Desktop\\text.txt";
        String MasaüstüDosyaYolu = farkliKisim + ortakKisim;

        System.out.println("Files.exists(Paths.get(MasaüstüDosyaYolu)) = " + Files.exists(Paths.get(MasaüstüDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(MasaüstüDosyaYolu)));
    }
}
