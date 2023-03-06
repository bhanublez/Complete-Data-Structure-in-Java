public class Edge{
    private Vertex start;
    private Vertex end;
    private Integer weight; 
    public Edge(Vertex startv,Vertex endv,Integer inputweight){
        this.start=startv;
        this.end=endv;
        this.weight=inputweight;
    }
     public Vertex getEnd(){
        return this.end;
     }

     public Integer getWeight(){
        return this.weight;
     }

     public Vertex getStart(){
        return this.start;
     } 
}