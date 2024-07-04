//Implementing Stack Using Arrays with basic operations

import java.lang.*;

//Stack Structure
class Stack{

	//Defining Stack Structure
	static final  int MAXSIZE = 1000;
	
	static int top;

	int [] arr = new int[MAXSIZE];

	//Initialize the top of stack 
	Stack(){
		//when array is empty
		top = -1;
	}


	/*Basic Stack Operations*/
	//#1 push
	 void push(int data){
		//Check for Stack overflow
		if(top == MAXSIZE)
		{
			System.out.println("Stack Overflow");
		}else{
			top++;
			arr[top] = data;
			System.out.println(data +":Pushed");
		} 
	}

	//#2 pop
	 int pop(){

	 	int x = -1;
	 	if(top == -1)
	 	{
	 		return -1;
	 	}else{
	 		x = arr[top];
	 		top--;
	 	}

	 	//return the deleted data
		return x;
	}

	//#3 peek(returns the top element of the stack without removing it from stack)
	 int peek(){

	 	if(top == -1)
	 	{
	 		//when stack is empty
	 		return -1;
	 	}else{
	 		return arr[top];
	 	}
	}

	//#4 StackTop
	 int stackTop(){
	 	if(top == -1)
	 	{
	 		//when stack is empty
	 		return -1;
	 	}else{
	 		return arr[top];
	 	}		
	}

	//#5 isStackEmpty
	 boolean isStackEmpty(){
	 	if(top == -1)return true;
	 	else return false;
	}

	//#6 isStackFull
	 boolean isStackFull(){
		if(top == MAXSIZE)
		{
			return true;
		}else
		{
			return false;
		}
	}

	//#7 peek (returs data of specified position)
	int peekElement(int pos)
	{
		int x = -1;

		if(top - pos + 1 < 0 ){
			return -1;
		}else
		{
			x = arr[top - pos+1];
			return x;
		}
	}


   //#8 print the Stack data
     void printStack(){
     	
     	if(top == -1) System.out.println("Stack is Empty");

		for(int i = top; i>=0; i-- )
		{
			System.out.println(arr[i]);
		}
	}
}


//main class
class Main{
	public static void main(String[] args) {

		Stack stk = new Stack();

		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.printStack();
		System.out.println(stk.isStackFull());
		System.out.println(stk.peek());
		System.out.println(stk.isStackEmpty());
		System.out.println(stk.stackTop());
	    System.out.println(stk.pop());
	    System.out.println(stk.pop());
	    System.out.println(stk.peekElement(1));


	}
}