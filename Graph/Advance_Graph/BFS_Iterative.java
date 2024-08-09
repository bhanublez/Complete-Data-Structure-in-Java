import java.util.*;

public class BFS_Iterative {
    public static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }

    private int n;
    private Integer[] prev;// to store the parent of each node (taki shortest path nikal sake)
    private List<List<Edge>> graph;

    public BFS_Iterative(List<List<Edge>> graph) {
        if (graph == null)
            throw new IllegalArgumentException("Graph can not be null");
        n = graph.size();
        this.graph = graph;
    }

    public List<Integer> path(int start, int end) {
        bfs(start);
        List<Integer> path = new ArrayList<>();
        for (Integer curr = end; curr != null; curr = prev[curr]) {
            path.add(curr);
        }
        Collections.reverse(path);
        if (path.get(0) == start)
            return path;
        path.clear();
        return path;
    }

    public void bfs(int start) {
        prev = new Integer[n];
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>(n);
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Edge> edges = graph.get(node);
            if (edges != null) {
                for (Edge edge : edges) {
                    if (!visited[edge.to]) {
                        queue.offer(edge.to);
                        visited[edge.to] = true;
                        prev[edge.to] = node;
                    }
                }
            }
        }
    }

    public static List<List<Edge>> createGraph(int n) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        return graph;
    }
    
    public static void main(String[] args) {
        List<List<Edge>> graph = createGraph(5);
        graph.get(0).add(new Edge(0, 1, 4));
        graph.get(0).add(new Edge(0, 2, 5));
        graph.get(1).add(new Edge(1, 0, 4));
        graph.get(1).add(new Edge(1, 2, -2));
        graph.get(1).add(new Edge(1, 3, 6));
        graph.get(2).add(new Edge(2, 0, 5));
        graph.get(2).add(new Edge(2, 1, -2));
        graph.get(2).add(new Edge(2, 3, 1));
        graph.get(3).add(new Edge(3, 1, 6));
        graph.get(3).add(new Edge(3, 2, 1));
        graph.get(4).add(new Edge(4, 1, 6));
        BFS_Iterative bfs = new BFS_Iterative(graph);
        System.out.println(bfs.path(0, 3));
    }


}
