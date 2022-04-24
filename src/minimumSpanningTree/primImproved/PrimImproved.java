package minimumSpanningTree.primImproved;

import java.util.*;

public class PrimImproved {



    public List<Path> primFunc(Map<String, Map<String, Integer>> graph, String startNode) {
        List<Path> mst = new ArrayList<>();
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
                edgeObject = new Edge(key, 0);
                mstPath.put(key, key);
            } else {
                edgeObject = new Edge(key, Integer.MAX_VALUE);
                mstPath.put(key, null);
            }
            keys.add(edgeObject);
            keysObjects.put(key, edgeObject);
        }

        while (keys.size() > 0) {
            poppedEdge = keys.poll();
            keysObjects.remove(poppedEdge.node);

            mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
            totalWeight += poppedEdge.weight;
            //인접 간선정보
            linkedEdges = graph.get(poppedEdge.node);
            for (String adjacent: linkedEdges.keySet()) {
                if (keysObjects.containsKey(adjacent)) {
                    linkedEdge = keysObjects.get(adjacent);

                    //가중치 비교
                    if (linkedEdges.get(adjacent) < linkedEdge.weight) {
                        linkedEdge.weight = linkedEdges.get(adjacent);
                        mstPath.put(adjacent, poppedEdge.node);
                        //최소힙 유지
                        keys.remove(linkedEdge);
                        keys.add(linkedEdge);
                    }
                }
            }
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
