//Check wether Array is sorted or not 

public class Solution {
    public static int isSorted(int n, int []a) {
        // Write your code here.

        for(int i=1; i< a.length; i++)
        {
            if(a[i] >= a[i-1])
            {

            }else
            {
                return 0;
            }
        }
        return 1;
    }
}