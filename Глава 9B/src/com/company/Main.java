package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 11. В каждом предложении текста исключить подстроку максимальной длины,
начинающуюся и заканчивающуюся заданными символами.  */

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("Example.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("   А этот пример покажет\t нам.  111 11     о т 11 о таов. Как\t можно вывести подстроку.");
        writer.flush();
        writer.close();


        // Создание объекта FileReader
        FileReader fr = new FileReader(file);
        char [] a = new char[200];   // Количество символов, которое будем считывать
        fr.read(a);                  // Чтение содержимого в массив


        String s = "Преобразованная: ";
        for (char b : a){
            if (b!='\t'){
                String charToString = Character.toString(b);
               s = s.concat(charToString);}
        }
        while(s.contains("  ")){
            s = s.replace("  ", " ");
        }
        System.out.println(s);


        char s1 = 'а';
        char s2 = 'а';

        String temp1 = new String();
        String temp2 = new String();
        boolean temp_indikator = false;

        for(char c: a){
            if(c==s1){ temp_indikator=true;}

            if(temp_indikator == true){String charToString = Character.toString(c); temp1 = temp1 + charToString;
            if(c==s2){temp2 = temp1;}
            if(c=='.'){if(temp2.length()!=0){System.out.println(temp2);} temp1=""; temp2=""; temp_indikator = false; }
            }
        }


    }
}
