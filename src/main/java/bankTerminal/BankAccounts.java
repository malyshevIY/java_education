package bankTerminal;

public class BankAccounts {

    private int id;
    private String name;
    private String lastName;
    private String password;
    private boolean hasDebitCard;

    public BankAccounts(int id, String name, String lastName, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.hasDebitCard = false;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    // Метод проверки существующей дебетовой карты у пользовтаеля
    public void checkIssueDebitCard() {
        if (!hasDebitCard) {
            hasDebitCard = true;
            System.out.println("Please create debit card for " + getFullName());
        } else
            System.out.println("The debit card has already been issued");
    }

    @Override
    public String toString() {
        return "BankAccounts{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", password='" + password + '\'' +
            '}';
    }


}
