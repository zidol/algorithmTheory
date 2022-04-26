package shortestPath.minimumSpanningTree.prim;

/**
 * node1 의 간선(weight)는 node2에 연결된건 표현
 *         weight
 * (node1)------(node2)
 */
public class Edge implements Comparable<Edge> {

    public int weight;

    //시작
    public String node1;
    //끝
    public String node2;

    public Edge(int weight, String node1, String node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", node1='" + node1 + '\'' +
                ", node2='" + node2 + '\'' +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

}
