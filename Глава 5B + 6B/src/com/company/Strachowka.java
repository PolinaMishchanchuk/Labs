package com.company;

public class Strachowka {

    private int count;
    private String tip;
    private int price;
    private int stepeni;

    public Strachowka(String tip, int price, int stepeni){
        this.tip =tip;
        this.price=price;
        this.stepeni=stepeni;
    }

    public Strachowka(Strachowka strachowka){
        this.tip = strachowka.getTip();
        this.price = strachowka.getPrice();
        this.stepeni = strachowka.getStepeni();
    }

    public boolean countCheck() {
        if (count >= 100) {
            return false;
        }
        return true;
    }

    public int getCount() {
        return count;
    }

    public void add(int count) {
        this.count += count;
    }
    public int getPrice() {
        return price;
    }
    public String getTip(){
        return tip;
    }
    public int getStepeni(){return stepeni;}
    public void setStepeni(int stepeni){
        this.stepeni=stepeni;
    }
    public  void setPrice(int price){
        this.price=price;
    }
    public void setTip(String tip){
        this.tip=tip;
    }
}
