//Find the largest Rectangle in Histogram




// #1 Bruteforce (Finding right smaller element and Left Smaller Element:)
/*Explaination*/
/* 


// #1 Solution for 1

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for(int i = 0; i< heights.length; i++)
        {
            int minHeight = Integer.MAX_VALUE;
            for(int j = i; j < heights.length; j++)
            {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea,minHeight * (j - i +1));
            }
        } 
        return maxArea;
    }
}

// #1 Solution for 2 Passees
//
class 
 int n = heights.length;
        Stack<Integer> stk = new Stack<> ();
        int leftSmall[] = new int [n];
        int rightSmall[] = new int [n];

        for(int i = 0; i < n ; i++)
        {
            while(!stk.isEmpty() && heights[stk.peek()] >= heights [i])
            {
                stk.pop();
            }
            if(stk.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = stk.pop() +1;
            stk.push(i);
        }

        //
        while(!stk.isEmpty()) stk.pop();

        for(int i = n-1; i >= 0; i--)
        {
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i])
            {
                stk.pop();
            }

            if(stk.isEmpty()) rightSmall[i] = n-1;
            else rightSmall[i] = stk.peek() -1;

            stk.push(i);
        }

        //
        int maxA = 0;
        for(int i=0; i<n; i++)
        {
           maxA = Math.max(maxA,heights[i]*(rightSmall[i] - leftSmall[i] +1)); 
        }

        return  maxA;



lass Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack < Integer > st = new Stack < > ();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) rightSmall[i] = n - 1;
            else rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;  

    }
}



/**/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack < Integer > st = new Stack < > ();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) rightSmall[i] = n - 1;
            else rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;  

    }
}
/**/


// #2 Optimized ()
/*Explaination*/
/* 
//Single Pass 

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack <Integer> stk = new Stack<> ();
        int maxA = 0;
        int n = heights.length;

        for(int i = 0; i <= n; i++)
        {
            while(!stk.empty() && (i == n || heights[stk.peek()]>= heights[i]))
            {
                int h = heights[stk.peek()];
                stk.pop();
                int width;
                if(stk.empty())
                    width = i;
                else
                    width = i - stk.peek() - 1;
                maxA = Math.max(maxA, width * h);
            }
            stk.push(i);
        }
        return maxA;  
    }
}

*/