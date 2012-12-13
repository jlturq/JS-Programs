import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TextFileScan{
  public static void main(String[] args) {
  	
    System.out.println("This reads three numbers and a line");
    System.out.println("of text from the file morestuff.txt.");
		
    Scanner inputStream = null;
		
    try {
       inputStream = new Scanner(new FileInputStream("morestuff.txt"));
    }
    catch(FileNotFoundException e) {
       System.out.println("File morestuff.txt not found");
       System.out.println("nor could it be opened.");
       System.exit(0);
    }
      
    int s1 = inputStream.nextInt();
    int s2 = inputStream.nextInt();
    int s3 = inputStream.nextInt();
			
    inputStream.nextLine();            //Go to next line
			
    String line = inputStream.nextLine();
    System.out.println("The three numbers read from file are: ");
    System.out.println(s1 + ", " + s2 + ", and " + s3);
			
    System.out.println("The line read from the file is: ");
    System.out.println(line);
			
    inputStream.close()
  }
}
