package com.company;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.Deflater;

public class Nasedka implements Serializable {
    private static final int BUFFER =  2_048 ;
    public static String name;
    public static int jaiza;


    public Nasedka(String name) {
        this.name = name;
    }
    public void nesti(int n) {
        System.out.println("Птица  " + name + "  cнесла  " + n + "  яйца ");
    }
    public void ptenzi(int n) {
        System.out.println("Птица " + name + " высиживает  "+ n +"  птенцов ");
    }

    public int getJaiza() {
        return jaiza;
    }

    public void setJaiza(int jaiza) throws NasedkaLogicException {
        if (jaiza <= 0){
            throw new NasedkaLogicException();
        }
        this.jaiza = jaiza;
    }

    public static void setName(String name) {
        Nasedka.name = name;
    }

    public static String getName() {
        return name;
    }

    public void pack(String dirName) throws FileNotFoundException {
        // получение списка имен файлов в директории
        File dir = new File(dirName);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new FileNotFoundException(dir + " not found");
        }
        File[] files = dir.listFiles();
        ArrayList<String> listFilesToJar = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                listFilesToJar.add(files[i].getPath());
            }
        }
        String[] temp = {};
        String[] filesToJar = listFilesToJar.toArray(temp);




        // собственно архивирование
        try (FileOutputStream fos = new FileOutputStream(name);
             JarOutputStream jos = new JarOutputStream(fos)) {
            byte[] buffer = new byte[BUFFER];
            // метод сжатия
            jos.setLevel(Deflater.DEFAULT_COMPRESSION);
            for (int i = 0; i < filesToJar.length; i++) {
                jos.putNextEntry(new JarEntry(filesToJar[i]));
                try (FileInputStream in = new FileInputStream(filesToJar[i])) {
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        jos.write(buffer, 0, len);
                    }
                    jos.closeEntry();
                } catch (FileNotFoundException e) {
                    System.err.println("Файл не найден" + e);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e + "Некорректный аргумент" + e);
        } catch (IOException e) {
            System.err.println("Ошибка доступа" + e);
        }
    }
}
