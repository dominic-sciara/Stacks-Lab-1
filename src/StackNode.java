// StackNode.java


/**
 *  StackNode class to be used for linked list
 *  implementation of a stack.
 *  
 *  @author     Dominic Sciara
 */
public class StackNode {
	
////////////////ATTRIBUTES ///////////////////
	public char value;
	public StackNode next;
	
////////////////CONSTRUCTOR///////////////////
	public StackNode(char x) {
		this.value = x;
		this.next = null;
	}
	
}
