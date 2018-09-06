package uva673;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str = br.readLine();
			
			int caseCount = Integer.parseInt(str);
			
			for (int i = 0 ; i < caseCount ; i++) {
				
				
				str = br.readLine();
				Stack<Character> st = new Stack<Character>();
				char[] characters = str.toCharArray();
				
				boolean correct = true;
				
				for (char c : characters) {
					
					if (c == '(' || c == '[') {
						st.push(c);
					}
					else {
						
						if (st.isEmpty()) {
							correct = false;
							break;
						}
						
						char topChar = st.pop();
						
						if ((c == ')' && topChar != '(') || (c == ']' && topChar != '[')) {
							correct = false;
							break;
						}
						
					}
				}

				if (!st.isEmpty())
					correct = false;
				
				if (correct)
					bw.write("Yes\n");
				else
					bw.write("No\n");
			}
			bw.flush();
		}catch(IOException e) {}
	}

}
