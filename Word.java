/**
 * This class represents a word in the game that is made up of letters.
 * @author Maya Al Hourani #251241606
 */

public class Word {
	private LinearNode <Letter> firstLetter; 
	
	//Constructor to store word in linked list.
	public Word(Letter[] letters) { 
		firstLetter = new LinearNode<Letter>(letters[0]);
		LinearNode<Letter> prev = firstLetter;
		LinearNode<Letter> curr = null;
		
		for (int i = 0; i < letters.length; i ++) {
			curr = new LinearNode<Letter>(letters[i]);
			prev.setNext(curr);
			prev = curr;
			
			if (i == 0) {
				this.firstLetter = curr;
				prev = curr;
			}
		}
	}
	
	//toString method 
	public String toString() {
		LinearNode<Letter> curr = firstLetter;
		LinearNode<Letter> LLTemp = firstLetter;
		String string = "Word: ";
		while(curr != null) {
			LLTemp = curr.getNext();
			string +=curr.getElement().toString() + " ";
			curr = LLTemp;

		}
		return string;
	}
	
	//Takes a mystery word as a parameter and updates each of the Letters label attribute contained in this Word object compared to the mystery word. 
	public boolean labelWord(Word mystery) {
		LinearNode<Letter> thisLetter = this.firstLetter;
		LinearNode<Letter> mysteryLetter = mystery.firstLetter;
		int thisIndex = 0;
		int otherIndex = 0;
		
		boolean areEqual = true;
		
		while (thisLetter != null) {
		
			while (mysteryLetter != null){
			
			 if (thisLetter.getElement().equals(mysteryLetter.getElement()) && thisIndex == otherIndex) {
				thisLetter.getElement().setCorrect();
				break;
				
			}if (thisLetter.getElement().equals(mysteryLetter.getElement())){
				if (thisIndex != otherIndex) {
					thisLetter.getElement().setUsed();
					break;
				}
			}else {
				thisLetter.getElement().setUnused();

			}
			
			mysteryLetter = mysteryLetter.getNext();
			otherIndex++;
		}
			
	mysteryLetter = mystery.firstLetter;
	otherIndex = 0;
	thisIndex++;
	if(thisLetter.getElement().decorator() != "!") {
		areEqual = false;
	}
	thisLetter = thisLetter.getNext(); 
	
	}
		return areEqual;
}
	
}
