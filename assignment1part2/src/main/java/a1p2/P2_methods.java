package a1p2;

public class P2_methods {

	/**
	 * PROGRAM 1
	 * 
	 * Find last index of element
	 *
	 * @param x array to search
	 * @param y value to look for
	 * @return last index of y in x; -1 if absent
	 * @throws NullPointerException if x is null
	 */
	 public static int findLast (int[] x, int y){
		for (int i=x.length-1; i > 0; i--){
			if (x[i] == y){
				return i;
			}
		}
		return -1;
	 }
	 // test: x=[2, 3, 5]; y=2; Expected = 0
	
	
	
	/**
	 * PROGRAM 2
	 * 
	 * Finds last index of zero
	 *
	 * @param x array to search
	 *
	 * @return last index of 0 in x; -1 if there is no zero
	 * @throws NullPointerException if x is null
	 */
	 public static int lastZero (int[] x){
		 for (int i = 0; i < x.length; i++){
			 if (x[i] == 0){
				 return i;
			 }
		 }
		 return -1;
	 }
	 // test: x=[0,1,0]; Expected = 2
	 
	 
	 
	 /**
	  * PROGRAM 3
	  * 
	  * Counts positive elements in array
	  *
	  * @param x array to search
	  * * @return number of positive elements in x
   	  * @throws NullPointerException if x is null
	  */
	  public static int countPositive (int[] x){
		  int count = 0;
	
		  for (int i=0; i < x.length; i++){
			  if (x[i] >= 0){
				  count++;
			  }
		  }
		  return count;
	 }
	 // test: x=[-4, 2, 0, 2]
	 // Expected = 2
	 
	 
	 
	 /**
	  * PROGRAM 4
	  * 
	  * Count odd or positive elements in an array
	  *
	  * @param x array to search
	  * @return count of odd or positive elements in x
	  * @throws NullPointerException if x is null
	  */
	  public static int oddOrPos (int[] x){
		  // Effects: if x is null throw NullPointerException
		  // else return the number of elements in x that
		  // are either odd or positive (or both)
		  int count = 0;

		  for (int i = 0; i < x.length; i++){
			  if (x[i]%2 == 1 || x[i] > 0){
				  count++;
			  }
		  }
		  return count;
	   }
	   // test: x=[-3, -2, 0, 1, 4]
	   // Expected = 3
	 
}
