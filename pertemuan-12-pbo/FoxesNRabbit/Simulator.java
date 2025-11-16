import java.util.ArrayList;
import java.util.List;
/**
 * Class Pendukung: Simulator
 * Simulator sebagai penguji/penggerak simulasi
 * 
 * @ilhmpbta
 * @20251116
 */
public class Simulator
{
    private Field field;
    private List<Animal> animals;
    
    public Simulator(int depth, int width){
        field = new Field(depth, width);
        animals = new ArrayList<>();
    }
    
    public void simulate(int steps) {
        for (int step = 0; step < steps; step++){
            List<Animal> newAnimals = new ArrayList<>();
            
            for (Animal animal: animals) {
                animal.act(newAnimals);
                if (!animal.isAlive()) animals.remove(animal);
            }
            animals.addAll(newAnimals);
        }
    }
    
    private void populate(){
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                double rand = Math.random();
                Location loc = new Location(row, col);
    
                if (rand < 0.08) {          // 8% chance fox
                    Fox fox = new Fox(field, loc);
                    animals.add(fox);
                } else if (rand < 0.18) {   // 10% chance rabbit
                    Rabbit rabbit = new Rabbit(field, loc);
                    animals.add(rabbit);
                } else {
                    // empty tile
                    field.clear(loc);
                }
            }
        }
    }
}