package com.company;

public class Strachowkas {
    private String name;
    private String tip;

    public Strachowkas(String name, String tip){
        this.name = name;
        this.tip=tip;
    }

    @Override
    public String toString() {
        return "Strachowkas{" +
                "name='" + name + '\'' +
                ", tip='" + tip + '\'' +
                '}';
    }
}
