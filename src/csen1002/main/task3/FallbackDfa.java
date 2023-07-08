package csen1002.main.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Write your info here
 * 
 * @name Omar Amin
 * @id 46-1014
 * @labNumber 23
 */

public class FallbackDfa {
	 Stack<String> stack = new Stack<String>();
	 String fdfa="0;1;2;3;4;5;6;7;8;9;10;11;12;13#r;t;x#0,r,3;0,t,10;0,x,1;1,r,8;1,t,12;1,x,6;2,r,0;2,t,4;2,x,9;3,r,2;3,t,2;3,x,4;4,r,6;4,t,11;4,x,11;5,r,4;5,t,6;5,x,5;6,r,5;6,t,13;6,x,5;7,r,11;7,t,9;7,x,3;8,r,6;8,t,0;8,x,8;9,r,4;9,t,9;9,x,4;10,r,13;10,t,0;10,x,6;11,r,8;11,t,6;11,x,2;12,r,7;12,t,6;12,x,0;13,r,8;13,t,6;13,x,2#12#3;9";
	 String fnl="";
	 Stack<String> stack2 = new Stack<String>();
	
	/**
	 * Constructs a Fallback DFA
	 * 
	 * @param fdfa A formatted string representation of the Fallback DFA. The string
	 *             representation follows the one in the task description
	 */
	public FallbackDfa(String fdfa) {
		// TODO Auto-generated constructor stub
		this.fdfa=fdfa;
	}

	/**
	 * @param input The string to simulate by the FDFA.
	 * 
	 * @return Returns a formatted string representation of the list of tokens. The
	 *         string representation follows the one in the task description
	 */
	
	public  String run(String input) {
		
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(fdfa.split("#")));
//		System.out.println(list.get(0));
		ArrayList<String> States = new ArrayList<String>(Arrays.asList(list.get(0).split(";")));
//		System.out.println(States.get(0));
		ArrayList<String> Symbols = new ArrayList<String>(Arrays.asList(list.get(1).split(";")));
//		System.out.println(Symbols.get(0));
		String strNew = list.get(2).replace(";", ",");
		ArrayList<String> Transitions = new ArrayList<String>(Arrays.asList(strNew.split(",")));
//		for(int k =0;k<Transitions.size();k++) {
//			System.out.print(Transitions.get(k) + "   ");
//		}
	    String startState=list.get(3);
		
	    ArrayList<String> acceptStates = new ArrayList<String>(Arrays.asList(list.get(4).split(";")));
//	    for(int k=0;k<acceptStates.size();k++) {
//	    	System.out.println(acceptStates.get(k));
//	    }
	    while(!input.isEmpty()) {
	    Stack<String> stack = new Stack<String>();
	    stack.push(startState);
	    System.out.println(stack);
	    System.out.println(input);
	    for(int i =0;i<input.length();i++) {
	    	String character=input.charAt(i)+"";
	    	String topOfStack=stack.peek();
	    	for (int j = 0; j < Transitions.size(); j = j + 3) {
	    		if(Transitions.get(j).equals(topOfStack) && Transitions.get(j+1).equals(character) ) {
	    		stack.push(Transitions.get(j+2));
	    		}	
	    	}
	    }
	    System.out.println(stack);
	    int j=0;
	    int firsttime=0;
	    String helper="";
	   
	    String state="";
	  
	    for (int i = input.length()-1; i >= 0; i--) {
	    	  
	    	 String topOfStack =stack.pop();
	        if(acceptStates.contains(topOfStack)) {
	        	
	        	j=i;
//	        	System.out.print(topOfStack);
	        	
	        	state=topOfStack;
	        	break;
	        }
	        else {
	        	if(firsttime==0) {
	        		helper=topOfStack;
	        		firsttime++;
	        	}
	        	state=topOfStack;
	        	if(i==0) {
	        		j=input.length()-1;
	        		state=helper;
	        	}
	        }
	       
	    }
	    for(int k=0;k<=j;k++) {
	    	fnl+=input.charAt(k);
	    }
	    fnl+=","+state+";";
	    
	   
		   
	   input=input.substring(j+1);
	    
	    }
	    System.out.print(fnl);
	    fnl=fnl.substring(0, fnl.length() - 1);  
	    return fnl;
	}
	
//	public static void main(String[] args) {
//		String S = "rxtrrrtrtrttrrrx";
//		run(S);
//		
//	}	
}
