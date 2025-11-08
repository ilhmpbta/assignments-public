public class Menu {
    static SewaKendaraan sewaKendaraan = new SewaKendaraan(30);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Menu Sewa Kendaraan ===");
            System.out.println("1. Tampilkan Daftar Kendaraan");
            System.out.println("2. Hitung Total Sewa");
            System.out.println("3. Total Pendapatan");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    sewaKendaraan.tampilkanKendaraan();
                    break;
                case 2:
                sewaKendaraan.tampilkanKendaraan();
                System.out.print("Masukkan indeks kendaraan: ");
                    int indeks = scanner.nextInt() - 1;
                    System.out.print("Masukkan jumlah hari sewa: ");
                    int hari = scanner.nextInt();
                    int totalSewa = sewaKendaraan.hitungTotalSewa(indeks, hari);
                    System.out.println("Total Sewa: " + totalSewa);
                    System.out.println();
                    System.out.println("Receipt untuk penyewaan:");
                    System.out.println("Kendaraan: " + sewaKendaraan.getModelKendaraan(indeks));
                    System.out.println("Jumlah Hari: " + hari);
                    System.out.println("Total Sewa: " + totalSewa);
                    System.out.println();
                    break;
                case 3:
                    long totalPendapatan = sewaKendaraan.getTotalPendapatan();
                    System.out.println("Total Pendapatan: " + totalPendapatan);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            System.out.println();
        }
    }
}
