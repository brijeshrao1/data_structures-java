
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// #1 Bruteforce (Using Searching)
/*Explaination*/
/* Compare each and every node of the of list1 nodes with the nodes of list2 and return the node if it is found else false
*/ 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
       
        while(temp1 != null){
            ListNode temp2 = headB;

            while(temp2 != null )
            {
                  if( temp1 == temp2) return temp1;
                  temp2 = temp2.next;  
            }

            temp1 = temp1.next;
        }

        return null;
}
}


// #2 Bruteforce (Using Hashing)
/*Explaination*/
/*Traverse throught the linked list1 and put all nodes into the hash set.
 *Now traverse throught the linked list2 and compare its nodes withe nodes present in hashset. And return the nodes if found.
 *
*/ 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        HashSet <ListNode> hSet = new HashSet <> ();
        while(temp != null)
        {
            hSet.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while(temp != null)
        {
            if(hSet.contains(temp)) return temp;
            temp = temp.next;
        }
        
        return null;
    }
}

// Optimal Soln (By Comparing the length of ll)
/*Explaination*/
/*Find the lenght of each llist and difference(d) b/w the length of list.
 *Move the pointer of longer llist by d steps . Now at this point pointer of both linked list will be pointing to same lavel of nodes in linked list
 *Now move the pointer of both llist simultaneously till both pointer pointer points to same node if it intersects.
*/ 
public class Solution {

    public int getdifference(ListNode headA,ListNode headB)
    {
        
        ListNode temp1 = headA;
        ListNode temp2  = headB;
         //Find the length of the linked lists
        int len1=0, len2=0;

        while(temp1 != null ||temp2 != null )
        {
            if(temp1 != null)
            {
                len1++;
                temp1 = temp1.next;
            }

            if(temp2 != null)
            {
              len2++;
              temp2 = temp2.next;
            }
        }
        return len1 - len2; //assuming the len1 is > len2
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode temp1 = headA;
        ListNode temp2  = headB;
        
       int diff = getdifference(headA,headB);


        if( diff > 0)
        {
            // temp1 = headA;
            while(diff != 0)
            {
                temp1 = temp1.next;
                diff--;
            }
        }
        else
        {
            // temp2 = headB;
            while(diff !=0 )
            {
                temp2 = temp2.next;
                diff++;
            }
        }

        while(temp1 != null)
        {
            if(temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;   
    }
}

// Optimized (By Comparing llist node and Chaning Pointers)
/*Explaination*/
/* Here we will travere throught the  both linked list simultaneously.
 * If any one of temp reaches to the null we will make that temp point to the opposit ll.
*/ 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1 != temp2)
        {
        // {
        //     if(temp1 == null)
        //     {
        //         temp1 = headB;
        //     }else
        //     {
        //         temp1 = temp1.next;
        //     }

        //     if(temp2 == null)
        //     {
        //         temp2 = headA;

        //     }else{
        //          temp2 = temp2.next;
        //     }

        //Short hand 
        temp1 = temp1 == null? headA : temp1.next;
        temp2 = temp2 == null? headB : temp2.next;
        }
        return temp1;
    }
}