package com.company;

public class Kostum extends Odejda implements Tkani {
    private int number_of_shelf;
    private int capacity_of_books;

    public Kostum(double square, int number_of_shelf, int capacity_of_books) {
        Tkani(square);
        //super(square);
        this.number_of_shelf = number_of_shelf;
        this.capacity_of_books = capacity_of_books;
    }

    public Kostum(double square) {
        Tkani(square);
        //super(square);
        number_of_shelf = 0;
        capacity_of_books = 0;
    }

    public int getNumber_of_shelf() {
        return number_of_shelf;
    }

    public void setNumber_of_shelf(int number_of_shelf) {
        this.number_of_shelf = number_of_shelf;
    }

    public int getCapacity_of_books() {
        return capacity_of_books;
    }

    public void setCapacity_of_books(int capacity_of_books) {
        this.capacity_of_books = capacity_of_books;
    }

    public void cleaning(){
        System.out.println("Костюм вымыт и высушен!)");
    }

    public void accommodation(){
        System.out.println("Костюм перевешен");
    }

    public void openDoorOfWardrobe(){
        System.out.println("Пришей пуговицу!");
    }

    public void show(){
        System.out.println("Костюм у нас имеет " + this.getNumber_of_shelf() + " пуговиц, ему уже " + this.getCapacity_of_books() +
                " лет и он " + this.getSquare() + " размера.");
    }

}
