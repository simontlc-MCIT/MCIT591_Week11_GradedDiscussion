import java.io.*;
import java.util.*;

public class PopularInitials {
	private ArrayList<NameStats> nameStat = new ArrayList<NameStats>();
//	
//	private String findSubstringBetweenFirstTwoLocations(String s, String c) {
//		int index1 = s.indexOf(c);
//		String remainingString = s.substring(index1 + 1);
//		return remainingString.substring(0, remainingString.indexOf(c));
//	}
	
	public PopularInitials(String nameFileName) {
		File f = new File(nameFileName);
		Scanner scanner;
		try {
			scanner = new Scanner(f);
			while(scanner.hasNextLine()) {
				String row = scanner.nextLine();
				String firstNameRead = row.substring(0,row.indexOf(","));
				char firstInitialRead = firstNameRead.charAt(0);
				String occurrenceRead = row.substring(row.lastIndexOf(",")+1,row.length());
				NameStats newName = new NameStats(firstNameRead,firstInitialRead,Integer.parseInt(occurrenceRead));
				nameStat.add(newName);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public char findMostPopularIni() {
		char mostPopIni = 'A';
		int maxCount = 0;
		for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
			int tempCount = 0;
			for (int i = 0; i < nameStat.size(); i++) {
				if(nameStat.get(i).getFirstInitial() == alphabet) {
					tempCount += nameStat.get(i).getOccurrence();
//					System.out.println("The number of initial " + alphabet + " is " + tempCount);
				}
			}
			if (tempCount > maxCount) {
				maxCount = tempCount;
				mostPopIni = alphabet;
			}
		}
		System.out.println("There were : " + maxCount + " people born this year with this initial.");
		return mostPopIni;
	}
	
	
	
	public ArrayList<NameStats> getNameStat() {
		return nameStat;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopularInitials run = new PopularInitials("yob1955.txt");

		char findings = run.findMostPopularIni();
		System.out.println("The most popular initial in this year is: " + findings);
		
	}

}
