package uva10082;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {

	static Map<Character,Character> charMap;
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		
		populateMap();
		
		try {
			while ((readLine = br.readLine()) != null) {
				char[] chars = readLine.toCharArray();
				for (int i = 0 ; i < chars.length ; i++) {
					
					
					chars[i] = charMap.get(chars[i]);;
					
				}
				
				System.out.println(new String(chars));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static void populateMap() {
		
		charMap = new HashMap<Character,Character>();
		
		
		charMap.put('1', '`');
		charMap.put('2', '1');
		charMap.put('3', '2');
		charMap.put('4', '3');
		charMap.put('5', '4');
		charMap.put('6', '5');
		charMap.put('7', '6');
		charMap.put('8', '7');
		charMap.put('9', '8');
		charMap.put('0', '9');
		charMap.put('-', '0');
		charMap.put('=', '-');
		
		charMap.put('W', 'Q');
		charMap.put('E', 'W');
		charMap.put('R', 'E');
		charMap.put('T', 'R');
		charMap.put('Y', 'T');
		charMap.put('U', 'Y');
		charMap.put('I', 'U');
		charMap.put('O', 'I');
		charMap.put('P', 'O');
		charMap.put('[', 'P');
		charMap.put(']', '[');
		charMap.put('\\',']');
		
		charMap.put('S', 'A');
		charMap.put('D', 'S');
		charMap.put('F', 'D');
		charMap.put('G', 'F');
		charMap.put('H', 'G');
		charMap.put('J', 'H');
		charMap.put('K', 'J');
		charMap.put('L', 'K');
		charMap.put(';', 'L');
		charMap.put('\'', ';');
		
		charMap.put('X', 'Z');
		charMap.put('C', 'X');
		charMap.put('V', 'C');
		charMap.put('B', 'V');
		charMap.put('N', 'B');
		charMap.put('M', 'N');
		charMap.put(',', 'M');
		charMap.put('.', ',');
		charMap.put('/', '.');
		
		charMap.put(' ', ' ');
		
		
		
		
		
		
	}

}
