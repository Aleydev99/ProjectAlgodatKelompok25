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
            Vertex current = findMinDistance(); // Tidak menggunakan array, iterasi langsung pada linked list
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

    private Vertex findMinDistance() {
        Vertex minVertex = null;
        int minDistance = Integer.MAX_VALUE;

        Vertex temp = head;
        while (temp != null) {
            if (!temp.visited && temp.distance < minDistance) {
                minDistance = temp.distance;
                minVertex = temp;
            }
            temp = temp.next;
        }
        return minVertex;
    }

    private void printPath(Vertex startVertex, Vertex destinationVertex) {
        System.out.println("Jalur Tercepat Dari " + startVertex.kelurahan + " Menuju " + destinationVertex.kelurahan + ":");

        // Mencari panjang jalur
        int pathLength = 0;
        Vertex current = destinationVertex;
        while (current != null) {
            pathLength++;
            current = current.previousVertex;
        }

        // Membentuk jalur sebagai linked list (bukan array)
        String path = "";
        current = destinationVertex;
        while (current != null) {
            path = current.kelurahan + (path.isEmpty() ? "" : " -> ") + path;
            current = current.previousVertex;
        }

        System.out.println(path + " -> Sampai");
        System.out.println("Total jarak: " + destinationVertex.distance + " km");
    }
    // Sorting kelurahan berdasarkan nama (Bubble Sort)
    public void sortVertices() {
        if (head == null || head.next == null) return;

        Vertex current = head;
        Vertex next;
        String tempName;

        // Bubble Sort
        while (current != null) {
            next = current.next;
            while (next != null) {
                if (current.kelurahan.compareTo(next.kelurahan) > 0) {
                    // Swap kelurahan
                    tempName = current.kelurahan;
                    current.kelurahan = next.kelurahan;
                    next.kelurahan = tempName;
                }
                next = next.next;
            }
            current = current.next;
        }
    }

    // Menampilkan kelurahan yang sudah diurutkan
    public void displaySortedVertices() {
        sortVertices(); // Mengurutkan kelurahan terlebih dahulu
        Vertex temp = head;
        while (temp != null) {
            System.out.print(temp.kelurahan + " -> ");
            temp = temp.next;
        }
        System.out.println("Selesai.");
    }
    
    public void resetVisited() {
        Vertex temp = head;
        while (temp != null) {
            temp.visited = false;
            temp = temp.next;
        }
    }

    // DFS (Depth-First Search) untuk menampilkan semua kelurahan
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

    // BFS (Breadth-First Search) untuk menampilkan semua kelurahan
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
        System.out.println("Selesai.");
    }
}


