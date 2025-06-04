public class AntrianProcess {
    NodeKendaraan front, rear;
    NodeBBM headBBM;
    NodeTransaksi headTransaksi;
    int size;

    public AntrianProcess() {
        front = null;
        rear = null;
        size = 0;
        headBBM = null;
        headTransaksi = null;
    }

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(Kendaraan kendaraan) {
        NodeKendaraan newNode = new NodeKendaraan(kendaraan);
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
            NodeKendaraan current = front;
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

    public Kendaraan dequeue() {
        if (isEmpty()) {
            System.out.println("Tidak ada kendaraan dalam antrian.");
            return null;
        }
        Kendaraan dilayani = front.kendaraan;
        front = front.next;
        size--;
        if (front == null) rear = null;
        return dilayani;
    }

    void tambahTransaksiPengisian(Kendaraan kendaraan, String jenisBBM, int hargaPerLiter, int liter) {
        BBM bbm = new BBM(jenisBBM, hargaPerLiter);
        TransaksiPengisian transaksi = new TransaksiPengisian(kendaraan, bbm, liter);

        NodeBBM newBBM = new NodeBBM(bbm);
        if (headBBM == null) {
            headBBM = newBBM;
        }
        else {
            NodeBBM current = headBBM;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newBBM;
        }

        NodeTransaksi newTransaksi = new NodeTransaksi(transaksi);
        if (headTransaksi == null) {
            headTransaksi = newTransaksi;
        } else {
            NodeTransaksi current = headTransaksi;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTransaksi;
        }

        System.out.println(">> Transaksi Berhasil Dicatat.");
    }

    void tampilkanRiwayatTransaksi() {
        if (headTransaksi == null) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        NodeTransaksi current = headTransaksi;
        System.out.println("\n-- Riwayat Transaksi --");
        System.out.println("Daftar Transaksi :");
        while (current != null) {
            TransaksiPengisian transaksi = current.transaksi;
            System.out.println(transaksi.kendaraan.platNomor + "\t: Rp." + transaksi.totalBayar);
            current = current.next;
        }
    }
}
