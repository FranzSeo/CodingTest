import java.util.*;

public class BFSSearch {
    public static void main(String[] args) {
        BFSSearch bfsSearch = new BFSSearch();
        HashMap<String, ArrayList<String>> graphBFS = bfsSearch.testData();
        ArrayList<String> result = bfsSearch.searchBFS(graphBFS, "A");
        System.out.println(result);
    }

    public HashMap<String, ArrayList<String>> testData() {
        HashMap<String, ArrayList<String>> graphBFS = new HashMap<String, ArrayList<String>>();
        graphBFS.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graphBFS.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graphBFS.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graphBFS.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graphBFS.put("F", new ArrayList<String>(Arrays.asList("D")));
        graphBFS.put("E", new ArrayList<String>(Arrays.asList("D")));
        graphBFS.put("G", new ArrayList<String>(Arrays.asList("C")));
        graphBFS.put("H", new ArrayList<String>(Arrays.asList("C")));
        graphBFS.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graphBFS.put("J", new ArrayList<String>(Arrays.asList("I")));
        return graphBFS;
    }

    public ArrayList<String> searchBFS(HashMap<String, ArrayList<String>> graphBFS, String startNode) {
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(0);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graphBFS.get(node));
            }
        }
        return visited;
    }
}
