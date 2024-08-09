import java.util.*;

public class TopologicalSort {
    static class Edge {
        int from, to, weight;

        public Edge(int f, int t, int w) {
            from = f;
            to = t;
            weight = w;
        }
    }

    public static int[] topologicalSort(Map<Integer, List<Edge>> graph, int n) {
        int[] ordering = new int[n];
        boolean[] visited = new boolean[n];
        int i = n - 1; // i is the index of the ordering array
        for (int at = 0; at < n; at++) {
            if (!visited[at]) {
                i = dfs(i, at, visited, ordering, graph);
            }
        }
        return ordering;
    }

    public static int dfs(int i, int at, boolean[] vis, int[] ord, Map<Integer, List<Edge>> graph) {
        vis[at] = true;
        List<Edge> edges = graph.get(at);
        if (edges != null) {
            for (Edge edge : edges) {
                if (!vis[edge.to]) {
                    i = dfs(i, edge.to, vis, ord, graph);
                }
            }
        }
        ord[i] = at; // Place the node in the correct position in the ordering array
        return i - 1; // Decrement i to place the next node at the correct index
    }

    public static Integer[] dagShortestPath(Map<Integer, List<Edge>> graph, int start, int n) {
        int[] toporder = topologicalSort(graph, n);
        Integer[] dist = new Integer[n];
        dist[start] = 0;
        for (int i = 0; i < n; i++) {
            int curr = toporder[i];
            if (dist[curr] != null) {
                List<Edge> edges = graph.get(curr);
                if (edges != null) {
                    for (Edge edge : edges) {
                        int newDist = dist[curr] + edge.weight;
                        if (dist[edge.to] == null) {
                            dist[edge.to] = newDist;
                        } else {
                            dist[edge.to] = Math.min(dist[edge.to], newDist);
                        }
                    }
                }
            }
        }
        return dist;
    }

    public static Integer[] dagLongestPath(Map<Integer, List<Edge>> graph, int start, int n) {
        Map<Integer, List<Edge>> negatedGraph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            negatedGraph.put(i, new ArrayList<>());
            List<Edge> edges = graph.get(i);
            if (edges != null) {
                for (Edge edge : edges) {
                    negatedGraph.get(i).add(new Edge(edge.from, edge.to, -edge.weight));
                }
            }
        }

        Integer[] negatedDistances = dagShortestPath(negatedGraph, start, n);

        Integer[] longestDistances = new Integer[n];
        for (int i = 0; i < n; i++) {
            if (negatedDistances[i] != null) {
                longestDistances[i] = -negatedDistances[i];
            }
        }

        return longestDistances;
    }

    public static void main(String[] args) {
        int n = 7;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        graph.get(0).add(new Edge(0, 1, 3));
        graph.get(0).add(new Edge(0, 2, 2));
        graph.get(0).add(new Edge(0, 5, 3));
        graph.get(1).add(new Edge(1, 3, 1));
        graph.get(1).add(new Edge(1, 2, 6));
        graph.get(2).add(new Edge(2, 3, 1));
        graph.get(2).add(new Edge(2, 4, 10));
        graph.get(3).add(new Edge(3, 4, 5));
        graph.get(5).add(new Edge(5, 4, 7));

        // Topological Order
        int[] ordering = topologicalSort(graph, n);
        System.out.print("Topological Order: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ordering[i] + " ");
        }
        System.out.println();

        // Shortest Path from node 0
        Integer[] dists = dagShortestPath(graph, 0, n);
        System.out.println("Shortest Distances from Node 0:");
        for (int i = 0; i < n; i++) {
            if (dists[i] != null) {
                System.out.println("Node " + i + ": " + dists[i]);
            } else {
                System.out.println("Node " + i + ": Unreachable");
            }
        }

        // Longest Path from node 0
        Integer[] longestDists = dagLongestPath(graph, 0, n);
        System.out.println("Longest Distances from Node 0:");
        for (int i = 0; i < n; i++) {
            if (longestDists[i] != null) {
                System.out.println("Node " + i + ": " + longestDists[i]);
            } else {
                System.out.println("Node " + i + ": Unreachable");
            }
        }
    }



}
