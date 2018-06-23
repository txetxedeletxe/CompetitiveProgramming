package uva483;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine;
		
		try {
			while ((readLine =br.readLine())!=null) {
				
				boolean inWord = false;
				StringBuilder wordBuilder = null;
				
				for (int i = 0 ; i < readLine.length() ; i++) {
					
					char c = readLine.charAt(i);
					
					if (c == ' ') {
						
						if (inWord) {
							inWord = false;
							System.out.print(wordBuilder.reverse().toString());
						}
						System.out.print(' ');
					}
					else {
						
						if (!inWord) {
							inWord = true;
							wordBuilder = new StringBuilder();
						}
						wordBuilder.append(c);
						
					}
				}
				if (inWord) {
					System.out.print(wordBuilder.reverse().toString());
				}
				System.out.println();
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
