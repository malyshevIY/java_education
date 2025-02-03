package bankTerminal;

public class DebitCards {
    private String cardNumber;
    private double balance;
    private BankAccounts bankAccounts;

    public DebitCards(BankAccounts bankAccounts, String cardNumber) {
        this.bankAccounts = bankAccounts;
        this.cardNumber = cardNumber;
        this.balance = 0.00;
    }

    public double getBalance() {
        return balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void checkBalance() {
        System.out.println("Balance for debit card " + cardNumber + " = " + balance);
    }

    public void deposit(double amount) {
        boolean isNotNegative = true;
        while (isNotNegative) {
            if (amount <= 0) {
                System.out.println("The amount must be greater than 0!, please try again");
            } else {
                balance += amount;
                isNotNegative = false;
            }
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) { // Проверка на снятие суммы, превышающей текущий баланс
            System.out.println("The amount must be less than the balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn from balance " + amount + ". Current balance = " + balance);
        }
    }

    @Override
    public String toString() {
        return "DebitCards{" +
            "cardNumber=" + cardNumber +
            ", amount=" + balance +
            ", bankAccounts=" + bankAccounts +
            '}';
    }
}
