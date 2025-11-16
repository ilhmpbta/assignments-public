import java.util.List;
/**
 * Subclass Rabbit
 * Rabbit adalah subclass dari hewan
 * 
 * @ilhmpbta
 * @20251116
 */
public class Rabbit extends Animal
{
    public Rabbit(Field field, Location location) {
        super(field, location);
    }
    
    @Override
    public void act(List<Animal> newAnimals) {
        if (isAlive()) {
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                setDead();
            }
        }
    }
}