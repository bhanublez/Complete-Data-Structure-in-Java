import java.util.*;

public class Connected_Components {

    private final static int n = 18; // Number of nodes
    private boolean visited[];
    private List<List<Integer>> graph;
    private int compCount;
    private int components[];

    public Connected_Components(List<List<Integer>> graph) {
        this.graph = graph;
        this.visited = new boolean[n];
        this.components = new int[n];
    }

    public int[] getComponents() {
        solve();
        return components;
    }

    public void solve() {
        if (compCount != 0)
            return;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                compCount++;
                dfs(i);
            }
        }
    }

    public void dfs(int curr) {
        visited[curr] = true;
        components[curr] = compCount;
        for (int next : graph.get(curr)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        // A graph with 8 connected components
        List<List<Integer>> graph = createGraph(n);
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(5).add(6);
        graph.get(6).add(5);
        graph.get(7).add(8);
        graph.get(8).add(7);
        graph.get(9).add(10);
        graph.get(10).add(9);
        graph.get(11).add(12);
        graph.get(12).add(11);
        graph.get(13).add(14);
        graph.get(14).add(13);
        graph.get(15).add(16);
        graph.get(16).add(15);
        graph.get(17).add(16);
        graph.get(16).add(17);

        Connected_Components cc = new Connected_Components(graph);
        cc.solve();
        System.out.println(cc.compCount);
        System.out.println(Arrays.toString(cc.components));
    }

    private static List<List<Integer>> createGraph(int n) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        return graph;
    }
}
