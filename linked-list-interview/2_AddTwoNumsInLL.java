//Problem: Add Two Numbers in Linked list 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummyHead = new ListNode(-1);
        ListNode currNode = dummyHead;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        int sum = 0;
        
        while(temp1!= null || temp2!=null){
            sum = carry;
            if(temp1!= null){   
                sum += temp1.val;
                // temp1 = temp1.next;
            }
            if(temp2!= null) {
                sum += temp2.val;
                // temp2 = temp2.next;
            }
            
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            
            //appending the node to the dummynode
            currNode.next = newNode;
            currNode = currNode.next;
            
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;           
        }
        
        //for left over carry
        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            currNode.next = newNode;
        }
        
        return dummyHead.next;
        
    }
}