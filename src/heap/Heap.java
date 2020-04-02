package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap {
    private int[] arr;
    private int count; //元素的个数
    private int n; //数组大小

    public Heap(int capacity){
        this.n = capacity;
        arr = new int[capacity+1];
        count = 0;
    }


    public void createHeap(int[] src){
        //先默认src的size < capacity
        if(src.length>n) return;

        //先将src复制到arr当中
        System.arraycopy(src,0,this.arr,1,src.length);
        //更新count的值
        count = src.length;


        int j = count / 2;

        for(int i = j;i>=1;i--){
            heapifyDown(i);
        }
    }


    public void insert(int value){
        //考虑数组满了的情况
        if(n == count){
            int[] newArr = new int[2*n];
            this.n = 2*n;
            System.arraycopy(this.arr,1,newArr,1,count);
            this.arr = newArr;
        }
        count++;
        arr[count] = value;
        //调整堆,满足堆的定义,自下而上
        heapifyUp(count/2);


    }

    private List<Integer> findValue(int value){
        List<Integer> index = new ArrayList<>();
        //遍历数组找到value的index
        for(int i=1;i<=count;i++){
            if(arr[i]==value){
                index.add(i);
            }
        }
        return index;
    }


    public boolean delete(int value){
        if(count==0) return false;
        List<Integer> index = findValue(value);
        if(index.size()==0) return false;
        for(int i=0;i<index.size();i++){
            int pos = index.get(i);
            arr[pos] = 0;
            if(pos>count/2) {
                continue;
            }

            //自上而下
            heapifyDown(pos);
        }
        return true;
    }

    public int[] heapSort(){

        int c = count;

        while (count>0){
            swap(arr,1,count--);
            heapifyDown(1);

        }
        int[] sortedArr = new int[c];
        System.arraycopy(arr,1,sortedArr,0,c);
        return sortedArr;
    }





    private void heapifyDown(int i) {
        int j = count/2;
        while (true){
            int maxPos = i;
            if(2*i+1 <= count && arr[i] < arr[2*i+1]) maxPos = 2*i+1;
            if(2*i<=count && arr[2*i] > arr[maxPos]) maxPos = 2*i;
            if(i == maxPos ) break;
            //交换i和i的子节点较大的值的位置
            swap(arr,i,maxPos);

            //最大位置的值超过了最后一个父节点跳出
            if(maxPos > j) break;

            i = maxPos;
        }
    }



    private void heapifyUp(int p){
        while (true){
            if(p<1) break;
            int maxPos = p;
            if(2*p+1<=count && arr[p] < arr[2*p+1]) maxPos = 2*p+1;
            if(2*p<=count &&arr[maxPos] < arr[2*p]) maxPos = 2*p;
            if(p==maxPos) break;
            swap(arr,p,maxPos);
            p = p/2;
        }
    }

    private void swap(int[] arr,int i,int maxPos){
        if(i==maxPos) return;
        int temp = arr[i];
        arr[i] = arr[maxPos];
        arr[maxPos] = temp;
    }




    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
