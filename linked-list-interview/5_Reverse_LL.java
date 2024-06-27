//Reverese a Linked List Iteratively and Recursivly

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



// #1 Bruteforce (Using Using Stack)
/*Explaination*/
/* Create a Temproary pointer and stack then traverse throught the linked list and push all elements into the stack.
 * Now reinitalize the temp with head and again traverse throught the ll and pop the elements from stack and change the value in linked list.
 * Return head of ll (ll will be having the element in reverse order).
*/

class Solution {
    public ListNode reverseList(ListNode head) {

        //Buteforce 
        ListNode  tempNode = head;
        Stack <Integer> stk = new Stack <Integer>();

        while(tempNode != null)
        {
            stk.push(tempNode.val);
            tempNode = tempNode.next;
        } 

        tempNode = head;
        while(tempNode != null)
        {
            tempNode.val = stk.pop();
            tempNode = tempNode.next;
        }

        return head; 
    }
}
//T.C = O(2n);
//S.C = O(n);(ie using extra space as stack )

// #2 Optimized (In-place reversal, Interchanging the connecting links of the nodes ie changing the direction of the arrows (Using prev, front and Temp) )
/*Explaination*/
/* Create three pointers prev(to track the prev node), front(to change the links) and Temp(to traverse the ll)
 * Now reinitalize the temp with head and again traverse throught the ll and pop the elements from stack and change the value in linked list.
 * Return head of ll (ll will be having the element in reverse order).
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode frontNode;
        ListNode prevNode = null;
        ListNode tempNode = head;

        while(tempNode != null)
        {
            //interchagning the links of node
            frontNode = tempNode.next;
            tempNode.next = prevNode;
            prevNode = tempNode;
            tempNode = frontNode;
        }

        return prevNode;
    }
}
//T.C = O(n);
//S.C = O(1);

// #3 Optimal (Using Recursion)

