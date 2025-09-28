public class MataKuliah {
    public String nama;
    public String kode;
    public int sks;

    public MataKuliah(String mynama, String mykode, int sks) {
        this.nama = mynama;
        this.kode = mykode;
        this.sks = sks;
    }

    public MataKuliah() {
        this("null", "null", 0);
    }
}
