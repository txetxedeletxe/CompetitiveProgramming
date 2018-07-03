package uva837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

class Main {

	static class SegmentContainer implements Iterable<Float[]>{
		
		
		//One use, fill unfill heap
		float[][] segmentHeap;
		int heapPointer;
	
		
		public SegmentContainer(int segmentCount) {
			
			segmentHeap = new float[segmentCount*2][2];
			heapPointer = 0;
			
			
		}
		
		public void addSegment(float[] segmentSpec) {
			
			float[][] insertionList = new float[2][2];
			
			if (segmentSpec[0] < segmentSpec[1]) {
				insertionList[0][0] = segmentSpec[0];
				insertionList[1][0] = segmentSpec[1];
			}
			else {
				insertionList[0][0] = segmentSpec[1];
				insertionList[1][0] = segmentSpec[0];
			}
			
			insertionList[0][1] = segmentSpec[2];
			insertionList[1][1] = 1/segmentSpec[2];
			
			
			int node1 = heapPointer++;
			int node2 = heapPointer++;
			
			segmentHeap[node1] = insertionList[0];
			flotate(node1);
			segmentHeap[node2] = insertionList[1];
			flotate(node2);
		}
		

		private void flotate(int node1) {
			
			if (node1 == 0)
				return;
			
			int topNode = ((node1 % 2 == 0) ? node1-2 : node1-1)/2;
			if (segmentHeap[node1][0]< segmentHeap[topNode][0]) {
				
				float[] tempRef;
				tempRef = segmentHeap[topNode];
				segmentHeap[topNode] = segmentHeap[node1];
				segmentHeap[node1] = tempRef;
				
				flotate(topNode);
			}
			
			return;
			
		}

		private float[] getMin() {
			
			float[] min = segmentHeap[0];
			
			segmentHeap[0] = segmentHeap[--heapPointer];
			sink(0);
			
			return min;
		}

		private void sink(int node) {
			
			int node1 = node*2+1;
			if (node1 >= heapPointer )
				return;
			
			
			int node2 = node*2+2;
			int wnode;
			
			if (node2 >= heapPointer || segmentHeap[node1][0]< segmentHeap[node2][0]) {
				wnode = node1;
			}
			else {
				wnode = node2;
			}
			
			if (segmentHeap[node][0]> segmentHeap[wnode][0]) {
				float[] tempRef;
				tempRef = segmentHeap[node];
				segmentHeap[node] = segmentHeap[wnode];
				segmentHeap[wnode] = tempRef;
				
				sink(wnode);
			}
		
			return;
		}

		
		@Override
		public Iterator<Float[]> iterator() {
			
			return new Iterator() {
				
				float[] lastPoint = new float[] {Float.NEGATIVE_INFINITY,1.0f};
				float transparecy = 1.0f;
				boolean over = false;
				@Override
				public Float[] next() {
					
					Float[] ret = new Float[3];
					ret[0] = lastPoint[0];
					
					transparecy *= lastPoint[1];
					
					ret[2] = transparecy;
					
					if (heapPointer == 0) {
						lastPoint = new float[] {Float.POSITIVE_INFINITY,1.0f};
						over = true;
					}
					else {
						lastPoint = getMin();
					}
					
					ret[1] = lastPoint[0];
					return ret;
					
					
				}
				
				@Override
				public boolean hasNext() {
					return !over;
				}
			};
		}
		
		
	}
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		
		try {
			readLine = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int numCases = Integer.parseInt(readLine);
		
		for (int i = 0 ; i < numCases ; i++) {
			
			if (i != 0)
				System.out.println();
			
			try {
				br.readLine();
				readLine = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int numSegments = Integer.parseInt(readLine);
			SegmentContainer sc = new SegmentContainer(numSegments);
			
			for (int j = 0 ; j < numSegments ; j++) {
			
				try {
					readLine = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				StringTokenizer st = new StringTokenizer(readLine);
				
				float[] segmentSpec = new float[3];
				
				segmentSpec[0] = Float.parseFloat(st.nextToken());
				st.nextToken();
				segmentSpec[1] = Float.parseFloat(st.nextToken());
				st.nextToken();
				segmentSpec[2] = Float.parseFloat(st.nextToken());
				
				sc.addSegment(segmentSpec);
				
			}
			
			System.out.println(sc.segmentHeap.length+1);
			
			for (Float[] projections : sc) {
				
				StringBuilder sb = new StringBuilder();
				String appendend = null;
				
				appendend = (projections[0] == Float.NEGATIVE_INFINITY) ? "-inf" : String.format("%.3f", projections[0]);
				sb.append(appendend);
				sb.append(' ');
				appendend = (projections[1] == Float.POSITIVE_INFINITY) ? "+inf" : String.format("%.3f", projections[1]);
				sb.append(appendend);
				sb.append(' ');
				appendend = String.format("%.3f", projections[2]);
				sb.append(appendend);
				
				System.out.println(sb.toString());
				
			}
			
		}

	}

}
