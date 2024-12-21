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

    public void dijkstra(Vertex startVertex, Vertex destinationVertex) {
        if (startVertex == null || destinationVertex == null) {
            return;
        }

        resetDistances();
        startVertex.distance = 0;

        while (true) {
            Vertex current = findMinDistance(); 
            if (current == null || current == destinationVertex) {
                break;
            }

            current.visited = true;
            EdgeList.Edge neighbor = current.edge.head;
            while (neighbor != null) {
                if (!neighbor.destination.visited) {
                    int newDistance = current.distance + neighbor.jarak;
                    if (newDistance < neighbor.destination.distance) {
                        neighbor.destination.distance = newDistance;
                        neighbor.destination.previousVertex = current;
                    }
                }
                neighbor = neighbor.next;
            }
        }

        printPath(startVertex, destinationVertex);
    }

    public void printPath(Vertex startVertex, Vertex destinationVertex) {
        System.out.println(
                "Jalur Tercepat Dari " + startVertex.kelurahan + " Menuju " + destinationVertex.kelurahan + ":");

        if (destinationVertex.previousVertex == null) {
            System.out.println("Tidak ada jalur yang tersedia.");
            return;
        }
        
        Vertex current = destinationVertex;
        StringBuilder path = new StringBuilder();
        int totalDistance = current.distance;

        while (current != null) {
            path.insert(0, current.kelurahan + (current == startVertex ? "" : " -> "));
            current = current.previousVertex;
        }

        System.out.println(path);
        System.out.println("Total jarak: " + totalDistance + " km");
    }

    public Vertex findMinDistance() {
        Vertex minVertex = null;
        int minDistance = Integer.MAX_VALUE;

        Vertex current = head;
        while (current != null) {
            if (!current.visited && current.distance < minDistance) {
                minDistance = current.distance;
                minVertex = current;
            }
            current = current.next;
        }

        return minVertex;
    }
    public void displayWithStack(Vertex startVertex) {
        if (startVertex == null) {
            return;
        }
        resetVisited();
        Stack stack = new Stack();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Vertex current = (Vertex) stack.pop();
            if (!current.visited) {
                current.visited = true;
                System.out.print(current.kelurahan + " -> ");

                EdgeList.Edge edge = current.edge.head;
                while (edge != null) {
                    if (!edge.destination.visited) {
                        stack.push(edge.destination);
                    }
                    edge = edge.next;
                }
            }
        }
        System.out.println("Selesai.");
    }
    
 public void displayWithQueue(Vertex startVertex) {
        if (startVertex == null) {
            return;
        }
        resetVisited();
        Queue queue = new Queue();
        queue.enqueue(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = (Vertex) queue.dequeue();
            if (!current.visited) {
                current.visited = true;
                System.out.print(current.kelurahan + " -> ");

                EdgeList.Edge edge = current.edge.head;
                while (edge != null) {
                    if (!edge.destination.visited) {
                        queue.enqueue(edge.destination);
                    }
                    edge = edge.next;
                }
            }
        }
    }
}
