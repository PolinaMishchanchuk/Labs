package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Какого размера Ваш костюм? ");
        double rasmer = scan.nextDouble();
        System.out.println("Сколько лет костюму? ");
        int vosrast = scan.nextInt();
        System.out.println("Введите сколько у костюма пуговиц: ");
        int number_pugoviz = scan.nextInt();

        Kostum kostum =  new Kostum(rasmer,number_pugoviz, vosrast);

        kostum.cleaning();
        kostum.accommodation();
        kostum.openDoorOfWardrobe();
        kostum.show();

        scan.close();
    }
}
