// Stack.java


/**
 *  Implementation of Stack ADT using linked
 *  nodes.
 *  
 *  There are other useful methods for the Stack 
 *  ADT but pop, push, peek, and isEmpty are the only
 *  ones used.
 *  
 *  @author     Dominic Sciara
 */
public class Stack {
	
	public StackNode head;
	int length = 0;
	
//////////////// CONSTRUCTORS ////////////////
	
	public Stack() {
		this.head = null;
	}
	
	public Stack(char value) {
		this.head = new StackNode(value);
	}
	
	public Stack(StackNode head) {
		this.head = head;
	}
	
//////////////// METHODS ///////////////////
	
	/**
     *  Checking if the stack is empty or not
     *  @return boolean value for empty or not
     */
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
     *  Adding a new node as the new head of the stack
     *  @param the character value for the new head
     */
	public void push(char newVal) {
		StackNode newHead = new StackNode(newVal); 
		
		if (this.isEmpty()) {
			this.head = newHead;
		}
		else {
			newHead.next = this.head;
			this.head = newHead;
			this.length += 1;
		}
	}
	
	/**
     *  Remove the head of the stack and return the value
     *  @return the character value of the head node that is removed
     */
	public char pop() {
		// Underflow
		if (this.isEmpty()) {
			System.out.println("Stack Underflow"); 
			return ' ';
		}
		// switch head nodes
		else {
			StackNode temp = this.head;
			this.head = temp.next;
			this.length -= 1;
			return temp.value;
		}
	}
	
	/**
     *  See value at the head of the stack
     *  @return the character value of the head node
     */
	public char peek() {
		// Underflow
		if (this.isEmpty()) {
			System.out.println("Stack Underflow"); 
			return ' ';
		}
		else {
			return this.head.value;
		}
	}
	
}
