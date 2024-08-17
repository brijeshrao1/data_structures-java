//Missing Element in array


// #1 Bruteforce ()
/*Algorithm*/
/* 
	- Do a lear search from 1 to N
	
	**Complexity Analysis**
	  -Time complexity  : O(nxn)
      -Space complexity : O(1)
*/

public class Solution {
    public static int missingNumber(int []a, int N) {
        
        int flag;
        for(int i=1; i<=N; i++)
        {
            flag = 0;
            for(int j=0; j<N; j++)
            {
                if( i == a[j])
                {
                    flag = 1;
                    break;
                }
            }
             if(flag == 0)
            {
                return i;
            }
        }
      return -1;     
    }
}


// #2 Optimized (Hashing)
/*Algorithm*/
/* 
	-Create a hash set array
	-Traverse through the array and mark index(element of array) of hash array
	-Traverse again through the hash array you will get the missing element whose index is marked as zero.

	**Complexity Analysis**
	  -Time complexity  : O(n) + O(n)
      -Space complexity : O(n)
*/
public class Solution {
    public static int missingNumber(int []a, int N) {
       int []hashSet = new int [N+1];

       for(int i=0; i < a.length; i++)
       {
           hashSet[a[i]] = 1 ;
       }

       for(int i = 0; i < hashSet.length; i++)
       {
           if(hashSet[i] == 0)
           return i;
       }
       return -1;
    }
}

/**There are two Optimal soln sum and XOR**/
// #3 Optimal Soln1(Using Sum)

/*Algorithm*/
/*

	-Sum of first n antural number is s1= n*(n+1)/2
	-Traverse throught the array and do the sum of all elements
	-Subtract s1- sum = missing element

	**Complexity Analysis**
	  -Time complexity  : O(n)
      -Space complexity : O(1)
*/
public class Solution {
    public static int missingNumber(int []a, int N) {
       int sum=0;
       int s1 = N*(N+1)/2;

       for(int i = 0 ; i<a.length; i++)
       {
           sum = sum + a[i];
       } 

       return s1 - sum;
    }
}

/*LeetCode Soln*/
class Solution {
    public int missingNumber(int[] nums) {
       int sum=0;
       int N = nums.length;
       int s1 = N*(N+1)/2;

       for(int i = 0 ; i<nums.length; i++)
       {
           sum = sum + nums[i];
       } 
       return s1 - sum;
    }
}

// #3 Optimal Soln1(Using XOR)
/*Algorithm*/
/*
Note:
*XOR of two same numsber will be zero;
*XOR of two diffrent number will return u the same number;

    - XOR is used because of the spac. it wil help to decrease the space complexity.
*/

public class Solution {
    public static int missingNumber(int []a, int N) {
        
        int XOR1 = 0;
        // for(int i = 1; i<=N; i++)
        // {
        //     XOR1 = XOR1^i;
        // }

        int XOR2 = 0;
        for(int i = 0; i<N-1; i++)
        {
            XOR2 = XOR2^a[i];
            XOR1 = XOR1^(i+1);
        }

        XOR1 = XOR1^N;

        return XOR1^XOR2;
    }
}