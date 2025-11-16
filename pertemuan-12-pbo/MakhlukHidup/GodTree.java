/**
 * Class GodTree (subTumbuhan)
 *
 * @ilhmpbta
 * @20251116
 */
public class GodTree extends Tumbuhan
{
    public GodTree (String nama) {
        super(nama);
    }
    
    @Override
    public void grow(){
        System.out.println(getName() + " mengumpulkan chakra duniawi!");
    }
    
    @Override
    public void photosynthesis(){
        System.out.println(getName() + " berhasil menghasilkan chakra fruit!");
    }
}