// Two Sum return yes or no




// #1 Bruteforce (Lear search)
/*Algorithm*/
/* 
	-Traverese thorught the array do the sum of elements (each combination using two loops)
	-If target is == sum the return "YES" else return NO as string 
	**Complexity Analysis**
	  -Time complexity  : O(n*n)
      -Space complexity : O(1)
*/
public class Solution {
    public static String read(int n, int []book, int target){
       for(int i = 0; i<n; i++)
       {
           for(int j=0; j<n; j++)
           {
               if(i == j) continue;
               if(book[i] + book [j] == target) return "YES";
           }
       }
       return "NO";
    }
}

/*Brute force slightly optimized*/
//Instead of adding each element add the i+1 element;
public class Solution {
    public static String read(int n, int []book, int target){
       for(int i = 0; i<n; i++)
       {
           for(int j=i+1; j<n; j++)
           {
               if(book[i] + book [j] == target) return "YES";
           }
       }
       return "NO";
    }
} 


// #2 Optimized (Hashing)
/*Algorithm*/
/* 
	-Use the HashMap to store the element and its index.
	-Travere through the array and subtract each element fromm the target. 
	-if the resultant values is present inside hashMap the return "YES" otherwise "NO.
    
	**Complexity Analysis**
	  -Time complexity  : O(n)
      -Space complexity : O(1)
*/
public class Solution {
    public static String read(int n, int []book, int target){

        HashMap<Integer, Integer> hMap = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            if(hMap.containsKey(target - book[i]))
            {
                return "YES";
            }else
            {
                hMap.put(book[i],i);
            }
        }
    return "NO";
    }
}

// #3 Optimal Soln()
/*Algorithm*/
/*
	-
	-
	-
	**Complexity Analysis**
	  -Time complexity  : O(n)
      -Space complexity : O(1)
*/