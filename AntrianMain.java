import java.util.Scanner;

public class AntrianMain {
    public static void menu() {
        System.out.println("\n");
        System.out.println("--- Menu SPBU ---");
        System.out.println("1. Tambah Antrian Kendaraan");
        System.out.println("2. Tampilkan Antrian");
        System.out.println("3. Cek Jumlah Antrian Kendaraan");
        System.out.println("4. Layani Kendaraan");
        System.out.println("5. Tampilkan Riwayat Transaksi");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianProcess antrian = new AntrianProcess();
        int pilihan;
        do {
            menu();
            pilihan = sc.nextInt();
            sc.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor\t\t: ");
                    String platNomor = sc.nextLine();
                    System.out.print("Masukkan Jenis Kendaraan\t: ");
                    String tipe = sc.nextLine();
                    System.out.print("Masukkan Merk Kendaraan\t\t: ");
                    String merk = sc.nextLine();
                    Kendaraan kendaraan = new Kendaraan(platNomor, tipe, merk);
                    antrian.enqueue(kendaraan);
                    System.out.println(">> Kendaraan masuk ke dalam antrian");
                    break;
                case 2:
                    antrian.tampilkanAntrian();
                    break;
                case 3:
                    System.out.println(">> Jumlah Kendaraan dalam Antrian: " + antrian.jumlahAntrian());
                    break;
                case 4:
                    Kendaraan dilayani = antrian.dequeue();
                    if (dilayani != null) {
                        System.out.println(">> Melayani kendaraan dengan plat: " + dilayani.platNomor);
                        System.out.print("Masukkan Jenis BBM\t\t: ");
                        String bbm = sc.nextLine();
                        System.out.print("Masukkan Harga per Liter\t: ");
                        int harga = sc.nextInt();
                        System.out.print("Masukkan Jumlah Liter\t\t: ");
                        int liter = sc.nextInt(); sc.nextLine();
                        antrian.tambahTransaksiPengisian(dilayani, bbm, harga, liter);
                    }
                    break;
                case 5:
                    antrian.tampilkanRiwayatTransaksi();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan SPBU kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 0);
        sc.close();
    }
}
