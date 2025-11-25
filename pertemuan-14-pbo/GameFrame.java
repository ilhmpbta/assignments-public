import javax.swing.*;

public class GameFrame extends JFrame {
    
    public GameFrame() {
        // Menambahkan panel game ke dalam frame
        this.add(new GamePanel());
        
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Method pack() menyesuaikan ukuran frame agar sesuai dengan komponen di dalamnya (GamePanel)
        this.pack(); 
        // Membuat jendela muncul di tengah layar
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
}