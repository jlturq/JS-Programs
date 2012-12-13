import java.util.Scanner;

public class LeapYear {
  public static void main(String[] args) {
  	
  //Create Scanner
  Scanner input = new Scanner(System.in);
				
  System.out.println("Enter a year: ");
  int year = input.nextInt();
		
  //Check if a leap year
  boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		
  //Display result
  System.out.println(year + " is a leap year? " + isLeapYear);
 }
}
