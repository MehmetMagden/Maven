package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {
        String dosyaYolu ="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);



        int sonSatirIndex = workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println("sonSatirIndex = " + sonSatirIndex);
        int expectedSatirSayisi = 25;
        Assert.assertEquals(expectedSatirSayisi,sonSatirIndex);

        int kullanilanSatirSayisi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expcetdedUsedLines =5;
        System.out.println("kullanilanSatirSayisi = " + kullanilanSatirSayisi);

        Assert.assertEquals(expcetdedUsedLines,kullanilanSatirSayisi);
    }
}
