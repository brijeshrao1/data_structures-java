//283. Move Zeroes


// #1 Bruteforce (Using temp Array)
/*Algorithm*/
/* 
	-Store the no zero numbers in temp list
	-Put back all elements from temp list to the array
	-Make rest of element of array as zero
	-Complexity Analysis
	 Time complexity  : O(n)
	 Space complexity : O(n)
	 :

*/

class Solution {
    public void moveZeroes(int[] nums) {

        ArrayList<Integer> temp = new ArrayList<>();
        
        //Store the no zero numbers in temp list
        for(int i=0; i< nums.length; i++)
        {
            if(nums[i] != 0)
            {
                temp.add(nums[i]);
            }
        } 

        //Put back all elements from temp list to the array
        for(int j=0; j<temp.size(); j++)
        {
            nums[j] = temp.get(j);
        }

        //Make rest of element of array as zero
        for(int k= temp.size(); k < nums.length; k++)
        {
            nums[k] = 0;
        }
        
    }
}



// #2 Optimized ()
/*Algorithm*/
/* 
	-
	-
	-
	-Complexity Analysis
*/

// #3 Optimal Soln(Using Two Pointer)
/*Explanation*/
/*
	-Take two pointer j and i. j will always point to the zero initialy will point to -1 and i will point to j+1
	-Find first zero of array make j point to it
	-Now traverse and through the array an make swap the no zero number with zero.
	-Complexity Analysis
	 Time complexity  : O(n)
	 Space complexity : O(1)
*/
class Solution {
    public void moveZeroes(int[] nums) {
        
        int j = -1;
        //finding the first zero element 
        for(int i = 0; i< nums.length; i++)
        {
            if(nums[i] == 0)
            {
                j = i;
                break;
            }
        }

        //Not having any zero
        if(j == -1) return;
        int temp;

        //Now  traversing and swaping the no zero with zero elements
        for(int i = j+1; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
              temp = nums[i];
              nums[i] = nums[j];
              nums[j] = temp;
              j++;
            }
        }  
    }
}


