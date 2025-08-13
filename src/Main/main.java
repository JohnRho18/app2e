package Main;

import java.util.Scanner;
import banking.BankingCode;

public class main {

    static BankingCode bApp[] = new BankingCode[50];
    static int accountCount = 0;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("HELLO WELCOME TO THE SYSTEM!");
            
            int choice;
            do {
                System.out.println("\nWhat do you feel doing today?");
                System.out.println("1. Banking");
                System.out.println("2. Doctors Appointment");
                System.out.println("3. Shopping");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1:
                        bankingMenu(sc);
                        break;
                    case 2:
                        System.out.println("Doctors Appointment functionality not implemented yet.");
                        break;
                    case 3:
                        System.out.println("Shopping functionality not implemented yet.");
                        break;
                    case 4:
                        System.out.println("Thank you for using the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid Selection!");
                        break;
                }
            } while (choice != 4);
        }
    }

    private static void bankingMenu(Scanner sc) {
        int resp;
        do {
            System.out.println("\n*** BANKING MENU ***");
            System.out.println("1. Register Account");
            System.out.println("2. Login Account");
            System.out.println("3. View All Accounts");
            System.out.print("Enter Selection: ");
            int action = sc.nextInt();
            
            switch (action) {
                case 1:
                    registerAccount(sc);
                    break;
                case 2:
                    loginAccount(sc);
                    break;
                case 3:
                    viewAllAccounts();
                    break;
                default:
                    System.out.println("Invalid Selection!");
                    break;
            }
            System.out.print("Do you want to continue in Banking Menu? (1-Yes/0-No): ");
            resp = sc.nextInt();
        } while (resp == 1);
    }

    private static void registerAccount(Scanner sc) {
        if (accountCount < 50) {
            System.out.print("Enter Account No.: ");
            int accountNo = sc.nextInt();
            System.out.print("Enter Account Pin: ");
            int pin = sc.nextInt();
            bApp[accountCount] = new BankingCode(accountNo, pin);
            accountCount++;
            System.out.println("Account registered successfully!");
        } else {
            System.out.println("Account limit reached. Cannot register more accounts.");
        }
    }

    private static void loginAccount(Scanner sc) {
        int attempts = 3;
        BankingCode loggedInAccount = null;

        while (loggedInAccount == null && attempts > 0) {
            System.out.print("Enter your Account No: ");
            int accountNo = sc.nextInt();
            System.out.print("Enter your Pin: ");
            int pin = sc.nextInt();

            for (int i = 0; i < accountCount; i++) {
                if (bApp[i].verifyAccount(accountNo, pin)) {
                    loggedInAccount = bApp[i];
                    break;
                }
            }

            if (loggedInAccount == null) {
                attempts--;
                System.out.println("INVALID ACCOUNT! Attempts left: " + attempts);
            }
        }

        if (loggedInAccount != null) {
            System.out.println("Login successful!");
            handleLoggedInSession(sc, loggedInAccount);
        } else {
            System.out.println("ATTEMPT LIMIT REACHED! Exiting to main menu.");
        }
    }

    private static void handleLoggedInSession(Scanner sc, BankingCode account) {
        int resp;
        do {
            System.out.println("\n*** WELCOME TO YOUR ACCOUNT ***");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            System.out.print("Enter action: ");
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    account.viewBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    float depositAmount = sc.nextFloat();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    float withdrawAmount = sc.nextFloat();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid action!");
                    break;
            }
            System.out.print("Do you want to continue in this session? (1-Yes/0-No): ");
            resp = sc.nextInt();
            if (resp == 0) {
                System.out.println("Logging out...");
            }
        } while (resp == 1);
    }
    
    private static void viewAllAccounts() {
        if (accountCount == 0) {
            System.out.println("No accounts registered yet.");
        } else {
            System.out.println("\n*** REGISTERED ACCOUNTS ***");
            for (int i = 0; i < accountCount; i++) {
                System.out.println("Account No: " + bApp[i].getAccountNo());
            }
        }
    }
}