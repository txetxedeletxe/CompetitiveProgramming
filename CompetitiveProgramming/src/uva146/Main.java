package uva146;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {

	public static void main(String[] args) {
		
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String str = null;
			
			while (!(str = br.readLine()).equals("#")) {
				
				String nextP = nextPermutation(str);
				
				if (nextP == null)
					bw.write("No Successor");
				else
					bw.write(nextP);
				
				bw.write("\n");
				
				
			}
			bw.flush();
		}catch (IOException e){}

	}

	
	
	private static String nextPermutation(String str) {
		
		//System.out.println(str);
		char[] ch = str.toCharArray();
		
		for (int i = ch.length-2 ; i >= 0 ; i--) {
			
			if (ch[i] < ch[i+1]) {
				
				int swapIndex = smallestHigherIndex(ch,i);
				//System.out.println(swapIndex);
				char temp = ch[swapIndex];
				ch[swapIndex] = ch[i];
				ch[i] = temp;
				
				Arrays.sort(ch, i+1,ch.length);
				return new String(ch);
			}
			
		}
		
		return null;
	}



	private static int smallestHigherIndex(char[] ch, int i) {
		
		int low = i +1;
		int high = ch.length;
		int mid = (low + high) / 2;
		
		while (low +1 != high) {
			
			if (ch[mid] <= ch[i]) {
				high = mid;
			}
			else {
				low = mid;
			}
			mid = (low + high) / 2;
		}
		
		return mid;
		
	}



}
