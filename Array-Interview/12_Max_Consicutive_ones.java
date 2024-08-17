//Maximum Consicutive ones

// #1 Optimal Soln()
/*Explanation*/
/*
	-Traveres throught the array and count the consicutive 1's. If consicutiveness breaks make the count = 0;
	-Store the max  
	-At last max will be having the max count of consicutive 1's.
	**Complexity Analysis**
	  -Time complexity  : O(n)
      -Space complexity : O(1)
*/

public class Solution {
	public static int consecutiveOnes(int n, int[] arr) {
		
		int max = 0;
		int count = 0;

		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] == 1)
			{
				count ++;
				max = Math.max(count, max);
			}else
			{
				count = 0;
			}
		}
	return max;
	}
}