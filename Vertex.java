public class Vertex {
    String kelurahan;
    boolean visited = false;
    int distance = Integer.MAX_VALUE;
    Vertex previousVertex;
    Vertex next;

    public Vertex(String kelurahan) {
        this.kelurahan = kelurahan;
    }
    
}
