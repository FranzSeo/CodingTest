import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimAlgorithm {
    public static void main(String[] args) {
        PrimAlgorithm prim = new PrimAlgorithm();
        ArrayList<PrimEdge> result = prim.primFunc("A",prim.madeDataSet());
        System.out.println(result);
    }

    public ArrayList<PrimEdge> primFunc(String startNode, ArrayList<PrimEdge> edges) {
        PrimEdge currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<PrimEdge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<PrimEdge> priorityQueue;

        ArrayList<String> connectedNodes = new ArrayList<String>();
        ArrayList<PrimEdge> mst = new ArrayList<PrimEdge>();
        // String -> node | ArrayList<PrimEdge> -> 간선의 목록
        HashMap<String, ArrayList<PrimEdge>> adjacentEdges = new HashMap<>();

        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<PrimEdge>());
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<PrimEdge>());
            }
        }
        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new PrimEdge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new PrimEdge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<PrimEdge>());

        priorityQueue = new PriorityQueue<PrimEdge>();
        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        while (priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if(!connectedNodes.contains(poppedEdge.node2)){
                connectedNodes.add(poppedEdge.node2);
                mst.add(new PrimEdge(poppedEdge.weight, poppedEdge.node1,poppedEdge.node2));

                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<PrimEdge>());
                for (int index = 0; index < adjacentEdgeNodes.size(); index++){
                    adjacentEdgeNode = adjacentEdgeNodes.get(index);
                    if(!connectedNodes.contains(adjacentEdgeNode.node2)){
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;
    }

    public ArrayList<PrimEdge> madeDataSet() {
        ArrayList<PrimEdge> edges = new ArrayList<>();
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
