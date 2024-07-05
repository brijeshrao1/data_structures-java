//Find the starting point of the loop in linked list


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

// #1 Bruteforce (Using Hash map)
/*Explaination*/
/* 
	- Traverse throught the linked list and keep putting inside the hashmap.
	- while putting into the hash map also check that whether it exist in or not 
	- If it exist that node will be your starting point of you list.
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        HashMap <ListNode,Integer> map = new HashMap<>();

        while(temp != null && temp.next != null)
        {
            //return the node if already exist
            if(map.containsKey(temp)) return temp;
            
            //put into the hash map if it is not there 
            map.put(temp,1);
            temp = temp.next;
        } 
        return null;
    }
}

// #1 Optimized (Fast and Slow Poniter)
/*Explaination*/
/* 
	- Detect a loop using fast and slow pointer.
	- To find the start point again move the one of any pointer from head and another from collision point by 1 step both.
	- Move until they point the same node, that node will be your starting point. 
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
       
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                slow = head;
                while(slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;       
    }
}