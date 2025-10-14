import java.util.Scanner;

public class Menu {
    private SnackMachine machine;
    private Scanner scanner;

    public Menu() {
        machine = new SnackMachine();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;

        do {
            System.out.println("\n==== SNACK MACHINE ====");
            System.out.println("1. Lihat daftar snack");
            System.out.println("2. Tambahkan snack baru");
            System.out.println("3. Masukkan uang");
            System.out.println("4. Beli snack");
            System.out.println("5. Lihat saldo user");
            System.out.println("6. Admin Mode");
            System.out.println("7. Kembalikan saldo user");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    machine.displaySnacks();
                    break;
                case 2:
                    addSnackMenu();
                    break;
                case 3:
                    insertMoneyMenu();
                    break;
                case 4:
                    purchaseMenu();
                    break;
                case 5:
                    System.out.println("Saldo user: " + machine.getUserBalance());
                    break;
                case 6:
                    adminMenu();
                    break;
                case 7:
                    int refund = machine.returnUserBalance();
                    System.out.println("Saldo " + refund + " dikembalikan ke user.");
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan MonsterMart SnackMachine!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (choice != 0);
    }

    // ==========================
    //        USER MENU
    // ==========================

    private void addSnackMenu() {
        System.out.print("Nama snack: ");
        String nama = scanner.nextLine();
        System.out.print("Kategori: ");
        String kategori = scanner.nextLine();
        System.out.print("Harga: ");
        int harga = Integer.parseInt(scanner.nextLine());
        System.out.print("Stok: ");
        int stok = Integer.parseInt(scanner.nextLine());

        machine.addSnack(nama, kategori, harga, stok);
        System.out.println("Snack berhasil ditambahkan.");
    }

    private void insertMoneyMenu() {
        System.out.print("Masukkan jumlah uang: ");
        int amount = Integer.parseInt(scanner.nextLine());
        String result = machine.insertMoney(amount);
        System.out.println(result);
    }

    private void purchaseMenu() {
        machine.displaySnacks();
        System.out.print("Pilih nomor snack yang ingin dibeli: ");
        int index = Integer.parseInt(scanner.nextLine());
        String result = machine.purchaseSnack(index);
        System.out.println(result);
    }

    // ==========================
    //        ADMIN MODE
    // ==========================

    private void adminMenu() {
        System.out.print("\nMasukkan password admin: ");
        String password = scanner.nextLine();

        // Simple authentication (bisa kamu ubah nanti)
        if (!password.equals("admin123")) {
            System.out.println("Password salah! Kembali ke menu utama.");
            return;
        }

        int choice;
        do {
            System.out.println("\n==== ADMIN MODE ====");
            System.out.println("1. Lihat log transaksi");
            System.out.println("2. Restock snack");
            System.out.println("3. Lihat saldo mesin");
            System.out.println("0. Keluar admin mode");
            System.out.print("Pilih menu: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    machine.displayLogs();
                    break;
                case 2:
                    restockMenu();
                    break;
                case 3:
                    System.out.println("Saldo mesin: " + machine.getMachineBalance());
                    break;
                case 0:
                    System.out.println("Keluar dari admin mode.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);
    }

    private void restockMenu() {
        machine.displaySnacks();
        System.out.print("Masukkan nomor snack yang ingin diisi ulang: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan jumlah tambahan stok: ");
        int jumlah = Integer.parseInt(scanner.nextLine());

        String result = machine.restockSnack(index, jumlah);
        System.out.println(result);
    }
}