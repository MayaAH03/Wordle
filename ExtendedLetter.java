/**
 * This class uses the class Letter and a string instance variable instead 
 * of a single char to see the relationship between words.
 * @author Maya Al Hourani #251241606
 */

public class ExtendedLetter extends Letter{
	
	private String content;
	private int family;
	private boolean related;
	private final int SINGLETON = -1;
	
	//Constructor to initialize instance variables for both classes.
	public ExtendedLetter(String s) {
		super('c');
		this.content = s;
		this.related = false;
		this.family = this.SINGLETON;
	}
	
	//Constructor to initialize instance variables for both classes.
	public ExtendedLetter(String s, int fam) {
		super('c');
		this.content = s;
		this.related = false;
		this.family = fam;
	}
	
	//equals method
	public boolean equals(Object other) {
		ExtendedLetter extendedOther = (ExtendedLetter) other;
		if (other instanceof ExtendedLetter) {
			if(this.content == extendedOther.content) {
				return true;
			}
		
		if(this.family == extendedOther.family) {
			this.related = true;
		}
		
		}
		return false;
	}
	
	//toString method to represent extendedLetter objects.
	public String toString() {
		if(decorator() == "-" && this.related) {
			return "." + this.content +".";
		}
		return decorator() + this.content + decorator();
	}
	
	//Creates an array letters of Letter objects of the same size as the size of the array content, and stores it based on the array codes.
	public static Letter[] fromStrings(String[] content, int[] codes) {
		Letter[] letters = new Letter[content.length];
		if (codes == null) {
			for (int i = 0; i < letters.length; i++) {
				letters[i] = new ExtendedLetter(content[i]);
			}
			} else if (codes != null) {
				for (int i = 0; i < letters.length; i++) {
				letters[i] = new ExtendedLetter(content[i], codes[i]);
			}
			}
		return letters;
		}
	}

