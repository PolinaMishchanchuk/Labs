package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 11. Найти, каких букв, гласных или согласных, больше в каждом
предложении текста.  */

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("Example.txt");

        // Создание файла
        file.createNewFile();

        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file);

        // Запись содержимого в файл
        writer.write("Just a simple example to show that program works correctly");
        writer.flush();
        writer.close();

        // Создание объекта FileReader
        FileReader fr = new FileReader(file);
        char [] a = new char[200];   // Количество символов, которое будем считывать
        fr.read(a);   // Чтение содержимого в массив

        Pattern p1 = Pattern.compile("[aeyuioAEYUIO]");
        Pattern p2 = Pattern.compile("[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]");

        int i = 0;
        int j = 0;

        for(char c : a) {
            String charToString = Character.toString(c);  // преобразую char в string
            Matcher m1 = p1.matcher(charToString );
            Matcher m2 = p2.matcher(charToString );
            if(m1.matches()){i++;}
            else {if (m2.matches()){j++;}}
        }

            System.out.println(i+" "+ j);
        if(i>j){
            System.out.println("Гласных больше!");
        }
        else System.out.println("Больше согласных!");
        fr.close();

    }
}
