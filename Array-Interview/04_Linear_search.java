//Linear Search in sorted array

// #1 Bruteforce ()
/*Algorithm*/
/* 
	- Traverese throught the array and compare the K with all elements of array 
	- if you found K then return 1 else -1

	**Complexity Analysis**
	  -Time complexity  : O(n)
      -Space complexity : O(1)
*/
class Solution {
    static int searchInSorted(int arr[], int N, int K) {

        // Your code here
        for(int i = 0; i < N; i++)
        {
            if(arr[i] == K)
            {
                return 1;
            }
        }
        return -1;
    }
}
