//Remove duplicates from array in-place

// #1 Bruteforce (Using Hash Set)
/*Explaination*/
/* 
	- Traverse throught the given sorted array and keep putting all the unique(***one element only once***) elements into the sets.
    - Now traverse through the set and put back all elements from set to the arrays and return the new resultant array.
    - TC = nlogn + O(n)
    - SC = O(n)
*/
import java.util.HashSet; 
public class Solution {
    public static int removeDuplicates(int[] arr,int n) {
        // Write your code here.

       HashSet < Integer > set = new HashSet < > ();
        
        for(int i = 0; i <  n; i++)
        {
            set.add(arr[i]);
        }

        int index = 0;
        int length = set.size();
        
        for(int i : set)
        {
            arr[index++] = i;
        }
    return length;
    }
}

// #2 Optimized (Two Pointer)
/*Explaination*/
/* 
  - Take two pointers pointing to the first and second element of the array traverse and compare the elements pointed by pointers.
  - Move the first pointer when arr[first] ≠ arr[second]. If it is equal move only the second.
  - At last first pointer will give you the length of the resultant array.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++)
        {
            if(nums[i] != nums[j])
            {
                nums[i+1] = nums[j];
                i++;
            }
        }
       return i+1; 
    }
}
