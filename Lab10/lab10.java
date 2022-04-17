package Lab10;

import java.util.*;
import java.util.Scanner;
 
class lab10 {
    static  Scanner in = new Scanner(System.in);

    static class AdjListNode {
        int vertex, weight;
 
        AdjListNode(int v, int w)
        {
            vertex = v;
            weight = w;
        }
        int getVertex() { return vertex; }
        int getWeight() { return weight; }
    }

    public static int dijkstra(int V, ArrayList<ArrayList<AdjListNode>> graph, int source)
    {
        int[] distance = new int[V];
        for (int i = 0; i < V; i++){
            distance[i] = Integer.MAX_VALUE;
            distance[source] = 0;
        }

        PriorityQueue<AdjListNode> pq = new PriorityQueue<>( (v1, v2) -> extracted(v1, v2));
        pq.add(new AdjListNode(source, 0));
 
        while (pq.size() > 0) {
            AdjListNode current = pq.poll();
 
            for (AdjListNode n :    graph.get(current.getVertex())) {

                if (distance[current.getVertex()]  + n.getWeight()  < distance[n.getVertex()]) {

                    distance[n.getVertex()] = n.getWeight() + distance[current.getVertex()];
                    pq.add(new AdjListNode( n.getVertex(),  distance[n.getVertex()]));
                }
            }
        }
        // If you want to calculate distance from source to
        // a particular target, you can return
        // distance[target]
        System.out.println("Enter Point:");

        return distance[in.nextInt()];
    }

    private static int extracted(AdjListNode v1, AdjListNode v2) {
        return v1.getWeight() - v2.getWeight();
    }
 
    public static void main(String[] args)
    {
        int V = 12;
        ArrayList<ArrayList<AdjListNode> > graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new AdjListNode(1, 4));
        graph.get(0).add(new AdjListNode(2, 5));

        graph.get(1).add(new AdjListNode(3, 9));
        graph.get(1).add(new AdjListNode(2, 4));

        graph.get(2).add(new AdjListNode(4, 5));

        graph.get(3).add(new AdjListNode(8, 2));
        graph.get(3).add(new AdjListNode(4, 5));

        graph.get(5).add(new AdjListNode(1, 10));
        graph.get(5).add(new AdjListNode(3, 4));
        graph.get(5).add(new AdjListNode(7, 3));


        graph.get(6).add(new AdjListNode(10, 5));
        graph.get(6).add(new AdjListNode(9, 3));
        graph.get(6).add(new AdjListNode(7, 4));
        graph.get(6).add(new AdjListNode(5, 2));


        graph.get(7).add(new AdjListNode(8, 5));
        graph.get(7).add(new AdjListNode(3, 1));

        graph.get(8).add(new AdjListNode(4, 10));

        graph.get(9).add(new AdjListNode(11, 9));
        graph.get(9).add(new AdjListNode(8, 1));

        graph.get(10).add(new AdjListNode(9, 7));
        graph.get(10).add(new AdjListNode(11, 10));

        graph.get(11).add(new AdjListNode(4, 8));
        
        System.out.println("Enter Start Point:");

        source  = in.nextInt();
        int distance = dijkstra(V, graph, source);

        System.out.println(distance);
    }
}
