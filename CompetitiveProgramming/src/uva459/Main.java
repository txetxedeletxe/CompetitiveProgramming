package uva459;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	static class UFDS {

		int[] elemRep;
		int numSets;
		int[] sizes;
		public UFDS(int elementCount) {
			
			elemRep = new int[elementCount];
			sizes = new int[elementCount];
			
			for (int i = 0 ; i < elementCount ; i++) {
				elemRep[i] = i;
				sizes[i] = 1;
			}
			
			numSets = elementCount;
		}
		
		public int findSet(int element) {
			
			return (elemRep[element] == element) ? element : (elemRep[element] = findSet(elemRep[element]));
		}
		
		public void unionSet(int elem1, int elem2) {
			
			if (!sameSet(elem1,elem2)) {
				numSets--;
				sizes[findSet(elem1)] += sizes[findSet(elem2)]; 
			}
			
			elemRep[findSet(elem2)] = findSet(elem1);
			
		}
		
		public boolean sameSet(int elem1, int elem2) {
			return findSet(elem1) == findSet(elem2);
		}
		
		public int sizeOfSet(int element) {
			
			int set = findSet(element);
			return sizes[set];
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str = br.readLine();
			
			int ncases = Integer.parseInt(str);
			br.readLine();
			for (int i = 0 ; i < ncases ; i++) {
				
				if (i != 0)
					bw.write('\n');
				
				str = br.readLine();
				
				int nodeCount = str.charAt(0) - 'A' + 1;
				
				UFDS ufds = new UFDS(nodeCount);
				
				while (true) {
					
					str = br.readLine();
					if (str == null || str.length() == 0) {
						break;
					}
					
					int elem1 = str.charAt(0) - 'A';
					int elem2 = str.charAt(1) - 'A';
					
					ufds.unionSet(elem1, elem2);
				}
				
				bw.write(String.valueOf(ufds.numSets));
				bw.write('\n');
			}
			
			bw.flush();
		}catch(IOException e) {}
	}

}
