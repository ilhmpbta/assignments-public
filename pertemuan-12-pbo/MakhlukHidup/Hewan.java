/**
 * Abstract class hewan (subMakhlukHidup)
 *
 * @ilhmpbta
 * @20251116
 */
public abstract class Hewan extends MakhlukHidup
{
    public Hewan (String nama) {
        super(nama);
    }
    
    public abstract void move();
}