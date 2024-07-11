//Merge two sorted linked list

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/


// #1 Bruteforce (Using Array)
/*Explaination*/
/* 
	Approach: Take elements from l1 and l2 and push into array then sort and Merge them.
	- Traverse through the both ll and insert all those element into the array.
	- Sort the array
	- Convert the sorted array into linked list.
*/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		LinkedListNode<Integer> temp1 = first;
        LinkedListNode<Integer> temp2 = second;

        ArrayList <Integer> arr = new ArrayList<>();

        //Pushing element from first to Array list
        int count1 = 0;
        while(temp1 != null)
        {
            count1++;
            arr.add(temp1.data);
            temp1 = temp1->data;
        }

        //Pushing element from Second to Array list
        int count2 = 0;
        while(temp2 != null)
        {
            count2++;
            arr.add(temp1.data);
            temp2 = temp2->data;
        }

        //Sort the array


       //Convert into the linkedlist


        //return head;
        return head;

	}
}




// #2 Optimized (Using Two Pointers)
/*Explaination*/
/* 
	- create a dummyNode and two pointer (pointing to the l1 and l2)
	- Traverse both ll and keep compairing the data 
	- link the nodes to dummyNode and return the new nodes
*/

/*Java Solution*/
public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		LinkedListNode<Integer> dummyNode = new LinkedListNode<> (-1);
        LinkedListNode<Integer> currNode; 
        LinkedListNode<Integer> temp1 ;
        LinkedListNode<Integer> temp2 ;

        currNode = dummyNode;
        temp1 = first;
        temp2 = second;

        while (temp1 != null && temp2 != null) {
            if(temp1.data < temp2.data)
            {
                currNode.next = temp1;
                currNode = temp1;
                temp1 = temp1.next;
            }else{
                currNode.next = temp2;
                currNode = temp2;
                temp2 = temp2.next;
            }
        }
      
       //Merging the remaining node 
       if(temp1 != null) currNode.next = temp1;
       else currNode.next = temp2;
       
       return dummyNode.next;
	}
}


/*C++ solution*/

Node<int>* sortTwoLists(Node<int>* first, Node<int>* second)
{
    Node <int>* temp1 = first;
    Node <int>* temp2 = second;
    Node <int>* dummyNode = new Node <int> (-1);
    Node <int>* currNode = dummyNode;

    while (temp1 != NULL && temp2 != NULL) 
    {
        if(temp1->data < temp2->data)
        {
                currNode->next = temp1;
                currNode = temp1;
                temp1 = temp1->next;
        }else{
                currNode->next = temp2;
                currNode = temp2;
                temp2 = temp2->next;
        }
    }

    //Merging the remaining node 
    if(temp1) currNode->next = temp1;
    else currNode->next = temp2;

    return dummyNode->next;
      
}
