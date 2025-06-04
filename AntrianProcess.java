public class AntrianProcess {
    NodeAntrian front, rear;
    int size;

    public AntrianProcess() {
        front = null;
        rear = null;
        size = 0;
    }

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(Kendaraan kendaraan) {
        NodeAntrian newNode = new NodeAntrian(kendaraan);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

}
