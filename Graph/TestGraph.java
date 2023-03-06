class TestGraph{
    private Graph TestGraph;
    public TestGraph(){
        this.TestGraph=new Graph(false,true);
        Vertex startNode=TestGraph.addVertex("1000");
        Vertex v1=this.TestGraph.addVertex("1001");
        Vertex v2=this.TestGraph.addVertex("1002");

        Vertex v11=this.TestGraph.addVertex("1011");
        Vertex v12=this.TestGraph.addVertex("1011");
        Vertex v21=this.TestGraph.addVertex("2001");

        Vertex v111=this.TestGraph.addVertex("1011");
        Vertex v112=this.TestGraph.addVertex("1012");
        Vertex v121=this.TestGraph.addVertex("1021");
        Vertex v211=this.TestGraph.addVertex("2011");

        this.TestGraph.addEdge(startNode,v1,null);
        this.TestGraph.addEdge(startNode,v2,null);

        this.TestGraph.addEdge(v1,v11,null);
        this.TestGraph.addEdge(v1,v12,null);
        this.TestGraph.addEdge(v2,v21,null);
        
        this.TestGraph.addEdge(v11,v111,null);
        this.TestGraph.addEdge(v11,v112,null);
        this.TestGraph.addEdge(v12,v121,null);
        this.TestGraph.addEdge(v21,v211,null);
        
        this.TestGraph.addEdge(v211,v2,null);
        
    }
    public Vertex getStartingVertex(){
        return this.TestGraph.getVertices().get(0);
    }
}