import java.util.Scanner;

public class Menu {
    static SewaKendaraan sewaKendaraan = new SewaKendaraan(30);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Menu Sewa Kendaraan ===");
            System.out.println("1. Tampilkan Daftar Kendaraan");
            System.out.println("2. Proses Penyewaan");
            System.out.println("3. Tampilkan Transaksi");
            System.out.println("4. Proses Pelunasan");
            System.out.println("5. Total Pendapatan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> sewaKendaraan.tampilkanKendaraan();
                case 2 -> sewaKendaraan.prosesSewa();
                case 3 -> sewaKendaraan.tampilkanTransaksi();
                case 4 -> sewaKendaraan.prosesPelunasan();
                case 5 -> System.out.println("Total Pendapatan: Rp " + sewaKendaraan.getTotalPendapatan() + "\n");
                case 6 -> {
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.\n");
            }
        }
    }
}
