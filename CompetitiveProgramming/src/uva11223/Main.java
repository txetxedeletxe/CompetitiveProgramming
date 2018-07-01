package uva11223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {

	static Map<String,Character> morseConversion;
	
	public static void main(String[] args) {
		
		build();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int caseCount = Integer.parseInt(str);
		
		for (int i = 1 ; i <= caseCount ; i++) {
			
			if (i != 1)
				System.out.println();
			
			System.out.println("Message #" + i);
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[] words = str.split("  ");
			StringBuilder sb = new StringBuilder();
			for (int j = 0 ; j < words.length ; j++) {
				
				if (j != 0)
					sb.append(" ");
				
				String[] characters = words[j].split(" ");
				
				for (int k = 0 ; k < characters.length ; k++) {
					
					sb.append(morseConversion.get(characters[k]));
				}
			}
			
			System.out.println(sb.toString());
		}
		
	}

	static void build() {
		
		morseConversion = new HashMap<String,Character>();
		
		morseConversion.put(".-",'A');
		morseConversion.put("-...",'B');
		morseConversion.put("-.-.",'C');
		morseConversion.put("-..",'D');
		morseConversion.put(".",'E');
		morseConversion.put("..-.",'F');
		morseConversion.put("--.",'G');
		morseConversion.put("....",'H');
		morseConversion.put("..",'I');
		morseConversion.put(".---",'J');
		morseConversion.put("-.-",'K');
		morseConversion.put(".-..",'L');
		morseConversion.put("--",'M');
		morseConversion.put("-.",'N');
		morseConversion.put("---",'O');
		morseConversion.put(".--.",'P');
		morseConversion.put("--.-",'Q');
		morseConversion.put(".-.",'R');
		morseConversion.put("...",'S');
		morseConversion.put("-",'T');
		morseConversion.put("..-",'U');
		morseConversion.put("...-",'V');
		morseConversion.put(".--",'W');
		morseConversion.put("-..-",'X');
		morseConversion.put("-.--",'Y');
		morseConversion.put("--..",'Z');
		morseConversion.put("-----",'0');
		morseConversion.put(".----",'1');
		morseConversion.put("..---",'2');
		morseConversion.put("...--",'3');
		morseConversion.put("....-",'4');
		morseConversion.put(".....",'5');
		morseConversion.put("-....",'6');
		morseConversion.put("--...",'7');
		morseConversion.put("---..",'8');
		morseConversion.put("----.",'9');
		morseConversion.put(".-.-.-",'.');
		morseConversion.put("--..--",',');
		morseConversion.put("..--..",'?');
		morseConversion.put(".----.",'\'');
		morseConversion.put("-.-.--",'!');
		morseConversion.put("-..-.",'/');
		morseConversion.put("-.--.",'(');
		morseConversion.put("-.--.-",')');
		morseConversion.put(".-...",'&');
		morseConversion.put("---...",':');
		morseConversion.put("-.-.-.",';');
		morseConversion.put("-...-",'=');
		morseConversion.put(".-.-.",'+');
		morseConversion.put("-....-",'-');
		morseConversion.put("..--.-",'_');
		morseConversion.put(".-..-.",'\"');
		morseConversion.put(".--.-.",'@');		
		
	}

}


