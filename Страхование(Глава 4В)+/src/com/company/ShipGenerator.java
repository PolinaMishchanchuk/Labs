package com.company;

import java.util.Random;

public class ShipGenerator implements Runnable {
    private Tunnel tunnel;
    private int shipCount;

    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }
    @Override
    public void run() {
        int count = 0;
        while (count < shipCount) {
            Thread.currentThread().setName(" Генерируем самолет");
            count++;
            tunnel.add(new Strachowka(getRandomStrachowka()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public Strachowka getRandomStrachowka() {
        Strachowka avto = new Avto();
        Strachowka gruz = new Gryz();
        Strachowka jizni = new Jizni();
        Strachowka nesthastnieSluthai = new NesthastnieSluthai();
        Strachowka medizina = new Medizina();
        Strachowka[] strachowkas = {avto,gruz,jizni,nesthastnieSluthai,medizina};
        int i = (int) Math.random() * (5);
        return strachowkas[i];
    }
}
