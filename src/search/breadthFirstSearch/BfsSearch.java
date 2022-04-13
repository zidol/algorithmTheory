package search.breadthFirstSearch;

import java.util.*;

public class BfsSearch {

    public List<String> bfsFunc(Map<String, List<String>> graph, String startNode) {
        List<String> visited = new ArrayList<>();
        List<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);
        int count = 0;

        //방문할 노드가 있는지 체크
        while (needVisit.size() > 0) {
            count += 1;
            String node = needVisit.remove(0);

            //방문을 하지 않았다면
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        //간선 수 + 노드 수 만큼 while 수행
        System.out.println(count);
        return visited;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<String, List<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));
        BfsSearch bfsSearch = new BfsSearch();
        System.out.println(bfsSearch.bfsFunc(graph, "A"));
    }
}
