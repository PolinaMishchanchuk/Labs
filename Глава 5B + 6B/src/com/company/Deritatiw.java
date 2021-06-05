package com.company;

import java.sql.*;
import java.util.Properties;

public class Deritatiw implements IDeritatiw{

    private Strachowka[] strachowkas;

    public Deritatiw(int count){
        strachowkas = new Strachowka[count];
    }
    public Strachowka[] getStrachowkas(){
        return this.strachowkas;
    }

    @Override
    public void addStrachowka(Strachowka strachowka) {
        if(Cheker.chekLength(this.strachowkas)){
            int position = Cheker.getPosition(this.strachowkas);
            this.strachowkas[position] = strachowka;
        }
        else {
            System.out.println("Error ");
        }
    }

    @Override
    public int GetStrachowkaCost() {
       int result = 0;
       for(Strachowka strachowka : this.strachowkas){
           if(strachowka!=null)
               result+=strachowka.getPrice();
           else
               break;
       }
       return result;
    }


   public void diapason(Deritatiw deritatiw, int maxprice, int minprice, int maxstepeni, int minstepeni){
       for(Strachowka strachowka : this.strachowkas){
           if(strachowka.getPrice()>=minprice && strachowka.getPrice()<=maxprice && strachowka.getStepeni()>=minstepeni && strachowka.getStepeni()<=maxstepeni){
               System.out.print(strachowka.getTip());
               System.out.println(" ");
           }
       }
   }

   public void summa(Strachowka[] strachowkas){    //пузырьковая сортировка непоавильная, просто допиши
       int position = strachowkas.length - 1;
      // for(position;position > 0; position --){}
       for(int i = position ;i > 0; i --) {
           for(int j=0; j<i;j++){
               if (strachowkas[j].getPrice() > strachowkas[j +1].getPrice()){
                   Strachowka temp1 = new Strachowka(strachowkas[j + 1]);
                   strachowkas[j + 1].setPrice(strachowkas[j].getPrice());
                   strachowkas[j].setPrice(temp1.getPrice());
               }
               position--;
           }

       }
       for(int i=0; i<5;i++){
           System.out.println(strachowkas[i].getTip()+ " "+ strachowkas[i].getPrice());
       }
   }




}
