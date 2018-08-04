package uva299;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str = br.readLine();
			
			int caseCount = Integer.parseInt(str);
			
			for (int caseIndex = 0 ; caseIndex < caseCount ; caseIndex++) {
				
				str = br.readLine();
				int trainLength = Integer.parseInt(str);
				
				int[] train = new int[trainLength];
			
				str = br.readLine();
				String[] splited = str.split(" ");
				
				for (int trainIndex = 0 ; trainIndex < trainLength ; trainIndex++) {
					
					train[trainIndex] = Integer.parseInt(splited[trainIndex]);
					
				}
				
				int swapCount = computeSwaps2(train);
				bw.write("Optimal train swapping takes "+ swapCount + " swaps.\n");
			}
			
			bw.flush();
		}catch(IOException e) {}
	}

	private static int computeSwaps(int[] train) {
		
		int swapCount = 0;
		
		while (true) {
			boolean swapped = false;
			for (int i = 0 ; i < train.length-1 ; i++) {
				
				if (train[i] > train[i+1]) {
					swapped = true;
					swapCount++;
					
					int temp = train[i];
					train[i] = train[i+1];
					train[i+1] = temp;
				}
				
				
			}
			if (!swapped)
				break;
			
		}
		return swapCount;
	}
	
	private static int computeSwaps2(int[] string) {
		
		int[] beforeChar = new int[string.length];
		int top = 0;
		int swapCount = 0;
		
		for (int c : string) {
			
			int index = findIndex(beforeChar,c,top);
			swapCount += index;
			top = insert(beforeChar,index,c,top);
			
		}
		
		return swapCount;
	}

	private static int insert(int[] beforeChar, int index, int c,int top) {
		
		for (int i = top ; i > index ; i--) {
			
			beforeChar[i] = beforeChar[i-1];
			
		}
			
		beforeChar[index] = c;
		return top+1;
	}

	private static int findIndex(int[] beforeChar, int c, int top) {
		
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
	
	private static int computeSwaps3(int[] string) {
		
		return mergeSortSwaps(string,0,string.length);
	}

	private static int mergeSortSwaps(int[] string, int low, int high) {
		if (low + 1 == high)
			return 0;
		
		int partial = mergeSortSwaps(string, low, (low+high)/2);
		partial +=  mergeSortSwaps(string, (low+high)/2, high);
		
		return partial + mergeSwaps(string,low,(low+high)/2,high);
	}

	private static int mergeSwaps(int[] seq, int low, int mid, int high) {
		
		int i = low;
		int j = mid;
		int k = 0;
		int swapCount = 0;
		
		int[] temp = new int[high - low];
		
		while (i != mid && j != high) {
			
			if (seq[i] > seq[j]) {
				
				temp[k++] = seq[j];
				swapCount += mid-i;
				j++;
				
			}
			else {
				temp[k++] = seq[i];
				i++;
			}
			
		}
		
		if (i == mid) {
			
			for (;j < high ; j++) {
				temp[k++] = seq[j];
			}
		}
		else {
			
			for (;i < mid ; i++) {
				temp[k++] = seq[i];
			}
		}
		
		
		for (i = low ; i < high ; i++) {
			seq[i] = temp[i-low];
		}
		
		return swapCount;
	}

}
