//Union of two sorted array Or Merge two sorted array


// #1 Bruteforce (Using set)
/*Algorithm*/
/* 
	-Traverse through the both array and put them in set.
	-Take out elements from the set and store into the union arraylist
	- Sort and return the array list.
	**Complexity Analysis**
	  -Time complexity  : O(n)
      -Space complexity : O()
*/

class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        Set <Integer> hashSet = new HashSet<>();
        ArrayList<Integer> union = new ArrayList<>();
        
        for(int i=0; i<n; i++)
        {
            hashSet.add(arr1[i]);
        }
        
        for(int i=0; i<m; i++)
        {
            if(!hashSet.contains(arr2[i]))
            {
                hashSet.add(arr2[i]);
            }
        }
        
        for(Integer item : hashSet)
        {
            union.add(item);
        }
        Collections.sort(union);
        return union;
    }
}
/*Using HashSet*/
static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
  HashSet <Integer> s=new HashSet<>();
  ArrayList < Integer > Union=new ArrayList<>();
  for (int i = 0; i < n; i++)
    s.add(arr1[i]);
  for (int i = 0; i < m; i++)
    s.add(arr2[i]);
  for (int it: s)
    Union.add(it);
  return Union;
}

// #2 Brute force (Using hashmap)
/*Algorithm*/
/* 
	-
	-
	-
	**Complexity Analysis**
	  -Time complexity  : O(n)
      -Space complexity : O(1)
*/


// #3 Optimal Soln(Two pointer)
/*Algorithm*/
/*
	-Take two pointers i and j. i will point to the arr1 elements & j will point to the arr2 elements.
	-Compare element of array pointed by i and j and put them in union list
	-
	**Complexity Analysis**
	  -Time complexity  : O(n+m)
      -Space complexity : O(n+m)
*/

class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
     ArrayList<Integer> union = new ArrayList <>();
        int i = 0, j = 0;
        
        while(i < n && j < m)
        {
            if(arr1[i] <= arr2[j])
            {
                if(union.size() == 0 || union.get(union.size()-1) != arr1[i])
                {
                    union.add(arr1[i]);
                }
                 i++;
            }
            else
            {
                if(union.size() == 0 || union.get(union.size()-1) != arr2[j])
                {
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        
        while(i<n)
        {
            if(union.get(union.size()-1) != arr1[i])
            {
                union.add(arr1[i]);
            }
            i++;
        }
        
        while(j<m)
        {
            if(union.get(union.size()-1) != arr2[j])
            {
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }
}