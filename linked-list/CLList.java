//Circular linked list
class CLList{
	
	private Node head;
	private Node tail;

	//constructor
	CLList(){
		this.head = null;
		this.tail = null;
	}

	//Circular linke list Node Structure
	class Node{
		int data;
		Node nextNode;

		Node(int data){
			this.data = data;
		}
	}

	//Inserting Node in Cicular linked list
	public void insert(int val){
		Node newNode = new Node(val);

		if(head == null && tail ==null){
			head = newNode;
			tail = newNode;
		}

		tail.nextNode = newNode;
		newNode.nextNode = head;
		tail = newNode;
	}

	//Print the circular linked list
	public void displayCLList(){
		Node tempNode = head;
		if(head!=null){
			do{
				System.out.print(tempNode.data+"->");
				tempNode = tempNode.nextNode;
			}while (tempNode!=head);
			System.out.print("Head");
		}
	}
	public static void main(String[] args) {

		CLList list  = new CLList();

		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		list.insert(16);
		list.displayCLList();
		
	}
}