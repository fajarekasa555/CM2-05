public class NodeKendaraan {
    NodeKendaraan next;
    Kendaraan kendaraan;

    public NodeKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
        this.next = null;
    }
}
