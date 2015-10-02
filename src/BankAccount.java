
public abstract class BankAccount
{
    private int accountNumber;
    private String firstName;
    private String lastName;
    private float balance;

    public final float maxWithdrawal = 10000;

    public static int accountNumberCounter = 1;

    public BankAccount(String firstName, String lastName, float initialBalance)
    {
        accountNumberCounter++;
        this.accountNumber = accountNumberCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountDescription()
    {
        return this.accountNumber + "(" + this.getAccountTypeDescription() + ") - " + this.firstName + " " + this.lastName + " - £" + this.balance;
    }

    public void deposit(float amountToDeposit) throws Exception
    {
        if (amountToDeposit < 0)
        {
            throw new Exception("Can't deposit a negative amount");
        }

        balance += amountToDeposit;
    }

    public void withdraw(float amountToWithdraw) throws Exception
    {
        if (amountToWithdraw < 0)
        {
            throw new Exception("Can't withdraw a negative amount");
        }

        if (amountToWithdraw > maxWithdrawal)
        {
            throw new Exception("Can't withdraw more than " + maxWithdrawal);
        }

        float totalToWithdrawIncludingTransactionCharge = amountToWithdraw + getTransactionCharge();

        if (totalToWithdrawIncludingTransactionCharge > (this.balance + getOverdraftAmountAllowed()))
        {
            throw new Exception("Sorry, total to withdraw: " + amountToWithdraw + " (" + totalToWithdrawIncludingTransactionCharge + " including transaction charge). Balance is only " + this.balance);
        }

        balance -= totalToWithdrawIncludingTransactionCharge;
    }

    public abstract String getAccountTypeDescription();

    public abstract float getOverdraftAmountAllowed();

    public abstract float getTransactionCharge();
}
