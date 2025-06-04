public class Kendaraan {

    String platNomor;
    String tipe;
    String merk;

    public Kendaraan(String platNomor, String tipe, String merk) {
        this.platNomor = platNomor;
        this.tipe = tipe;
        this.merk = merk;
    }

    void tampilkanInformasi() {
        System.out.println("Plat Nomor\t: " + platNomor);
        System.out.println("Tipe\t\t: " + tipe);
        System.out.println("Merk\t\t: " + merk);
    }
}