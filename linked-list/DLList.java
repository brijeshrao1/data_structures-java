//Doubly linked list
class DLList{

	private Node head;
	private int size;

	DLList(){
		size =0;
	}

	class Node{
		int data;
		Node nextNode;
		Node prevNode;

		Node(int val){
			this.data = val;
			prevNode = null;
			nextNode = null;	
		}

		Node(int val, Node prevNode, Node nextNode){
			this.data = val;
			this.prevNode = prevNode;
			this.nextNode = nextNode;
		}
	}

	//insert first Node in doubly linked list
	public void insertAtStart(int val){
		Node newNode = new Node(val);

		newNode.nextNode = head;
		newNode.prevNode = null;

		if(head!=null){
			head.prevNode = newNode; 
		}
		head = newNode;
	}

	//insert Last Node in doubly linked list
	public void insertAtLast(int val){
		Node newNode = new Node(val);
		Node lastNode = head;

		newNode.nextNode = null;

		if(head==null){
			head = newNode;
			newNode.prevNode = null;
			return;
		}else{
			while(lastNode.nextNode!=null){
				// System.out.print(lastNode.data+"->");
				lastNode = lastNode.nextNode;
			}
		}
		lastNode.nextNode = newNode;
		newNode.prevNode = lastNode;
	}

	//insert at any pos in after particular value doubly linked list
	public void insertAtIndex(int val){

	}

	//print the doubly linked using next list
	public void dispalyNext(){
		Node tempNode = head;
		while (tempNode!=null){
			System.out.print(tempNode.data+"->");
			tempNode = tempNode.nextNode;
		}
		System.out.println("End");
	}

	//print the doubly using prev linked list
	public void dispalyPrev(){
		Node tempNode = head;
		Node lastNode = null;
		while(tempNode!=null){
			lastNode = tempNode;
			tempNode = tempNode.nextNode;	
		}
        // System.out.print(lastNode.nextNode);
		while(lastNode!=null){
			System.out.print(lastNode.data+"<-");
			lastNode = lastNode.prevNode;
		}
		System.out.println("Start");		
	}


	public static void main(String argc []){

		System.out.println("Doubly Linked List");
		DLList list = new DLList();

		list.insertAtStart(50);
		list.insertAtStart(40);
		list.insertAtStart(30);
		list.insertAtStart(20);
		list.insertAtStart(10);
		list.insertAtLast(60);
	
		list.dispalyNext();
		// list.dispalyPrev();
	}

}