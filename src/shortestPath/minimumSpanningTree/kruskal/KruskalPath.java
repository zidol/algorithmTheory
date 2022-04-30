package shortestPath.minimumSpanningTree.kruskal;

import java.util.*;

public class KruskalPath {

    //부모 노드 확인용
    Map<String, String> parent = new HashMap<>();
    //자신의 랭크 확인
    Map<String, Integer> rank = new HashMap<>();

    //루트노드
    public String find(String node) {
        //path compression
        if (!Objects.equals(parent.get(node), node)) {
            //재귀함수로 root node 탐색하여 모든 노드들 root에 연결
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);//루트 노드 리턴
    }

    //두개 노드를 연결하면 사이클이 안생길때만 호출
    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        //union by rank
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {//같거나 root2가 클때
            parent.put(root1, root2);
            //랭크가 같을때
            if (Objects.equals(rank.get(root1), rank.get(root2))) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }
    //초기화
    public void makeSet(String node) {
        //자신을 루트로 만들고, 원소가 개별 집합으로 이뤄지도록 초기화
        parent.put(node, node);
        // 랭크를 모두 0
        rank.put(node, 0);
    }

    public List<Edge> kruskalFunc(List<String> vertices, List<Edge> edges) {//노드 리스트, 간선 리스트
        //최종 결과
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;


        //1. 초기화
        for (String vertex : vertices) {
            makeSet(vertex);
        }
        //2. 간선의 weight 기반 sorting
        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            //루트드가 다르면 (사이클이 없다면)
            if (!Objects.equals(find(currentEdge.nodeV), find(currentEdge.nodeU))) {
                union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }
        return mst;
    }

    public static void main(String[] args) {

        //연결된 노드관리용
        List<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        KruskalPath kruskalPath = new KruskalPath();

        List<Edge> edges1 = kruskalPath.kruskalFunc(vertices, edges);
        System.out.println("edges1 = " + edges1);
    }
}
