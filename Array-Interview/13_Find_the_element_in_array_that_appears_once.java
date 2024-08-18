//Find the element in array that appears once and other more than once

// #1 Bruteforce (Using Lenear Search)
/*Algorithm*/
/* 
	-Search each element in same array and increase the count
	**Complexity Analysis**
	  -Time complexity  : O(n*n)
      -Space complexity : O(1)
*/
class Solution {
    public int singleNumber(int[] nums) {
        
        int count = 0;
        int num = 0;
        int n = nums.length;
        for(int i=0; i< n; i++)
        {
            num = nums[i];
            count = 0;
            for(int j=0; j< n; j++)
            {
                if(nums[j] == num)
                {
                    count++;
                }
            }
            if(count == 1) return num;
        }
    return num;
    }
}


// #2 Optimized (Using Array hashing)
/*Algorithm*/
/* 
	-
	-
	-
	**Complexity Analysis**
	  -Time complexity  : nlogn +O(n/2 +1)
      -Space complexity : O(1)
*/
// #2 Optimized (HashMap)
/*Algorithm*/
/* 
	-Put the array element and its count into the map (element as key and count as value)
	-Traverse throught the map if count of element is 1 then return that element.
	-We used here un orderd map.
	**Complexity Analysis**
	  -Time complexity  : O(n)
      -Space complexity : O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {

        int n = nums.length;
        int val = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i < n; i++)
        {
            val = map.getOrDefault(nums[i],0);
            map.put(nums[i], val+1);
        }

        for(Map.Entry<Integer, Integer> res: map.entrySet())
        {
            if(res.getValue()==1)
            return res.getKey();
        }
        return -1;
    }
}

// #3 Optimal Soln(Uinng XOR)
/*Algorithm*/
/*
	-XOR of two same element is zero
	-XOR of two different element is number
	**Complexity Analysis**
	  -Time complexity  : O(n)
      -Space complexity : O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {
     int XOR = 0;
     for(int i = 0; i < nums.length; i++)
     {
        XOR = XOR^nums[i];
     }   
     return XOR;
    }
}