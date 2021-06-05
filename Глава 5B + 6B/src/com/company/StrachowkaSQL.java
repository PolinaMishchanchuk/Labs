package com.company;

public class StrachowkaSQL {
    private int id;
    private String name;
    private String strachowka;
    private int price;
    private int tip;

 public StrachowkaSQL(int id, String name, String strachowka, int price, int tip){
     this.id = id;
     this.name=name;
     this.strachowka=strachowka;
     this.price=price;
     this.tip=tip;
 }

    @Override
    public String toString() {
        return "StrachowkaSQL{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", strachowka='" + strachowka + '\'' +
                ", price=" + price +
                ", tip=" + tip +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getTip() {
        return tip;
    }

    public String getStrachowka() {
        return strachowka;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStrachowka(String strachowka) {
        this.strachowka = strachowka;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }
}
