package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        //input olarak verilen
        /*
        satırNo, sutunNo parametrelerini parametre olarak alıp o cell deki datayı String olarak bana döndüren birmethod
        oluşturun
         */

        int satirNo=4;
        int sutunNo=4;
        //Dönen string'in Cezayir olduğunu test edin
        String expectedData = "Cezayir";

        String actualData= banaDataGetir(satirNo-1,sutunNo-1);  //cünkü excel endex ile çalışır
        Assert.assertEquals(expectedData,actualData);
    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData="";
        String dosyaYolu ="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData = workbook.getSheet("Sayfa1").getRow(satirIndex).getCell(sutunIndex).toString();



        return istenenData;


    }
}
