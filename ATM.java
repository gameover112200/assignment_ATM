
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int correctPin = 1234;
        int attempts = 0;
        int pin;

        double balance = 1000;

        String[] transactions = new String[100];
        int count = 0;

        boolean login = false;

        System.out.println("Welcome to ATM");

        while (attempts < 3) {

            System.out.print("Enter your PIN: ");
            pin = input.nextInt();

            if (pin == correctPin) {
                login = true;
                break;
            }
            else {
                attempts++;
                System.out.println("Wrong PIN");
            }
        }

        if (login == true) {

            System.out.println("Login successful!");

            int choice = 0;

            while (choice != 5) {

                System.out.println();
                System.out.println(" ATM MENU ");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                if (choice == 1) {

                    System.out.println("Your balance is: " + balance);

                }

                else if (choice == 2) {

                    System.out.print("Enter amount to deposit: ");
                    double amount = input.nextDouble();

                    if (amount > 0) {

                        balance = balance + amount;

                        transactions[count] = "Deposit: " + amount;
                        count++;

                        System.out.println("Deposit successful!");
                        System.out.println("New balance: " + balance);

                    }
                    else {
                        System.out.println("Invalid amount");
                    }

                }

                else if (choice == 3) {

                    System.out.print("Enter amount to withdraw: ");
                    double amount = input.nextDouble();

                    if (amount > 0) {

                        if (amount <= balance) {

                            balance = balance - amount;

                            transactions[count] = "Withdraw: " + amount;
                            count++;

                            System.out.println("Withdrawal successful!");
                            System.out.println("New balance: " + balance);

                        }
                        else {
                            System.out.println("Not enough balance");
                        }

                    }
                    else {
                        System.out.println("Invalid amount");
                    }

                }

                else if (choice == 4) {

                    System.out.println("Transaction History:");

                    if (count == 0) {
                        System.out.println("No transactions yet");
                    }

                    for (int i = 0; i < count; i++) {
                        System.out.println(transactions[i]);
                    }

                }

                else if (choice == 5) {

                    System.out.println("Thank you for using ATM");

                }

                else {

                    System.out.println("Invalid choice");

                }
            }

        }
        else {

            System.out.println("Your account is locked");
            System.out.println("Too many wrong attempts");

        }

        input.close();
    }
}
