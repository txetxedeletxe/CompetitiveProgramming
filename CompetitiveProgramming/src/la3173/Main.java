package la3173;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


class Main {

	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = null;
		
		try {
			while ((str = br.readLine()) != null) {
				
				String[] permutations = getPermutations(str);
				int largestI = 0;
				int largestAD = 0;
				for (int i = 0 ; i < permutations.length ; i++) {
					
					int AD = minAbsDistance(permutations[i]);
					
					if (AD > largestAD) {
						largestAD = AD;
						largestI = i;
					}
				}
				
				bw.write(permutations[largestI] + largestAD + "\n");
			
			}
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int minAbsDistance(String string) {
		int minDist = Integer.MAX_VALUE;
		
		for (int i = 1 ; i < string.length() ; i++) {
			int dist = absDistance(string.charAt(i-1),string.charAt(i));
			if (dist < minDist)
				minDist = dist;
		}
		
		return minDist;
	}

	private static int absDistance(char charAt, char charAt2) {
		
		return Math.abs(charAt-charAt2);
	}

	private static String[] getPermutations(String str) {
		
		String[] per21 = new String[21];
		per21[10] = str;
		
		for (int i = 9 ; i >= 0 ; i--) {
			
			per21[i] = prevPermutation(per21[i+1]);
		}
		
		for (int i = 11 ; i < 21 ; i++) {
			
			per21[i] = nextPermutation(per21[i-1]);
		}
		
		Arrays.sort(per21);
		return per21;
	}

	private static String nextPermutation(String string) {
		
		int swappedChar0 = -1;
		int swappedChar1 = 0;
		for (int i = string.length()-2 ; i >= 0 ; i-- ) {
			
			for (int j = string.length()-1 ; j > i ; j--) {
				
				if (string.charAt(i) < string.charAt(j)) {
					swappedChar0 = i;
					swappedChar1 = j;
					break;
				}
					
			}
			
			if (swappedChar0 != -1)
				break;
			
		}
		
		char[] ca2 = string.toCharArray();
		
		if (swappedChar0 != -1) {
			char temp = ca2[swappedChar0];
			ca2[swappedChar0] = ca2[swappedChar1];
			ca2[swappedChar1] = temp;
		}
		Arrays.sort(ca2, swappedChar0+1, ca2.length);
		
		return new String(ca2);
		
	}

	private static String prevPermutation(String string) {
		
		int swappedChar0 = -1;
		int swappedChar1 = 0;
		for (int i = string.length()-2 ; i >= 0 ; i-- ) {
			
			for (int j = string.length()-1 ; j > i ; j--) {
				
				if (string.charAt(i) > string.charAt(j)) {
					swappedChar0 = i;
					swappedChar1 = j;
					break;
				}
					
			}
			
			if (swappedChar0 != -1)
				break;
			
		}
		
		char[] ca2 = string.substring(0, swappedChar0+1).toCharArray();
		char[] ca = string.substring(swappedChar0+1,string.length()).toCharArray();
		
		if (swappedChar0 != -1) {
			ca2[ca2.length-1] = string.charAt(swappedChar1);
			ca[swappedChar1-ca2.length] = string.charAt(swappedChar0);
		}
		
		Arrays.sort(ca);
		
		StringBuilder sb = new StringBuilder();
		sb.append(ca);
		sb.reverse();
		String sss = sb.toString();
		
		sb = new StringBuilder();
		sb.append(ca2);
		sb.append(sss);
		return sb.toString();
		
	}

}
