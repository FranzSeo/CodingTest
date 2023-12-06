public class PrimEdge implements Comparable<PrimEdge>{
    public int weight;
    public String node1;
    public String node2;
    public PrimEdge(int weight, String node1, String node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public String toString() {
        return "PrimEdge{" +
                "weight=" + weight +
                ", node1='" + node1 + '\'' +
                ", node2='" + node2 + '\'' +
                "}";
    }
    @Override
    public int compareTo(PrimEdge primEdge) {
        return this.weight - primEdge.weight;
    }
}
