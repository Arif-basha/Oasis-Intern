import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter UserId : ");
        String uid=sc.nextLine();
        System.out.print("Enter User Pin : ");
        int upin=sc.nextInt();
        String cid="user";
        int cpin=1234;
        int bal=1000;
        int choice=0;
        if(upin==cpin){
            while(true) {
            System.out.println("Welcome User!!!");
            System.out.println("1.Withdrawal");
            System.out.println("2.Deposit");
            System.out.println("3.Transfer");
            System.out.println("4.Exit");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Withdrawal....");
                        System.out.println("Enter the amount to withdraw : ");
                        int amt = sc.nextInt();
                        if (amt <= bal) {
                            System.out.println("Withdrawal Completed:)");
                            bal = bal - amt;
                            System.out.println("Balance : " + bal);
                        } else {
                            System.out.println("Insufficient Funds:(");
                            System.out.println("Balance : " + bal);
                        }
                        break;
                    case 2:
                        System.out.println("Deposit...");
                        System.out.println("Enter the amount to deposit : ");
                        int depamt = sc.nextInt();
                        System.out.println("Deposit Successful:)");
                        System.out.println("Balance : " + (bal + depamt));
                        bal=bal + depamt;
                        break;
                    case 3:
                        System.out.println("Money Transaction...");
                        sc.nextLine();
                        System.out.println("Enter the userid of receiver : ");
                        String tid = sc.nextLine();
                        System.out.println("Enter the amount to send : ");
                        int tamt = sc.nextInt();
                        System.out.println("Enter the pin : ");
                        int tpin = sc.nextInt();
                        if (tamt <= bal) {
                            System.out.println("Amount Successfully Transferred :)");
                            System.out.println("Balance : " + (bal - tamt));
                            bal=bal-tamt;
                        } else {
                            System.out.println("Insufficient Funds :(");
                            System.out.println("Balance : " + bal);
                        }
                        break;
                    case 4:
                        System.out.println("Thank You for using our ATM Services :)");
                        System.exit(0);
                }
            }
        }else{
            System.out.println("Invalid Pin.. Contact Branch :(");
        }

    }
}