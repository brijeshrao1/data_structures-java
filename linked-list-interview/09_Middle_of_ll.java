//Find Middle Of the linked List

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


// #1 Bruteforce (By finding length of ll)
/*Explaination*/
/*
    - Traverse throught the linked list and count the node of ll.
    - callculate middle (middle /2 + 1) and Re initialize the temp with head
    - Traverse throught the ll and decrease the count till it becomes zero. The point where count become zero will be your middle of ll.
*/ 
class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode temp = head;

        //Find the length of the linked list and count the nodes
        int count=0;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }

        //find middle
        int middle = (count/2)+1;
        temp = head;
        
        while (temp != null)
        {
            middle--;
            if(middle == 0) break;
            temp = temp.next;
        }
        return temp;
    }
}

/**Optimized:(Tortoise and Hare Algo)*/
/*Explaination*/
/* 
	- Take to pointers slow and Fast (ie Slow will move by 1 step and Fast will be moved by 2 steps.   
    **Note:** 
    - for Even = at end of traversal fast will be null.
    - for odd = at end of traversal fast will be at last node.
    - When fast pointer reaches to any of above two places stop then and there. return the node which is being pointed by slow pointer. 
    (Slow pointer will be pointing to the middle node).
*/