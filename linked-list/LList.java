class LList{
	
	private Node head;
	private Node tail;
	private int size;

	//intializing the size of linked list
	LList(){
		this.size = 0;
	}

	//Creating node structure
	class Node{
		private int data;
		private Node nextNode;

		public Node(int val){
			this.data = val;
			nextNode = null;
		}

		//if you are providing next node as well
		public Node(int val, Node nextNode){
			this.data = val;
			this.nextNode = nextNode;
		}
	}

	//inserting the first node in linked list
	public void insertFirstNode(int val){
		Node newNode = new Node(val);
		newNode.nextNode = head;
		head = newNode;

		if(tail == null){
			tail = head;
		}
		size+=1;
	}

	//inserting the last Node in Linked list
	public void insertLastNode(int val){
		Node lastNode = new Node(val);

		if(tail==null){
			insertFirstNode(val);
			return;
		}else{
			tail.nextNode = lastNode;
		}
		tail = lastNode;
		size+=1;
	}

	//inserting the Node in at any particular index
	public void insertAtIndex(int val, int index){
		
		if(index==0){
			insertFirstNode(val);
		}else if(index==size) {
			insertLastNode(val);
		}else{

			Node tempHead = head;
			for (int i=1;i<=index;i++)
			{
				tempHead = tempHead.nextNode;
			}

			Node newNode = new Node(val,tempHead.nextNode);
			tempHead.nextNode = newNode;
		}
	}

	//print the linked linked list
	public void showLinkedList(){
		Node tempHead = head;

		while(tempHead!=null){
			System.out.print(tempHead.data+"->");
			tempHead = tempHead.nextNode;
		}
		System.out.println("End");
	}


	//main method
	public static void main(String arg []){
		LList list = new LList();

		list.insertFirstNode(50);
		list.insertFirstNode(40);
		list.insertFirstNode(30);
		list.insertFirstNode(20);
		list.insertFirstNode(10);
		list.insertLastNode(600);
		list.insertLastNode(700);
		list.insertLastNode(800);
		list.insertAtIndex(6,6);
		list.showLinkedList();
	}
}