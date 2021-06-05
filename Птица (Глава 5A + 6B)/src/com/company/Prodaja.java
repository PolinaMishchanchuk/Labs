package com.company;

public class Prodaja implements IProdaja {
    public static final double KOEF = 0.3;
    public static int prodaja(int n){
        double znath = KOEF * n;
        int zeloe = (int)znath;
        return zeloe;
    }

    public static void prodaja_final(int n){
        double znath = KOEF * n;
        int zeloe = (int)znath;
        System.out.println("На рынке продано: " + zeloe +" яиц");
    }
}
