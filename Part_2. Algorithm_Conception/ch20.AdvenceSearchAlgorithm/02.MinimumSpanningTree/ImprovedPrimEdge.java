public class ImprovedPrimEdge implements Comparable<ImprovedPrimEdge> {
    public String node;
    public int weight;

    public ImprovedPrimEdge(String node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public String toString() {
        return "{" + this.node + " : " + this.weight + "}";
    }

    @Override
    public int compareTo(ImprovedPrimEdge o) {
        return this.weight - o.weight;
    }
}
