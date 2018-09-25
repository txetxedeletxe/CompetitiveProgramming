package uva908;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {

	static class DJSet{
		
		int[] set;
		
		public DJSet(int elemCount) {
			set = new int[elemCount];
			
			for (int i = 0 ; i < elemCount ; i++) {
				
				set[i] = i;
			}
		}


		public int getParent(int i) {
			
			while (set[i] != i) {
				i = set[i];
			}
			
			return i;
		}

		public void mergeSets(int i, int j) {
			
			if (i < j) {
				set[j] = i;
			}
			else {
				set[i] = j;
			}
			
		}
		
		
	}
	
	
	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String str = br.readLine();
			String[] splitend;

			while (true) {
				
				if (str == null)
					break;
				
				if (str.equals("\n")) {
					bw.write("\n");
					str = br.readLine();
				}
				
				int nodeCount = Integer.parseInt(str);
				
				Queue<int[]> pq = new PriorityQueue<int[]>(nodeCount+9,new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						
						return o1[2] - o2[2];
					}
				});
				
				
				long cost = 0;
				for (int edgeIndex = 0 ; edgeIndex < nodeCount -1 ; edgeIndex++) {
					
					str = br.readLine();
					splitend = str.split(" ");
					
					int[] previousEdge = new int[3];
					
					previousEdge[0] = Integer.parseInt(splitend[0]) -1;
					previousEdge[1] = Integer.parseInt(splitend[1]) -1;
					previousEdge[2] = Integer.parseInt(splitend[2]);
					
					cost += previousEdge[2];
					pq.add(previousEdge);
				}
				
				bw.write(cost + "\n");
				
				str = br.readLine();
				int newEdgeCount = Integer.parseInt(str);
				
				for (int edgeIndex = 0 ; edgeIndex < newEdgeCount ; edgeIndex++) {
					
					str = br.readLine();
					splitend = str.split(" ");
					
					int[] newEdge = new int[3];
					
					newEdge[0] = Integer.parseInt(splitend[0]) -1;
					newEdge[1] = Integer.parseInt(splitend[1]) -1;
					newEdge[2] = Integer.parseInt(splitend[2]);
					
					pq.add(newEdge);
					
				}
				
				DJSet djset = new DJSet(nodeCount);
				
				
				cost = 0;
				int edgeCount = 0;
				while (edgeCount != nodeCount - 1) {
					
					int[] nextEdge = pq.poll();
					
					int ip = djset.getParent(nextEdge[0]);
					int jp = djset.getParent(nextEdge[1]);
					if (ip != jp) {
						
						djset.mergeSets(ip,jp);
						edgeCount++;
						cost += nextEdge[2];
					}
					
					
				}
				
				bw.write(cost + "\n");
				
				
			}
			bw.flush();
		} catch (IOException e) {
		}
	}

}
