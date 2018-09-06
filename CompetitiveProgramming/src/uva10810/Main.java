package uva10810;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		try {
			Scanner br = new Scanner(System.in);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			
			while (true) {
				
				
				int seqLen = br.nextInt();
				
				if (seqLen == 0)
					break;
				
				long[] seq = new long[seqLen];
				for (int seqIndex = 0 ; seqIndex < seqLen ; seqIndex++) {
					
					
					long element = br.nextLong();
					seq[seqIndex] = element;
					
				}
				
				bw.write(uqs(seq,0,seq.length)+"\n");
			}
			bw.flush();
			br.close();
		}catch(IOException e) {}
	}

	private static long uqs(long[] seq, int low, int high) {
		
		if (low +1 == high) {
			return 0;
		}
		
		long partial = 0;
		partial += uqs(seq,low,(low + high)/2);
		partial += uqs(seq,(low + high)/2,high);
		
		partial += mergeSwaps(seq,low,(low + high)/2,high);
		
		
		return partial;
	}

	private static long mergeSwaps(long[] seq, int low, int mid, int high) {
		
		int i = low;
		int j = mid;
		int k = 0;
		long swapCount = 0;
		
		long[] temp = new long[high - low];
		
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



