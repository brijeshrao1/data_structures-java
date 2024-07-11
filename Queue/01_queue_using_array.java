//Implement Queue using Array

class Queue{
	private int front, rear, size, qLength;
	private int queue[];

	Queue(int arrSize){
		front = rear = qLength = 0;
		size = arrSize;
		queue = new int [size];
	}


	//queueEnqueue operation
	public void enqueue(int data)
	{
		if(qLength == size)
		{
			System.out.println("Queue is full please come after some time");
			return;
		}else{
			queue[rear] = data;
			qLength++;
			rear++;
		}
	}

	//queueDequeue operation
	public int dequeue(int data)
	{
		if(qLength == 0)
		{
			System.out.println("Queue is empty");
			return -1;
		}else{
			int deletedData = queue[front];
			front ++;
			qLength--;
			return deletedData;
		}
	}

	//Print Queue;
	public void displayQueue()
	{
		if(front == rear)
		{
			System.out.println("Queue is empty");
		}else{
			for(int i=front; i<rear; rear++)
			{
				System.out.print(queue[front]);
			}
		}
	}

	//main
	public static void main(String[] args) {

		Queue q = new Queue (4);
		System.out.println(q.size);
		System.out.println(q.);
		System.out.println(q.size);
		System.out.println(q.size);
		System.out.println(q.size);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.displayQueue();
	}
}

//GFG Question


class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=0;
		rear=0;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    if(rear > arr.length)
	    {
	        return;
	    }else{
	        arr[rear] = x;
	        rear++;
	    }
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		if(front == rear)
		{
		    return -1;
		}else
		{
		    int deletedEle = arr[front];
		    front++;
		    return deletedEle;
		}
		
	} 
}
