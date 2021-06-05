package com.company;

import java.io.InvalidObjectException;
import java.util.concurrent.Phaser;

public class Conekter {
    public void conecter(Phasers nasedka, String name, Storage jaiza){
        String file = "notes3.txt";
        Serializator sz = new Serializator();
        boolean b = sz.serialization(nasedka, file);
        Phasers.name = name; // изменение значения static-поля
        Phasers.storage= jaiza;
        // чтение и вывод объекта
        Nasedka res = null;
        try {
            res = sz.deserialization(file);
        } catch (InvalidObjectException e) {
            // обработка
            e.printStackTrace();
        }
        System.out.println(res.getName()+ " " +res.getJaiza());
    }
}
