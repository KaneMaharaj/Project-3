import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
import java.util.Random;
public class InheritanceClass extends Account{
    Scanner scanner = new Scanner(System.in);
    private Stack<Integer> winnings = new Stack<>();
    Random money = new Random();
    private int moneyWon;
    //private int account;
    //HOW TO COMPARE INPUTTED NUMBER TO USERACC NUMBER IN ORDER TO ACCESS ITS SPECIFIC ACCOUNT
    public void lotteryTime(Account account) {
            if (account.getBalance() > 5) {
                System.out.println("Say Goodbye To Your $5");
                account.Withdraw(5);
                System.out.println("Scratching...");
                moneyWon = money.nextInt(100);
                System.out.println("You Won $" + moneyWon);
                winnings.add(moneyWon);
                account.Deposit(moneyWon);
                System.out.println("Recent Winnings: $" + winnings);
            }
            else {
                System.out.println("Not Enough Money To Play!");
            }
    }
}

