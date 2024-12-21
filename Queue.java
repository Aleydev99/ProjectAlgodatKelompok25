public class Queue {
    private Node front, rear;

    private class Node {
        Vertex vertex;
        Node next;

        public Node(Vertex vertex) {
            this.vertex = vertex;
            this.next = null;
        }
    }

    public void enqueue(Vertex vertex) {
        Node newNode = new Node(vertex);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Vertex dequeue() {
        if (front == null)
            return null;
        Vertex vertex = front.vertex;
        front = front.next;
        if (front == null)
            rear = null;
        return vertex;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
