import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------Welcome to Number Guessing Game-------------------------------");
        System.out.println("You have guess the randomly generated number by the computer!!!");
        System.out.println("You will be promoted to next round by guessing the correct number!!!");
        System.out.println("You will have 5 attempts for each round!!!");
        System.out.println("----------------------------All The Best!!!_______________________________________________");
        int ugnum=0;
        Scanner sc=new Scanner(System.in);
        int att=5;
            int min=1;
            int max=100;
            int cgnum=(min + (int)(Math.random() * ((max - min) + 1)));
            int points=0;
            for(int i=1;i<=att;i++){
                System.out.println(i+"th Attempt");
                System.out.print("Enter your Guess - ");
                ugnum=sc.nextInt();
                if(ugnum==cgnum){
                    points+=1;
                    System.out.println("Correct Guess Hoorayyy!!!!");
                    max+=100;
                    System.out.println("Moving to Next Round!");
                    System.out.println("Range b/w : "+1+" to "+max);
                    System.out.println("Score :"+points);
                    att=5;
                    i=0;
                    cgnum=(min + (int)(Math.random() * ((max - min) + 1)));
                }else{
                    if(ugnum<cgnum){
                        System.out.println("Wrong Guess :(-- Try Higher!!!");
                        System.out.println(" Try Again!");
                    }else if(ugnum>cgnum){
                        System.out.println("Wrong Guess :(-- Try Lower");
                        System.out.println(" Try Again!");
                    }

                }
            }
            System.out.println("All Attempts are Over:(");
        System.out.println("Better Luck Next Time :(");

    }
}