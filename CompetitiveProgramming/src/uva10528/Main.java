package uva10528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

class Main {

	static Map<String,Integer> notePos;
	static String[] bijectiveArray;
	static int[] scaleMask;
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		
		buildMaps();
		try {
			while (!(s = br.readLine()).equals("END")) {
				
				int mask = 0;
				
				String[] notes = s.split(" ");
				
				for (String note : notes) {
					
					mask |= (1 << notePos.get(note)); 
				}
				
				StringBuilder sb = new StringBuilder();
				for (int i = 0 ; i < scaleMask.length ; i++) {
					
					if ((mask & scaleMask[i]) == 0) {
						
						if (sb.length() != 0)
							sb.append(' ');
						sb.append(bijectiveArray[i]);
					}
				}
				
				System.out.println(sb.toString());
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static void buildMaps() {
		
		notePos = new TreeMap<String,Integer>();
		notePos.put("C", 0);
		notePos.put("C#", 1);
		notePos.put("D", 2);
		notePos.put("D#", 3);
		notePos.put("E", 4);
		notePos.put("F", 5);
		notePos.put("F#", 6);
		notePos.put("G", 7);
		notePos.put("G#", 8);
		notePos.put("A", 9);
		notePos.put("A#", 10);
		notePos.put("B", 11);
		
		bijectiveArray = new String[12];
		
		bijectiveArray[0] = "C";
		bijectiveArray[1] = "C#";
		bijectiveArray[2] = "D";
		bijectiveArray[3] = "D#";
		bijectiveArray[4] = "E";
		bijectiveArray[5] = "F";
		bijectiveArray[6] = "F#";
		bijectiveArray[7] = "G";
		bijectiveArray[8] = "G#";
		bijectiveArray[9] = "A";
		bijectiveArray[10] = "A#";
		bijectiveArray[11] = "B";
		
		scaleMask = new int[12];
		
		scaleMask[0] = 0b010101001010;
		scaleMask[1] = 0b101010010100;
		scaleMask[2] = 0b010100101001;
		scaleMask[3] = 0b101001010010;
		scaleMask[4] = 0b010010100101;
		scaleMask[5] = 0b100101001010;
		scaleMask[6] = 0b001010010101;
		scaleMask[7] = 0b010100101010;
		scaleMask[8] = 0b101001010100;
		scaleMask[9] = 0b010010101001;
		scaleMask[10] = 0b100101010010;
		scaleMask[11] = 0b001010100101;
		
	}

}
