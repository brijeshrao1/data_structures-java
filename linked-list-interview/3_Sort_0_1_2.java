// Sort the 0's,1's and 2's in LL


/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
// #1 Bruteforce (Using Data Replacement)
/*Explaination*/
/*
 * Take 3 counters named as count0,count1 and count2;
 * Traverse through the LL and increase the corresponding counts for nums you are getting while traversal.
 * Again traverse the LL to do the data replacement in LL
*/


class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        
        Node tempNode = head;
        int count0 = 0,count1 = 0, count2 = 0;/*counters*/
        
        //counting the occurancess of 0's, 1's and 2's
        while(tempNode != null){
            
            if(tempNode.data == 0)
            {
                count0++;
            }else if(tempNode.data == 1)
            {
                count1++;
            }else
            {
                count2++;
            }
            
            tempNode = tempNode.next;
        }
        
        //Replacing the data in ll based in counts
        tempNode = head;
        
        while(tempNode != null)
        {
            if(count0 != 0)
            {
                tempNode.data = 0;
                count0--;
            }else if (count1 != 0)
            {
                tempNode.data =1;
                count1--;
            }else
            {
                tempNode.data = 2;
                count2--;
            }
            
            tempNode = tempNode.next;
        }
        
        return head;
    }
}

//T.C = O(2n); Here we are using two passes
//S.C = O(1);

// #2 Optimal soln (Segrigating in one pass)

// Approach: Segrigate the 0's,1's and 2's in three seprate dummyNodes.

/*Explaination*/
/*
 *Create three dummyNode to segrigate the 0's,1's and 2's another three pointer nodes which will point to the current nodes of each Segrigated list.
 *We will traverse through the ll for segrigation 
 *At last we will merge / join the links of these three lls and we will return the new head
*/

class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        
       Node zeroHead = new Node(-1);
       Node oneHead = new Node(-1);
       Node twoHead = new Node(-1);
       
       Node zeroNode = zeroHead, oneNode = oneHead, twoNode = twoHead, tempNode = head;
       Node newHead;
       
       if (head == null || head.next == null) return head;
       
       while(tempNode != null)
       {
           if(tempNode.data == 0)
           {
               zeroNode.next = tempNode;
               zeroNode =  tempNode;
           }else if(tempNode.data == 1)
           {
                oneNode.next = tempNode;
                oneNode = tempNode;
           }else
           {
               twoNode.next = tempNode;
               twoNode = tempNode;
           }
           
           tempNode = tempNode.next;
       }
       
       zeroNode.next = (oneHead.next != null)? oneHead.next: twoHead.next;
       oneNode.next =twoHead.next;
       twoNode.next = null;
       
       newHead = zeroHead.next;
       
       return newHead;
    }
}

//T.C = O(n); Here we are using one passes
//S.C = O(1);
