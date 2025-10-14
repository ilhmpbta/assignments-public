import java.util.Scanner;
import java.util.Stack;

public class SnackMachine {
    public Inventory inventory;
    public Logger logger;
    public int userBalance;
    public int machineBalance;

    public SnackMachine() {
        inventory = new Inventory(10);
        logger = new Logger();
        inventory.addSnack("Chitato", "Keripik", 5000, 10);
        inventory.addSnack("Coca-Cola", "Minuman", 7000, 15);
        inventory.addSnack("SilverQueen", "Coklat", 12000, 5);
        inventory.addSnack("Tango", "Biskuit", 4000, 20);
        inventory.addSnack("Mie Sedaap", "Mie Instan", 3000, 25);
        userBalance = 0;
        machineBalance = 0;
    }

    public void addSnack(String nama, String kategori, int harga, int stok) {
        inventory.addSnack(nama, kategori, harga, stok);
        logger.log("Snack ditambahkan: " + nama + ", Kategori: " + kategori + ", Harga: " + harga + ", Stok: " + stok);
    }

    public String insertMoney(int amount) {
        if (amount > 0) {
            userBalance += amount;
            logger.log("Saldo user ditambahkan: " + amount + ". Saldo sekarang: " + userBalance);
            return "Jumlah uang yang dimasukkan: " + amount + ". Saldo sekarang: " + userBalance;
        } else {
            return "Jumlah uang tidak valid!";
        }
    }

    public String purchaseSnack(int index) {
        index -= 1;
        inventory.buySnack(index);
        if (inventory.snacks[index] != null) {
            if (userBalance < inventory.snacks[index].harga) {
                return "Saldo tidak cukup!";
            }

            if (inventory.snacks[index].stok < 0) {
                return "Stok habis!";
            }

            userBalance -= inventory.snacks[index].harga;
            machineBalance += inventory.snacks[index].harga;
            logger.log("Snack " + inventory.snacks[index].nama + " dibeli. Sisa stok: " + inventory.snacks[index].stok);
            return "Berhasil membeli " + inventory.snacks[index].nama + ". Sisa saldo: " + userBalance;
        } else {
            return "Gagal membeli snack.";
        }
    }

    public String restockSnack(int index, int additionalStock) {
        index -= 1;
        inventory.restockSnack(index, additionalStock);

        if (inventory.snacks[index] != null) {
            logger.log("Snack " + inventory.snacks[index].nama + " diisi ulang. Stok baru: " + inventory.snacks[index].stok);
            return "Snack " + inventory.snacks[index].nama + " diisi ulang. Stok baru: " + inventory.snacks[index].stok;
        } else {
            return "Gagal mengisi ulang snack.";
        }
    }

    public void displaySnacks() {
        inventory.displaySnacks();
    }

    public void displayLogs() {
        logger.displayLogs();
    }

    public int getUserBalance() {
        return userBalance;
    }

    public int returnUserBalance() {
        int balanceToReturn = userBalance;
        userBalance = 0;
        logger.log("Saldo user dikembalikan: " + balanceToReturn);
        return balanceToReturn;
    }

    public int getMachineBalance() {
        return machineBalance;
    }
    
    
}
