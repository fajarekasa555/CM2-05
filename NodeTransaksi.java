public class NodeTransaksi {
    TransaksiPengisian transaksi;
    NodeTransaksi next;

    public NodeTransaksi(TransaksiPengisian transaksi) {
        this.transaksi = transaksi;
        this.next = null;
    }
}
