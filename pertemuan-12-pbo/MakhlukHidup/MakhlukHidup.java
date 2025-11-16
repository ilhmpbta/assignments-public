/**
 * Abstract parent class (Makhluk Hidup)
 *
 * @ilhmpbta
 * @20251116
 */
public abstract class MakhlukHidup
{
    private String nama;
    
    public MakhlukHidup (String nama) {
        this.nama = nama;
    }
    
    public String getName() {
        return nama;
    }
    
    public void breathe() {
        System.out.println(nama + " sedang menggunakan hamon");
    }
    
    public abstract void grow();
}