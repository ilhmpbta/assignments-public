import java.util.Date;

public class Transaksi {
    private Personil penyewa;
    private Personil pelayan;
    private Kendaraan kendaraan;
    private int lamaSewa;
    private long totalBayar;
    private boolean lunas;
    private Date tanggalSewa;
    private Date tanggalPelunasan;

    public Transaksi(Personil penyewa, Personil pelayan, Kendaraan kendaraan, int lamaSewa, long totalBayar) {
        this.penyewa = penyewa;
        this.pelayan = pelayan;
        this.kendaraan = kendaraan;
        this.lamaSewa = lamaSewa;
        this.totalBayar = totalBayar;
        this.lunas = false;
        this.tanggalSewa = new Date();
        this.tanggalPelunasan = null;
    }

    public void setLunas(boolean lunas) {
        this.lunas = lunas;
    }

    public void setTanggalPelunasan(Date tanggalPelunasan) {
        this.tanggalPelunasan = tanggalPelunasan;
    }

    public boolean isLunas() {
        return lunas;
    }

    public String getNamaPenyewa() {
        return penyewa.getNama();
    }

    public String getModelKendaraan() {
        return kendaraan.getModel();
    }

    public Date getTanggalSewa() {
        return tanggalSewa;
    }

    @Override
    public String toString() {
        return "Penyewa: " + penyewa.getNama() +
               ", Pelayan: " + pelayan.getNama() +
               ", Kendaraan: " + kendaraan.getModel() + " (" + kendaraan.getMerk() + ")" +
               ", Lama Sewa: " + lamaSewa + " hari" +
               ", Total: Rp " + totalBayar +
               ", Status: " + (lunas ? "Lunas" : "Belum Lunas") +
               (lunas ? ", Tanggal Pelunasan: " + tanggalPelunasan : "");
    }
}
