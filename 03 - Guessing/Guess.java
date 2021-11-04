//random number guessing game

import java.util.Random;
import java.util.Scanner;
public class Guess {
  public static void main(String[] args) {
    Random Random_number= new Random();
    int answer=Random_number.nextInt(20); // chooses random number from 1 through 20 for player to guess
    int turns=0;
    Scanner scan=new Scanner(System.in);
    System.out.println("Guess a number between 1 to 20, You will have 10 trys!" );

    int guess;
    int i=11;
    boolean win=false;
    while(win==false) {
      guess=scan.nextInt();
      turns++;

    if(guess==answer) {
      win=true;
    }
    else if(i<3){ //if turns is less than 0 then player loses and will be told the correct number
      System.out.println("You lose! the right answer was: "+answer+" ");
      System.out.println("The correct number was "+answer+" ");
      return;
    }
    else if(guess<answer){ //checks if players guess is lower than the correct guess. Also informs player if guess is too low.
      i--;
      System.out.println("Your guess is lower than the correct number! Turns left: "+(i-1));



    }
    else if(guess>answer) { // checks if players guess is higher than the correct guess. Also informs player if guess is too high.
      i--;
      System.out.println("Your guess is higher than the correcr number! Turns left: "+(i-1));

    }


  }
    System.out.println("You win!");
    System.out.println("You used "+turns+" trys to guess the right number. Good job!");
}

}
