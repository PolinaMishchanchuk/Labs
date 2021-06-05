package com.company;

public class Bird {               // ПТИЦА
    private Wings wings;
    private Beak beak;
    private String name;

    public Bird(String name) {
        this.name = name;
        this.wings = new Wings();
        this.beak = new Beak();
    }

    // ПОЛЕТ

    public void fly() {
        System.out.print("Птица " + name + " сейчас летает");
        wings.use();
    }

    // ПОЕТ
    public void poet() {
        System.out.print("Птица " + name + " поет");
        beak.peck1();
    }

    // ЕДА

    public void eat() {
        System.out.print("Птица " + name + " съедает свою жертву");
        beak.peck();
    }

    // ПРИЗЕМЛЕНИЕ

    public void sit_down(){
        System.out.print("Птица " + name + " сейчас садится");
        wings.use();
    }

    // АТАКА

    public void attack(){
        System.out.println("Птица " + name + " атакует!");
        wings.use();
        beak.peck();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bird bird = (Bird) o;

        if (!wings.equals(bird.wings)) return false;
        return name.equals(bird.name);

    }

    @Override
    public int hashCode() {
        int result = wings.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Bird : '" + name + "'";
    }
}
