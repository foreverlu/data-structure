package heap;

import Utils.ArrUtils;


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = ArrUtils.generateArr(15,100);
        Heap heap = new Heap(arr.length);
        heap.createHeap(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(heap.getArr()));
//        heap.insert(56);
//        System.out.println(Arrays.toString(heap.getArr()));
//        System.out.println(heap.delete(heap.getArr()[6]));
//        System.out.println(Arrays.toString(heap.getArr()));

        int [] sortedArr = heap.heapSort();
        System.out.println(Arrays.toString(sortedArr));
    }
}
