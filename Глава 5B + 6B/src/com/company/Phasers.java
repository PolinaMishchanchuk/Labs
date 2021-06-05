package com.company;

import java.util.concurrent.Phaser;

public class Phasers {
    private static String name;
    private static Storage storage;

    public Phasers(String name,Storage storage){
        this.name = name;
        this.storage=storage;
    }
}
