package com.company;

public class Kukushka {
    private int n;
    private Bird bird;

    public Kukushka(int n) {
       Bird bird = new Bird("Кукушка");
       this.n = n;
    }

    public void podbros(Bird bird) {
        System.out.println("Кукушка подбросила яйца  " + bird);
    }
}
