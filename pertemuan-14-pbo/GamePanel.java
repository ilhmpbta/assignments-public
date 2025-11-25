import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    
    // Konstanta untuk ukuran area permainan
    static final int GAME_WIDTH = 800;
    static final int GAME_HEIGHT = 600;
    
    Thread gameThread;
    Image image;
    Graphics graphics;
    
    Paddle player1, player2;
    Ball ball;

    public GamePanel() {
        // Inisialisasi posisi Paddle (pemukul)
        player1 = new Paddle(0, (GAME_HEIGHT / 2) - 50, 1); // Kiri
        player2 = new Paddle(GAME_WIDTH - 20, (GAME_HEIGHT / 2) - 50, 2); // Kanan
        
        // Inisialisasi posisi Ball (bola)
        ball = new Ball((GAME_WIDTH / 2) - 15, (GAME_HEIGHT / 2) - 15);
        
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setFocusable(true);
        // Menambahkan KeyListener untuk menangani input keyboard
        this.addKeyListener(new AL()); 
        
        // Memulai thread untuk game loop
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    // Digunakan oleh Swing untuk menggambar komponen
    public void paint(Graphics g) {
        // Double buffering: menggambar ke image dulu, baru ditampilkan (untuk menghindari flickering)
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }
    
    // Method untuk menggambar semua objek game
    public void draw(Graphics g) {
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);
    }
    
    // Method untuk menggerakkan semua objek game
    public void move() {
        player1.move();
        player2.move();
        ball.move();
        checkCollision();
    }

    // Game loop yang berjalan di thread terpisah
    public void run() {
        // Game loop: diatur ke sekitar 60 frames per second (fps)
        double nsPerFrame = 1000000000 / 60.0;
        long lastTime = System.nanoTime();
        double delta = 0;
        
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerFrame;
            lastTime = now;
            
            while (delta >= 1) {
                // 1. Logika game (menggerakkan objek)
                move();
                // 2. Menggambar ulang (memanggil paint())
                repaint();
                delta--;
            }
        }
    }
    
    // Class internal untuk menangani input keyboard
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
            player2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
            player2.keyReleased(e);
        }
    }
    
    public void checkCollision() {
        // 1. Tabrakan dengan Paddle 1 (Kiri)
        if (ball.getBounds().intersects(player1.getBounds())) {
            ball.xVelocity = Math.abs(ball.xVelocity); // Memantul ke kanan
            // Opsional: tingkatkan kecepatan bola
        }
        
        // 2. Tabrakan dengan Paddle 2 (Kanan)
        if (ball.getBounds().intersects(player2.getBounds())) {
            ball.xVelocity = -Math.abs(ball.xVelocity); // Memantul ke kiri
            // Opsional: tingkatkan kecepatan bola
        }
    }
}