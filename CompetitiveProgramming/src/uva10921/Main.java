package uva10921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	static final char[] maps = {'2','2','2','3','3','3','4','4','4','5','5','5','6','6','6','7','7','7','7','8','8','8','9','9','9','9'};

	public static void main(String[] args) {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		char[] strAsChar;
		
		
		try {
			while ((str = br.readLine()) != null) {
				
				strAsChar = str.toCharArray();
				
				for (int i = 0 ; i < strAsChar.length ; i++) {
					
					strAsChar[i] = (strAsChar[i] == '0' || strAsChar[i] == '1' || strAsChar[i] == '-') ? strAsChar[i] : maps[(int)(strAsChar[i]-'A')];
					
				}
			
				System.out.println(new String(strAsChar));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}


}
