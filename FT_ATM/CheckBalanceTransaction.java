import java.util.ArrayList;
public class CheckBalanceTransaction {
    
    public int account;
    
	//constructor for check balance 
    public synchronized float checkBalance(int cardId, int PIN,             
            ArrayList<CheckingAccount> checkingAccountList,
            ArrayList<DebitCard> debitCardList)
    {
		//'for loop' for each debit card instance in debit card list  
        for(DebitCard dc : debitCardList)
        {
            if(dc.cardId == cardId && dc.PIN == PIN)
            {
                for(CheckingAccount ca : checkingAccountList)
                {
                    if(ca.getAccountNumber() == dc.accountNo)
                    {
                        account = ca.getAccountNumber();
                        return ca.balance;
                    }
                }
            }
        }
        System.out.println("Invalid cardId or PIN");
        return Float.NaN;
    }
}
