package link;

public class Test {
    public static void main(String[] args) {
        SimpleLinkedList<String> linkedList = new SimpleLinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        //System.out.println(linkedList.toString());
        //linkedList.remove("2");
        //System.out.println(linkedList.toString());

        linkedList.insert("4","2");
        System.out.println(linkedList.toString());
        linkedList.reserve();
        System.out.println(linkedList.toString());
//        DeLinkedList<String> deLinkedList = new DeLinkedList<>();
//        deLinkedList.add("a");
//        deLinkedList.add("b");
//        deLinkedList.add("c");
//        deLinkedList.add("b");
//        deLinkedList.add("g");
//        deLinkedList.remove("b");
//        System.out.println(deLinkedList.toString());
    }
}
