package queue;


//用数组实现的队列
public class ArrayQueue<T> {
    private int maxSize = 16;
    private T[] array;
    private int head;
    private int tail;


    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        array = (T[]) new Object[maxSize];
        head = 0;
        tail = 0;
    }
    public ArrayQueue(){
        array = (T[])new Object[this.maxSize];
        head = 0;
        tail = 0;
    }

    //插入操作
    public boolean push(T data){
        //检查是否满了
        if(tail >= maxSize-1) return false;
        array[tail++] = data;
        return true;
    }

    //取出
    public T pull(){
        //检查是否为空
        if(tail == head) return null;
        T data = array[head++];
        return data;
    }

    //获取size
    public int size(){
        return tail-head;
    }

    public String toString(){
        String str = "";
        for(int i=head;i<tail;i++){
            str = str + array[i];
        }

        return str;
    }


}
