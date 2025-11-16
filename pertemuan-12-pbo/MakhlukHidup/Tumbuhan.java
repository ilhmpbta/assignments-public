/**
 * Abstract class Tumbuhan (subMakhlukHidup)
 *
 * @ilhmpbta
 * @20251116
 */
public abstract class Tumbuhan extends MakhlukHidup 
{
    public Tumbuhan (String nama) {
        super(nama);
    }
    
    public abstract void photosynthesis();
}