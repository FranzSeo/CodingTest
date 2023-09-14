import java.util.*;

public class DemoDijkstra {
    public static void main(String[] args) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

    }

    public HashMap<String, ArrayList<Edge>> createGraph() {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
        return graph;
    }

    public ArrayList<String> getKeys(HashMap<String, ArrayList<Edge>> testData) {
        ArrayList<String> keys = new ArrayList<>();

        for (String key : testData.keySet()) {
            System.out.println(key);
            keys.add(key);
            System.out.println(testData.get(key));
        }
        return keys;
    }
    public void getNodeList(String vertex, HashMap<String, ArrayList<Edge>> graph){
        ArrayList<Edge> nodeList = graph.get(vertex);
        for (int i = 0; i < nodeList.size(); i++){
            System.out.println(nodeList.get(i));
        }
    }
}
