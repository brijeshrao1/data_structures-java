//Right rotate an array by d placess


// #1 Bruteforce ()
/*Algorithm*/
/* 
	-
	-
	-
    -Complexity Analysis
    -Time complexity  : O(n). One pass is used to put the numbers in the new array.
    -And another pass to copy the new array to the original one.
    -Space complexity : O(n). Another array of the same size is used.
*/
class Solution {
      public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}


// #2 Optimized ()
/*Algorithm*/
/* 
	-
	-
	-
*/

// #3 Optimal Soln()
/*Algorithm*/
/*
     -This approach is based on the fact that when we rotate the array k times,
     -k elements from the back end of the array come to the front and the rest of the elements from the front shift backwards.
     -In this approach, we firstly reverse all the elements of the array.
     -Then, reversing the first k elements followed by reversing the rest n−k elements gives us the required result. 
*/

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int offset = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, offset - 1);
        reverse(nums, offset, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}