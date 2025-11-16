/**
 * Main class
 *
 * @ilhmpbta
 * @20251116
 */
public class Main
{
    public static void main(String[] args){
        // Manusia
        Manusia hokage = new Hokage("Naruto");
        hokage.breathe();
        hokage.grow();
        hokage.speak();
        
        // Hewan
        Hewan bijuu = new Bijuu("Kyuubi");
        bijuu.breathe();
        bijuu.grow();
        bijuu.move();
        
        // Tumbuhan
        Tumbuhan godTree = new GodTree("Shinju");
        godTree.breathe();
        godTree.grow();
        godTree.photosynthesis();
    }
}