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