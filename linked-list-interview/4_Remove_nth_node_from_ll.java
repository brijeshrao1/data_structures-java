//Remove Nth Node from end of LL


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

// #1 Bruteforce (Using Counter and L-N )
/*Explaination*/
/*
 * Find length(L) of ll
 * Find the node1(just before{(L - N)}) the node2 (which you want to delete {(L - N)+1}).Where N is the node which you want to delete 
 * Now traverse through the LL till (count become zero )
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //Find the length of ll
        ListNode tempNode = head;
        int nodeCount = 0;

        while(tempNode != null){
            nodeCount ++;
            tempNode = tempNode.next;
        }

        //If n is pointing to head of ll
        if( nodeCount == n ){
            ListNode newHead = head.next;
            return newHead;
        } 

        //index of node before deletion node
        int nodeNum = nodeCount - n;
        tempNode = head;
        while(tempNode != null){
            nodeNum --;
            if (nodeNum == 0) break;  
            tempNode = tempNode.next;  
            }
            tempNode.next = tempNode.next.next;

        return head;
    }
}

// #2 Optimal Soln (Using Fast and Slow Pointer )
/*Explaination*/
/*
 * Take two pointer fast and slow pointing to the head of ll. 
 * At very first move the fast pointer by n steps(n = node number to delete form end). when loop ends it will be pointing to the node just before the node which you want to delete.
 * At this moment Slow is pointing to head and fast is pointing to just before node. Now start moving both pointer till fast.next != null
 * At last slow will be pointing to the just before node which you want to delete. Now remove the links using slow pointer for deletion of node.
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //
        ListNode fastPtr = head, slowPtr = head;
        for(int i=1; i <= n; i++) fastPtr = fastPtr.next;

        //
        if(fastPtr == null) return head.next;

        //
        while(fastPtr.next != null){
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = slowPtr.next.next;

    return head;
    }
}




