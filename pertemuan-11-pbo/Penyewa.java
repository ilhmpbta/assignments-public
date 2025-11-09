public class Penyewa extends Personil {
    private String noIdentitas;

    public Penyewa(String nama, String kontak, String noIdentitas) {
        super(nama, kontak);
        this.noIdentitas = noIdentitas;
    }

    public String getNoIdentitas() { return noIdentitas; }
}
