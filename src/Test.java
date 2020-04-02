import queue.ArrayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentSkipListSet;

public class Test {
    public static void main(String[] args) {
//        ArrayQueue<Integer> queue = new ArrayQueue<>();
//        queue.push(12);
//        queue.push(11);
//        System.out.println(queue.size());
//        System.out.println(queue.pull());
//        System.out.println(queue.pull());
//        System.out.println(queue.pull());
//        ArrayQueue<String> queue1 = new ArrayQueue<>();
//        queue1.push("a");
//        queue1.push("b");
//        queue1.push("c");
//        queue1.push("d");
//        String v = queue1.pull();
//        System.out.println(v);
//        System.out.println(queue1.toString());
        //ConcurrentSkipListSet set = new ConcurrentSkipListSet();

//        List set = new ArrayList();
//        for(int i=0;i<100000000;i++){
//            set.add(i);
//        }
//        long t1= System.currentTimeMillis();
//        System.out.println(set.contains(100000));
//        System.out.println(System.currentTimeMillis()-t1);
//        String[] str = {};
//        String s = String.join(",",str);
//        System.out.println(s);
//        StringJoiner sj = new StringJoiner(",");
//        sj.add("a");
//        sj.add("b");
//        System.out.println(sj.toString());


        String s = "sss";
        int i = s.substring(0,0).indexOf("s");
        System.out.println(i);
    }
}
