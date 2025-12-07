import java.sql.*;
import java.util.ArrayList;

/**
 * Kelas BukuDAO untuk mengelola operasi database pada tabel buku
 *
 * @ilhmpbta
 * @07122025
 */

public class BukuDAO {

    public ArrayList<Buku> getAll() {
        ArrayList<Buku> list = new ArrayList<>();
        String sql = "SELECT * FROM buku";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Buku(
                    rs.getInt("id_buku"),
                    rs.getString("judul"),
                    rs.getString("pengarang")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error membaca: " + e.getMessage());
        }
        return list;
    }

    public void insert(Buku b) {
        String sql = "INSERT INTO buku (judul, pengarang) VALUES (?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPengarang());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Gagal insert: " + e.getMessage());
        }
    }

    public void update(Buku b) {
        String sql = "UPDATE buku SET judul=?, pengarang=? WHERE id_buku=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPengarang());
            ps.setInt(3, b.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Gagal update: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM buku WHERE id_buku=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Gagal delete: " + e.getMessage());
        }
    }
}
