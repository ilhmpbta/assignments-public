public class Inventory {
    public Snack[] snacks;
    public int count;

    public Inventory(int capacity) {
        snacks = new Snack[capacity];
        count = 0;
    }

    public void addSnack(String nama, String kategori, int harga, int stok) {
        if (count < snacks.length) {
            snacks[count] = new Snack(nama, kategori, harga, stok);
            count++;
        } else {
            System.out.println("Inventory penuh!");
        }
    }

    public void displaySnacks() {
        System.out.println("Daftar Snack:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + snacks[i].toString());
        }
    }

    public Snack buySnack(int index) {
        if (index >= 0 && index < count) {
            snacks[index].stok--;
            return snacks[index];
        } else {
            System.out.println("Indeks tidak valid!");
            return null;
        }
    }

    public Snack restockSnack(int index, int additionalStock) {
        if (index >= 0 && index < count) {
            snacks[index].stok += additionalStock;
            return snacks[index];
        } else {
            System.out.println("Indeks tidak valid!");
            return null;
        }
    }
}
