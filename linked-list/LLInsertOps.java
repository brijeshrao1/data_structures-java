class LLInsertOps {

	//linked list node
	class Node{
		int data;
		Node nextNode;

		Node(int val){
			this.data = val;
			nextNode = null;
		}
	}

	//Head node
	Node head;

	//Insert Node at the begining
	public void insertAtStart(int data){

		Node newNode = new Node(data);
		
		if(this.head == null){
			this.head = newNode;
		}
		else
		{
			Node tempNode = this.head;
			newNode.nextNode = tempNode;
			this.head = newNode;
		}	
	}

	//Inserting at Node nth possition

	public void insertAtPos(int data, int pos){
		Node newNode = new Node(data);

		Node tempNode = this.head;
		int nodeCount = 0;

		// if(this.head == null & nodeCount==pos){
		// 	this.head = newNode;
		// 	nodeCount+=nodeCount;
		// }
		if(tempNode == null && nodeCount==pos){
			tempNode = newNode;
			nodeCount = nodeCount + 1;
			this.head = tempNode;
		}
		else
		{
			while(pos != nodeCount){
				tempNode = tempNode.nextNode;	
				nodeCount += nodeCount;
			}

			
		}

	}


	//Inserting at 


	//Insert Node at the last
	public void insertAtEnd(int data){

		Node newNode = new Node(data);
		if(this.head == null){
			this.head = newNode;
		}
		else
		{
			Node tempHead = this.head;
			while(tempHead.nextNode!=null){
				tempHead = tempHead.nextNode;
			}
			tempHead.nextNode = newNode;	
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

		System.out.println("Inserting Node at Begning of Linked List");

		LLInsertOps list = new LLInsertOps();

		list.insertAtPos(20,0);
		list.showLinkedList();

	}
}