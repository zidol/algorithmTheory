package search.depthFirstSearch;

import search.breadthFirstSearch.BfsSearch;

import java.util.*;

public class DfsSearch {

    public List<String> dfsFunc(Map<String, List<String>> graph, String startNode) {
        List<String> visited = new ArrayList<>();
        List<String> needVisit = new ArrayList<>();
        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return  visited;
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
        DfsSearch dfsSearch = new DfsSearch();
        System.out.println(dfsSearch.dfsFunc(graph, "A"));
    }
}
