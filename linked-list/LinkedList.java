class LinkedList{

	//creating node data type(class)
	class Node{
		int data;
		Node nextNode;

		//intializing the Node
		Node(int val){
			this.data = val;
			nextNode = null;
		}

		Node head;
	}

	//Insert node method
	public void insertNode(int data){

		Node newNode = new Node(data);

		if(this.head==null){
			this.head = newNode;
		}
		else{
			Node tempNode = this.head;
			while(tempNode!=null)
			{
				tempNode = tempNode.nextNode;
			}
		}
	}

	//print linked list
	public void printLList(){

		Node tempNode = this.head;

		while(tempNode!=null){
			System.out.println(tempNode.data);
			tempNode= tempNode.nextNode;
		}

	}

	//main method
	public static void main(String arg []){
		System.out.println("Welcome to the Linked List...");

		LinkedList list = new LinkedList();

		//Inserting node into the linked list
		list.insertNode(10);
		list.insertNode(20);
		list.insertNode(30);
		list.insertNode(40);
		list.insertNode(50);

		//print llist
		list.printLList();
	}
}