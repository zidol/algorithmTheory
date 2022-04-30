package shortestPath.minimumSpanningTree.prim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class PrimAlgorithm {

    public Edge currentEdge;
    private Edge adjacentEdgeNode;
    private Edge poppedEdge;
    private List<Edge> currentEdgeList;
    private List<Edge> candidateEdgeList;
    private PriorityQueue<Edge> priorityQueue;
    private List<Edge> adjacentEdgeNodes;

    public List<Edge> primFunc(String startNode, List<Edge> edges) {
        //연결된 vertex집합
        List<String> connectedNodes = new ArrayList<>();
        //최종 결과
        List<Edge> mst = new ArrayList<>();

        //근접한 노드의 간선들을 배열로
        HashMap<String, List<Edge>> adjacentEdges = new HashMap<>();

        //초기화 start
        for (int i = 0; i < edges.size(); i++) {
            //노드명 갖고 오기 위해
            currentEdge = edges.get(i);
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
            }
        }
        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            //위에서 초기화 한 근접 노드의 빈 리스트
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            //변수에 따로 안마들어도 됨
//            adjacentEdges.get(currentEdge.node1).add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }
        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());//에러 방지를 위해 디폴트값
        priorityQueue = new PriorityQueue<Edge>();// 최소힙 구현

//        for (int i = 0; i < candidateEdgeList.size(); i++) {
//            priorityQueue.add(candidateEdgeList.get(i));
//        }
        //시작 노드의 인접 간선 리스트를 최소힙에 초기화
        priorityQueue.addAll(candidateEdgeList);
        System.out.println("priorityQueue : " + priorityQueue);
        //초기화 end

        while (priorityQueue.size() > 0) {
            //최소의 간선을 pop(priorityQueue 최소 힙이기 때문에)
            poppedEdge = priorityQueue.poll();
            System.out.println("poppedEdge ; " + poppedEdge);
            //node2가  connectedNodes에 포함되면 사이클 형성
            if (!connectedNodes.contains(poppedEdge.node2)) {
                //해당 edge를 mst에 추가
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                //node2의 연결되어 있는 노드(간선)들
                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
                for (int i = 0; i < adjacentEdgeNodes.size(); i++) {
                    adjacentEdgeNode = adjacentEdgeNodes.get(i);
                    //전부 다 넣지 않고 포함되지 않는것들만 걸러서 입력
                    if (!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        System.out.println(connectedNodes);
        return mst;

    }

    public static void main(String[] args) {

        List<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(11, "F", "G"));

        PrimAlgorithm primAlgorithm = new PrimAlgorithm();

        System.out.println(primAlgorithm.primFunc("A", edges));

    }

}
