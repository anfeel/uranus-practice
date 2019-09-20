package org.szfs.basic.web.demo.test.concurrency.deadlock;

import java.util.Random;

/**
 * 
 * @author prd-fuy
 * @version $Id: DemostrateDeadlock.java, v 0.1 2018年11月12日 下午4:32:33 prd-fuy Exp $
 */
public class DemostrateDeadlock {
    
    private static final int NUM_THREADS    = 20;
    private static final int NUM_ACCOUNTS   = 5;
    private static final int NUM_ITERATIONS = 1000000;
    
    public static void main(String[] args) {
        final Random random = new Random();
        final Account[] accounts = new Account[NUM_ACCOUNTS];
        
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
        }
        
        for (int i = 0; i < NUM_THREADS; i++) {
            new Thread(new Runnable() {
                
                @Override
                public void run() {
                    for (int j = 0; j < NUM_ITERATIONS; j++) {
                        int fromAcct = random.nextInt(NUM_ACCOUNTS);
                        int toAcct = random.nextInt(NUM_ACCOUNTS);
                        if (fromAcct == toAcct)
                            continue;
                        int amount = random.nextInt(1000);
                        System.out.println("fromAcc = Account[" + fromAcct + "] ,  toAcc = Account[" + toAcct + "] , amount = " + amount);
                        transferMoney(accounts[fromAcct], fromAcct, accounts[toAcct], toAcct, amount);
                    }
                    
                }
            }).start();
        }
        
    }
    
    public static void transferMoney(Account fromAcc, int fromAccNo, Account toAcc, int toAccNo, int money) {
        synchronized (fromAcc) {
            synchronized (toAcc) {
                if (fromAcc.getBalance() < money)
                    throw new RuntimeException("Not Sufficient Balance");
                else {
                    fromAcc.debit(fromAccNo, toAccNo, money);
                    toAcc.credit(fromAccNo, toAccNo, money);
                }
            }
        }
    }
    
}
