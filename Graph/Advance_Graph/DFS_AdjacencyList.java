import java.util.*;

public class DFS_AdjacencyList {
    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int dfs(Map<Integer, List<Edge>> graph, int start, int n) {
        int count = 0;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            count++;
            List<Edge> edges = graph.get(node);
            if (edges != null) {
                for (Edge edge : edges) {
                    if (!visited[edge.to]) {
                        stack.push(edge.to);
                        visited[edge.to] = true;
                    }
                }
            }
        }
        return count;// no. of nodes in the component
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Edge(0, 1, 4), new Edge(0, 2, 5)));
        graph.put(1, Arrays.asList(new Edge(1, 0, 4), new Edge(1, 2, -2), new Edge(1, 3, 6)));
        graph.put(2, Arrays.asList(new Edge(2, 0, 5), new Edge(2, 1, -2), new Edge(2, 3, 1)));
        graph.put(3, Arrays.asList(new Edge(3, 1, 6), new Edge(3, 2, 1)));
        graph.put(4, Arrays.asList(new Edge(4, 1, 6)));
        System.out.println(dfs(graph, 0, 5));
    }

}
