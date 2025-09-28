public class Main {
    public static void main(String[] args) {
        LocalDB db = new LocalDB();
        Menu menu = new Menu(db);
        menu.showMenu();
    }
}
