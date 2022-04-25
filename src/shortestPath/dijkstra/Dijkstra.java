package shortestPath.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {

        Edge edgeNode, adjacentNode;
        // 우선순위 큐에서 꺼낸 거리
        int currentDistance;
        int distance;
        // 우선 순위에서 큐에서 꺼낸 노드 이름
        String currentNode;
        //근접 노드 가중치
        int weight;
        //근접 논드 명
        String adjacent;
        ArrayList<Edge> nodeList;
        //거리 저장 배열 초기화
        HashMap<String, Integer> distances = new HashMap<>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        //시작지점 노드와 distance(weight 저장)
        distances.put(start, 0);

        //인접한 노드 우선순위 큐(최소힙)
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        //우선순위 큐 데이터 초기화(처음 시작 노드)
        priorityQueue.add(new Edge(distances.get(start), start));


        //알고리즘
        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();        //시작 edge 정보 가져오기(데이터 불러오면서 큐에선 삭제)
            currentDistance = edgeNode.distance;    //큐에서 가져온 distance(weight)
            currentNode = edgeNode.vertex;          //큐에서 가져온 node 이름

            //큐에서 꺼낸 node의 distance가 거리저장배열(distances)에 해당하는 노드의 distance보다 크면 변경할 필요 없으므로, 다음 단계 거치지 않고 continue
            if (distances.get(currentNode) < currentDistance) {
                continue;
            }
            //근접한 노드(엣지)들
            nodeList = graph.get(currentNode);
            //근접 Node들 순회
            for (Edge edge : nodeList) {

                //근접한 노드(엣지) 정보
                adjacentNode = edge;
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;

                distance = currentDistance + weight;

                //거리 저장 배열(distances)에 있는 노드 distance 값과 비교
                if (distance < distances.get(adjacent)) {
                    //distances의 해당하는 노드 값 교체
                    distances.put(adjacent, distance);
                    //우선순위 큐에 넣기
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        Dijkstra dijkstra = new Dijkstra();
        System.out.println(dijkstra.dijkstraFunc(graph, "A"));


    }
}
