// Project1.java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *  Project 1 demonstrates the stack ADT implementation
 *  and use cases. It is used here to identify input
 * 	text as certain languages. 
 * 
 * 	NOTICE: Similar file I/O is used here that is used in
 *  Project0.
 *  
 *  @author     Dominic Sciara
 */
public class Project1 {
	
	// Constants to help reading characters
	final int END_OF_STRING = 13;
	final int END_OF_FILE = -1;
	final int NEW_LINE = 10;
	
	
	
	/**
	 *  Main entry point for the program.
	 *  @param args[]   Holds two command line arguments:  the input filename
	 *                  and the output filename.
	 */
	public static void main (String args[]) {
		BufferedReader  input;
        BufferedWriter  output;
        Project1 project;
        
        
        project = new Project1();
        

        
        //  Check for command line arguments.
        if (args.length != 2) {
            System.out.println("Usage:  java Project1 [input file pathname]" +
                " [output file pathname]");
            System.exit(1);
        }
        
        //  Open the files that will be used for input and output.
        try {
            input = new BufferedReader(new FileReader(args[0]));
            output = new BufferedWriter(new FileWriter(args[1]));
        } catch (Exception ioe) {
            System.err.println(ioe.toString());
            return;
        }
        
        //  Repeats for each string separated by a new line
        while (true) {
	        String text = "";
	        int current = project.readChar(input);
	        
	        // Reading whole strings at a time from input file
	        while (current != project.END_OF_STRING && current != project.END_OF_FILE && current != project.NEW_LINE) {
	        	text += (char)current; // casting current from int
	        	current = project.readChar(input);
	        }
	        
	        // Output string being analyzed and its language test results
	        project.writeString("Input:" + text + "\n", output);
	        project.writeString("Language 1: " + LanguageCheck.language1(text) + "\n", output);
	        project.writeString("Language 2: " + LanguageCheck.language2(text) + "\n", output);
	        project.writeString("Language 3: " + LanguageCheck.language3(text) + "\n", output);
	        project.writeString("Language 4: " + LanguageCheck.language4(text) + "\n", output);
	        project.writeString("Language 5: " + LanguageCheck.language5(text) + "\n\n", output);
	        
	        // Breaking the loop essentially ends the program
	        if (current == project.END_OF_FILE) {
	        	break;
	        }
	        // Newline character follow after end of string characters
	        else if (current == project.END_OF_STRING){
	        	project.readChar(input);
	        }
	        
	        // Moving on to next string
        }
        
        
        
        
       
        
        
        //  Close files and end program
        try {
            input.close();
            output.close();
        } catch (Exception x) {
            System.err.println(x.toString());
        }
        return;
        
        
        
	}
	
	/**
     *  Reads the next character from the input file.
     *  @param  input A buffered stream from a file that contains one 
     *  			sequence of characters per line. (one string per line)
     *  @return The next integer representation of a character from the 
     *  			input file.
     */
	private int readChar(BufferedReader input) {
        int letter = 0;
        
        try {
            letter = input.read();
        } catch (IOException iox) {
            System.err.println(iox.toString());
            System.exit(2);
        }
        
        return letter;
    }
	
	
	 /**
     *  Write a string to the output stream.
     *  @param text   The text to write.
     *  @param output The output stream to write the text to.
     */
	private void writeString(String text, BufferedWriter output) {
	    
        try {
            output.write(text);  
        } catch (IOException iox) {
            System.err.println(iox.toString());
            System.exit(3);
        }
        
        return;
    }
	
}
	


