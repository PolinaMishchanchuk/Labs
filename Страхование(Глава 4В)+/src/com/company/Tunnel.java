package com.company;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {
    private List<Strachowka> store;
    private static final int maxStrachowkaInTunel = 5;
    private static final int minShipsInTunel = 0;
    private int shipsCounter = 0;

    public Tunnel() {
        store = new ArrayList<>();
    }

    public synchronized boolean add(Strachowka element) {   // что-то типа тунеля в воздухе между пунктом назначения и нашим аэропортом

        try {
            if (shipsCounter < maxStrachowkaInTunel) {
                notifyAll();
                store.add(element);
                String info = String.format("%s + Выплата страховки: %s %s %s", store.size(), element.getTip(), element.getStepeni(), Thread.currentThread().getName());
                System.out.println(info);
                shipsCounter++;

            } else {
                System.out.println(store.size() + "> Перегрузка, подождите немного : " + Thread.currentThread().getName());
                wait();
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Strachowka get(String tip) {

        try {
            if (shipsCounter > minShipsInTunel) {
                notifyAll(); //возобновляет работу всех потоков, у которых ранее был вызван метод wait()
                for (Strachowka strachowka : store) {
                    if (strachowka.getTip() == tip) {
                        shipsCounter--;
                        System.out.println(store.size() + " - Начисление в страховку: " + Thread.currentThread().getName());
                        store.remove(strachowka);
                        return strachowka;
                    }
                }
            }

            System.out.println("0 < Страховки не используются");
            wait(); //освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой поток не вызовет метод notify()

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
