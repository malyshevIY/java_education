package bankTerminal;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.Scanner;

public class Terminal {
    static Random random = new Random();
    static BankAccounts currentBankAccount = null;
    static DebitCards currentDebitCard = null;
    static Scanner scanner = new Scanner(System.in);

    // Метод создания аккаунта
    public static BankAccounts createAccount() {
        System.out.println("Please enter yours name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please enter yours Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your Password: ");
        String password = scanner.nextLine();

        BankAccounts bankAccount = new BankAccounts
            (
                random.nextInt(10000),
                firstName,
                lastName,
                password
            );
        System.out.println("Account " + bankAccount.getId() +
            " for " + bankAccount.getFullName() + "  successfully created");
        return bankAccount;
    }

    // Создание дебетовой карты
    public static DebitCards createDebitCard(BankAccounts bankAccounts) {
        String cardNumber = RandomStringUtils.randomNumeric(11); // генерируем строку из случацных цифр
        System.out.println("The debit card " + cardNumber + " for "
            + bankAccounts.getFullName()
            + " successfully created");
        return new DebitCards(bankAccounts, cardNumber);
    }

    // Проверка баланаса карты
    public static void checkBalance(DebitCards debitCards) {
        if (debitCards == null) {
            System.out.println("Please create a debit card");
        } else
            debitCards.checkBalance();
    }

    // Внесение депозита
    public static void deposit(DebitCards debitCards) {
        if (debitCards == null) {
            System.out.println("Please create a debit card");
        } else {
            System.out.println("Please enter the amount: ");
//            double amount = scanner.nextDouble();
            debitCards.deposit(10);
            System.out.println("Balance debit card "
                + debitCards.getCardNumber() + " = "
                + debitCards.getBalance());
        }
    }

    // Снятие денег с карты
    public static void withdraw(DebitCards debitCards) {
        if (debitCards == null) {
            System.out.println("Please create a debit card");
        } else {
            System.out.println("Please enter the withdrawal amount: ");
//            double amount = scanner.nextDouble();
            debitCards.withdraw(10.00);
            System.out.println("Balance debit card "
                + debitCards.getCardNumber() + " = "
                + debitCards.getBalance());
        }
    }


    public static void main(String[] args) {

        boolean isExit = false;
        while (!isExit) {
            System.out.println("Dear customer, choose operation number:");
            System.out.println("1: Create account");
            System.out.println("2: Create Debit card");
            System.out.println("3: Check balance");
            System.out.println("4: Deposit");
            System.out.println("5: Withdraw");
            System.out.println("6: Exit");

            switch (scanner.nextLine()) {
                case "1":
                    currentBankAccount = createAccount();
                    currentDebitCard = null; // Сброс предыдущей карты, если аккаунт изменился
                    break;
                case "2":
                    if (currentBankAccount == null) {
                        System.out.println("Please create an account first!");
                    } else if (currentDebitCard == null) {
                        currentDebitCard = createDebitCard(currentBankAccount);
                    } else {
                        System.out.println("Debit card is already created for " + currentBankAccount.getFullName());
                    }
                    break;
                case "3":
                    checkBalance(currentDebitCard);
                    break;
                case "4":
                    deposit(currentDebitCard);
                    break;
                case "5":
                    withdraw(currentDebitCard);
                    break;
                case "6":
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid operation number");
            }
        }
    }
}
