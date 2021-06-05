package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> d = new HashMap<>();   // записывая первую строку
        Scanner f=new Scanner(System.in);
        System.out.print("Длина строки d= ");
        int n = f.nextInt();

        for(int i=0; i<=n-1; i++)
        {
            System.out.print("d" + i + "=");
            d.put(i, f.next());
        }
        System.out.print("D(Str)= "+ d.get(0));
        for(int i=1; i<=n-1; i++){
            System.out.print(d.get(i));
        }
        System.out.println(" --исходная строка");


        System.out.print("Длина строки q= ");
        int m = f.nextInt();
        HashMap<Integer, Integer> q = new HashMap<Integer, Integer>(); // cоздаю конечную строку
        for(int i=0; i<m; i++)
        {
            System.out.print("q" + i + "=");
            q.put(i, f.nextInt());

        }
        System.out.print("Q(Int)= "+q.get(0));
        for(int i=1; i<m; i++)
        {
            System.out.print(" " + q.get(i));
        }
        System.out.println(" --зашифрованная строка");

        HashMap<Integer, Integer> w = new HashMap<Integer, Integer>();
        System.out.print("W(Int)= ");
        for(int i=0; i<m; i++)
        {
            w.put(i, q.get(i)-48);
            System.out.print(w.get(i)+" ");
        }
        System.out.println();

        System.out.print("K2= ");
        for(int i=0; i<m; i++)
        {
            System.out.print(w.get(i)+"->"+q.get(i)+" ");
        }
        System.out.println();
        int[] str = new int[n];
        int k = 0;
            for(int i=0;i<m;i++){
              if((i + 1) % 3 != 0){
                  if(2-i<0){str[k]= (int) (str[k]+(w.get(i)*Math.pow(10,(Math.abs(2-i+3))%3)));}
                  else {str[k]= (int) (str[k]+(w.get(i)*Math.pow(10,(Math.abs(2-i))%3)));}
              }
              else{
                  if(2-i<0){str[k]= (int) (str[k]+(w.get(i)*Math.pow(10,(Math.abs(2-i+3))%3))); k++;}
                  else {str[k]= (int) (str[k]+(w.get(i)*Math.pow(10,(Math.abs(2-i))%3))); k++;}
              }
            }


        HashMap<Integer, Integer> r = new HashMap<Integer, Integer>();
        System.out.print("R(Int)= ");
        for(int j=0; j<n; j++)
        {
            r.put(j, str[j]);
            System.out.print(r.get(j)+" ");
        }
        System.out.println();


        System.out.print("K1= "+d.get(0)+"->"+r.get(0));
        for(int j=1; j<n; j++)
        {
            System.out.print(" : "+d.get(j)+"->"+r.get(j));
        }
        System.out.println();
    }
}
