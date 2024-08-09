import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        int target = n - 1;
        List<List<Integer>> result = new ArrayList<>();
        Deque<List<Integer>> queue = new ArrayDeque<>();
        queue.add(Arrays.asList(0));

        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int lastNode = path.get(path.size() - 1);

            if (lastNode == target) {
                result.add(new ArrayList<>(path));
            } else {
                for (int neighbor : graph[lastNode]) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }

        return result;
    }
}
