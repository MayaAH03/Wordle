/**
 * This class stores a mystery word and all guesses. It 
 * keeps a history of the past word guesses in a linked list.
 * @author Maya Al Hourani #251241606
 */
public class WordLL {

	private Word mysteryWord;
	private LinearNode<Word> history;
	
	//Initializing history and mysteryWord
	public WordLL(Word mystery) {
		this.mysteryWord = mystery;
		history = null;
	}
	
	//Method to compute a user's guess and return if its true or false using labelWord method from previous class.
	public boolean tryWord(Word guess) {
		boolean equals;
		LinearNode guessNode = new LinearNode<Word>(guess);
		guess.labelWord(mysteryWord);
		guessNode.setNext(history);
		history = guessNode;
		if (guessNode.equals(mysteryWord)) {
			equals = true;
		}else {
			equals = false;
		}
		return equals;
	}
	//toString Method
	public String toString() {
		LinearNode<Word> curr = history;
		String string = " ";
		while (curr != null) {
			string += curr.getElement().toString() + "\n";
			curr = curr.getNext();
		}
		return string;
	}
}

