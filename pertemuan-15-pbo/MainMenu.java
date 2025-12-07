import java.util.Scanner;

/**
 * Kelas MainMenu untuk menjalankan aplikasi perpustakaan sederhana
 *
 * @ilhmpbta
 * @07122025
 */

public class MainMenu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BukuDAO dao = new BukuDAO();

        while (true) {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Lihat semua buku");
            System.out.println("2. Tambah buku");
            System.out.println("3. Edit buku");
            System.out.println("4. Hapus buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            int pilih = in.nextInt();
            in.nextLine();

            switch (pilih) {
                case 1:
                    for (Buku b : dao.getAll()) {
                        System.out.println(b.getId() + ". " + b.getJudul() + " - " + b.getPengarang());
                    }
                    break;

                case 2:
                    System.out.print("Judul: ");
                    String j = in.nextLine();
                    System.out.print("Pengarang: ");
                    String p = in.nextLine();
                    dao.insert(new Buku(0, j, p));
                    break;

                case 3:
                    System.out.print("ID buku yang mau diubah: ");
                    int idu = in.nextInt();
                    in.nextLine();

                    System.out.print("Judul baru: ");
                    String j2 = in.nextLine();

                    System.out.print("Pengarang baru: ");
                    String p2 = in.nextLine();

                    dao.update(new Buku(idu, j2, p2));
                    break;

                case 4:
                    System.out.print("ID buku yang mau dihapus: ");
                    int idh = in.nextInt();
                    dao.delete(idh);
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}
