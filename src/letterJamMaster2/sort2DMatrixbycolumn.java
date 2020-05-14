package letterJamMaster2;
import java.util.*;

//Shamelessly copied from https://www.geeksforgeeks.org/sorting-2d-array-according-values-given-column-java/

public class sort2DMatrixbycolumn {
	// Function to sort by column 
    public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 

}
