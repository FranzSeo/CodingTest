public class KruskalEdge implements Comparable<KruskalEdge> {

    public int weight;
    public String nodeV;
    public String nodeU;

    public KruskalEdge(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    @Override
    public String toString() {
        return "KruskalEdge{" +
                "weight=" + weight +
                ", nodeV='" + nodeV + '\'' +
                ", nodeU='" + nodeU + '\'' +
                '}';
    }

    @Override
    public int compareTo(KruskalEdge edge) {
        return this.weight - edge.weight;
    }

}
