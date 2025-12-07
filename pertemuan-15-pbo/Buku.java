/**
 * Class buku untuk menyimpan informasi buku
 *
 * @ilhmpbta
 * @07122025
 */

public class Buku {
    private int id;
    private String judul;
    private String pengarang;

    public Buku(int id, String judul, String pengarang) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
    }

    public int getId() { return id; }
    public String getJudul() { return judul; }
    public String getPengarang() { return pengarang; }

    public void setJudul(String j) { judul = j; }
    public void setPengarang(String p) { pengarang = p; }
}
