package uva10810;

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
			String str;
			boolean lined = false;
			while (true) {
				
				str = br.readLine();
				int seqLen = Integer.parseInt(str);
				
				if (seqLen == 0)
					break;
				
				if (lined)
					bw.write("\n");
				
				lined = true;
				
				long[] seq = new long[seqLen];
				for (int seqIndex = 0 ; seqIndex < seqLen ; seqIndex++) {
					
					str = br.readLine();
					long element = Long.parseLong(str);
					seq[seqIndex] = element;
					
				}
				
				bw.write(uqs(seq,0,seq.length)+"");
			}
			bw.flush();
			
		}catch(IOException e) {}
	}

	private static int uqs(long[] seq, int low, int high) {
		
		if (low +1 == high) {
			return 0;
		}
		
		int partial = 0;
		partial += uqs(seq,low,(low + high)/2);
		partial += uqs(seq,(low + high)/2,high);
		
		partial += mergeSwaps(seq,low,(low + high)/2,high);
		
		
		return partial;
	}

	private static int mergeSwaps(long[] seq, int low, int mid, int high) {
		
		int i = low;
		int j = mid;
		int k = 0;
		int swapCount = 0;
		
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



