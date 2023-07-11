import java.util.*;

public class testDemo {
    public static void main(String[] args) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(2, "A"));
        priorityQueue.add(new Edge(5,"B"));
        priorityQueue.add(new Edge(1, "C"));
        priorityQueue.add(new Edge(7, "D"));
        System.out.println(priorityQueue);
        priorityQueue.peek();

        Edge edge1 = priorityQueue.poll();
        System.out.println(edge1);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.size());
    }
}