package net.Vernard.JavaTest02;

import java.io.File;
import java.io.FileFilter;

public class FileFiltering {

    public static void main(String[] args) {

        // using an anonymous class
//        FileFilter filter01 = new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().endsWith(".js");
//            }
//        };

        // using Lambda expression || FileFilter is called a "Functional Interface"
        FileFilter filter01 = (File pathname) -> pathname.getName().endsWith(".js");

        File dir = new File("E:/Users/vmerc/Documents/repos/vernard.net/www/resume/vmercader_r");

        File[] files = dir.listFiles(filter01);

        for (File f : files) {
            System.out.println(f);
        }
    }
}
