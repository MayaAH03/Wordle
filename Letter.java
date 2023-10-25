/**
 * This class represents a single letter that is used in the game.
 * @author Maya Al Hourani #251241606
 */
public class Letter {

	private char letter;
	private int label;
	final private int UNSET = 0;
	final private int UNUSED = -1;
	final private int USED = 1;
	final private int CORRECT = 2;

	
	
	//This initializes the variables label and letter.
	public Letter(char c) {
		label = UNSET;
		letter = c;
	}
	
	
	//equals method   
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Letter) {
			Letter otherObj = (Letter) otherObject;
			if(this.letter == otherObj.letter) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	//Returns special characters based on label input.
	public String decorator() {
		if (label == USED) {
			return "+";
		}if (label == UNUSED) {
			return "-";
		} if (label == UNSET) {
			return " ";
		}if (label == CORRECT) {
			return"!";
		}else {
			return " ";
		}
	}
	
	//toString method to print input string with decorators. 
	public String toString() {
		return decorator() + letter + decorator();
	}
	
	// SETTER METHODS
	
	public void setUnused() {
		label = UNUSED;
	}
	
	
	public void setUsed() {
		label = USED;
	}
	
	
	public void setCorrect() {
		label = CORRECT;
	}
	
	//Checks if label is unused.  
	public boolean isUnused() {
		if (label == UNUSED) {
			return true;
		} else {
			return false;
		}
	}
	
	//Turning a word into a array of characters.
	public static Letter[] fromString(String s) {
	  Letter[] wordArray = new Letter[s.length()];  
	  for (int i = 0; i < s.length(); i++) {
		  Letter obj = new Letter(s.charAt(i));
		  
		  wordArray[i] = obj;
		  }
	  
	  	return wordArray;
	  }

}