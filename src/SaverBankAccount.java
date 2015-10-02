
public class SaverBankAccount extends BankAccount
{
    public SaverBankAccount(String firstName, String lastName, float initialBalance)
    {
        super(firstName, lastName, initialBalance);
    }

    public String getAccountTypeDescription()
    {
        return "saver";
    }

    public float getOverdraftAmountAllowed()
    {
        return 0;
    }

    public float getTransactionCharge()
    {
        return 1;
    }
}
