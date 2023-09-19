import java.util.*;

public class KruskalAlgorithm {
    HashMap<String, String> parent = new HashMap<String, String>();
    HashMap<String, Integer> rank = new HashMap<String, Integer>();

    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<KruskalEdge> edges = new ArrayList<>();
        KruskalAlgorithm algorithm = new KruskalAlgorithm();
        //System.out.println(algorithm.madeDataSet().toString());

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
        edges = kruskalAlgorithm.madeDataSet();

        System.out.println(kruskalAlgorithm.kruskalFunc(vertices, edges));
    }

    private String find(String node) {
        // path compression
        if (this.parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return this.parent.get(node);
    }


    private void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if (rank.get(root1) == rank.get(root2)) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    private void makeSet(String node){
        parent.put(node, node);
        rank.put(node, 0);
    }

    private ArrayList<KruskalEdge> kruskalFunc(ArrayList<String> vertices, ArrayList<KruskalEdge> edges){
        ArrayList<KruskalEdge> mst = new ArrayList<>();
        KruskalEdge currentNode;

        for (int index = 0; index <vertices.size(); index++){
            makeSet(vertices.get(index));
        }
        Collections.sort(edges);

        for (int index = 0; index < edges.size(); index++){
            currentNode = edges.get(index);
            if(find(currentNode.nodeV) != find(currentNode.nodeU)){
                union(currentNode.nodeV, currentNode.nodeU);
                mst.add(currentNode);
            }
        }
        return mst;
    }

    public ArrayList<KruskalEdge> madeDataSet() {
        ArrayList<KruskalEdge> edges = new ArrayList<>();
        edges.add(new KruskalEdge(7, "A", "B"));
        edges.add(new KruskalEdge(5, "A", "D"));
        edges.add(new KruskalEdge(7, "B", "A"));
        edges.add(new KruskalEdge(8, "B", "C"));
        edges.add(new KruskalEdge(9, "B", "D"));
        edges.add(new KruskalEdge(7, "B", "E"));
        edges.add(new KruskalEdge(8, "C", "B"));
        edges.add(new KruskalEdge(5, "C", "E"));
        edges.add(new KruskalEdge(5, "D", "A"));
        edges.add(new KruskalEdge(9, "D", "B"));
        edges.add(new KruskalEdge(7, "D", "E"));
        edges.add(new KruskalEdge(6, "D", "F"));
        edges.add(new KruskalEdge(7, "E", "B"));
        edges.add(new KruskalEdge(5, "E", "C"));
        edges.add(new KruskalEdge(7, "E", "D"));
        edges.add(new KruskalEdge(8, "E", "F"));
        edges.add(new KruskalEdge(9, "E", "G"));
        edges.add(new KruskalEdge(6, "F", "D"));
        edges.add(new KruskalEdge(8, "F", "E"));
        edges.add(new KruskalEdge(11, "F", "G"));
        edges.add(new KruskalEdge(9, "G", "E"));
        edges.add(new KruskalEdge(11, "G", "F"));
        return edges;
    }
}
