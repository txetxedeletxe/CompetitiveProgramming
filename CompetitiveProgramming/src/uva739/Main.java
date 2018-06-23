package uva739;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;



class Main {

	
	static Map<Character,Integer> soundexCode;
	
	public static void main(String[] args) {
		
		initializeMap();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		System.out.println("         NAME"  + (new String(new char[21]).replace('\0', ' ')) + "SOUNDEX CODE");
		try {
			while ((readLine = br.readLine()) != null) {
				
				String soundex = computeSoundex(readLine);
				System.out.println("         " + readLine + (new String(new char[25 - readLine.length()]).replace('\0', ' ')) + soundex);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("                   END OF OUTPUT" );

	}

	private static void initializeMap() {
		
		soundexCode = new TreeMap<Character,Integer>();
		
		soundexCode.put('A', 0);
		soundexCode.put('E', 0);
		soundexCode.put('I', 0);
		soundexCode.put('O', 0);
		soundexCode.put('U', 0);
		soundexCode.put('Y', 0);
		soundexCode.put('W', 0);
		soundexCode.put('H', 0);
		
		soundexCode.put('B', 1);
		soundexCode.put('P', 1);
		soundexCode.put('F', 1);
		soundexCode.put('V', 1);
		
		soundexCode.put('C', 2);
		soundexCode.put('S', 2);
		soundexCode.put('K', 2);
		soundexCode.put('G', 2);
		soundexCode.put('J', 2);
		soundexCode.put('Q', 2);
		soundexCode.put('X', 2);
		soundexCode.put('Z', 2);
		
		soundexCode.put('D', 3);
		soundexCode.put('T', 3);
		
		soundexCode.put('L', 4);
		
		soundexCode.put('M', 5);
		soundexCode.put('N', 5);
		
		soundexCode.put('R', 6);
	}

	private static String computeSoundex(String readLine) {
		
		StringBuilder sb = new StringBuilder();
		
		char thisChar = readLine.charAt(0);
		sb.append(thisChar);
		int lastCode = soundexCode.get(thisChar);
		
		for (int i = 1 ; i < readLine.length() ; i++) {
			
			thisChar = readLine.charAt(i);
			int code = soundexCode.get(thisChar);
			
			if (code != 0 && code != lastCode) {
				sb.append(code);
				
				if (sb.length() == 4)
					break;
			}
			
			lastCode = code;
		}
		if (sb.length() < 4) {
			sb.append(new String(new char[4-sb.length()]).replace('\0', '0'));
		}
		return sb.toString();
	}



}
