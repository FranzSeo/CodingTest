import java.util.*;

public class DijkstraPath {

    public static void main(String[] args) {
        DijkstraPath obj = new DijkstraPath();
        HashMap<String, Integer> result
                = obj.dijkstraPath(obj.createGraph(), "A");
        System.out.println(result);
    }

    public HashMap<String, Integer> dijkstraPath(HashMap<String, ArrayList<Edge>> graph, String start) {
        HashMap<String, Integer> distances = new HashMap<>();
        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, distance, weight;
        String currentNode, adjacent;

        // 초기화
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distances.get(start), start));

        // 로직
        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }

            nodeList = graph.get(currentNode);
            for (int i = 0; i < nodeList.size(); i++) {
                adjacentNode = nodeList.get(i);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;

                distance = currentDistance + weight;

                if (distance < distances.get(adjacent)){
                    distances.put (adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }

        // 반환
        return distances;

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

    public void getNodeList(String vertex, HashMap<String, ArrayList<Edge>> graph) {
        ArrayList<Edge> nodeList = graph.get(vertex);
        for (int i = 0; i < nodeList.size(); i++) {
            System.out.println(nodeList.get(i));
        }
    }
}
