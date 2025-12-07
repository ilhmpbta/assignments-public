import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Kelas Database untuk mengelola koneksi ke database MySQL
 *
 * @ilhmpbta
 * @07122025
 */

public class Database {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER); 
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            return null;
        }
    }
}
