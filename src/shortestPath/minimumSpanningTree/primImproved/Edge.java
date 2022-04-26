package shortestPath.minimumSpanningTree.primImproved;

public class Edge implements Comparable<Edge> {

    //인접된 노드의 이름
    public String node;
    //인접된 노드의 접근하는 weight
    public int weight;

    public Edge(String node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node='" + node + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
