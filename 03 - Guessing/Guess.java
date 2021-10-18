//random number guessing game

import java.util.Random;
import java.util.Scanner;
public class Guess {
  public static void main(String[] args) {
    Random Random_number= new Random();
    int answer=Random_number.nextInt(20);
    int turns=10;
    Scanner scan=new Scanner(System.in);
    System.out.println("Guess a number between 1 to 20, You will have 10 trys!" );

    int guess;
    int i=10;
    boolean win=false;
    while(win==false) {
      guess=scan.nextInt();
      turns++;

    if(guess==answer) {
      win=true;
    }
    else if(i<0){
      System.out.println("You lose! the right answer was: "+answer);
      return;
    }
    else if(guess<answer){
      i++;
      System.out.println("Your guess is lower than the number! Turns left: "+(i-1));



    }
    else if(guess>answer) {
      i++;
      System.out.println("Your guess is Higher than the answer! Turns left: "+(i-1));

    }


  }
    System.out.println("You win!");
    System.out.println("Then number was "+answer);
    System.out.println("You used "+turns+" turns to guess the right number.");
}

}
