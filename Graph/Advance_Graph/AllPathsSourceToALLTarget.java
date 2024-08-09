import java.util.*;

class Solution {
    private int n;
    private Integer prev[];

    public List<List<Integer>> allPathsSourceToALLTarget(int[][] graph) {
        n = graph.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            List<Integer> path = path(0, i, graph);
            if (!path.isEmpty()) {
                result.add(path);
            }
        }
        return result;
    }

    public List<Integer> path(int start, int end, int[][] graph) {
        bfs(start, graph);
        List<Integer> path = new ArrayList<>();
        for (Integer curr = end; curr != null; curr = prev[curr]) {
            path.add(curr);
        }
        Collections.reverse(path);
        if (path.get(0) == start) {
            return path;
        }
        path.clear();
        return path;
    }

    public void bfs(int start, int[][] graph) {
        prev = new Integer[n];
        boolean visited[] = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int[] edges = graph[node];
            if (edges != null) {
                for (int i = 0; i < edges.length; i++) {
                    if (!visited[edges[i]]) {
                        queue.offer(edges[i]);
                        visited[edges[i]] = true;
                        prev[edges[i]] = node;
                    }
                }
            }
        }
    }
}
