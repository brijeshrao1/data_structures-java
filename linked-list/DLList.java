//Doubly linked list
class DLList{

	private Node head;
	private int size;

	DLList(){
		size = 0;
	}

	//Doubly linked list node structure
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

	//Insert first Node in doubly linked list
	public void insertAtStart(int val){
		Node newNode = new Node(val);

		newNode.nextNode = head;
		newNode.prevNode = null;

		if(head!=null){
			head.prevNode = newNode; 
		}
		head = newNode;
	}

	//Insert Last Node in doubly linked list
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
		size+=1;
	}

	//Insert at any pos in after particular value doubly linked list
	public void insertAtIndex(int val,int index){
		Node newNode = new Node(val);

		//Check for the first case if DLL is empty
		if(head==null && index==0){
			head = newNode;
			size+=1;
		}else{
			if(size<=index||index<0||head==null){
				System.out.println("ERROR: Invalid index "+index+" Please enter the index range  between {0 to "+size+"}");
				return;
			}
			Node tempNode = head;
			int countIndex =0;
			while(tempNode!=null && countIndex <=index){
				tempNode = tempNode.nextNode;
				countIndex+=1;
			}
		}

	}

	//Search in doubly linked list and return value
	public boolean  search(int val){
		Node tempNode = head;

		while(tempNode!=null && tempNode.data != val){
			tempNode = tempNode.nextNode;
		}

		if (tempNode.data == val) {
			return true;
		}
		return false;
	}

	//Search in doubly linked list and return node
	public Node searchNode(int val){

		Node tempNode = head;

		while(tempNode!=null && tempNode.data != val){
			tempNode = tempNode.nextNode;
		}

		if (tempNode.data == val) {
			return tempNode;
		}
		return null;

	}

	//Insert After the some particular value;
	public void insertAfter(int val, int after){
		Node insertAfterNode = searchNode(after);
		
		if(insertAfterNode == null){
			System.out.println("not found");
			return;
		}

		Node newNode = new Node(val);

		newNode.nextNode =insertAfterNode.nextNode;
		insertAfterNode.nextNode = newNode;
		newNode.prevNode = insertAfterNode;

		if(newNode.nextNode!=null){
			newNode.nextNode.prevNode = newNode;
		}
		size+=1;
	}

	//print the doubly linked using next list
	public void dispalyNext(){

		Node tempNode = head;
		System.out.println("Length of Doubly linked list is: "+ this.size);
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

		DLList list = new DLList();	
		list.insertAtLast(10);
		list.insertAtLast(20);
		list.insertAtLast(30);
		list.insertAtLast(40);
		list.insertAtLast(50);
		// list.insertAtIndex(0,3);
		list.dispalyNext();
		list.insertAfter(22,20);
		list.dispalyNext();
		
		System.out.println(list.search(20));
		System.out.println(list.searchNode(20));

	}

}