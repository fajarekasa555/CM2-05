public class NodeAntrian {
    NodeAntrian next;
    Kendaraan kendaraan;

    public NodeAntrian(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
        this.next = null;
    }
}
