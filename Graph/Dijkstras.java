import java.util.*;

public class Dijkstras{
    private static final double EPS = 1e-6;
    public static class Edge{
        double cost;
        int from ,to;
        public Edge(int from,int to,double cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }

    public static class Node{
        int id;
        double value;
        public Node(int id,double value){
            this.id=id;
            this.value=value;
        }
    }

    private int n;
    private double[] dist;
    private Integer[] prev;
    private List<List<Edge>> graph;

    private Comparator<Node> comparator=new Comparator<Node>(){
        public int compare(Node node1,Node node2){
            if(Math.abs(node1.value-node2.value)<EPS) return 0;
            return(node1.value -node2.value)>0?+1:-1;
        }
    };
    public Dijkstras(int n){
        this.n=n;
        createEmptyGraph();
    }
    public Dijkstras(int n,Comparator<Node> comparator){
        this(n);
        if(comparator==null) throw new IllegalArgumentException("Comparator cannot be null");
        this.comparator=comparator;
    }

    public void addEdge(int from,int to,int cost){
        graph.get(from).add(new Edge(from,to,cost));
    }

    public List<List<Edge>> getGraph(){
        return graph;
    }
    public List<Integer> reconstructPath(int start, int end) {
        if (end < 0 || end >= n) throw new IllegalArgumentException("Invalid node index");
        if (start < 0 || start >= n) throw new IllegalArgumentException("Invalid node index");
        double dist = dijkstra(start, end);
        List<Integer> path = new ArrayList<>();
        if (dist == Double.POSITIVE_INFINITY) return path;
        for (Integer at = end; at != null; at = prev[at]) path.add(at);
        Collections.reverse(path);
        return path;
      }
      public double dijkstra(int start, int end) {
        // Maintain an array of the minimum distance to each node
        dist = new double[n];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[start] = 0;
    
        // Keep a priority queue of the next most promising node to visit.
        PriorityQueue<Node> pq = new PriorityQueue<>(2 * n, comparator);
        pq.offer(new Node(start, 0));
    
        // Array used to track which nodes have already been visited.
        boolean[] visited = new boolean[n];
        prev = new Integer[n];
    
        while (!pq.isEmpty()) {
          Node node = pq.poll();
          visited[node.id] = true;
    
          // We already found a better path before we got to
          // processing this node so we can ignore it.
          if (dist[node.id] < node.value) continue;
    
          List<Edge> edges = graph.get(node.id);
          for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
    
            // You cannot get a shorter path by revisiting
            // a node you have already visited before.
            if (visited[edge.to]) continue;
    
            // Relax edge by updating minimum cost if applicable.
            double newDist = dist[edge.from] + edge.cost;
            if (newDist < dist[edge.to]) {
              prev[edge.to] = edge.from;
              dist[edge.to] = newDist;
              pq.offer(new Node(edge.to, dist[edge.to]));
            }
          }
          if (node.id == end) return dist[end];
        }
       
        return Double.POSITIVE_INFINITY;
      }
      private void createEmptyGraph() {
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
      }
    public static void main(String ar[]){
        Dijkstras dj=new Dijkstras(6);
        dj.addEdge(0,1,10);
        dj.addEdge(1,2,20);
        dj.addEdge(2,3,8);
        dj.addEdge(3,4,2);
        dj.addEdge(4,1,7);
        dj.addEdge(4,2,30);
        System.out.println(dj.dijkstra(3,4));
    }
}