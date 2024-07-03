//Find the length of loop in the loop






//Bruteforce
//Function should return the length of the loop in LL.

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