public class TestScores {

  //Variable to reference an array holding test scores
  private double[] scores;

  public TestScores(double[] s) throws IllegalArgumentException {

  //Create array to hold scores passed as argument.
  scores = new double[s.length];
  	
  //Copy the scores passed as argument into new array. 
  //Check for illegal values as they are copied.		
		
  System.arraycopy(s, 0, scores, 0, s.length);
		
  //TestScores badScores = new TestScores(new double[] {});

  try {
      for (int i = 0; i < scores.length; i++) {
	  if (scores[i] < 0.0 || scores[i] > 100.0)
	     throw new IllegalArgumentException();
	  else
	     getAverage();
      }
      System.out.println("The average of the object's test scores is: " + getAverage());
  }
  catch (IllegalArgumentException e) {
      System.out.println("Exception: Score must be between 0.0 and 100.0\n");
  }
  }

	/**
	 * The getAverage method returns average of object's test scores.
	 */

	public double getAverage() {
	  double total = 0.0;                                // Accumulator
		
	  //Accumulate sum of scores.
  	  for (int i = 0; i < scores.length; i++)
	    total += scores[i];

	  //Return average of scores.
	  return (total / scores.length);
	                       
	}		
}	
