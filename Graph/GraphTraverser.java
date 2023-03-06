import java.util.*;
import java.util.Queue;
class GraphTraverser{
    public static void depthFirstTraversal(Vertex start,ArrayList<Vertex> visitedVertices){
        System.out.println(start.getData());

        for(Edge e:start.getEdges()){
            Vertex neighbour=e.getEnd();

            if(!visitedVertices.contains(neighbour)){
                visitedVertices.add(neighbour);
                GraphTraverser.depthFirstTraversal(neighbour,visitedVertices);
            }
        }
    }

    public static void breadthFirstSearch(Vertex start,ArrayList<Vertex> visitedVertices) {
        Queue visitQueue=new PriorityQueue<>();
        visitQueue.add(start);
        while(!visitQueue.isEmpty()){
            Vertex current = visitQueue.poll();
            System.out.println(current.getData());
            for(Edge e:current.getEdges()){
               Vertex neighbour= e.getEnd();
                if(!visitedVertices.contains(neighbour)){
                    visitedVertices.add(neighbour);
                    visitQueue.add(neighbour);
                }
            }
        }

        
    }
    public static void main(String ar[]){
        TestGraph test = new TestGraph();
        Vertex startingVertex=test.getStartingVertex();
        ArrayList<Vertex>  visitedVertices=new ArrayList<Vertex>();
        visitedVertices.add(startingVertex);
        GraphTraverser.depthFirstTraversal(startingVertex,visitedVertices);

        GraphTraverser.breadthFirstSearch(startingVertex,visitedVertices);

        
    }
}