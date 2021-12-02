import java.util.*;

public class Calculator {
  public static void main(String[] args) {
    while (true) { //A while loop for user
        Scanner input = new Scanner(System.in); //create input method
        System.out.print("Enter the fractions expression(Type quit to stop): "); //Ask input from user
        String exp = input.nextLine(); //Set exp as the input from user
        if (exp.equals("quit")) { //set if for user want to quit
          break; //stop the program
        } //end if exp is quit
        int firstS = exp.indexOf(" "); // look for the index of the first Space
        int secondS = exp.lastIndexOf(" "); //look at the index of the second Space
        String operator = exp.substring(firstS + 1, secondS); //set the operator is between two spaces
          if (operator.length() > 1) { //set if operator is more than 1
            System.out.println("ERROR: Input is in an invalid format."); //print error
            break; //stop the program
          } //end if operator is error
        else if (exp.contains("/0")) { //set if there is /0
          System.out.println("ERROR: Cannot divide by zero."); //print error
          break; //stop the program
        } //end if /0 in exp
        String result = produceAnswer(exp); //set up the result
        int lowDash = result.indexOf("_"); //identify the index of low dash sign
        int divide = result.indexOf("/"); //identify the index of divide sign
        String whole = result.substring(0, lowDash); //set whole is from first char to _
        String frac = result.substring(lowDash + 1, result.length()); //set fraction is from next char of _ to the end
        String numer = result.substring(lowDash + 1, divide); //set numerator is from next char of _ to /
        String denom = result.substring(divide + 1, result.length()); //set denom is from nex char of / to the end
        if (frac.equals("0/1")) { //set if for fraction is unnecessary
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

  // Name: produceAnswer()
  // Purpose: identify the operator and fractions user input
  // Input: input of expression from user
  // Return: return the answers of the expression that user gave
  public static String produceAnswer(String exp) {
    int firstS = exp.indexOf(" "); // look for the index of the first Space
    int secondS = exp.lastIndexOf(" "); //look at the index of the second Space
    String operator = exp.substring(firstS + 1, secondS); //set the operator is between two spaces
    String operand1 = exp.substring(0, firstS); //set operand1 is from the first char to the first space
      if (operand1.contains("/") && !operand1.contains("_")) { //look if operand1 is fraction
        operand1 = convertMix(operand1); //then covert the operand1 to whole-fraction mix
      } //end if operand1 has / and no _
      else if (!operand1.contains("_")){ //look if operand1 is just a number
        operand1 += "_0/1"; //then add "_0/1" behind the number to convert to whole-fraction mix
      } //end if only integer
    String operand2 = exp.substring(secondS + 1, exp.length()); //set operand2 is from the next char of second space to the end
      if (operand2.contains("/") && !operand2.contains("_")) { //look if operand1 is fraction
        operand2 = convertMix(operand2); //convert operand2 to whole-fraction mix
      } //end if operand2 has / and no _
      else if (!operand2.contains("_")){ //look if operand2 is just a number
        operand2 += "_0/1"; //convert it to whole-fraction mix by adding "_0/1" behind
      } //end if only integer

      if (operator.equals("+")) { //identify if the operator is +
      operand1 = convertFraction(operand1); //convert operand1 to fraction
      operand2 = convertFraction(operand2); //convert operand2 to fraction
      String result = calculationAdd(operand1, operand2); //set result equals to the calculation
      return result; //then return the result to the main
    } //end addition

    else if (operator.equals("-")) { //identify if the operator is -
      operand1 = convertFraction(operand1); //convert operand1 to fraction
      operand2 = convertFraction(operand2); //convert operand2 to fraction
      String result = calculationMinus(operand1, operand2); //set result equals to the calculation
      return result; //then return the result to the main
    } //end subtraction

    else if (operator.equals("*")) { //identify if the operator is *
      operand1 = convertFraction(operand1); //convert operand1 to fraction
      operand2 = convertFraction(operand2); //convert operand2 to fraction
      String result = calculationMultiply(operand1, operand2); //set result equals to the calculation
      return result; //then return the result to the main
    } //end multiplication

    else if (operator.equals("/")) { //identify if the operator is /
      operand1 = convertFraction(operand1); //convert operand1 to fraction
      operand2 = convertFraction(operand2); //convert operand2 to fraction
      String result = calculationDivide(operand1, operand2); //set result equals to the calculation
      return result; //then return the result to the main
    } //end division

    return "Error"; //let make sure this method could run 100%

  } //end produceAnswer()

  // Name: calculationAdd()
  // Purpose: to calculate addition of two fractions
  // Input: two fractions string from user
  // Return: return the result back to produceAnswer()
  public static String calculationAdd(String firstF, String secondF) { //set two string of fractions to calculate
    String numer1 = getNumer1(firstF); //get numerator 1
    String denom1 = getDenom1(firstF); //get denominator 1
    String numer2 = getNumer2(secondF); //get numerator 2
    String denom2 = getDenom2(secondF); //get donominator 2
    int Fnumer = Integer.parseInt(numer1) * Integer.parseInt(denom2) + Integer.parseInt(numer2) * Integer.parseInt(denom1); //calculate the final numerator
    int Fdenom = Integer.parseInt(denom1) * Integer.parseInt(denom2); //calculate the final denominator
    String result = reduceFraction(Fnumer, Fdenom); //reduce the result to simplest fraction
    String Fresult = convertMix(result); //convert the answer back to whole-fraction mix
    return Fresult; //return the Final result
  } //end addition()

  // Name: calculationMinus()
  // Purpose: to calculate subtraction of two fractions
  // Input: two fractions strings from user
  // Return: return the result back to produceAnswer()
  public static String calculationMinus(String firstF, String secondF) { //set two string of fractions to calculate
    String numer1 = getNumer1(firstF); //get numerator 1
    String denom1 = getDenom1(firstF); //get denominator 1
    String numer2 = getNumer2(secondF); //get numerator 2
    String denom2 = getDenom2(secondF); //get donominator 2
    int Fnumer = Integer.parseInt(numer1) * Integer.parseInt(denom2) - Integer.parseInt(numer2) * Integer.parseInt(denom1); //calculate the final numerator
    int Fdenom = Integer.parseInt(denom1) * Integer.parseInt(denom2); //calculate the final denominator
    String result = reduceFraction(Fnumer, Fdenom); //reduce the result to simplest fraction
    String Fresult = convertMix(result); //convert the answer back to whole-fraction mix
    return Fresult; //return the Final result
  } //end subtraction()

  // Name: calculationMultiply()
  // Purpose: to calculate multiplication of two fractions
  // Input: two fractions strings from user
  // Return: return the result back to produceAnswer()
  public static String calculationMultiply(String firstF, String secondF) { //set two string of fractions to calculate
    String numer1 = getNumer1(firstF); //get numerator 1
    String denom1 = getDenom1(firstF); //get denominator 1
    String numer2 = getNumer2(secondF); //get numerator 2
    String denom2 = getDenom2(secondF); //get donominator 2
    int Fnumer = Integer.parseInt(numer1) * Integer.parseInt(numer2); //calculate the final numerator
    int Fdenom = Integer.parseInt(denom1) * Integer.parseInt(denom2); //calculate the final denominator
    String result = reduceFraction(Fnumer, Fdenom); //reduce the result to simplest fraction
    String Fresult = convertMix(result); //convert the answer back to whole-fraction mix
    return Fresult; //return the Final result
  } //end multiplication()

  // Name: calculationDivide()
  // Purpose: to calculate division of two fractions
  // Input: two fractions strings from user
  // Return: return the result back to produceAnswer()
  public static String calculationDivide(String firstF, String secondF) { //set two string of fractions to calculate
    String numer1 = getNumer1(firstF); //get numerator 1
    String denom1 = getDenom1(firstF); //get denominator 1
    String numer2 = getNumer2(secondF); //get numerator 2
    String denom2 = getDenom2(secondF); //get donominator 2
    int Fnumer = Integer.parseInt(numer1) * Integer.parseInt(denom2); //calculate the final numerator
    int Fdenom = Integer.parseInt(denom1) * Integer.parseInt(numer2); //calculate the final denominator
    String result = reduceFraction(Fnumer, Fdenom); //reduce the result to simplest fraction
    String Fresult = convertMix(result); //convert the answer back to whole-fraction mix
    return Fresult; //return the Final result
  } //end division

  // Name: convertMix()
  // Purpose: to convert fraction to whole-fraction mix
  // Input: fraction
  // Return: the result of convertion
  public static String convertMix(String fraction) { //set a fraction in parameter
    int divide = fraction.indexOf("/"); //identify the index of "/"
    String numer = fraction.substring(0, divide); //set numerator is from the first char to "/"
    String denom = fraction.substring(divide + 1, fraction.length()); //set denominator is from next char of "/" to the end
    String reducedF = reduceFraction(Integer.parseInt(numer), Integer.parseInt(denom)); //reduce the fraction if it's not in simplest form
    int rDivide = reducedF.indexOf("/"); //identify the index of reduced "/"
    String rNumer = reducedF.substring(0, rDivide); //set reduced numerator is from the first char to "/"
    String rDenom = reducedF.substring(rDivide + 1, reducedF.length()); //set reduced denominator is from next char of "/" to the end
    int integer = Integer.parseInt(rNumer) / Integer.parseInt(rDenom); //calculate the whole number in a mix
    int Fnumer = Integer.parseInt(rNumer) % Integer.parseInt(rDenom); //calculate the final numerator
    String result = String.valueOf(integer) + "_" + String.valueOf(Fnumer) + "/" + rDenom; //finish convertion
    return result; //return the result
  } //end determineFraction()

  // Name: convertFraction()
  // Purpose: convert mix to fraction
  // Input: whole-fraction mix
  // Return: the result of convertion
  public static String convertFraction(String fraction) { //set a mix in parameter
    int lowDash = fraction.indexOf("_"); //identify the index of low dash
    int divide = fraction.indexOf("/"); //identify the index of "/"
    String whole = fraction.substring(0, lowDash); //set whole is from the first char to low dash
    String numer = fraction.substring(lowDash + 1, divide); //set numerator is from next char of low dash to "/"
    String denom = fraction.substring(divide + 1, fraction.length()); //set denominator is from the next char of "/" to the end
    int Fnumer = Integer.parseInt(whole) * Integer.parseInt(denom) + Integer.parseInt(numer); //calculate the final numerator
    String result = String.valueOf(Fnumer) + "/" + denom; //finish convertion
    return result; //return the result
  } //end convertFraction();

  // Name: getNumer1()
  // Purpose: to get numerator 1 from fraction 1
  // Input: fraction 1
  // Return: numerator 1
  public static String getNumer1(String fraction1) { //set a fraction in parameter
    int divide = fraction1.indexOf("/"); //identify the index of "/"
    String numer1 = fraction1.substring(0, divide); //set numerator 1 is from first char to "/"
    return numer1; //return the numerator1
  } //end get numer1

  // Name: getDenom1()
  // Purpose: to get denominator 1 from fraction 1
  // Input: fraction 1
  // Return: denominator 1
  public static String getDenom1(String fraction1) { //set a fraction in parameter
    int divide = fraction1.indexOf("/"); //identify the index of "/"
    String denom1 = fraction1.substring(divide + 1, fraction1.length()); //set denominator 1 is from next char of "/" to the end
    return denom1; //return denominator 1
  } //end get denom1

  // Name: getNumer2()
  // Purpose: to get numerator 2 from fraction 2
  // Input: fraction 2
  // Return: numerator 2
  public static String getNumer2(String fraction2) { //set a fration in parameter
    int divide = fraction2.indexOf("/"); //identify the index of "/"
    String numer2 = fraction2.substring(0, divide); //set numerator 2 is from the first char to "/"
    return numer2; //return numerator 2
  } //end get numer2

  // Name: getDenom2()
  // Purpose: to get denominator 2 from fraction 2
  // Input: fraction 2
  // Return: denominator 2
  public static String getDenom2(String fraction2) { //set a fraction in parameter
    int divide = fraction2.indexOf("/"); //identify the index of "/"
    String denom2 = fraction2.substring(divide + 1, fraction2.length()); //set numerator 2 is from the next char of "/" to the end
    return denom2; //return denominator 2
  } //end get denom2

  // Name: reduceFraction()
  // Purpose: to reduce the fraction
  // Input: numerator as int and denominator as int
  // Return: return the reduced fraction
  public static String reduceFraction(int x, int y) { //set int numerator and denominator
    int d;  //set int d
    d = __gcd(x, y); //d is divisor from __gcd()
    x = x / d; //x is x divides the divisor
    y = y / d; //y is y divides the divisor
    String num = String.valueOf(x) + "/" + String.valueOf(y); //add "/" between two value and set them as string
    return num; //return the num
  } //end reduceFraction()

  // Name: __gcd()
  // Purpose: to find the greatest common divisor
  // Input: int first number and second number
  // Return: return the __gcd after reduced
  public static int __gcd(int a, int b) { //set int first number and second number
    if (b == 0) { //if denominator is 0
      return a; //then no need to reduce
    } //end if
    return __gcd(b, a % b); //return the __gcd by (b, a % b)
  } //end __gcd()

} //end class
