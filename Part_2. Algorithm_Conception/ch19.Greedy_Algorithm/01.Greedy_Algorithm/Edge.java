public class Edge implements Comparable<Edge> {
    public Integer distance;
    public String vertex;

    public Edge(Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }
}
