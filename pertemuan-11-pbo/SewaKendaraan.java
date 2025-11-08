public class SewaKendaraan {
    private Kendaraan listKendaraan[];
    private int hargaSewaPerHari[];
    private int jumlahKendaraan;
    private long totalPendapatan;

    public void tambahKendaraan(Kendaraan kendaraan, int harga) {
        if (jumlahKendaraan < listKendaraan.length) {
            listKendaraan[jumlahKendaraan] = kendaraan;
            hargaSewaPerHari[jumlahKendaraan] = harga;
            jumlahKendaraan++;
        } else {
            System.out.println("Kapasitas penuh");
        }
    }
    
    public SewaKendaraan(int kapasitas) {
        listKendaraan = new Kendaraan[kapasitas];
        hargaSewaPerHari = new int[kapasitas];
        jumlahKendaraan = 0;
        totalPendapatan = 0;
        
        tambahKendaraan(new Mobil("Toyota", "Avanza", 2020, 4), 500000);
        tambahKendaraan(new Motor("Yamaha", "NMAX", 2021, 2), 200000);
        tambahKendaraan(new Sepeda("Polygon", "Hustle", 2019, "BMX"), 200000);
    }

    public void tampilkanKendaraan() {
        for (int i = 0; i < jumlahKendaraan; i++) {
            Kendaraan k = listKendaraan[i];
            System.out.println((i+1) + "  Merk: " + k.getMerk());
            System.out.println("  Model: " + k.getModel());
            System.out.println("  Tahun: " + k.getTahunProduksi());
            System.out.println("  Harga Sewa: " + hargaSewaPerHari[i]);
            System.out.println();
        }
    }

    public int hitungTotalSewa(int indeks, int hari) {
        if (indeks >= 0 && indeks < jumlahKendaraan) {
            totalPendapatan += hargaSewaPerHari[indeks] * hari;
            return hargaSewaPerHari[indeks] * hari;
        } else {
            System.out.println("Indeks kendaraan tidak valid");
            return 0;
        }
    }

    public int getJumlahKendaraan() {
        return jumlahKendaraan;
    }

    public long getTotalPendapatan() {
        return totalPendapatan;
    }

    public String getModelKendaraan(int indeks) {
        if (indeks >= 0 && indeks < jumlahKendaraan) {
            return listKendaraan[indeks].getModel();
        } else {
            return null;
        }
    }
}
