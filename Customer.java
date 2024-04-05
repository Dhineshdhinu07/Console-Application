import java.util.Scanner;

public class Customer {
    String name;
    String address;
    String branch;
    String ifsc;
    double balance;
    String accountType;
    String pin = "1234"; // Default PIN

    public Customer() {
        setDetails("Dhinesh", "10/4, Pappanan nagar, Tiruppur", "Kongu Main Road", "KVB001234", 30000, "Savings");
    }

    public void setDetails(String name, String address, String branch, String ifsc, double balance, String accountType) {
        this.name = name;
        this.address = address;
        this.branch = branch;
        this.ifsc = ifsc;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void displayCustomerDetails() {
        System.out.println("Name: " + this.name + "\nAddress: " + this.address + "\nBranch: " + this.branch +
                           "\nIFSC: " + this.ifsc + "\nBalance: " + this.balance + "\nAccount Type: " + this.accountType);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("1--> Admin");
            System.out.println("2--> Customer");
            System.out.println("3--> Bank");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    admin();
                    break;
                case 2:
                    customer();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void admin() {
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Enter admin pin : ");
        String pin = sc.next();
        if (pin.equals(customer.pin)) {
            while (true) {
                System.out.println("1--> Customer Details");
                System.out.println("2--> Bank Details");
                System.out.println("3--> Amount Details");
                System.out.println("4--> Back");
                int c = sc.nextInt();
                switch (c) {
                    case 1:
                        customer.displayCustomerDetails();
                        break;
                    case 2:
                        System.out.println("Bank Details");
                        break;
                    case 3:
                        System.out.println("Amount Details");
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } else {
            System.out.println("Invalid pin. Access Denied");
        }
    }

    public static void customer() {
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Enter your PIN : ");
        String enteredPin = sc.next();
        if (enteredPin.equals(customer.pin)) {
            while (true) {
                System.out.println("-------WELCOME TO ATM-------");
                System.out.println("1--> Withdraw");
                System.out.println("2--> Deposit");
                System.out.println("3--> Balance");
                System.out.println("4--> Change PIN");
                System.out.println("5--> Exit");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        customer.withdraw(sc);
                        break;
                    case 2:
                        customer.deposit(sc);
                        break;
                    case 3:
                        customer.checkBalance();
                        break;
                    case 4:
                        customer.changePin(sc);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } else {
            System.out.println("Invalid PIN. Access Denied");
        }
    }

    public void withdraw(Scanner sc) {
        System.out.println("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance =balance - amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        }
    }

    public void deposit(Scanner sc) {
        System.out.println("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance=balance+ amount;
        System.out.println("Deposit successful. Updated balance: " + balance);
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void changePin(Scanner sc) {
        System.out.println("Enter new PIN: ");
        pin = sc.next();
        System.out.println("PIN changed successfully.");
    }
}
