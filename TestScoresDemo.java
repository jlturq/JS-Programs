public class TestScoresDemo {
  public static void main(String[] args) {
  	
    //Double[] badScores = {97.5, 66.7, 88.0, 101.0, 99.0};
		
    //Double[] goodScores = {97.5, 66.7, 88.0, 100.0, 99.0};
		
    try {
	//Create a TestScores object initialized with badScores.
	TestScores t = new TestScores(new double[] {97.5, 66.7, 88.0, 101.0, 99.0});
			
	//Create a TestScores object initialized with goodScores.
	TestScores ts = new TestScores(new double[] {97.5, 66.7, 88.0, 100.0, 99.0});
    }
    //The following should not execute:
    catch (IllegalArgumentException e) {
	System.out.println("Invalid score found.\n" + e.getMessage());
    }
  }
}
