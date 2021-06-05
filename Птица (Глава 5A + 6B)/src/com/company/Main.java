package com.company;

import java.io.Serializable;
import java.io.*;
import java.util.Scanner;

// поток ввода и вывода + искючительная ситуация, математическое исключение, тест.,
// сохранение с сериализацией, изменяю информацию в конектере.

public class Main {

    public static <TestSerial> void main(String[] args) throws IOException {
        Bird bird1 = new Bird("Соловей");
        Bird bird2 = new Bird("Синица");
        Bird bird3 = new Bird("Сорока");
        Bird bird4 = new Bird("Сокол");

        bird1.fly();
        bird2.eat();
        bird3.sit_down();
        bird4.attack();

        System.out.println(bird1.equals(bird2));
        System.out.println(bird4.equals(bird4));
        System.out.println(bird1);
        System.out.println(bird2);
        System.out.println(bird3);
        System.out.println(bird4);


        Nasedka nasedka1 = new Nasedka("Курица");
        try {nasedka1.setJaiza(-3);}
        catch (NasedkaLogicException e){
            System.out.println("Внимание! Количество яиц отрицательное! Введите еще раз! ");
        }
        try {nasedka1.setJaiza(3);}
        catch (NasedkaLogicException e){
            System.out.println("Внимание! Количество яиц отрицательное! Введите еще раз! ");
        }
        nasedka1.nesti(3);
        nasedka1.ptenzi(3);

        Scanner scan = null;
        try {
            scan = new Scanner(System.in);
        }catch (Exception e){
            e.printStackTrace();
        }


        // ЗАПИСЬ И СЧИТЫВАНИЕ ИЗ ФАЙЛА
        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            String text = "40";
            writer.write(text);
            writer.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage() + "Файла нет");
        }

        int a=0;
        try(FileReader reader = new FileReader("notes3.txt"))
        {
            a = reader.read();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage() + "Файла нет");
        }

          Prodaja.prodaja_final(a);

        Kukushka kukushka1 = new Kukushka(3);
        kukushka1.podbros(bird1);

    // СОЗДАНИЕ И ЗАПИСЬ ОБЪЕКТА (для наседки курицы)

        System.out.println(nasedka1.getName()+ " " +nasedka1.getJaiza());
        Conekter conekter = new Conekter();
        conekter.conecter(nasedka1,"Perepel", 5);

    //АРХИВАЦИЯ

        String dirName = "notes3.txt";
        try {
            nasedka1.pack(dirName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
