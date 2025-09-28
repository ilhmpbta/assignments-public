public class Mahasiswa {
    public String nrp;
    public String nama;
    public int tier;
    public double ipk;
    public int sks_ambil;
    public int sks_batas;

    public Mahasiswa(String mynrp, String mynama, int mytier, double ipk){
        this.nrp = mynrp;
        this.nama = mynama;
        this.tier = mytier; 
        this.ipk = ipk;
        this.sks_ambil = 0;
        this.sks_batas = batas_sks(ipk);
    }

    public Mahasiswa(){
        this("null", "null", 1, 0);
    }

    public void dataMahasiswa() {
        System.out.println("NRP     : " + this.nrp);
        System.out.println("Nama    : " + this.nama);
        System.out.println("Status  : Mahasiswa Aktif S-" + this.tier);
        System.out.println("IPK     : " + this.ipk);
        System.out.println("SKS     : " + this.sks_ambil + " / " + this.sks_batas);
    }

    public int batas_sks (double ipk) {
        if (ipk >= 3.50) return 24;
        if (ipk >= 3.00) return 22;
        if (ipk >= 2.50) return 20;
        return 18;
    }
}
