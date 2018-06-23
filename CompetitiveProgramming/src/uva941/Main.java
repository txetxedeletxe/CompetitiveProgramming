package uva941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

	public static void main(String[] args) {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		
		try {
			readLine = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int caseCount = Integer.parseInt(readLine);
		
		for (int caseIndex = 0 ; caseIndex < caseCount ; caseIndex++) {
			
			try {
				readLine = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			char[] inputString =readLine.toCharArray();
			int strLen = inputString.length;
			Arrays.sort(inputString);
			
			try {
				readLine = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			long permNum = Long.parseLong(readLine);
			char[] permutation = new char[strLen];
			
			for (int i = 0 ; i < strLen ; i++) {
				
				long permutations = factorial(strLen - i - 1);
				int inPosition = (int) (permNum / permutations);
				permNum = permNum % permutations;
				
				permutation[i] = inputString[inPosition];
				deleteIth(inputString,inPosition,strLen-i-1);
				
			}
			
			System.out.println(new String(permutation));
			
			
			
		}
		

	}

	private static void deleteIth(char[] inputString, int inPosition, int newLength) {
		
		for (int i = inPosition; i < newLength ; i++) {
			
			inputString[i] = inputString[i+1];
		}
		
	}

	private static long factorial(int i) {
		
		long partial = 1;
		
		for (int j = 2 ; j <= i ;j++) {
			
			partial *= j;
		}
			
		return partial;
	}

}
