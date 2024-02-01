package BFS;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class IntQueue {

  private int[] ar;
  private int front, end, sz;

  public IntQueue(int max_sz) {
    front = end = 0;
    this.sz = max_sz + 1;
    ar = new int[sz];
  }

  public boolean isEmpty() {
    return front == end;
  }

  public int peek() {
    return ar[front];
  }

  public void enqueue(int value) {
    ar[end] = value;
    if (++end == sz) end = 0;
    if (end == front) throw new RuntimeException("Queue too small!");
  }

  public int dequeue() {
    int ret_val = ar[front];
    if (++front == sz) front = 0;
    return ret_val;
  }
}

public class BFSQueue {

  static class Edge {
    int from, to, cost;

    public Edge(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }
  }

  static int bfs(Map<Integer, List<Edge>> graph, int start, int n) {

    int count = 0;
    boolean[] visited = new boolean[n];
    IntQueue queue = new IntQueue(n + 1);

    int DEPTH_TOKEN = -1;

    queue.enqueue(start);
    queue.enqueue(DEPTH_TOKEN);
    visited[start] = true;

    while (true) {

      Integer node = queue.dequeue();

      if (node == DEPTH_TOKEN) {

        if (queue.isEmpty()) break;

        queue.enqueue(DEPTH_TOKEN);

      } else {

        count++;

        List<Edge> edges = graph.get(node);
        if (edges != null) {

          for (Edge edge : edges) {
            if (!visited[edge.to]) {
              visited[edge.to] = true;
              queue.enqueue(edge.to);
            }
          }
        }
      }
    }

    return count;
  }

  
  public static void main(String[] args) {

    
    int numNodes = 8;
    Map<Integer, List<Edge>> graph = new Hashtable<>();
    addDirectedEdge(graph, 1, 2, 1);
    addDirectedEdge(graph, 1, 2, 1); 
    addDirectedEdge(graph, 1, 3, 1);
    addDirectedEdge(graph, 2, 4, 1);
    addDirectedEdge(graph, 2, 5, 1);
    addDirectedEdge(graph, 3, 6, 1);
    addDirectedEdge(graph, 3, 7, 1);
    addDirectedEdge(graph, 2, 2, 1); 
    addDirectedEdge(graph, 2, 3, 1);
    addDirectedEdge(graph, 6, 2, 1);
    addDirectedEdge(graph, 1, 6, 1);

    long nodeCount = bfs(graph, 0, numNodes);
    System.out.println("DFS node count starting at node 0: " + nodeCount);

    nodeCount = bfs(graph, 2, numNodes);
    System.out.println("DFS node count starting at node 4: " + nodeCount);

    graph.clear();
    numNodes = 100;
    for (int i = 0; i < numNodes; i++)
      for (int j = 0; j < numNodes; j++) addDirectedEdge(graph, i, j, 1);

    nodeCount = bfs(graph, 6, numNodes);
    System.out.println("BFS node count starting at node 6: " + nodeCount);
    if (nodeCount != 100) System.err.println("Error with BFS");
  }

  private static void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost) {
    List<Edge> list = graph.get(from);
    if (list == null) {
      list = new ArrayList<Edge>();
      graph.put(from, list);
    }
    list.add(new Edge(from, to, cost));
  }
}
