
public class PremiumBankAccount extends BankAccount
{
    public PremiumBankAccount(String firstName, String lastName, float initialBalance)
    {
        super(firstName, lastName, initialBalance);
    }

    public String getAccountTypeDescription()
    {
        return "premium";
    }

    public float getOverdraftAmountAllowed()
    {
        return 10000;
    }

    public float getTransactionCharge()
    {
        return 0;
    }
}
