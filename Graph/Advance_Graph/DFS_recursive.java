import java.util.*;
public class DFS_recursive {
    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }
    
    public static long dfs(int curr, boolean visited[], Map<Integer, List<Edge>> graph) {
        if (visited[curr])
            return 0;
        visited[curr] = true;
        long count = 1;// count of nodes in the component
        List<Edge> edges = graph.get(curr);
        if (edges != null) {
            for (Edge edge : edges) {
                count += dfs(edge.to, visited, graph);
            }
        }
        return count;
    }
}
