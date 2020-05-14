package letterJamMaster2;
import java.util.List;
import java.util.Scanner;

public class letterJamMaster2Main {
	
	
	public static void run() {
//		I have to make these scanner things to get input
		
		Scanner scanNumberPlayers = new Scanner(System.in);
		List<String> wordList = textFileImporter.array("/home/luke/eclipse-workspace/letterJamMaster2/src/letterJamMaster2/mediumdictionary.txt");
		System.out.print("Enter number of player you would like to enter:");
		int numberPlayers = scanNumberPlayers.nextInt();
		char keyLetters[] = new char[numberPlayers];
		Scanner scanKeyLetters = new Scanner(System.in);
		
		System.out.print("Please enter their letters, pressing enter between each");
		for(int i = 0; i < numberPlayers; i++) {
			keyLetters[i] = scanKeyLetters.nextLine().charAt(0);
		}
		
		System.out.print("there are now " + keyLetters.length + " letters stored");
		
//		gotta close them too
		scanKeyLetters.close();
		scanNumberPlayers.close();
		
//		gonna try to use a two dimensional array because I am insane
//		the first index is the player, the second the word
		int[][] wordScores = new int[numberPlayers][wordList.size()];
		
//		Oh no, he's writing another 2d array
//		0 score 1 is word index
		int[][] scoreOrder = new int[2][wordList.size()];
		int tempScore = 0;
		
//		holy crap either i am crazy or because these arrays share a dimension (wordList.size) I could combine them into a THREE dimensional array
		
		for(int indexWordInList = 0; indexWordInList < wordList.size(); indexWordInList++) {
			
//			Everything in here happens for each word
			for (int indexCharacterInWord = 0;indexCharacterInWord < wordList.get(indexWordInList).length(); indexCharacterInWord++) {
				
//				Everything in here happens for each letter
				for (int indexLetterInKeyLetters = 0; indexLetterInKeyLetters < keyLetters.length; indexLetterInKeyLetters++) {
					if(wordList.get(indexWordInList).charAt(indexCharacterInWord) == keyLetters[indexLetterInKeyLetters]) {
//						Bump up the words score for this player one point per letter
						wordScores[indexLetterInKeyLetters][indexWordInList]++;
						
					}
				}
			}
//			This is still happening for each word
			for (int indexPlayer = 0; indexPlayer < numberPlayers; indexPlayer++) {
				tempScore = tempScore + wordScores[indexPlayer][indexWordInList];
			}
			scoreOrder[0][indexWordInList] = tempScore;
			scoreOrder[1][indexWordInList] = indexWordInList;
			System.out.println("adding a score of " + tempScore + " to " + wordList.get(indexWordInList));
			tempScore = 0;
		}
		

		

		
		
//		gonna sort 2D array I hope I copied this code from https://www.geeksforgeeks.org/sorting-2d-array-according-values-given-column-java/
		
		sort2DMatrixbycolumn.sortbyColumn(scoreOrder, 0);
		
//		print it and hope it works
		System.out.print("Printing results");
		
		for(int printIndex = 0; printIndex < 10; printIndex++) {
			System.out.print(wordList.get(scoreOrder[1][printIndex]));
			System.out.print(scoreOrder[0][printIndex]);
			System.out.println();
		}
		
	}
	
	public static void main(String args[]) {
		run();	
	}

}
