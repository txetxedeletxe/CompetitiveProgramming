package uva612;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class Main {

	static final Comparator<int[]> comp = new Comparator<int[]>() {
		
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[1] - o2[1];
		}
	};
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str = br.readLine();
			
			int caseCount = Integer.parseInt(str);
			
			for (int caseIndex = 0 ; caseIndex < caseCount ; caseIndex++) {
				
				br.readLine();
				str = br.readLine();
				
				
				if (caseIndex != 0)
					bw.write("\n");
				
				String[] splited = str.split(" ");
				
				
				int strCount = Integer.parseInt(splited[1]);
				
				int[][] invInSeq = new int[strCount][2];
				String[] strings = new String[strCount];
				
				for (int strIndex = 0 ; strIndex < strCount ; strIndex++) {
					strings[strIndex] = br.readLine();
					invInSeq[strIndex][0] = strIndex;
					invInSeq[strIndex][1] = numInversions3(strings[strIndex].toCharArray());
				}
				
				Arrays.sort(invInSeq, comp);
				
				for (int[] index : invInSeq) {
					bw.write(strings[index[0]] + "\n");
				}
			}
			bw.flush();
		}catch(IOException e) {}
	}

	private static int numInversions(char[] string) {
		
		int swapCount = 0;
		
		while (true) {
			boolean swapped = false;
			for (int i = 0 ; i < string.length-1 ; i++) {
				
				if (string[i] > string[i+1]) {
					swapped = true;
					swapCount++;
					
					char temp = string[i];
					string[i] = string[i+1];
					string[i+1] = temp;
				}
				
				
			}
			if (!swapped)
				break;
			
		}
		return swapCount;
	}
	
	private static int numInversions2(char[] string) {
		
		char[] beforeChar = new char[string.length];
		int top = 0;
		int swapCount = 0;
		
		for (char c : string) {
			
			int index = findIndex(beforeChar,c,top);
			swapCount += index;
			top = insert(beforeChar,index,c,top);
			
		}
		
		return swapCount;
	}

	private static int insert(char[] beforeChar, int index, char c,int top) {
		
		for (int i = top ; i > index ; i--) {
			
			beforeChar[i] = beforeChar[i-1];
			
		}
			
		beforeChar[index] = c;
		return top+1;
	}

	private static int findIndex(char[] beforeChar, char c, int top) {
		
		int low = 0;
		int high = top;
		int mid = (high+low)/2;
		
		while (low != high) {
			
			if (beforeChar[mid] <= c) {
				high = mid;
			}
			else {
				low = mid +1;
			}
			
			mid = (high+low)/2;
		}
		
		return mid;
	}

	private static int numInversions3(char[] string) {
		
		return mergeSortSwaps(string,0,string.length);
		
	}

	private static int mergeSortSwaps(char[] string, int low, int high) {
		
		if (low + 1 == high)
			return 0;
		
		int partial = mergeSortSwaps(string, low, (low+high)/2);
		partial += mergeSortSwaps(string, (low+high)/2, high);
		
		return partial + mergeSwaps(string, low, (low+high)/2, high);
	}

	private static int mergeSwaps(char[] string, int low, int mid, int high) {
		
		
		int i = low;
		int j = mid;
		int k = 0;
		int swaps = 0;
		char[] temp = new char[high-low];
		
		while (i != mid && j != high) {
			
			if (string[i] > string[j]) {
				
				temp[k++] = string[j++];
				swaps += mid-i;
			}
			else {
				temp[k++] = string[i++];
			}
			
		}
		
		if (i == mid) {
			
			for (;j < high ; j++) {
				temp[k++] = string[j];
			}
		}
		else {
			for (;i < mid ; i++) {
				temp[k++] = string[i];
			}
		}
		
		for (i = low ; i < high ; i++) {
			string[i] = temp[i-low];
		}
		
		return swaps;
		
		
	}
	
}
