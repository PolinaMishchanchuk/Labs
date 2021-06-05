package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineSort {
    public void Sort(File file) throws IOException {
        FileReader fr = new FileReader(file);
        char [] a = new char[200];   // Количество символов, которое будем считывать
        fr.read(a);
        int i = 0;
        String[] str = new String[6];
        for (char c : a){
            if(c!= '.'){
                String charToString = Character.toString(c);
                str[i] = str[i] + charToString;
            }
            String charToString = Character.toString(c);
            str[i] = str[i] + charToString;
            System.out.println(str[i]);
            i++;
        }


    }
}
