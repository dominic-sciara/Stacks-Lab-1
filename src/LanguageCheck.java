// LanguageCheck.java


/**
 *  Tests for different languages on given strings.
 *  
 *  NOTICE:In my comments below, I will refer
 *  to a "round". What I mean by this is:
 *  	FullString: ABAABBAAABBB
 *  	round1 = AB
 *  	round2 = AABB
 *  	round3 = AAABBB
 *  
 *  @author     Dominic Sciara
 */
public class LanguageCheck {
	
		//////////LANGUAGE 1 TEST//////////
	/**
     *  Algorithm for checking if a given string adheres to
     *  language 1 rules:
     *  	L1= { w: w contains equal numbers of A's and B's 
     *  		(in any order) and no other characters} 
     *  
     *  @param text The text to be tested.
     */
	public static String language1(String text) {
		Stack s = new Stack();
		char c;
		
		// Looping through text string, 1 character at a time
		for (int i = 0; i < text.length(); i++){
			c = text.charAt(i);
			
			// checking for characters other than A and B
			if (c != 'A' && c != 'B') {
				return "FAIL - Contains invalid character: " + c;
			}
			// empty stack = push A or B to stack
			else if (s.isEmpty()) {
				s.push(c);
			}
			// A's get pushed on top of A's
			// B's get pushed on top of B's
			else if (s.peek() == c){
				s.push(c);
			}
			// A's pop off B's
			// B's pop off A's
			else {
				s.pop();
			}
		}
		
		// there was the same amount of A's and B's
		// after all the rounds
		if (s.isEmpty()) {
			return "PASS!";
		}
		// different amount of A's and B's after all the rounds
		else {
			return "FAIL - Number of A's != Number of B's";
		}
		
	}
	
		//////////LANGUAGE 2 TEST//////////
	/**
     *  Algorithm for checking if a given string adheres to
     *  language 2 rules:
     * 		L2 = { w: w is of the form (A^n)(B^n), for some n > 0 } 
     * 
     *  @param text The text to be tested.
     */
	public static String language2(String text) {
		Stack s1 = new Stack();
		boolean round1 = true;
		char c;
		
		
		// edge case
		if (text == "") {
			return "FAIL - Empty string is invalid";
		}
		
		// Looping through text string, 1 character at a time
		for (int i = 0; i < text.length(); i++){
			c = text.charAt(i);
			
			// checking for characters other than A and B
			if (c != 'A' && c != 'B') {
				return "FAIL - Contains invalid character: " + c;
			}
			
			else if (c == 'A') {
				// this means there is no B's in the stack yet
				if (round1) {
					s1.push(c);
				}
				// there can only be 1 full round for language 2
				else {
					return "FAIL - A's can not occur after B's";
				}
			}
			
			else if (c == 'B') {
				// so we know that no more A's can occur after this
				round1 = false;
				
				// text can't start with B's
				// OR there is no more A's to be popped off
				if (s1.isEmpty()) {
					if (text.charAt(0) == 'B') {
						return "FAIL - String cannot start with a B";
					} else {
						return "FAIL - Too many B's in one round";
					}
				}
				// popping off A's for each B that comes up
				else {
					s1.pop();
				}
			}
			
		}
		
		// means there is the same number of A's and B's
		if (s1.isEmpty()) {
			return "PASS!";
		} 
		// different number of A's and B's
		else {
			return "FAIL - Number of A's != Number of B's";
		}
	}
	
		//////////LANGUAGE 3 TEST//////////
	/**
     *  Algorithm for checking if a given string adheres to
     *  language 3 rules:
     * 		 L3 = { w: w is of the form (A^n)(B^2n), for some n > 0 } 
     * 
     * 	NOTICE: same exact logic as Test 2 is used, just pushing 2 A's for every 1 A
     * 
     *  @param text The text to be tested.
     */
	public static String language3(String text) {
		Stack s1 = new Stack();
		boolean round1 = true;
		char c;
		
		// edge case
		if (text == "") {
			return "FAIL - Empty string is invalid";
		}
		
		// Looping through text string, 1 character at a time
		for (int i = 0; i < text.length(); i++){
			c = text.charAt(i);
			
			// checking for characters other than A and B
			if (c != 'A' && c != 'B') {
				return "FAIL - Contains invalid character: " + c;
			}
			// this means there is no B's in the stack yet
			// pushing 2 A's to mimic language 2 logic
			else if (c == 'A') {
				if (round1) {
					s1.push(c);
					s1.push(c);
				}
				// there can only be 1 full round for language 3
				else {
					return "FAIL - A's can not occur after B's";
				}
			}
			else if (c == 'B') {
				// so we know that no more A's can occur after this
				round1 = false;
				
				// text can't start with B's
				// OR there is no more A's to be popped off
				if (s1.isEmpty()) {
					if (text.charAt(0) == 'B') {
						return "FAIL - String cannot start with a B";
					} else {
						return "FAIL - There are too many B's";
					}
				}
				// popping off A's for each B that comes up
				else {
					s1.pop();
				}
			}
			
		}
		
		// means there is the same number of A's and B's
		// but because we added 2 A's for every 1 in the String
		// this means we had exact (A^n)(B^2n)
		if (s1.isEmpty()) {
			return "PASS!";
		} 
		// different number of A's and B's
		else {
			return "FAIL - 2 * (Number of A's) != Number of B's";
		}
	}
	
