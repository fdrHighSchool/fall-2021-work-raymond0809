import java.util.*;

public class FracCalc {
  public static void main(String[] args) {
    while (true) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your problem (write quit to stop calculator): "); //ask user for the problem they want to solve
        String exp = input.nextLine(); //set the problem as the input from user
        if (exp.equals("quit")) { //checks to see if user wants to quit program
          break;
        }

        int spaceOne = exp.indexOf(" "); // checks the index of the first space
        int spaceTwo = exp.lastIndexOf(" "); //checks the index of the second space

        String operator = exp.substring(spaceOne + 1, spaceTwo); //places the operator between spaces
          if (operator.length() > 1) { //checks if operator is in the wrong location
            System.out.println("Please type the problem in the proper format. Ex. 1/2 + 1/3 or 1_1/2 + 1/3"); //shows user how to properly type problem
            break; //stops program
          }
        else if (exp.contains("/0")) { // checks if user is trying to divide by 0.
          System.out.println("Please type another problem. Cannot divide by 0.");
          break;
        }
        String result = answerSetup(exp); //set up the answer
        int underScore = result.indexOf("_"); //identifies where there could be a _
        int divide = result.indexOf("/"); //identifies the index of division symbol
        String whole = result.substring(0, underScore);
        String frac = result.substring(underScore + 1, result.length());
        String numer = result.substring(underScore + 1, divide);
        String denom = result.substring(divide + 1, result.length());
        if (frac.equals("0/1")) {
          System.out.println(whole); //replace mix to just whole number
        } //end if fraction is 0/1
        else if (whole.equals("0")) { //set if for whole is unnecessary
          System.out.println(numer + "/" + denom); //replace mix to just fraction
        } //end if whole is 0
        else { //set else if result is mix
          System.out.println(result); //print the result
        } //end else

    } //end while loop

  } //end main


  public static String answerSetup(String exp) { //answerSetup will indentify the operator and the fraction the user put
    int spaceOne = exp.indexOf(" "); // look for the index of the first Space
    int spaceTwo = exp.lastIndexOf(" "); //look at the index of the second Space
    String operator = exp.substring(spaceOne + 1, spaceTwo); //set the operator is between two spaces
    String oP1 = exp.substring(0, spaceOne);
      if (oP1.contains("/") && !oP1.contains("_")) { //checks if oP1 has / or _
        oP1 = convertMix(oP1); //then covert oP1 to a whole fraction mix
      } //doesnt run if oP1 has no "/" and no "_"
      else if (!oP1.contains("_")){ //look if oP1 is just a number
        oP1 += "_0/1";
      }

    String oP2 = exp.substring(spaceTwo + 1, exp.length());
      if (oP2.contains("/") && !oP2.contains("_")) { //checks if oP2 has / or _
        oP2 = convertMix(oP2); //convert oP2 to whole-fraction mix
      } //doesnt run if oP2 has no / or _
      else if (!oP2.contains("_")){
        oP2 += "_0/1";
      }

      if (operator.equals("+")) { //identifies if addition is what will be used
      oP1 = Converter(oP1); //convert oP1 to a fraction
      oP2 = Converter(oP2); //convert oP2 to a fraction
      String result = Addition(oP1, oP2);
      return result; //returns the answer
    }

    else if (operator.equals("-")) { //identifies if subtraction is what will be used
      oP1 = Converter(oP1); //convert oP1 to a fraction
      oP2 = Converter(oP2); //convert oP2 to a fraction
      String result = Subtraction(oP1, oP2);
      return result; //returns the answer
    }

    else if (operator.equals("*")) { ////identifies if multiplication is what will be used
      oP1 = Converter(oP1); //convert oP1 to a fraction
      oP2 = Converter(oP2); //convert oP2 to a fraction
      String result = Multiplication(oP1, oP2);
      return result; //returns the answer
    }

    else if (operator.equals("/")) { ////identifies if division is what will be used
      oP1 = Converter(oP1); //convert oP1 to a fraction
      oP2 = Converter(oP2); //convert oP2 to a fraction
      String result = Division(oP1, oP2);
      return result; //returns answer
    }

    return "There is a problem. Restart calculator."; //returns error because it shows something must be wrong if code cant indentify the operator

  }


  public static String Addition(String fractionOne, String fractionTwo) { //will do the calculating for addition
    String numerOne = firstNumer(fractionOne); //gets numerator 1
    String denomOne = firstDenom(fractionOne); //gets denominator 1
    String numerTwo = workNumer2(fractionTwo); //gets numerator 2
    String denomTwo = workDenom2(fractionTwo); //gets donominator 2
    int lastNum = Integer.parseInt(numerOne) * Integer.parseInt(denomTwo) + Integer.parseInt(numerTwo) * Integer.parseInt(denomOne);
    int lastDenom = Integer.parseInt(denomOne) * Integer.parseInt(denomTwo); //calculate the final denominator
    String result = Simplifier(lastNum, lastDenom); //reduces result to the simplest form possible
    String Fresult = convertMix(result);
    return Fresult; //return the result to answerSetup
  } //end addition


  public static String Subtraction(String fractionOne, String fractionTwo) { //will do the calculating for subtraction
    String numerOne = firstNumer(fractionOne); //gets numerator 1
    String denomOne = firstDenom(fractionOne); //gets denominator 1
    String numerTwo = workNumer2(fractionTwo); //gets numerator 2
    String denomTwo = workDenom2(fractionTwo); //gets donominator 2
    int lastNum = Integer.parseInt(numerOne) * Integer.parseInt(denomTwo) - Integer.parseInt(numerTwo) * Integer.parseInt(denomOne);
    int lastDenom = Integer.parseInt(denomOne) * Integer.parseInt(denomTwo); //calculate the final denominator
    String result = Simplifier(lastNum, lastDenom); //reduces result to the simplest form possible
    String Fresult = convertMix(result);
    return Fresult; //return the result to answerSetup
  } //end subtraction


  public static String Multiplication(String fractionOne, String fractionTwo) { //will do the calculating for multiplication
    String numerOne = firstNumer(fractionOne); //gets numerator 1
    String denomOne = firstDenom(fractionOne); //gets denominator 1
    String numerTwo = workNumer2(fractionTwo); //gets numerator 2
    String denomTwo = workDenom2(fractionTwo); //gets donominator 2
    int lastNum = Integer.parseInt(numerOne) * Integer.parseInt(numerTwo);
    int lastDenom = Integer.parseInt(denomOne) * Integer.parseInt(denomTwo);
    String result = Simplifier(lastNum, lastDenom); //reduces result to the simplest form possible
    String Fresult = convertMix(result);
    return Fresult; //return result to answerSetup
  } //end multiplication


  public static String Division(String fractionOne, String fractionTwo) { //will do the calculating for division
    String numerOne = firstNumer(fractionOne); //gets numerator 1
    String denomOne = firstDenom(fractionOne); //gets denominator 1
    String numerTwo = workNumer2(fractionTwo); //gets numerator 2
    String denomTwo = workDenom2(fractionTwo); //gets donominator 2
    int lastNum = Integer.parseInt(numerOne) * Integer.parseInt(denomTwo);
    int lastDenom = Integer.parseInt(denomOne) * Integer.parseInt(numerTwo);
    String result = Simplifier(lastNum, lastDenom); //reduces result to simplest form possible
    String Fresult = convertMix(result);
    return Fresult; //return result to answerSetup
  } //end division


  public static String convertMix(String fraction) { //converts big fraction to fraction with whole number
    int divide = fraction.indexOf("/");
    String numer = fraction.substring(0, divide);
    String denom = fraction.substring(divide + 1, fraction.length());
    String reducedF = Simplifier(Integer.parseInt(numer), Integer.parseInt(denom));
    int rDivide = reducedF.indexOf("/");
    String rNumer = reducedF.substring(0, rDivide);
    String rDenom = reducedF.substring(rDivide + 1, reducedF.length());
    int integer = Integer.parseInt(rNumer) / Integer.parseInt(rDenom);
    int lastNum = Integer.parseInt(rNumer) % Integer.parseInt(rDenom);
    String result = String.valueOf(integer) + "_" + String.valueOf(lastNum) + "/" + rDenom;
    return result; //return the result
  }


  public static String Converter(String fraction) {
    int underScore = fraction.indexOf("_"); //identify the index of low dash
    int divide = fraction.indexOf("/");
    String whole = fraction.substring(0, underScore);
    String numer = fraction.substring(underScore + 1, divide);
    String denom = fraction.substring(divide + 1, fraction.length());
    int lastNum = Integer.parseInt(whole) * Integer.parseInt(denom) + Integer.parseInt(numer);
    String result = String.valueOf(lastNum) + "/" + denom;
    return result; //return the result
  }


  public static String firstNumer(String fraction1) { //firstNumer will get numerator 1 from first fraction
    int divide = fraction1.indexOf("/");
    String numerOne = fraction1.substring(0, divide);
    return numerOne; //return the numerator1
  }


  public static String firstDenom(String fraction1) { //firstDenom will get denominator 1 from fraction
    int divide = fraction1.indexOf("/");
    String denomOne = fraction1.substring(divide + 1, fraction1.length());
    return denomOne;
  }


  public static String workNumer2(String fraction2) { //get numerator 2 from frac 2
    int divide = fraction2.indexOf("/");
    String numerTwo = fraction2.substring(0, divide);
    return numerTwo;
  }


  public static String workDenom2(String fraction2) { //get denominator 2 from frac 2
    int divide = fraction2.indexOf("/");
    String denomTwo = fraction2.substring(divide + 1, fraction2.length());
    return denomTwo;
  }

  public static String Simplifier(int x, int y) { //will simplify a fraction
    int d;
    d = GCD(x, y);
    x = x / d;
    y = y / d;
    String num = String.valueOf(x) + "/" + String.valueOf(y);
    return num;
  } //end Simplifier()

  public static int GCD(int a, int b) { //gcd is to find the greatest common divisor to help simplify
    if (b == 0) {
      return a;
    }
    return GCD(b, a % b);
  } //end GCD()

} //end class
