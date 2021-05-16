import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Margaret Reed
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;
		myWords = Arrays.copyOfRange(source, start, start + size);
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * calculates the length of myWords
	 * @return counter
	 */
	public int length(){
		// TODO: change this
		int counter = 0;
		for(String word : myWords){
			counter += 1;
		}
		return counter;
	}


	/**
	 * calculates if word grams are equal
	 * @param o
	 * @return bool
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram wg = (WordGram) o;
		if(!(wg.myWords.length == this.myWords.length)) {
			return false;
		}
		for(int i = 0; i < myWords.length; i++){
			if(!(wg.myWords[i].equals(this.myWords[i]))){
				return false;
			}
		}
			return true;
		}
	/**
	 * Turning the array into its hash code
	 * @return nyHash
	 */
	@Override
	public int hashCode(){
		if(myHash == 0){
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * adds to the end a new word and removes first index to maintain size
	 * @param last is last String of returned WordGram
	 * @return new word gram
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		for(int i = 0; i < (myWords.length - 1); i++){
			wg.myWords[i] = this.myWords[i + 1];
		}
		wg.myWords[myWords.length-1] = last;
		return wg;
	}
	/**
	 * Turning the array into a list separated by a space
	 * @return myToString
	 */
	@Override
	public String toString(){
		if(myToString == null) {
			myToString = String.join(" ", this.myWords);
		}
		return myToString;
	}
}
