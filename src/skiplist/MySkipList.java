package skiplist;

import java.util.Random;

//自己实现的跳表,加油
public class MySkipList {
    //最大层数
    private int MAX_LEVEL = 16;

    //目前该跳表有几层
    private int levelCount;

    private Random random = new Random();

    private Node head = new Node();




    //查找元素的方法
    public int find(int value){
        Node p = head;
        for(int i = levelCount-1;i>=0;i--){
            while (p.forward[i]!=null && p.forward[i].getData()<value){
                p = p.forward[i];
            }
        }

        while (p.forward[0]!=null && p.forward[0].getData()!=value){
            p = p.forward[0];
        }
        if(p.forward[0]!=null && p.forward[0].getData()==value){
            return value;
        }else return -1;

    }



    //先写insert方法
    public void insert(int value){
        int l = randomLevel();

        Node newNode = new Node();
        newNode.setData(value);
        newNode.setLevel(l);

        //接下来就是更新forward
        Node p = head;

        Node[] update = new Node[l];
        for(int i=0;i<update.length;i++){
            update[i] = head;
        }

        //找到每一层新插入节点的前一个节点
        for(int i=l-1;i>=0;i--){
            while (p.forward[i]!=null && p.forward[i].getData()<value){
                p = p.forward[i];
            }
            //这样将前一个节点保存到了update当中
            update[i] = p;
        }

        //更新跳表的结构,将update中的节点的下一个节点(forward)改成newNode,
        //newNode的下一个节点就是update中的下一个节点
        //感觉这一步是不是可以放到上一个循环当中,而且update数组都不是必须的
        for(int i=l-1;i>=0;i--){
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }

        //更新levelCount
        if(l>levelCount) levelCount = l;

    }


    //删除操作
    public void delete(int value){
        Node p = head;
        //先找到value在每一级的前一个节点保存到update中
        Node[] update = new Node[MAX_LEVEL];
        for(int i=levelCount-1;i>=0;i--){
            while (p.forward[i] != null && p.forward[i].getData()<value){
                p = p.forward[i];
            }
            update[i] = p;
        }
        //修改原表中各级的update中Node的下一个指向来达到删除的目的
        if(p.forward!=null && p.forward[0].getData()==value){
            //可以直接从最高层开始删除,也可以从被删除节点所在的最高层(level)开始
            for(int i=levelCount-1;i>=0;i--){
                if (update[i].forward[i]!=null && update[i].forward[i].getData()==value){
                    update[i].forward[i] = update[i].forward[i].forward[i];
                }
            }

        }


    }



    public void print(){
        Node p = head;
        while (p!=null){
            System.out.print(p.getData()+",");
            p = p.forward[0];
        }
    }


    //产生随机层数的方法,产生的数字在1-MAX_LEVEL之间
    private int randomLevel(){
        int count = 1;
        for(int i=1;i<MAX_LEVEL;i++){
            int k = random.nextInt();
            if(k%2 ==1) count++;
        }
        return count;
    }

    //跳表中的节点
    private class Node{
        //用于存储数据
        private int data = -1;

        //保存这个节点在每一层,或者说每一级的下一个节点
        //比如1,2,3,4,5,6
        //如果有3级分别是
        //1,5
        //1,3,5
        //1,2,3,4,5,6
        //则1的forward为{2(第一(0)级),3(第二(1)级),5(第三(2)级)}
        private Node[] forward = new Node[MAX_LEVEL];

        //保存该节点存在的层数
        private int level;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node[] getForward() {
            return forward;
        }

        public void setForward(Node[] forward) {
            this.forward = forward;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
