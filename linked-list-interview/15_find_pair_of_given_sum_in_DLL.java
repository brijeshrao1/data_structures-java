//find the pair in given doubly linked list


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

// #1 Bruteforce (Adding first element with next all element in dll)
/*Explaination*/
/* 
    - Pick the first elment and add it with rest of all next elements.
    - And keep pushing those pairs in 2D array whose sum == given targer.
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        Node temp1 = head, temp2 = null;
        
        ArrayList <ArrayList <Integer>> pairList = new ArrayList <> ();
        
        
        while(temp1 != null)
        {
            temp2 = temp1.next;
           
            while((temp2 != null) && (temp1.data + temp2.data <= target))
            {
                if((temp1.data + temp2.data) == target)
                {
                  ArrayList <Integer> pairs = new ArrayList <> ();
                  pairs.add(temp1.data);
                  pairs.add(temp2.data);
                  pairList.add(pairs);
                }
                
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        
        return pairList;
    }
}
   

// #1 Optimized (Using two pointer)
/*Explaination*/
/* 
    - Find the tail of doubly linked list
    - Take left and right pointer which will be pointing to the first and last node if doubly linked list.
    - Move the pointers untill data of left < data of right if data is equal the push the data into array list as pair.
    - Move left or Right if it is not a
*/
class Solution {
    
    //Method to find the tail of the dll
    public static Node findTail(Node head)
    {
        Node tail = head;
        while(tail.next != null)
        {
            tail = tail.next;
            
        }
        return tail;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        
        //
        ArrayList <ArrayList<Integer>> pairList = new ArrayList<>();
        
        if (head == null) return pairList;
        
        Node left = head;
        Node right = findTail(head);
        
        while(left.data < right.data)
        {
            if(left.data+right.data == target)
            {
                ArrayList <Integer> pairs = new ArrayList<>();
                pairs.add(left.data);
                pairs.add(right.data);
                
                pairList.add(pairs);
                
                left = left.next;
                right = right.prev;
                
            }else if(left.data+right.data < target)
            {
                // right = right.prev;
                left = left.next;
            }else{
                // left = left.next;
                right = right.prev;
            }
        }
        
        return pairList;
    }
}
        

