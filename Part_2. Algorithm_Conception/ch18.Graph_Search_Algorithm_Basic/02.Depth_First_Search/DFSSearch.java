import java.util.*;

public class DFSSearch {
    public static void main(String[] args) {
        DFSSearch dfsSearch = new DFSSearch();
        HashMap<String, ArrayList<String>> graphDFS = dfsSearch.testData();
        ArrayList<String> result = dfsSearch.searchDFS(graphDFS, "A");
        System.out.println(result);
    }

    public ArrayList<String> searchDFS(HashMap<String, ArrayList<String>> graphDFS, String startNode) {
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graphDFS.get(node));
            }
        }
        return visited;
    }

    public HashMap<String, ArrayList<String>> testData() {
        HashMap<String, ArrayList<String>> graphDFS = new HashMap<String, ArrayList<String>>();
        graphDFS.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graphDFS.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graphDFS.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graphDFS.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graphDFS.put("F", new ArrayList<String>(Arrays.asList("D")));
        graphDFS.put("E", new ArrayList<String>(Arrays.asList("D")));
        graphDFS.put("G", new ArrayList<String>(Arrays.asList("C")));
        graphDFS.put("H", new ArrayList<String>(Arrays.asList("C")));
        graphDFS.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graphDFS.put("J", new ArrayList<String>(Arrays.asList("I")));
        return graphDFS;
    }
}
