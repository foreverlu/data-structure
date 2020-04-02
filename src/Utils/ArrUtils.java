package Utils;

import java.util.Random;

public class ArrUtils {

    public static int[] generateArr(int size,int bound){
        Random random = new Random();
        int[] arr = new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(bound)+1;
        }

        return arr;
    }
}
