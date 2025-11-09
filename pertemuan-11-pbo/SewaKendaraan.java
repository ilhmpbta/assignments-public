import java.util.*;

public class SewaKendaraan {
    private Kendaraan listKendaraan[];
    private int hargaSewaPerHari[];
    private int jumlahKendaraan;
    private long totalPendapatan;
    private List<Transaksi> daftarTransaksi = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public SewaKendaraan(int kapasitas) {
        listKendaraan = new Kendaraan[kapasitas];
        hargaSewaPerHari = new int[kapasitas];
        jumlahKendaraan = 0;
        totalPendapatan = 0;

        // contoh data
        tambahKendaraan(new Mobil("Toyota", "Avanza", 2020, 4), 500000);
        tambahKendaraan(new Motor("Yamaha", "NMAX", 2021, 2), 200000);
        tambahKendaraan(new Sepeda("Polygon", "Hustle", 2019, "BMX"), 100000);
    }

    public void tambahKendaraan(Kendaraan kendaraan, int harga) {
        if (jumlahKendaraan < listKendaraan.length) {
            listKendaraan[jumlahKendaraan] = kendaraan;
            hargaSewaPerHari[jumlahKendaraan] = harga;
            jumlahKendaraan++;
        } else {
            System.out.println("Kapasitas penuh.");
        }
    }

    public void tampilkanKendaraan() {
        System.out.println("\n=== Daftar Kendaraan ===");
        for (int i = 0; i < jumlahKendaraan; i++) {
            Kendaraan k = listKendaraan[i];
            System.out.println((i + 1) + ". " + k.getMerk() + " " + k.getModel() + " (" + k.getTahunProduksi() + ")");
            System.out.println("   Harga Sewa per Hari: Rp " + hargaSewaPerHari[i]);
        }
        System.out.println();
    }

    public int hitungTotalSewa(int indeks, int hari) {
        if (indeks >= 0 && indeks < jumlahKendaraan) {
            return hargaSewaPerHari[indeks] * hari;
        } else {
            System.out.println("Indeks kendaraan tidak valid.");
            return 0;
        }
    }

    public long getTotalPendapatan() {
        return totalPendapatan;
    }

    public void prosesSewa() {
        tampilkanKendaraan();
        System.out.print("Masukkan indeks kendaraan: ");
        int indeks = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indeks < 0 || indeks >= jumlahKendaraan) {
            System.out.println("Indeks kendaraan tidak valid.\n");
            return;
        }

        System.out.print("Masukkan nama penyewa: ");
        String namaPenyewa = scanner.nextLine();
        System.out.print("Masukkan kontak penyewa: ");
        String kontakPenyewa = scanner.nextLine();
        System.out.print("Masukkan nomor identitas penyewa: ");
        String idPenyewa = scanner.nextLine();
        Penyewa penyewa = new Penyewa(namaPenyewa, kontakPenyewa, idPenyewa);

        System.out.print("Masukkan nama pelayan: ");
        String namaPelayan = scanner.nextLine();
        System.out.print("Masukkan kontak pelayan: ");
        String kontakPelayan = scanner.nextLine();
        System.out.print("Masukkan shift pelayan: ");
        String shiftPelayan = scanner.nextLine();
        Pelayan pelayan = new Pelayan(namaPelayan, kontakPelayan, shiftPelayan);

        System.out.print("Masukkan jumlah hari sewa: ");
        int hari = scanner.nextInt();
        scanner.nextLine();

        long total = hitungTotalSewa(indeks, hari);
        Transaksi t = new Transaksi(penyewa, pelayan, listKendaraan[indeks], hari, total);
        daftarTransaksi.add(t);
        totalPendapatan += total;

        System.out.println("\n=== Receipt Penyewaan ===");
        System.out.println("Penyewa: " + penyewa.getNama());
        System.out.println("Kontak: " + penyewa.getKontak());
        System.out.println("Kendaraan: " + listKendaraan[indeks].getModel());
        System.out.println("Durasi: " + hari + " hari");
        System.out.println("Total: Rp " + total);
        System.out.println("Status: Belum Lunas\n");
    }

    public void tampilkanTransaksi() {
        System.out.println("\n=== Daftar Transaksi ===");
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.\n");
            return;
        }

        int i = 1;
        for (Transaksi t : daftarTransaksi) {
            System.out.println(i++ + ". Penyewa: " + t.getNamaPenyewa());
            System.out.println("   Kendaraan: " + t.getModelKendaraan());
            System.out.println("   Tanggal Sewa: " + t.getTanggalSewa());
            System.out.println("   Status: " + (t.isLunas() ? "Lunas" : "Belum Lunas"));
            System.out.println();
        }
    }

    public void prosesPelunasan() {
        tampilkanTransaksi();
        if (daftarTransaksi.isEmpty()) return;

        System.out.print("Masukkan nomor transaksi yang akan dilunasi: ");
        int indeks = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indeks < 0 || indeks >= daftarTransaksi.size()) {
            System.out.println("Nomor transaksi tidak valid.\n");
            return;
        }

        Transaksi t = daftarTransaksi.get(indeks);
        if (t.isLunas()) {
            System.out.println("Transaksi ini sudah lunas.\n");
        } else {
            t.setLunas(true);
            t.setTanggalPelunasan(new Date());
            System.out.println("Transaksi berhasil dilunasi.\n");
        }
    }
}
