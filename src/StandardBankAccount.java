
public class StandardBankAccount extends BankAccount
{
    public StandardBankAccount(String firstName, String lastName, float initialBalance)
    {
        super(firstName, lastName, initialBalance);
    }

    public String getAccountTypeDescription()
    {
        return "standard";
    }

    public float getOverdraftAmountAllowed()
    {
        return 500;
    }

    public float getTransactionCharge()
    {
        return 0;
    }
}
