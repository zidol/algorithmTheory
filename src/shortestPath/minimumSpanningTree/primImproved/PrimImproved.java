package shortestPath.minimumSpanningTree.primImproved;

import java.util.*;

public class PrimImproved {



    public List<Path> primFunc(Map<String, Map<String, Integer>> graph, String startNode) {
        List<Path> mst = new ArrayList<>();
        //전체 노드들
        PriorityQueue<Edge> keys = new PriorityQueue<>();

        //node to node 정보 담는 맵
        Map<String, String> mstPath = new HashMap<>();

        //각각읜 노드마다 해당 객체
        Map<String, Edge> keysObjects = new HashMap<>();

        Integer totalWeight = 0;

        Edge edgeObject, poppedEdge, linkedEdge;

        //인접 간선 정보
        Map<String, Integer> linkedEdges;


        for (String key : graph.keySet()) {

            if (key == startNode) {
                //엣지 정보
                edgeObject = new Edge(key, 0);
                //노드와 노드의연결 정보를 담는 Map
                mstPath.put(key, key);
            } else {
                edgeObject = new Edge(key, Integer.MAX_VALUE);
                mstPath.put(key, null);
            }
            //각각의 노드 : 0 또는 최대값
            keys.add(edgeObject);
            //각 노드의 해당 객체
            keysObjects.put(key, edgeObject);
        }
        System.out.println("keys : " + keys);
        System.out.println("keysObjects : " + keysObjects);
        System.out.println("mstPath : " + mstPath);

        while (keys.size() > 0) {
            poppedEdge = keys.poll();
            keysObjects.remove(poppedEdge.node);

            mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
            totalWeight += poppedEdge.weight;
            //인접 간선정보
            linkedEdges = graph.get(poppedEdge.node);
            for (String adjacent: linkedEdges.keySet()) {
                //아직 체크되지 않은 키들을 체크
                //인접 노드가 있는지 확인
                if (keysObjects.containsKey(adjacent)) {
                    //인접한 edge
                    linkedEdge = keysObjects.get(adjacent);

                    //가중치 비교
                    if (linkedEdges.get(adjacent) < linkedEdge.weight) {
                        linkedEdge.weight = linkedEdges.get(adjacent);
                        //pop한 노드(poppedEdge.node)와 인접노드(adjacent)를 이어줌
                        mstPath.put(adjacent, poppedEdge.node);
                        //최소힙 유지
                        //중간값을 업데이트 하지 못하기때문에 해당 노드를 삭제 후 다시 넣어줌
                        keys.remove(linkedEdge);
                        keys.add(linkedEdge);
                    }
                }
            }
            System.out.println("keys : " + keys);
        }
        System.out.println(totalWeight);
        return mst;
    }

    public static void main(String[] args) {


        Map<String, Map<String, Integer>> graph = new HashMap<String, Map<String, Integer>>();

        Map<String, Integer> edges;
        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("D", 5);
        graph.put("A", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        graph.put("B", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 8);
        edges.put("E", 5);
        graph.put("C", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        graph.put("D", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        graph.put("E", edges);

        edges = new HashMap<String, Integer>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        graph.put("F", edges);

        edges = new HashMap<String, Integer>();
        edges.put("E", 9);
        edges.put("F", 11);
        graph.put("G", edges);

        PrimImproved primImproved = new PrimImproved();

        System.out.println(primImproved.primFunc(graph, "A"));

    }
}
