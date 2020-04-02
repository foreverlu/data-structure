package link;
//单向链表结构


import java.util.LinkedList;

public class SimpleLinkedList<T>{
    class Node<T> {
        private T data;
        private Node nextNode;

        public Node(T data){
            this.data = data;
            nextNode = null;
        }

        public Node(T data,Node next){
            this.data = data;
            this.nextNode = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
    //头结点
    private Node head;
    private int size;
    private Node tail;

    public SimpleLinkedList(){
        this.head = new Node(null);
        this.size=0;
        this.tail = this.head;
    }

    //添加
    public boolean add(T data){
        tail.data = data;
        Node node = new Node(null);
        tail.nextNode = node;
        tail = node;
        size++;
        return true;
    }

    //删除元素
    public T remove(T data){
        if (size==0) return data;
        Node node = head;
        T temp = null;
        Node pre = null;
        while (node != tail){
            temp = (T)node.getData();
            if(temp!=null && temp.equals(data)){
                if(pre==null){
                    pre = node.nextNode;
                    node.nextNode=null;
                    head = pre;

                    pre = null;
                    node = head;
                    size--;
                    continue;
                }
                pre.nextNode = node.nextNode;
                node = pre.nextNode;
                size--;
            }
            pre = node;
            node = node.nextNode;
        }
        return data;
    }

    //插入元素
    public void insert(T data,T index){
        Node node = head;
        T data1 = null;
        while (node != tail){
            data1 = (T)node.getData();
            if(index.equals(data1)){
                Node node1 = new Node(data);
                node1.setNextNode(node.getNextNode());
                node.setNextNode(node1);
                size++;
                return ;
            }
            node = node.getNextNode();

        }

        add(data);


    }

    public String toString(){
        String str = "";
        int i = 0;
        Node node = head;

        while (node!=tail){
            T data = (T)node.getData();
            str = str+","+data;
            node = node.getNextNode();
        }
        return str;
    }


    //链表反转
    public void reserve(){
        if(size<2) return;
        Node node = head;
        Node pre = tail;
        while (node!=tail){
            Node next = node.getNextNode();
            node.setNextNode(pre);
            pre = node;
            node = next;
        }
        head = pre;

    }

    //鏈錶中環的檢測
    public boolean checkCircle(){
        Node fast = head.nextNode;
        Node slow = head;
        while (fast != null && slow != null){
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
            if(slow == fast) return true;
        }
        return false;
    }

    //有序鏈錶的合併



}