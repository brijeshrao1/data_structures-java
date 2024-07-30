//Second Largest and Second Smallest Element in Array


// #1 Bruteforce (with Sorting)
/*Explaination*/
/* 
    -Sort the array 
    -Second Last element of the array will the second largest element in the array.
*/



// #2 Optimized (By two passes without sorting)
/*Explaination*/
/* 
   - First find the largest
   - Then find the second largest 
*/



// #3 Optimal soln (By single passes without sorting)
/*Explaination*/
/* 
 	-Consider first element as the largest (take two variables flargest and slargest)
   -Traverse through the array compare with largest
*/


public class Solution {

    public static int secondLargest(int len, int []arr){
        int largest = arr[0];
        int slargest = -1;

        for(int i = 1; i < len; i++)
        {
            if(arr[i] > largest)
            {
                slargest = largest;
                largest = arr[i];
            }else if(arr[i] < largest && arr[i] > slargest)
            {
                slargest = arr[i];
            }
        }
        return slargest;
    }

    public static int secondSmallest(int len, int []arr){
        int smallest = arr[0];
        int sSmallest = Integer.MAX_VALUE;

        for(int i = 1; i < len; i++)
        {
            if(arr[i] < smallest)
            {
                sSmallest = smallest;
                smallest = arr[i];
            }else if(arr[i] != smallest && arr[i] < sSmallest)
            {
                sSmallest = arr[i];
            }
        }
        return sSmallest;
    }
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        int sLargest = secondLargest(n, a);
        int sSmallest = secondSmallest(n, a);

        return new int [] {sLargest,sSmallest};
    }
}
