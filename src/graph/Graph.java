package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    //节点个数
    private int v;
    private LinkedList<Integer> adj[];


    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void add(int i,int j){
        if(!adj[i].contains(j))
            adj[i].add(j);
    }
    public void add(int i,int...j){
        for(int s=0;s<j.length;s++){
            add(i,j[s]);
        }
    }
//    public void add(int i,int[] arr){
//        for(int s=0;s<arr.length;s++){
//            add(i,arr[s]);
//        }
//    }


    //广度优先算法
    public void bfs(int src,int des){
        if(src==des) return;
        //队列,将访问定点的邻接顶点放入,依次访问
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        boolean visited[] = new boolean[v];
        int[] pre = new int[v];
        for(int m=0;m<pre.length;m++){
            pre[m]=-1;
        }
        visited[src] = true;
        while (queue.size()!=0){
            int w = queue.poll();
            LinkedList<Integer> cList = adj[w];
            for(int i=0;i<cList.size();i++){
                int t = cList.get(i);
                if(!visited[t]){
                    visited[t] = true;
                    pre[t] = w;
                    if(t==des){
                        print(pre,src,des);
                        System.out.println();
                    }else {
                        queue.add(t);
                    }
                }
            }
        }

    }


    //深度优先搜索,找到从a到b的路径,不一定是最短距离
    private boolean found = false;
    public void dfs(int src,int des){
        if(src==des) return;
        //思路和广度优先差不多
        boolean visited[] = new boolean[v];
        visited[0] = true;
        int[] pre = new int[v];
        for(int i=0;i<pre.length;i++){
            pre[i] = -1;
        }
        LinkedList<Integer> list = adj[src];
        //src节点开始
        search(visited,pre,src,des);
        print(pre,src,des);
    }

    private void search(boolean[] visited, int[] pre, int p, int des) {
        visited[p] = true;
        if(found==true) return;
        if(p==des){
            found=true;
            return;
        }
        LinkedList<Integer> list = adj[p];
        for(int i=0;i<list.size();i++){
            int t = list.get(i);
            if(!visited[t]){
                pre[t] = p;
                search(visited,pre,t,des);
            }

        }
    }


    private void print(int[] pre,int i,int j){
        if(pre[j]!=-1){
            print(pre,i,pre[j]);
        }
        System.out.print(j+" ");
    }




    public String toString(){
        String str = "";
        for(int i=0;i<v;i++){
            str = str+i+":";
            for(int j=0;j<adj[i].size();j++){
                str=str+adj[i].get(j)+" ";
            }
            str = str + ",";
        }

        return str;
    }


    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }
}
