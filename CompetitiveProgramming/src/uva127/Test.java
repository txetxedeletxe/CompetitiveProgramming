package uva127;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		
		try {
			
			System.out.println("Number of cases:");
			Scanner sc = new Scanner(System.in);
			
			int caseCount = sc.nextInt();			
			
			File ftest = new File("TestFile.txt");
			File fresult = new File("ResultFile.txt");
		
			
			if (!ftest.exists())
				ftest.createNewFile();
			
			if (!fresult.exists())
				fresult.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(ftest));
			for (int i = 0 ; i < caseCount ; i++) {
				String deck = generateDeck();
				bw.write(deck);
			}
			bw.write("#\n");
			bw.close();
			System.setIn(new FileInputStream(ftest));
			System.setOut(new PrintStream(fresult));
			
			Main.main(new String[] {});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private static String generateDeck() {
		
		String[] deck = new String[52];
		
		for (int i = 0 ; i < 52 ; i++) {
			
			StringBuilder sb = new StringBuilder();
			
			
			int faceValue = i % 13; 
			
			switch (faceValue) {
				case 0:
					sb.append("A");
					break;
				case 9:
					sb.append("T");
					break;
				case 10:
					sb.append("J");
					break;
				case 11:
					sb.append("Q");
					break;
				case 12:
					sb.append("K");
					break;
				default:
					sb.append(String.valueOf(faceValue+1));
					break;
			}
			
			int suit = i / 13;
			
			switch (suit) {
			
				case 0:
					sb.append("C");
					break;
				case 1:
					sb.append("D");
					break;
				case 2:
					sb.append("H");
					break;
				case 3:
					sb.append("S");
			}
			
			
			deck[i] = sb.toString();
		}
		
		List<String> deckList = Arrays.asList(deck);
		Collections.shuffle(deckList);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(deckList.get(0));
		
		for (int i = 1 ; i < 26 ; i++) {
			sb.append(" " + deckList.get(i));
		}
		
		sb.append("\n" + deckList.get(26));
		
		for (int i = 27 ; i < 52 ; i++) {
			sb.append(" " + deckList.get(i));
		}
		
		sb.append("\n");
		
		return sb.toString();
	}
}
