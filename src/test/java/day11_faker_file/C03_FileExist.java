package day11_faker_file;

import org.junit.Test;

public class C03_FileExist {

    @Test
    public void test01() {
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.home"));
    }
}
