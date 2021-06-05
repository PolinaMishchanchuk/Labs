package com.company;

public class VistawkaKartin {

    private String name;
    private Cartina cartina;
    private static Exposition exposition;

    public static class Exposition{
        private String[] rasmeshenije;
        private int nomer;

        public Exposition(int nomer, String rasmeshenije){super();}

        public Exposition(int nomer, String[] rasmeshenije){
            this.nomer = nomer;
            this.rasmeshenije = rasmeshenije;
        }


        public void zamena(Exposition exposition, String[] mesto) {
            exposition.rasmeshenije = mesto;
        }
    }

    public static class Cartina{
        private String[] name_cartina;
        private String[] name_avtor;
        private int[] date;
        int numer_cartina;

        public Cartina(){super();}
        public Cartina(int numer_cartina, String[] name_cartina, String[] name_avtor, int[] date){
            this.name_cartina = name_cartina;
            this.date = date;
            this.name_avtor = name_avtor;
            this.numer_cartina = numer_cartina;
        }

        public String[] getName_cartina(){return  name_cartina;}
        public  void setName_cartina(String[] name_cartina){this.name_cartina = name_cartina;}
        public int[] getDate(){return date;}
        public void setDate(int[] date){this.date = date;}
        public String[] getName_avtor(){return  name_avtor;}
        public void setName_avtor(String[] name_avtor){this.name_avtor = name_avtor;}
        public int getNumer_cartina() {
            return numer_cartina;
        }
        public void setNumer_cartina(int numer_cartina) {
            this.numer_cartina = numer_cartina;
        }

        @Override
        public String toString() {
            return "Catalog{" +
                    "name_cartina='" + getName_cartina() + '\'' +
                    ", name_avtor=" + getName_avtor() +
                    ", data=" + getDate() +
                    ", numberRecords=" +getNumer_cartina() +
                    '}';
        }
    }

   public  VistawkaKartin() {super();}
    public VistawkaKartin(String rasmeshenije, int nomer,int numer_cartina,String nameVistawka,String[] name_cartina, String[] name_avtor, int[] date){
        this.name = nameVistawka;
        this.cartina = new Cartina(numer_cartina,name_cartina,name_avtor,date);
        this.exposition = new Exposition(nomer,rasmeshenije);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Cartina getCartina() {
        return cartina;
    }

    public void show(){
        System.out.println("На выставке картин: " + name + " содержится картины: ");
    }
}
