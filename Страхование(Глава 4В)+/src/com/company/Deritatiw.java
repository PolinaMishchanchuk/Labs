package com.company;

import java.util.*;

public class Deritatiw implements IDeritatiw{

    private Strachowka[] strachowkas;

    public  Deritatiw(int count){
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

   public void summa(Strachowka[] strachowkas){
        Arrays.stream(strachowkas).sorted();
        for(int i=0; i<5;i++){
            System.out.println(strachowkas[i].getTip()+ " "+ strachowkas[i].getPrice());
        }
   }
}
