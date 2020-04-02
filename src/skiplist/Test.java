package skiplist;

public class Test {
    public static void main(String[] args) {
        MySkipList list = new MySkipList();
        list.insert(2);
        list.insert(4);
        list.insert(9);
        list.insert(5);
        list.insert(10);
        list.insert(8);
        list.print();
        System.out.println(list.find(4));
        System.out.println(list.find(6));
        list.delete(8);
        list.print();


    }
}
