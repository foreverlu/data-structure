package graph;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.add(0,1,2);
        graph.add(1,0,3,4);
        graph.add(2,0,3);
        graph.add(3,1,2,4,5);
        graph.add(4,1 ,3,5,6);
        graph.add(5,3,4,6,7);
        graph.add(6,4,5,7);
        graph.add(7,6,5);

        System.out.println("graph"+graph.toString());

        graph.bfs(0,6);

        graph.dfs(2,7);
    }
}
