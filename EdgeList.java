public class EdgeList {
    Edge head;

    public class Edge {
        Vertex destination;
        int jarak;
        Edge next;

        public Edge(Vertex destination, int jarak) {
            this.destination = destination;
            this.jarak = jarak;
        }
    }
    public void addEdge(Vertex destination, int jarak) {
        Edge newEdge = new Edge(destination, jarak);
        if (head == null) {
            head = newEdge;
        } else {
            Edge temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newEdge;
        }
    }
}
