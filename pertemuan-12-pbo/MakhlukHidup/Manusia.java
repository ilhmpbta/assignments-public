/**
 * Abstract class Manusia (sub MakhlukHidup)
 *
 * @ilhmpbta
 * @20251116
 */
public abstract class Manusia extends MakhlukHidup
{
    public Manusia (String nama) {
        super(nama);
    }
    
    public abstract void speak();
}