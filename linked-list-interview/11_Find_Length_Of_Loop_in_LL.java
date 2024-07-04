//Find the length of loop in the loop

//Node Structure
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

n

// #1 Bruteforce (Using HashMap)
/*Explaination*/
/* 
 - Take a timer(keep increasing the pointer) and Traverse through the ll and keep pushing the nodes and timer value as key value in hashMap until it points to null or points to same node.
 - when reached to same node(which is already present in hashmap) take out the value and find diff (d= timer - value).
 - d will your length of the linked list.
*/
class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        Node tempNode  = head;
        int timer = 1;
        
        HashMap <Node, Integer> hashMap = new HashMap <>();
        while(tempNode != null)
        {
            if(hashMap.containsKey(tempNode))
            {
                int value = hashMap.get(tempNode);
                return timer - value;
            }
            
            //push the node into hashmap
            hashMap.put(tempNode,timer);
            timer++;
            tempNode = tempNode.next;
        }
        
        //return zero if the ll is lenear
        return 0;
    }
}

// #2 Optimized Approach (Using Fast and Slow pointer)
/*Explaination*/
/* 
 - Take two pointer (Slow and Fast) pointing to the head of linked list.
 - Move the pointer util fast != null and fast.next != null.
 - if slow and fast point points to same node then find the lenght of loop 
 - to find the length move the fast pointer by one step now till it doesnot points to slow.
 Note: keep slow as it is where the loop is detected. start counting the loop node from next by moving fast 
*/
class Solution
{
    
    static int findLength(Node slow, Node fast)
    {
        int count = 1;
        fast = fast.next;
        while(slow != fast)
        {
            count++;
            fast = fast.next;
        }
    return count;
    }
    
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        Node fast = head;
        Node slow = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) return findLength(slow, fast);
        }
     return 0;
    }
}