class LLAddOps {


	//linked list node
	class Node{
		int data;
		Node nextNode;

		Node(int val){
			this.data = val;
			nextNode = null;
		}
	}

	//head node
	Node head;

	//insert Node
	public void insertNode(int data){
		Node newNode = new Node(data);

		if(this.head == null){
			this.head = newNode;
		}else{
			Node tempHead = this.head;

			while(tempHead.nextNode!=null){
				tempHead = tempHead.nextNode;
			}
			tempHead.nextNode = newNode;	
		}
	}

	//method to insert the node at beigning
	public void insertAtStart(int data){

		Node newNode = new Node(data);
		
		if(this.head == null){
			this.head = newNode;
		}else{
			Node tempNode = this.head;
			newNode.nextNode = tempNode;
			this.head = newNode;
		}	
	}

	//printing the linked list 
	public void showLinkedList(){

		Node tempNode = head;
		while(tempNode!=null)
		{
			System.out.println(tempNode.data);
			tempNode = tempNode.nextNode;
		}
	}
	

	public static void main(String arg []){
		System.out.println("**************"+"Inserting Node at Begning of Linked List"+"******************");

		LLAddOps list = new LLAddOps();

		list.insertAtStart(20);
		list.showLinkedList();
		list.insertAtStart(10);
		list.insertNode(30);
		list.insertNode(40);
		list.insertNode(50);
		list.showLinkedList();

	}
}