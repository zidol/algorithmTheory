package shortestPath.dijkstra;

import java.util.*;

public class Edge implements Comparable<Edge> {

    //weight(가중치)
    public int distance;

    //노드(Node)
    public String vertex;

    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "distance=" + distance +
                ", vertex='" + vertex + '\'' +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }



    public static void main(String[] args) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Edge(2, "A"));
        priorityQueue.add(new Edge(5, "B"));
        priorityQueue.offer(new Edge(1, "C"));
        priorityQueue.offer(new Edge(7, "D"));

//        System.out.println(priorityQueue);
//
//        System.out.println(priorityQueue.peek());
//        Edge poll = priorityQueue.poll();
//        System.out.println(poll);
//        System.out.println(priorityQueue.toString());

        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        for (String key : graph.keySet()) {
            System.out.println(key);
            System.out.println(graph.get(key));
        }
    }

}
