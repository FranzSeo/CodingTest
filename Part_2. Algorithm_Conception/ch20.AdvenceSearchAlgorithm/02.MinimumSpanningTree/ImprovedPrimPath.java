public class ImprovedPrimPath {
    public String node1;
    public String node2;
    public int weight;

    public ImprovedPrimPath(String node1, String node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ImprovedPrimPath{" + "node1='" + node1 + '\'' + ", node2='" + node2 + '\'' + ", weight=" + weight + '}';
    }
}
