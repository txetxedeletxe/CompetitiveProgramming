package uva11462;

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
			
			while (true) {
				
				str = br.readLine();
				
				int ageCount = Integer.parseInt(str);
				
				if (ageCount == 0)
					break;
				
				str = br.readLine();
				String[] splited = str.split(" ");
				int[] ageVector = new int[ageCount];
				for (int i = 0 ; i < ageCount ; i++) {
					ageVector[i] = Integer.parseInt(splited[i]);
				}
				
				countingSort(ageVector,1,100);
				bw.write(""+ageVector[0]);
				for (int i = 1 ; i < ageCount ; i++) {
					bw.write(" " + ageVector[i]);
				}
				bw.write('\n');
			}
			bw.flush();
			
			
		}catch(IOException e) {}
	}

	private static void countingSort(int[] ageVector, int min, int max) {
		
		int[] massDistribution = new int[max-min];
		
		for (int i : ageVector) {
			
			massDistribution[i-min]++;
			
		}
		
		for (int i = 1 ; i < max-min ; i++) {
			
			massDistribution[i] += massDistribution[i-1];
		}
		
		int ageVectorIndex = 0;
		for (int i = 0 ; i < max-min ; i++) {
			
			for (;ageVectorIndex < massDistribution[i] ; ageVectorIndex++) {
				
				ageVector[ageVectorIndex] = i+min;
			}
		}
		
	}

}
