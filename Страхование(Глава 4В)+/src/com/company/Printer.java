package com.company;

public class Printer {
    public static void printDeritatiw(Strachowka[] strachowkas){
        StringBuilder str = new StringBuilder(strachowkas.length);
        str.append("[");
        for(Strachowka strachowka : strachowkas){
            str.append(strachowka.getTip());
            str.append(" ");
        }
        str.append("]");
        System.out.println(str.toString());
    }

    public static void PrintPrice (int price){
        System.out.println("Общая цена страховок " + price);
    }


}
