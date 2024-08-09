public class Edge<T extends Comparable<T>> {
    private Vertex start;
    private Vertex end;
    private T weight;

    public Edge(Vertex startv, Vertex endv, T inputweight) {
        this.start = startv;
        this.end = endv;
        this.weight = inputweight;
    }

    public Vertex getEnd() {
        return this.end;
    }

    public T getWeight() {
        return this.weight;
    }

    public Vertex getStart() {
        return this.start;
    }
}
