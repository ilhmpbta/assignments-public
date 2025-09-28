public class Dosen {
    public String nidn;
    public String nama;
    public String lab;

    public Dosen(String mynidn, String mynama, String mylab) {
        this.nidn = mynidn;
        this.nama = mynama;
        this.lab = mylab;
    }

    public Dosen() {
        this("null", "null", "null");
    }

    public void dataDosen() {
        System.out.println("NIDN    : " + this.nidn);
        System.out.println("Nama    : " + this.nama);
        System.out.println("Lab     : " + this.lab);
    }
}
