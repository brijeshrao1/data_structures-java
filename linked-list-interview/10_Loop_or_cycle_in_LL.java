//Detecting Loop/Cycle in Linked List

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// #1 Bruteforce (Using Hashset)
/*Explaination*/
/* 
 - Traverse through the ll and keep pushing the nodes in hashMap.
 - while pushing we will check wether this node is already present in the node or not.
 - if node is already there then return true else return false
*/
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode temp = head;

        Map<ListNode,Integer > hashMap = new HashMap<>();
        while( temp != null && temp.next !=null)
        {
            if(hashMap.containsKey(temp)) return true;
            
            hashMap.put(temp,1);
            temp = temp.next;
        }
    return false;
    }
}

// #2 Optimized Approach (Using Fast and Slow pointer)
/*Explaination*/
/* 
 - Take two pointer (Slow and Fast) pointing to the head of linked list.
 - Move the pointer util fast != null and fast.next != null
 - return true if both pointer points to the same node 
*/
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        } 
        
        return false;
    }
}