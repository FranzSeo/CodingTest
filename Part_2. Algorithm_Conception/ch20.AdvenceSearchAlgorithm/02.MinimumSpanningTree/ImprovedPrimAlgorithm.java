import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ImprovedPrimAlgorithm {
    public static void main(String[] args) {
        ImprovedPrimAlgorithm prim = new ImprovedPrimAlgorithm();
        var result = prim.improvedPrimFunc(prim.getData(), "A");
        System.out.println(result);
    }

    public ArrayList<ImprovedPrimPath> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> gragh, String startNode) {
        ArrayList<ImprovedPrimPath> mst = new ArrayList<ImprovedPrimPath>();
        PriorityQueue<ImprovedPrimEdge> keys = new PriorityQueue<ImprovedPrimEdge>();
        HashMap<String, ImprovedPrimEdge> keysObjects = new HashMap<String, ImprovedPrimEdge>();
        HashMap<String, String> pi = new HashMap<String, String>();
        Integer totalWeight = 0;
        HashMap<String, Integer> linkedEdges;
        ImprovedPrimEdge edgeObject, poppedEdge, linkedEdge;

        for (String key : gragh.keySet()) {
            // Start Node >> Initial >> 0
            if (key == startNode) {
                edgeObject = new ImprovedPrimEdge(key, 0);
                pi.put(key, key);
            }
            // Other Nodes >> Initial >> infinity
            else {
                edgeObject = new ImprovedPrimEdge(key, Integer.MAX_VALUE);
                pi.put(key, null);
            }
            keys.add(edgeObject);
            keysObjects.put(key, edgeObject);
        }
        while (keys.size() > 0) {
            poppedEdge = keys.poll();
            keysObjects.remove(poppedEdge.node);

            mst.add(new ImprovedPrimPath(pi.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
            totalWeight += poppedEdge.weight;

            linkedEdges = gragh.get(poppedEdge.node);
            for (String adjacent : linkedEdges.keySet()) {
                linkedEdge = keysObjects.get(adjacent);
                pi.put(adjacent, poppedEdge.node);

                keys.remove(linkedEdge);
                keys.add(linkedEdge);
            }
        }
        System.out.println(totalWeight);
        return mst;
    }

    HashMap<String, HashMap<String, Integer>> getData() {
        HashMap<String, HashMap<String, Integer>> data = new HashMap<String, HashMap<String, Integer>>();

        HashMap<String, Integer> edges;
        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("D", 5);
        data.put("A", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        data.put("B", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 8);
        edges.put("E", 5);
        data.put("C", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        data.put("D", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        data.put("E", edges);

        edges = new HashMap<String, Integer>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        data.put("F", edges);

        edges = new HashMap<String, Integer>();
        edges.put("E", 9);
        edges.put("F", 11);
        data.put("G", edges);

        return data;
    }
}
