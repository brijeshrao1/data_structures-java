//Find Largest Element in Array

// #1 Bruteforce (Buy Sorting)
/*Explaination*/
/* 
    -Sort array and return the last element of the array
*/

class Solution {
    public static int largest(int n, int[] arr) {
        
        Arrays.sort(arr);
        
        return arr[n-1];
    }
}



// #2 Optimized ()
/*Explaination*/
/* 
    -Consider the first element as largest element.
    -Start Compairing with the elements in array.
    -Keep changing the largest element variable when u found.
*/
class Solution {
    public static int largest(int n, int[] arr) {
        
        int largestEle = arr[0];
        
            for(int j = 1; j<arr.length; j++)
            {
               if(arr[j] > largestEle)
               {
                   largestEle = arr[j];
               }
            }
        return largestEle;
    }
}