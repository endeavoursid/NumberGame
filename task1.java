import java.util.*;
import java.lang.Math;

public class task1{
    public static void main(String[]args){
        int min=1;
        int max=100;
        int randomNum = min + (int)(Math.random() * ((max-min) + 1));
        System.out.println("---Number Game---\n\n");
        Scanner sc= new Scanner(System.in);
        guess(randomNum);
        while(true){
            System.out.println("\n\nWould you like to play again(Y or N)? ");
             String str=sc.nextLine();
             if(str.equals("Y")){
              randomNum = min + (int)(Math.random() * ((max-min) + 1));
              guess(randomNum);
             }
             else break;
        }
        
    }
    public static void guess(int randomNum){
        
        System.out.println("Try Guessing a number between 1 and 100 in atmost 6 tries\n");
        Scanner sc= new Scanner(System.in);
        for(int i=1;i<=6;i++){
            System.out.print("Guess no. "+i+":- ");
            int n=sc.nextInt();
            System.out.print("\n");
            if(n==randomNum){
                System.out.println("yayy! you guessed it right!\nYou guessed it in "+i+" attempts.");
                break;
            }
            if(i==6){
                System.out.println("You weren't able to guess the right number. The number was "+randomNum);
                break;
            }
            if(n<randomNum){
                if(n<randomNum-50)
                 System.out.println("Your guess is too small.");
                else System.out.println("Guess something greater.");
            }
            else if(n>randomNum){
                if(n<randomNum-50)
                 System.out.println("Your guess is too large.");
                else System.out.println("Guess something smaller.");
            }
        }
    }
}