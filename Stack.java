public class Stack {
    private Node top;

    private class Node {
        Vertex vertex;
        Node next;

        public Node(Vertex vertex) {
            this.vertex = vertex;
            this.next = null;
        }
    }

    public void push(Vertex vertex) {
        Node newNode = new Node(vertex);
        newNode.next = top;
        top = newNode;
    }

    public Vertex pop() {
        if (top == null)
            return null;
        Vertex vertex = top.vertex;
        top = top.next;
        return vertex;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
