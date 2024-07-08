// Remove Duplicates from Sorted DLL 


// class Node{
// 	int data;
// 	Node next;
// 	Node prev;

// 	Node(int data)
// 	{
// 		this.data = data;
// 		this.next = null;
// 		this.next = null;
// 	}
// }


/* Explaination */
// Approach(By changing links)
/*
 - Take to pointers pointing to the same head and nextNode.
 - Keep moving the pointer for of nextnode till it same as data of temp
 - Change the links when it stops.
*/


class Solution{
    Node removeDuplicates(Node head){
        // Code Here.
        
        Node tempNode = head;
        Node nextNode;
        
        while(tempNode != null && tempNode.next !=null)
        {
            nextNode = tempNode.next;
            
            while(nextNode != null && nextNode.data == tempNode.data)
            {
                nextNode = nextNode.next;
            }
        
            tempNode.next = nextNode;
            
            if(nextNode != null) nextNode.prev = tempNode;
            
            tempNode = tempNode.next;
        }
        return head;
    }
}