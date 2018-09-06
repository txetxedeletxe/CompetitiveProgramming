package uva11495;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			String str;
			
			while (true) {
				
				str = br.readLine();
				String[] splited = str.split(" ");
				int n = Integer.parseInt(splited[0]);
				
				if (n == 0)
					break;
				
				int[] permutation = new int[n];
				
				
				for (int i = 0 ; i < n ; i++)
					permutation[i] = Integer.parseInt(splited[i+1]);
				
				
				long inversionIndex = inversionIndex(permutation,0,n);
				
				if (inversionIndex % 2 == 1)
					bw.write("Marcelo\n");
				else
					bw.write("Carlos\n");
				
			}
			bw.flush();
			
		}catch(IOException e) {}
	}

	private static long inversionIndex(int[] permutation,int min,int max) {
		
		if (min + 1 == max)
			return 0;
		
		long partial = inversionIndex(permutation, min, (max+min)/2);
		partial += inversionIndex(permutation, (max+min)/2 , max);
		
		return partial + inversionMergeSort(permutation, min, (max+min)/2 , max);
		
	}

	private static long inversionMergeSort(int[] seq, int low, int mid, int high) {
		int i = low;
		int j = mid;
		int k = 0;
		long swapCount = 0;
		
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
