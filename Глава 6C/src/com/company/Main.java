package com.company;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.Scanner;
import java.util.Date;

/*11. Ввести из текстового файла, связанного с входным потоком, последовательность строк.
 Выбрать и сохранить m последних слов в каждой из последних n строк.
  */


// ДОПИСАЛА РАЗДЕЛЕНИЕ НА СТРОКИ

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("Example.txt");
        file.mkdir();
        if(file.exists()) {
            if (file.mkdir()) {
                System.out.println("Каталог" + file.getAbsolutePath() + " cоздать не удалось");
            } else {
                System.out.println("Каталог" + file.getAbsolutePath() + " успешно создан");
            }
            System.out.println("Каталог" + file.getAbsolutePath() + " уже есть");
        }


        // Создание файла
        file.createNewFile();


        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file);

        // Запись содержимого в файл
        writer.write(" Это простой пример. Тут в котором мы осуществляем это. С помощью языка Java. Запись в файл. Чтение из выбранного одного файла. Выборка строк и слов.");
        writer.flush();
        writer.close();

        // Создание объекта FileReader
        FileReader fr = new FileReader(file);
        char [] a = new char[200];   // Количество символов, которое будем считывать
        fr.read(a);   // Чтение содержимого в массив

        //посчитаем общее количество строк .
        int stroka = 0;

        for(char c : a) {
            if(c=='.'){
                System.out.println(c);stroka++;}
            else System.out.print(c);
        }
          System.out.println("\n");

        System.out.println("Введите количество строк которые надо выбрать:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println("Введите количество слов которые надо выбрать:");
        Scanner scan1 = new Scanner(System.in);
        int number1 = scan1.nextInt();
        int n = number;//последние строки
        int m = number1;//последние слова
        int count =0;// считает количество точек
        int b = stroka-n-1;//с какого места пишем сторки
        File file1 = new File("Example1.txt");
        file1.mkdir();
        if(file1.exists()){
            if(file1.mkdir()){
                System.out.println("Каталог"+file1.getAbsolutePath()+" cоздать не удалось");
            }
            else {
                System.out.println("Каталог"+file1.getAbsolutePath()+" успешно создан");
            }
            System.out.println("Каталог"+file1.getAbsolutePath()+" уже есть");
        }

        file1.createNewFile();
        FileWriter writer1 = new FileWriter(file1);

        for(char c : a) {
         if(c=='.'){ count++; }
         if(count>b){
             writer1.write(c);
             System.out.print(c);}   // Вывод символов один за другим
        }
        System.out.println("\n");
        writer1.flush();
        writer1.close();
        fr.close();

        //ВЫБИРАЕМ ПОСЛЕДНИЕ СЛОВА В СТРОЧКАХ

        // Создание объекта FileReader
        FileReader fre = new FileReader(file1);
        char [] q = new char[200];   // Количество символов, которое будем считывать
        fre.read(q);   // Чтение содержимого в массив

        //посчитаем общее количество слов в каждой строке.
        int i=0;
        int slowo = 0;
        int[] x = new int[stroka];
        for(char u : q) {
            if(u!='.'){if(u==' ') {slowo++;} }
            else {
                x[i]=slowo;
                System.out.println(x[i]);
                i++;
                slowo =0;
            }
        }
        i=0;


        File file2 = new File("Example2.txt");
        file2.mkdir();
        if(file2.exists()){
            if(file2.mkdir()){
                System.out.println("Каталог"+file2.getAbsolutePath()+" cоздать не удалось");
            }
            else {
                System.out.println("Каталог"+file2.getAbsolutePath()+" успешно создан");
            }
            System.out.println("Каталог"+file2.getAbsolutePath()+" уже есть");
        }

        file2.createNewFile();
        FileWriter writer2 = new FileWriter(file2);

        for(char u : q){
            if(u!='.'){
                if(u==' ') {slowo++;}
                if(slowo>x[i]-m){
                    System.out.print(u);
                    writer2.write(u);
                }
            }
            else {
                i++;
                slowo =0;
                System.out.println('\n');
                writer2.write('\n');
            }
        }

        writer2.flush();
        writer2.close();
        fre.close();

        /*
        // директория
        File dir = new File("com" + File.separator + "data.txt");
        if (dir.exists() && dir.isDirectory()) { // если объект является каталогом и если этот каталог существует
            System.out.println("каталог " + dir.getName() + " существует");
        }
        else System.out.println("Каталог создан");


        File[] files = dir.listFiles();
        for(int j = 0; j < files.length; j++) {
            Date date = new Date(files[j].lastModified());
            System.out.print("\n"+files[j].getPath()+" \t| "+files[i].length()+"\t|"+date);
            // использовать toLocaleString() или toGMTString()
        }
// метод listRoots() возвращает доступные корневые каталоги
        File root = File.listRoots()[1];
        System.out.printf("\n%s %,d из %,d свободно.", root.getPath(), root.getUsableSpace(),
                root.getTotalSpace());   */

    }
}
