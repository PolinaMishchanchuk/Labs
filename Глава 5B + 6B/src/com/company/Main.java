package com.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Phaser;

//синхронизовать доступ к ресурсам по потокам. 11В
//создать базу данных, организовать соединение, функции(цена, сортировка). 12В

// исключения в функциях в драйвере. серриализацию не сделала

public class Main {

    public static void main(String[] args) {
        Dreiwer dreiwer = new Dreiwer();
        dreiwer.dreiwer();
        System.out.println("Общая цена страховок:");
        dreiwer.price();
        System.out.println("Cортировка по типу:");
        dreiwer.sort();

        Strachowka avto = new Avto();
        Strachowka gruz = new Gryz();
        Strachowka jizni = new Jizni();
        Strachowka nesthastnieSluthai = new NesthastnieSluthai();
        Strachowka medizina = new Medizina();
        // создание коллекцию товаров1
        Item[] goods = new Item[8];
        for (int i = 0; i < goods.length; i++) {
            if(i<3) goods[i] = new Item(avto.getTip());
            if(i>2 && i<5) goods[i] = new Item(jizni.getTip());
            if(i==5) goods[i] = new Item(gruz.getTip());
            if(i==6) goods[i] = new Item(nesthastnieSluthai.getTip());
            if(i>6) goods[i] = new Item(medizina.getTip());
        }
        List<Item> listGood = Arrays.asList(goods);
        // создание имеющихся страховок
        Storage storageA1 = Storage.createStorage(listGood.size(), listGood);

        // создание новых карточек пользователей страховок
        Storage storageB = Storage.createStorage(listGood.size());
        Storage storageC = Storage.createStorage(listGood.size());
        Storage storageD = Storage.createStorage(listGood.size());
        Storage storageE = Storage.createStorage(listGood.size());

        // создание фазера для синхронизации передачи страховок
        Phaser phaser = new Phaser();
        phaser.register();
        int currentPhase;

        // иммитация передачи страховок
        Thread tr1 = new Thread(new Truck(phaser, "tr1", 15,1, storageA1, storageB));
        Thread tr2 = new Thread(new Truck(phaser, "tr2", 10,2, storageA1, storageC));
        Thread tr3 = new Thread(new Truck(phaser, "tr3", 13,1, storageA1, storageD));
        Thread tr4 = new Thread(new Truck(phaser, "tr4", 20,3, storageA1, storageE));

        // добавление+оплата+подключение
        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();
        // синхронизация добавления
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Добавление страховок завершено. Фаза " + currentPhase
                + " завершена.");
        // синхронизация оплаты
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Оплата страховок завершена. Фаза " + currentPhase
                + " завершена.");
        // синхронизация подключения
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + currentPhase
                + " завершена.");
        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) {
            System.out.println("Фазы синхронизированы и завершены.");
        }

        printGoodsToConsole("Страховки у пользователя tr1", storageB);
        printGoodsToConsole("Страховки у пользователя tr2", storageC);
        printGoodsToConsole("Страховки у пользователя tr3", storageD);
        printGoodsToConsole("Страховки у пользователя tr4", storageE);
    }
    public static void printGoodsToConsole(String title, Storage storage) {
        System.out.println(title);
        Iterator<Item> goodIterator = storage.iterator();
        while (goodIterator.hasNext()) {
            System.out.print(goodIterator.next().getRegistrationNumber() + " ");
        }
        System.out.println();
    }



}
