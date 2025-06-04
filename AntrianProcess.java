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

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Daftar Kendaraan dalam Antrian:");
            NodeAntrian current = front;
            int no = 1;
            while (current != null) {
                System.out.println("Kendaraan ke-" + no++);
                current.kendaraan.tampilkanInformasi();
                System.out.println();
                current = current.next;
            }
        }
    }

    public int jumlahAntrian() {
        return size;
    }
}
