import java.awt.*;

public class Ball {
    
    int x, y;
    int xVelocity = 3; // Kecepatan horizontal
    int yVelocity = 3; // Kecepatan vertikal
    int diameter = 30;
    
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Menggambar bola sebagai lingkaran putih
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }
    
    // Memperbarui posisi dan menangani pantulan
    public void move() {
        x += xVelocity;
        y += yVelocity;
        
        // Logika pantulan atas/bawah
        // y <= 0 (Batas atas)
        // y >= GamePanel.GAME_HEIGHT - diameter (Batas bawah)
        if (y <= 0 || y >= GamePanel.GAME_HEIGHT - diameter) {
            yVelocity = -yVelocity; // Membalikkan arah vertikal
        }
        
        // CATATAN: Logika tabrakan dengan Paddle dan penghitungan skor belum ada di kode ini.
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }
}