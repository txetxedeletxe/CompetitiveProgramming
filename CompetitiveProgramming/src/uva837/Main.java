package uva837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import java.util.StringTokenizer;

class Main {

	static class SegmentContainer implements Iterable<Float[]>{
		
		float[][] segmentEnds;
		int count;
		
		public SegmentContainer(int segmentCount) {
			
			segmentEnds = new float[segmentCount*2][2];
			count = 0;
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
			
			for (int i = 0 ; i < count ; i++) {
				
				if (insertionList[0][0] < segmentEnds[i][0]) {
					
					float[] insertend = insertionList[0];
					
					if (insertionList[1][0] < segmentEnds[i][0]) {
						
						insertionList[0] = insertionList[1];
						insertionList[1] = segmentEnds[i];
					}
					else {
						
						insertionList[0] = segmentEnds[i];
					}
					
					segmentEnds[i] = insertend;
				}
			}
			
			segmentEnds[count] = insertionList[0];
			segmentEnds[count+1] = insertionList[1];
			
			count += 2;
			
		}
		

		@Override
		public Iterator<Float[]> iterator() {
			
			return new Iterator() {
				
				int pointer = -1;
				float transparecy = 1.0f;
				@Override
				public Float[] next() {
					
					Float[] ret = new Float[3];
					
					if (pointer == -1) {
						ret[0] = Float.NEGATIVE_INFINITY;
					}
					else {
						ret[0] = segmentEnds[pointer][0];
						transparecy *= segmentEnds[pointer][1];
					}
					
					ret[2] = transparecy;
					pointer++;
					if (pointer  == segmentEnds.length) {
						ret[1] = Float.POSITIVE_INFINITY;
					}
					else {
						ret[1] = segmentEnds[pointer][0];
					}
					
					
					
					return ret;
					
					
				}
				
				@Override
				public boolean hasNext() {
					return pointer < segmentEnds.length;
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
			
			System.out.println(sc.segmentEnds.length+1);
			
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
