package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;

/*11. Пусть текст содержит миллион символов и необходимо сформировать
из них строку путем конкатенации. Определить время работы кода.
Ускорить процесс, используя класс StringBuilder. */

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("Example.txt");

        // Создание файла
        file.createNewFile();

        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file);

        // Запись содержимого в файл
        writer.write("Конкатенация - это синоним слова \"объединение\". Истоки слова \"конкатенация\" от латыни: \"сon-\" означает \"вместе\", \"catena\" в переводе с латыни это \"цепь\". По-русски будет «сцеплять».\n" +
                "\n" +
                "2. Где же используется конкатенация в Java?\n" +
                "Ответ: при работе со строками. Конкатенация строк в Java означает, в целом, слияние, \"склеивание\" двух строк в одну. Давайте рассмотрим на примере.\n" +
                "\n" +
                "Пример №1\n" +
                "public class Test {\n" +
                "\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tString morning1 =\"доброе\";\n" +
                "\t\tString morning2 =\"не доброе, потому что сегодня понедельник\";\n" +
                "\n" +
                "\t\tSystem.out.println(\"Сегодня утро \" + morning1);\n" +
                "\t\tSystem.out.println(\"Сегодня утро \" + morning2);\n" +
                "\t}\n" +
                "}\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "public class Test {\n" +
                " \n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tString morning1 =\"доброе\";\n" +
                "\t\tString morning2 =\"не доброе, потому что сегодня понедельник\";\n" +
                " \n" +
                "\t\tSystem.out.println(\"Сегодня утро \" + morning1);\n" +
                "\t\tSystem.out.println(\"Сегодня утро \" + morning2);\n" +
                "\t}\n" +
                "}\n" +
                "Если Вы попробуете запустить этот код на своём компьютере, то Вы в консоли увидите следующее:\n" +
                "\n" +
                "Сегодня утро доброе\n" +
                "Сегодня утро не доброе, потому что сегодня понедельник\n" +
                "\n" +
                "Комментарии:\n" +
                "\n" +
                "String morning1 =\"доброе\";\n" +
                "String morning2 =\"не доброе, потому что сегодня понедельник\";\n" +
                "1\n" +
                "2\n" +
                "String morning1 =\"доброе\";\n" +
                "String morning2 =\"не доброе, потому что сегодня понедельник\";\n" +
                "В этих 2 строчках мы объявили переменные типа String и присвоили им значения. Итого у нас сейчас с Вами 2 отдельные строчки \"доброе\" и \"не доброе, потому что сегодня понедельник\".\n" +
                "\n" +
                "System.out.println(\"Сегодня утро \" + morning1);\n" +
                "System.out.println(\"Сегодня утро \" + morning2);\n" +
                "1\n" +
                "2\n" +
                "System.out.println(\"Сегодня утро \" + morning1);\n" +
                "System.out.println(\"Сегодня утро \" + morning2);\n" +
                "А в этих 2 строчках мы осуществили конкатенацию строк, то есть как бы \"склеили\" отдельные строчки в одну строчку с помощью оператора +\n" +
                "\n" +
                "Пример №2\n" +
                "public class Test {\n" +
                "\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\n" +
                "\t\tString name = \"Виктор\";\n" +
                "\t\tString car = \"Porsche 918 Spyder\";\n" +
                "\t\tSystem.out.println(name + \" купил \" + car);\n" +
                "\t}\n" +
                "}\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "public class Test {\n" +
                " \n" +
                "\tpublic static void main(String[] args) {\n" +
                " \n" +
                "\t\tString name = \"Виктор\";\n" +
                "\t\tString car = \"Porsche 918 Spyder\";\n" +
                "\t\tSystem.out.println(name + \" купил \" + car);\n" +
                "\t}\n" +
                "}\n" +
                "Если Вы попробуете запустить этот код на своём компьютере, то Вы в консоли увидите следующее:\n" +
                "\n" +
                "Виктор купил Porsche 918 Spyder\n" +
                "\n" +
                "Комментарии:\n" +
                "\n" +
                "String name = \"Виктор\";\n" +
                "String car = \"Porsche 918 Spyder\";\n" +
                "1\n" +
                "2\n" +
                "String name = \"Виктор\";\n" +
                "String car = \"Porsche 918 Spyder\";\n" +
                "В этих 2 строчках мы объявили переменные типа String и присвоили им значения. Итого у нас сейчас с Вами 2 отдельные строчки \"Виктор\" и \"Porsche 918 Spyder\".\n" +
                "\n" +
                "System.out.println(name + \" купил \" + car);\n" +
                "1\n" +
                "System.out.println(name + \" купил \" + car);\n" +
                "А в этой строчке мы осуществили конкатенацию строк, то есть как бы \"склеили\" отдельные строчки в одну строчку с помощью оператора +\n" +
                "\n" +
                "Да, уж. Красивую машину купил Виктор. Вот она красавица Porsche 918 Spyder. Эх...");
        writer.flush();
        writer.close();

        // Создание объекта FileReader
        FileReader fr = new FileReader(file);
        char [] a = new char[2000];   // Количество символов, которое будем считывать
        fr.read(a);   // Чтение содержимого в массив


        long startTime1 = System.nanoTime();       // начало отсчета времени работы конкатенации
        String javaHub = "Nathalo1: ";             //работает конкатинация
        for(char c : a) {
            String charToString = Character.toString(c);
            javaHub = javaHub.concat(charToString);
        }
        System.out.println(javaHub);
        long endTime1 = System.nanoTime();            // конец конкатенации и подсчет времени работы
        long duration1 = (endTime1 - startTime1);
        System.out.println("\n"+"\n"+"\n"+duration1);
        long m1 = System.currentTimeMillis();
        System.out.println(m1);



        long startTime2 = System.nanoTime();
        StringBuilder s = new StringBuilder("Nathalo2: ");        //работает StringBuilder и подсчет времени его работы
        for(char c : a) {
            String charToString = Character.toString(c);
            s.append(charToString);
        }
        System.out.println(s);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("\n"+"\n"+"\n"+duration2);
        long m2 = System.currentTimeMillis();
        System.out.println(m2);

    }
}
