//Delete the middle of the linked list 

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

// #1 Bruteforce (using n/2)
/*Explaination*/
/* s
	Hint: You have to just find node just before the middle node.
	- Traverse  and find the length(n) of ll.
	- Now again traverse through the ll and keep decreasing the count so that it you reach to node just before the middle node.
	- Change the links break the loop and return the head.
*/
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        ListNode temp = head;

        //Edge case
        if (head == null || head.next == null) return null;

        //Finding the length of the ll
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        int res = count/2;
        temp = head;
        while(temp != null)
        {
            res--;
            if(res == 0)
            {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }   
    return head; 
    }
}

// #2 Optimized Approach (Using Fast and Slow pointer)
/*Explaination*/
/* 
 Hint: Skip one step of slow pointer.
 Note: *Odd list fast pointer will reaches to last node
 	   *Even list fast pointer will reaches to null
 - Move slow and fast pointer by 1 and 2 steps
 - When fast pointer will reaches to lastnode or null at that ponint of time slow will be poninting to the just before the middle node.
 - Remove the node by changing the links of slow pointer
*/
class Solution {
    public ListNode deleteMiddle(ListNode head) {

        ListNode slow = head;

        if(head == null || head.next == null) return null;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;  
        }
        slow.next = slow.next.next;
        return head;   
    }
}