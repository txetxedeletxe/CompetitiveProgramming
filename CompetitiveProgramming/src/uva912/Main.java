package uva912;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
			
			if (findSet(elem1) > findSet(elem2)) {
				int temp = elem1;
				elem1 = elem2;
				elem2 = temp;
			}
			
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
			String str;
			
			int w = 0;
			while (true) {
				
				str = br.readLine();
				
				
				if (str == null)
					break;
				
				if (w != 0)
					bw.write('\n');
				w++;
				if (str.length() == 0) {
					
					str = br.readLine();
				}
				
				int seqLength = Integer.parseInt(str);
				
				char[] dna1 = new char[seqLength];
				char[] dna2 = new char[seqLength];
				
				boolean[] mut1 = new boolean[seqLength];
				boolean[] mut2 = new boolean[seqLength];
				
				int[] m1 = new int[seqLength];
				int[] m2 = new int[seqLength];
				
				List<int[]> al = new ArrayList<>();
				Set<Integer> mset = new TreeSet<>();
				
				int nextV = 0;
				
				for (int i = 0 ; i < seqLength ; i++) {
					
					str = br.readLine();
					dna1[i] = str.charAt(0);
					int j = numeric(str);
					
					if (j != 0) {
						mut1[i] = true;
						m1[i] = j;
						if (!mset.contains(j)) {
							al.add(new int[] {j,nextV++});
							mset.add(j);
							
						}
					}
					
				}
				
				
				
				for (int i = 0 ; i < seqLength ; i++) {
					
					str = br.readLine();
					dna2[i] = str.charAt(0);
					
					int j = numeric(str);
					
					if (j != 0) {
						mut2[i] = true;
						m2[i] = j;
						if (!mset.contains(j)) {
							al.add(new int[] {j,nextV++});
							mset.add(j);
							
						}
					}
				}
				
				Collections.sort(al, new Comparator<int[]>() {

					@Override
					public int compare(int[] arg0, int[] arg1) {
						
						return arg0[0] - arg1[0];
					}
				});
				
				
				UFDS ufds = new UFDS(nextV+4);
				
				for (int i = 0 ; i <seqLength ; i++) {
					
					if (mut1[i]) {
						
						if (mut2[i]) {
							ufds.unionSet(findOrdered(al,m1[i]) + 4, findOrdered(al,m2[i]) + 4);
						}
						else {
							ufds.unionSet(dna2[i] - 'A', findOrdered(al,m1[i]) + 4);
						}
					}
					else {
						if (mut2[i]) {
							ufds.unionSet(dna1[i] - 'A', findOrdered(al,m2[i]) + 4);
						}
						else {
							ufds.unionSet(dna1[i] - 'A', dna2[i] - 'A');
						}
					}
				}
				
				boolean feasible = true;
				
				for (int i = 0 ; i < 4 ; i++) {
					
					if (ufds.elemRep[i] != i)
						feasible = false;
				}
				
				
				
				if (feasible == false)
					bw.write("NO\n");
				else {
					bw.write("YES\n");
					
					for (int[] tup : al) {
						
						int st = ufds.findSet(tup[1] + 4);
						
						if ( st < 4) {
							bw.write(tup[0] + " " + ((char)(st + 'A')) + "\n");
						}
					}
				}
				
				
					
			}
			
			bw.flush();
		}catch(IOException e) {}
	}

	private static int findOrdered(List<int[]> al, int i) {
		
		int low = 0;
		int high = al.size() - 1;
		int mid = (low + high)/2;
		
		while (low != high) {
			int[] ma = al.get(mid);
						
			if (ma[0] < i) {
				low = mid+1;
			}else if (ma[0] > i) {
				high = mid-1;
			}
			else {
				return ma[1];
			}
			
			mid = (low + high)/2;
		}
		
		return al.get(mid)[1];
	}

	
	
	private static int numeric(String str) {
		
		try {
			int t = Integer.parseInt(str);
			return t;
		}
		catch (Exception e) {
			return 0;
		}
	}

}
