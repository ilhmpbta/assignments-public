/**
 * Class Hokage (subManusia)
 *
 * @ilhmpbta
 * @20251116
 */
public class Hokage extends Manusia
{
    public Hokage (String nama) {
        super(nama);
    }
    
    @Override
    public void grow() {
        System.out.println(getName() + " sedang mengumpulkan chakra! khooo");
    }
    
    @Override
    public void speak() {
        System.out.println(getName() + " adalah hokage terbaik! dattebayo");
    }
}