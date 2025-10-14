
/**
* Create a machine that issues tickets of the given price.
* Note that the price must be greater than zero
*/

public class ticketMachine
{
    private int price;
    private int balance;
    @SuppressWarnings("unused")
    private int total;

    public ticketMachine(int cost) {
        price = cost;
        balance = 0;
        total = 0;
    }

    public int getPrice() {
        return price;
    }

    public int getBalance() {
        return balance;
    }

    public void insertMoney(int amount) {
        if (amount > 0) balance += amount;
        else {
            System.out.println("Insert a positive amount, (" + amount + " is invalid");            
        }
    }

    public void printTicket() {
        if (balance >= price) {
            System.out.println("#####################");
            System.out.println("# The BlueJ line");
            System.out.println("#    Ticket");
            System.out.println("# " + price + " cents");
            System.out.println("#####################");
            
            total += price;
            balance -= price;
        }
        else System.out.println("You need to insert at least: " + (price - balance) + " more cents");
    }
    
    public int refundBalance() {
        int amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}