	//////////LANGUAGE 4 TEST//////////
	/**
     *  Algorithm for checking if a given string adheres to
     *  language 4 rules:
     * 		 L4 = { w: w is of the form ((A^n)(B^m))^p, for some m,n,p > 0 } 
     * 
     *  @param text The text to be tested.
     */
	public static String language4(String text) {
		
         Stack s1 = new Stack(); // to store current round
         Stack s2 = new Stack(); // to store previous round
         char c;
        
         // edge case
	    if (text == "") {
	    	return "FAIL - Empty string is invalid";
	    }
	    
	  
	    // Looping through text string, 1 character at a time
	    for (int i = 0; i < text.length(); ++i) {  
	    	c = text.charAt(i);

	    	// checking for characters other than A and B
            if (c != 'A' && c != 'B') {
            	return "FAIL - Contains invalid character: " + c;
            }
            
            // A's always get pushed to s1
            else if (c == 'A') {
            	if (s1.isEmpty() || s1.peek() == 'A') 
            		s1.push(c);
            	else {
            		// popping off all items from s1 into s2
            		// because new round is starting (s1.peek = B)
            		while (!s1.isEmpty())
            			s2.push(s1.pop());
            		s1.push(c);
            	}
            }
            else if (c == 'B') {
            	// B can't be pushed to an empty s1
            	// that would mean text starts with a B
            	if (s1.isEmpty()) {
            		if (text.charAt(0) == 'B') {
						return "FAIL - String cannot start with a B";
					} else {
						return "FAIL - There are too many B's";
					}
            	}
            		
            	s1.push(c);
            }
            
            // pop off values from previous round to 
            // make sure it matches current round
            if (!s2.isEmpty()) {
            	if (s1.peek() == s2.peek())
            		s2.pop();
            	else {
            		return "FAIL - Rounds of A's and B's are not the same";
            	}
            }
	    }
	    
	    // s2 not empty implies different number of A's and B's in different rounds
	    if (!s2.isEmpty()) {
	    	return "FAIL - Rounds of A's and B's are not the same";
	    }
	    else {
	    	return "PASS!";
	    }
	    		
	        
	        	
    }
	
	//////////LANGUAGE 5 TEST//////////
	/**
     *  Algorithm for checking if a given string adheres to
     *  language 5 rules:
     * 		L5 = { w: w is of the form (A^n)C(B^n), for some n > 0 } 
     * 
     *  @param text The text to be tested.
     */
	public static String language5(String text) {
		Stack s1 = new Stack();
		boolean round1 = true;
		boolean containsC = false;
		char c;
		
		
		// edge case
		if (text == "") {
			return "FAIL - Empty string is invalid";
		}
		
		// Looping through text string, 1 character at a time
		for (int i = 0; i < text.length(); i++){
			c = text.charAt(i);
			
			// checking for characters other than A and B
			if (c != 'A' && c != 'B' && c != 'C') {
				return "FAIL - Contains invalid character: " + c;
			}
			
			else if (c == 'A') {
				// this means there is no B's in the stack yet
				if (round1) {
					s1.push(c);
				}
				// there can only be 1 full round for language 2
				else {
					return "FAIL - A's can not occur after B's";
				}
			}
			else if (c == 'C') {
				containsC = true;
				// can't start a new round without any A's
				if (s1.isEmpty()) {
					return "FAIL - There needs to be only A's before a C";
				}
				round1 = false;
			}
			
			else if (c == 'B') {
		
				// text can't start with B's
				// OR there is no more A's to be popped off
				if (s1.isEmpty()) {
					if (text.charAt(0) == 'B') {
						return "FAIL - String cannot start with a B";
					} else {
						return "FAIL - There are too many B's";
					}
				}
				else if (!containsC) {
					return "FAIL - Need a C in-between the A's and B's";
				}
				// popping off A's for each B that comes up
				else {
					s1.pop();
				}
			}
			
		}
		
		// means there is the same number of A's and B's
		if (s1.isEmpty()) {
			if (!containsC) {
				return "FAIL - String does not contain a C";
			}
			return "PASS!";
		} 
		// different number of A's and B's
		else {
			return "FAIL - Number of A's != Number of B's";
		}
	}
	
}