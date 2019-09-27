package concurrency.deadlock;

/**
 * 
 * @author prd-fuy
 * @version $Id: Accont.java, v 0.1 2018年11月12日 下午4:32:44 prd-fuy Exp $
 */
public class Account {
    
    private int    balance = 10000;
    private int    accNo;
    private String accName;
    
    /**
     * 
     */
    public Account() {
    }
    
    /**
     * @param balance
     * @param accNo
     * @param accName
     */
    public Account(int balance, int accNo, String accName) {
        this.balance = balance;
        this.accNo = accNo;
        this.accName = accName;
    }
    
    public void debit(int fromAccNo, int toAccNo, int money) {
        System.out.println("fromAcc = Account[" + fromAccNo + "] ,  toAcc = Account[" + toAccNo + "] , before debit , balance = " + this.balance);
        this.balance -= money;
        System.out.println("fromAcc = Account[" + fromAccNo + "] ,  toAcc = Account[" + toAccNo + "] , after debit , balance = " + this.balance);
    }
    
    public void credit(int fromAccNo, int toAccNo, int money) {
        System.out.println("fromAcc = Account[" + fromAccNo + "] ,  toAcc = Account[" + toAccNo + "] , before credit , balance = " + this.balance);
        this.balance += money;
        System.out.println("fromAcc = Account[" + fromAccNo + "] ,  toAcc = Account[" + toAccNo + "] , before credit , balance = " + this.balance);
    }
    
    /**
     * Getter method for property <tt>balance</tt>.
     * 
     * @return property value of balance
     */
    public int getBalance() {
        return balance;
    }
    
    /**
     * Setter method for property <tt>balance</tt>.
     * 
     * @param balance value to be assigned to property balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    /**
     * Getter method for property <tt>accNo</tt>.
     * 
     * @return property value of accNo
     */
    public int getAccNo() {
        return accNo;
    }
    
    /**
     * Setter method for property <tt>accNo</tt>.
     * 
     * @param accNo value to be assigned to property accNo
     */
    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }
    
    /**
     * Getter method for property <tt>accName</tt>.
     * 
     * @return property value of accName
     */
    public String getAccName() {
        return accName;
    }
    
    /**
     * Setter method for property <tt>accName</tt>.
     * 
     * @param accName value to be assigned to property accName
     */
    public void setAccName(String accName) {
        this.accName = accName;
    }
    
}
