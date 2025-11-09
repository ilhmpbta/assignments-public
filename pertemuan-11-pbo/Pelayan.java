public class Pelayan extends Personil {
    private String shift;

    public Pelayan(String nama, String kontak, String shift) {
        super(nama, kontak);
        this.shift = shift;
    }

    public String getShift() { return shift; }
}
