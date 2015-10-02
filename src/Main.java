import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        Scanner scanner = new Scanner(System.in);

        int mainMenuSelection;

        while (true)
        {
            System.out.println("------------------------");
            System.out.println("You are at the main menu");
            System.out.println("1. add account");
            System.out.println("2. list accounts");
            System.out.println("3. account management");
            System.out.println("4. exit");
            System.out.println("------------------------");

            mainMenuSelection = scanner.nextInt();
            scanner.nextLine();

            switch (mainMenuSelection)
            {
                case 1:
                    System.out.println("Enter first name");
                    String firstName = scanner.nextLine();

                    System.out.println("Enter last name");
                    String lastName = scanner.nextLine();

                    boolean accountTypeIsValid = false;

                    int typeOfAccount;

                    do
                    {
                        System.out.println("Enter type of account (1. standard, 2. saver, 3. premium)");
                        typeOfAccount = scanner.nextInt();
                        scanner.nextLine();

                        switch (typeOfAccount)
                        {
                            case 1:
                            case 2:
                            case 3:
                                accountTypeIsValid = true;
                                break;

                            default:
                                System.out.println("Account type not valid");
                                break;
                        }
                    }
                    while (!accountTypeIsValid);

                    boolean depositValid = false;

                    // set to 0 by default, update amount if user enters an amount
                    float initialDeposit = 0;

                    do {
                        System.out.println("Enter initial deposit (or press enter to skip)");
                        String initialDepositInput = scanner.nextLine();

                        if (initialDepositInput.isEmpty())
                        {
                            break;
                        }
                        else
                        {
                            try
                            {
                                initialDeposit = Float.parseFloat(initialDepositInput);
                                depositValid = true;
                            }
                            catch (Exception e)
                            {
                                System.out.println("Not a valid deposit");
                            }
                        }
                    }
                    while (!depositValid);

                    BankAccount newAccount = null;

                    switch (typeOfAccount)
                    {
                        case 1:
                            newAccount = new StandardBankAccount(firstName, lastName, initialDeposit);
                            break;

                        case 2:
                            newAccount = new SaverBankAccount(firstName, lastName, initialDeposit);
                            break;

                        case 3:
                            newAccount = new PremiumBankAccount(firstName, lastName, initialDeposit);
                            break;
                    }

                    accounts.add(newAccount);

                    break;

                case 2:
                    for (BankAccount account : accounts)
                    {
                        System.out.println(account.getAccountDescription());
                    }
                    break;

                case 3:

                    System.out.println("Enter account number");

                    int accountNumberToSearchFor = scanner.nextInt();
                    scanner.nextLine();

                    BankAccount foundAccount = null;

                    for (BankAccount account : accounts)
                    {
                        if (account.getAccountNumber() == accountNumberToSearchFor)
                        {
                            foundAccount = account;
                            break;
                        }
                    }

                    if (foundAccount != null)
                    {
                        int accountManagementSelection = 0;

                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");

                        accountManagementSelection = scanner.nextInt();
                        scanner.nextLine();

                        switch (accountManagementSelection)
                        {
                            case 1:
                                boolean amountDepositedSuccessfully = false;
                                while(!amountDepositedSuccessfully)
                                {
                                    System.out.println("How much do you want to deposit?");
                                    try {
                                        float amountToDeposit = scanner.nextFloat();
                                        scanner.nextLine();

                                        foundAccount.deposit(amountToDeposit);
                                        amountDepositedSuccessfully = true;
                                    }
                                    catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }

                                break;

                            case 2:
                                boolean amountWithdrawnSuccessfully = false;
                                while(!amountWithdrawnSuccessfully)
                                {
                                    System.out.println("How much do you want to withdraw?");
                                    try {
                                        float amountToWithdraw = scanner.nextFloat();
                                        scanner.nextLine();

                                        foundAccount.withdraw(amountToWithdraw);
                                        amountWithdrawnSuccessfully = true;
                                    }
                                    catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                break;
                        }
                    }

                    break;

                default:
                    System.exit(0);
            }
        }
    }
}
