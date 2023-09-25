import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimAlgorithm {
    public static void main(String[] args) {
        PrimAlgorithm primAlgorithm = new PrimAlgorithm();

    }
    public ArrayList<PrimEdge> primFunc(String startNode, ArrayList<PrimEdge> edges){
        PrimEdge currentNode, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<Edge> priorityQueue;

        ArrayList<String> connectedNodes = new ArrayList<String>();
        ArrayList<PrimEdge> mst = new ArrayList<PrimEdge>();
        HashMap<String, ArrayList<PrimEdge>> adjacentEdges = new HashMap<>();

        for (int i = 0; i <edges.size(); i++){
            currentNode = edges.get(i);
            if(!adjacentEdges.containsKey(currentNode.node1)){
                adjacentEdges.put(currentNode.node1, new ArrayList<PrimEdge>());
            }
            if(!adjacentEdges.containsKey(currentNode.node2)){
                adjacentEdges.put(currentNode.node2, new ArrayList<PrimEdge>());
            }
        }
        return mst;
    }

    public ArrayList<PrimEdge> madeDataSet() {
        ArrayList <PrimEdge> edges = new ArrayList<>();
        edges.add(new PrimEdge(7, "A", "B"));
        edges.add(new PrimEdge(5, "A", "D"));
        edges.add(new PrimEdge(8, "B", "C"));
        edges.add(new PrimEdge(9, "B", "D"));
        edges.add(new PrimEdge(7, "D", "E"));
        edges.add(new PrimEdge(5, "C", "E"));
        edges.add(new PrimEdge(7, "B", "E"));
        edges.add(new PrimEdge(6, "D", "F"));
        edges.add(new PrimEdge(8, "E", "F"));
        edges.add(new PrimEdge(9, "E", "G"));
        edges.add(new PrimEdge(11, "F", "G"));
        return edges;
    }
}
