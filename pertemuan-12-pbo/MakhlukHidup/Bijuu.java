/**
 * Class Bijuu (subHewan)
 *
 * @ilhmpbta
 * @20251116
 */
public class Bijuu extends Hewan
{
    public Bijuu (String nama) {
        super(nama);
    }
    
    @Override
    public void grow(){
        System.out.println(getName() + " mengumpulkan chakra alamiah!");
    }
    
    @Override
    public void move(){
        System.out.println(getName() + " menggunakan tailed beast bomb!");
    }
}