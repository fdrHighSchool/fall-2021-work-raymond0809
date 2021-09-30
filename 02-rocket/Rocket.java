//rocket ship code
public class Rocket{
  public static void main(String[] args) {
    triangle();
    box();
    box2();    //these are all my functions that I call to make my rocket
    box();
    triangle();
  } //ends main code

  public static void triangle() { //creates my traingle shape so I can call it whenever needed
    System.out.println("    /\\");
    System.out.println("   /  \\");
    System.out.println("  /    \\");
  }

  public static void box() { //calls my empty box option so I can call it when i need it
    System.out.println(" +______+");
    System.out.println(" |      |");
    System.out.println(" |      |");
    System.out.println(" +______+");
  }

  public static void box2() { //seperate box to get the US text in my rocket
    System.out.println(" |United|");
    System.out.println(" |States|");


  }
} //end program
