package com.company;
import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название выставки и размещение экспозиции: ");
        String name = scan.next();
        String rasmeshenije = scan.next();
        System.out.println("Введите количество картин на выставке: ");
        int numer_cartina = scan.nextInt();
        String[] name_cartinas = new String[numer_cartina];
        String[] name_avtors = new String[numer_cartina];
        int[] dates = new int[numer_cartina];
        for(int i=0 ,j=0; i < numer_cartina; i++, j++){
            System.out.println("Введите название картины " + (j+1) + " имя автора и дату: " );
            name_cartinas[i] = scan.next();
            name_avtors[i] = scan.next();
            dates[i] = scan.nextInt();
        }
        VistawkaKartin vistawka = new VistawkaKartin(rasmeshenije,2,numer_cartina,name,name_cartinas, name_avtors,dates){
            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        };

        vistawka.show();
        for (int i=0; i < numer_cartina; i++){
            System.out.println(name_cartinas[i] + " "+ name_avtors[i]+ " "+ dates[i]);
        }

         String zamena= scan.next();



        VistawkaKartin.Exposition exposition = new VistawkaKartin.Exposition(3,"fhg");

        scan.close();
    }

}
