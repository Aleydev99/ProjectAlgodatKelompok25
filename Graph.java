public class Graph {
    Vertex head;

    public void addVertex(String kelurahan) {
        Vertex newVertex = new Vertex(kelurahan);
        if (head == null) {
            head = newVertex;
        } else {
            Vertex temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVertex;
        }
    }

    public void insertEdge(String sourceKelurahan, String destinationKelurahan, int jarak) {
        Vertex source = searchVertex(sourceKelurahan);
        Vertex destination = searchVertex(destinationKelurahan);

        if (source != null && destination != null) {
            source.addEdge(destination, jarak);
            destination.addEdge(source, jarak);
        }
    }

    public Vertex searchVertex(String kelurahan) {
        Vertex temp = head;
        while (temp != null) {
            if (temp.kelurahan.equals(kelurahan)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void resetDistances() {
        Vertex temp = head;
        while (temp != null) {
            temp.distance = Integer.MAX_VALUE;
            temp.previousVertex = null;
            temp.visited = false;
            temp = temp.next;
        }
    }
}
