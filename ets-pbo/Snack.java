public class Snack {
    public String nama;
    public String kategori;
    public int harga;
    public int stok;

    public Snack(String nama, String kategori, int harga, int stok) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    @Override
    public String toString() {
        return nama + " | " + kategori + " | " + stok + " | " + harga;
    }
}
