package link;

public class DeLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public DeLinkedList(){
        head = new Node(null);
        tail = head;
        size=0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void add(T data){
        tail.setData(data);
        Node node = new Node(null);
        tail.setNext(node);
        node.setPre(tail);
        tail=node;
        size++;
    }

    public void remove(T data){
        Node node = head;
        while (node != tail){
            T data1 = (T)node.getData();

            if(data.equals(data1)){
                if(node==head){
                    node.next=null;
                    node.next.pre=null;
                    node = node.next;
                    head = node;
                    size--;
                    continue;
                }
                node.pre.setNext(node.next);
                node.next.setPre(node.pre);
                size--;
            }
            node = node.getNext();

        }
    }

    @Override
    public String toString() {
        Node node = head;
        String str = "";
        while (node!=tail){
            T data = (T)node.getData();
            str = str+","+data;
            node = node.getNext();
        }
        return str;
    }

    class Node<T>{
        private Node pre;
        private Node next;
        private T data;


        public Node(T data){
            this.data = data;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
