import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] myArray = new int[]{ 3, 4, 7, -50, 10, -5, -7, 15};
        int[] sortedArray = sort(myArray, myArray.length);
        for(int i = 0; i < sortedArray.length;i++){
            System.out.println(sortedArray[i] + " ");
        }
        
    }

    public static void toSwap(int[] array, int first, int second){
        int dummy = array[first];
        array[first] = array[second];
        array[second] = dummy;
    }

    public static int[] sort(int[] array, int count){
        for (int out = count - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(array[in] < array[in + 1])
                    toSwap(array, in , in+1);
            }
        }

        return array;
    }
}
