
public class NameStats {
	private String firstName;
	private int occurrence;
	private char firstInitial;
	
	public NameStats(String firstNameRead, char firstInitialRead, int occurrenceRead) {
		firstName = firstNameRead;
		occurrence = occurrenceRead;
		firstInitial = firstInitialRead; 
	}

	public int getOccurrence() {
		return occurrence;
	}

	public char getFirstInitial() {
		return firstInitial;
	}
	
	
	
}
