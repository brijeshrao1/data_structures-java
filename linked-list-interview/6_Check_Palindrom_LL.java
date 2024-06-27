//Check Palindromm Linked List

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
/* Create a tempNode and Stack and traverse through the ll and push elements into the stack from ll
 * Reinitalize the tempNode with head and traverse again through the ll and compare the element with top of stack 
 * if all elements are equal then return true else false
*/
class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode tempNode = head;
        Stack <Integer> stk  = new Stack <> ();

        //traverse through the linked list and push into stack
        while( tempNode != null)
        {
            stk.push(tempNode.val);
            tempNode = tempNode.next;
        }

        //reinitialize the temp Node with head
        tempNode = head;

        //Comparing the stack and LL elements
        while(tempNode != null){
            if(tempNode.val == stk.pop())
            {
              tempNode = tempNode.next;  
            }else{
                return false;
            }
        }
        return true;
    }
}

// #1 Optimized Soln (Comparing Fist Half and Second Half)
/*Explaination*/
/* First of all find the middle of ll using Fast and Slow Pointer(Fast by 2 and Slow by 1).
 * Riverse the second Half(Note For Reversing the Linked List will pass slow.next)
 * Compare the Second Half and First Half and return true or fase accordingly
 NOTE: Incase of Odd LL fast will stop at the last node of ll but Incase of Even LL fast will stop at the second last node 
*/
class Solution {
    public ListNode reverseLL(ListNode nextHalfHead){

        //checking edge case( ll is empty or having only one element)
        if(nextHalfHead == null || nextHalfHead.next == null) return nextHalfHead;

        ListNode newHead = reverseLL(nextHalfHead.next);
        ListNode front = nextHalfHead.next;
        
        front.next = nextHalfHead;

        nextHalfHead.next = null;

        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
       
        //Finding the middle node 
        while(fast.next != null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next; 
        }

        //Reversing the second half of the ll and return the new head
        ListNode newHead = reverseLL(slow.next);
        
        ListNode firstHead = head;
        ListNode secondHead = newHead;

        //Comparing the first half with the second half
        while(secondHead != null)
        {
            if(firstHead.val != secondHead.val)
            {
                reverseLL(newHead);
                return false;
            }

            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
         reverseLL(newHead);

         return true;
    }
}
