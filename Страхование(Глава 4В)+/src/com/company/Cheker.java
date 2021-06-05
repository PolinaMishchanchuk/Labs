package com.company;

public class Cheker {
    public static boolean chekLength(Strachowka[] strachowkas){
        boolean flag = true;
        if(strachowkas[strachowkas.length-1]!=null){
            flag = false;
        }
        return flag;
    }
    public static int getPosition(Strachowka[] strachowkas){
        int position = 0;
        for(int i=0; i<strachowkas.length; i++){
            if(strachowkas[i]==null){
                position=i;
                break;
            }
        }
        return position;
    }
}
