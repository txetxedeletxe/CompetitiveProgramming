package uva793;

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
				
				int nodeCount = Integer.parseInt(str);
				
				UFDS ufds = new UFDS(nodeCount);
				
				int succ = 0;
				int fail = 0;
				
				while (true) {
					
					str = br.readLine();
					if (str == null || str.length() == 0) {
						break;
					}
					
					String[] splt = str.split(" ");
					
					char c = splt[0].charAt(0);
					int elem1 = Integer.parseInt(splt[1]) - 1;
					int elem2 = Integer.parseInt(splt[2]) - 1;
					
					if (c == 'c') {
						ufds.unionSet(elem1, elem2);
					}
					else {
						
						if (ufds.sameSet(elem1, elem2)) {
							succ++;
						}
						else {
							fail++;
						}
					}
					
					
				}
				
				bw.write(succ+","+fail);
				bw.write('\n');
			}
			
			bw.flush();
		}catch(IOException e) {}
	}

}
