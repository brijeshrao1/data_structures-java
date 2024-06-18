//Rearrange Odd and Even in Linked list;
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//#1 Bruteforce Approach

/* ---Explaination--- */
/*
 *Take a tempNode and move it by 2 steps and traverse the ll three times.
 *1st time to find Odd indexes and push it to the array list.
 *2nd time to find the even indexes and push it to the array list.
 *3rd time to update the ll node values by array list values.
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        ListNode tempNode = head;
        ArrayList <Integer> arrayList = new ArrayList<> ();
        
        //check wether the ll having one node only or empty ll
        if(head == null || head.next == null) return head;
        
        //traversing for odd indexses
        while(tempNode != null &&  tempNode.next != null)
        {
            arrayList.add(tempNode.val);
            tempNode = tempNode.next.next;
        }
        
        //Adding last node when ll length is even
        if(tempNode!=null) arrayList.add(tempNode.val);
        
        //traversing for even indexes
        tempNode = head.next;
        while(tempNode !=null && tempNode.next != null)
        {
            arrayList.add(tempNode.val);
            tempNode  = tempNode.next.next;
        }
        
        //Adding last node when ll length is odd
        if(tempNode!=null) arrayList.add(tempNode.val);
        
        int i = 0;
        tempNode = head;
        while(tempNode!=null)
        {
            tempNode.val = arrayList.get(i);
            i++;
            tempNode = tempNode.next;
        }
        
     return head;    
    }
}


T.C = O();
S.C = O(n);


//#2 Optimal Approach:
/* ---Explaination--- */
/*
 *By Changing the links approach
 *Take two pointers (oddNode and evenNode). Odd will point to the odd nodes and evenNode will point to the even nodes.
 *Keep moving the pointer nodes (oddNode and evenNode) untill even node points to the last node.
 *NOTE: All checks should be made on evenNode only. And keep a track of evenHead Node which will be used at last to join the both ll
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        ListNode oddNode,evenNode,evenHead; 
        
        //Check for edge casse like empty ll or ll with only one node
        if(head == null || head.next == null )
        {
            return head;
        }else{
            oddNode = head;
            evenNode = head.next;
            evenHead = head.next;
        }
       
        //Changing the links of odd and even node and grouping them seprately
        while(evenNode !=null && evenNode.next != null)
        {
            oddNode.next = oddNode.next.next;
            evenNode.next = evenNode.next.next;
            
            oddNode = oddNode.next;
            evenNode = evenNode.next;
        } 
        
        //joining the both even and odd ll group
        oddNode.next = evenHead;
        
     return head;   
    }
    
}