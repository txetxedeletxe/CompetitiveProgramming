package uva727;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str = br.readLine();
			
			int caseCount = Integer.parseInt(str);
			
			br.readLine();
			
			for (int caseIndex = 0 ; caseIndex < caseCount ; caseIndex++) {
				
				if (caseIndex != 0)
					bw.write("\n\n");
				
				
				
				str = br.readLine();
				StringBuilder expressionBuilder = new StringBuilder();
				if (caseIndex != caseCount-1) {
					while (!str.equals("")) {
						expressionBuilder.append(str);
						str = br.readLine();
					}
				}
				else {
					while (str != null) {
						expressionBuilder.append(str);
						str = br.readLine();
					}
				}
				String pf = toPostFix(expressionBuilder.toString());
				bw.write(pf);
				
			}
			bw.flush();
			
		}catch(IOException e) {}
	}

	private static String toPostFix(String string) {
		
		if (string.equals(""))
			return "";
		
		char[] charA = string.toCharArray();
		
		List<String> operands = new ArrayList<>();
		List<Character> operator = new ArrayList<>();
		
		int openedParenthesis = 0;
		StringBuilder sb = null;
		char nextOperation = '+';
		
		for (char c : charA) {
			
			
			if (c == '(') {
				openedParenthesis++;
				
				if (openedParenthesis == 1) {
					sb = new StringBuilder();
					continue;
				}
				
				
			}
			else if (c == ')') {
				openedParenthesis--;
			
				if (openedParenthesis == 0) {
					if (nextOperation != '+') {
						operands.set(operands.size()-1, operands.get(operands.size()-1) + toPostFix(sb.toString()) + nextOperation);
						nextOperation = '+';
					}
					else {
					operands.add(toPostFix(sb.toString()));
				
					}
					continue;
				}
				
			}
			
			if (openedParenthesis > 0) {
				sb.append(c);
			}
			else {
				
				if (c >= '0' && c <= '9') {
					if (nextOperation != '+') {
						operands.set(operands.size()-1, operands.get(operands.size()-1) + c + nextOperation);
						nextOperation = '+';
					}
					else {
					operands.add(String.valueOf(c));
				
					}
				}else {
					
					if (c == '*' || c == '/'){
							
						nextOperation = c;
						
					}
					else {
						operator.add(c);
					}
					
							
				}
				
			}
			
			
		}
		
		
		sb = new StringBuilder();
		sb.append(operands.get(0));
		for (int i = 0 ; i < operator.size() ; i++) {
			sb.append(operands.get(i+1));
			sb.append(operator.get(i));
			
			
		}
		
		return sb.toString();
		
	}



}
