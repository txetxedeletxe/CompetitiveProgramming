package uva394;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

	static class ArraySpec{
		
		String identifier;
		int baseAddress;
		int sizeOfElement;
		int dimensionCount;
		int[][] indexBounds;
		int[] c_D;
		
		public ArraySpec(String stringSpec) {
			
			StringTokenizer st = new StringTokenizer(stringSpec);
			identifier = st.nextToken();
			baseAddress = Integer.parseInt(st.nextToken());
			sizeOfElement = Integer.parseInt(st.nextToken());
			dimensionCount = Integer.parseInt(st.nextToken());
			indexBounds = new int[dimensionCount][2];
			for (int i = 0 ; i < dimensionCount ; i++) {
				
				
				indexBounds[i][0] = Integer.parseInt(st.nextToken());
				indexBounds[i][1] = Integer.parseInt(st.nextToken());
				
				
			}
			
			
			
		}

		public int calculatePhysicalAddress(ArrayList<Integer> indexes) {
			
			if (c_D == null)
				calculateConstants();
			
			int phAddress = c_D[0];
			
			for (int i = 1 ; i < dimensionCount+1 ; i++) {
				phAddress += c_D[i]*indexes.get(i-1);
			}
			
			return phAddress;
			
			
			
		}
		
		private void calculateConstants() {
			
			c_D = new int[dimensionCount+1];
			
			c_D[dimensionCount] = sizeOfElement;
			
			for (int i = dimensionCount-1 ; i > 0 ; i--) {
				c_D[i] = c_D[i+1]*(indexBounds[i][1] - indexBounds[i][0] + 1);
			}
			
			c_D[0] = baseAddress;
			
			for (int i = 1 ; i < dimensionCount+1 ; i++) {
				c_D[0] -= c_D[i]*indexBounds[i-1][0];
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		
		try {
			readLine = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringTokenizer st = new StringTokenizer(readLine);
		
		int nArrayDeclaration = Integer.parseInt(st.nextToken());
		int nArrayReference = Integer.parseInt(st.nextToken());
		
		Map<String,ArraySpec> arraySpecMap = new HashMap<String,ArraySpec>();
		for (int i = 0 ; i < nArrayDeclaration ; i++) {
			try {
				readLine = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArraySpec as = new ArraySpec(readLine);
			arraySpecMap.put(as.identifier, as);
			
		}
		
		
		for (int i = 0; i < nArrayReference ; i++) {
			try {
				readLine = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st = new StringTokenizer(readLine);
			
			String arrayIdentifier = st.nextToken();
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			
			while (st.hasMoreTokens()) {
				indexes.add(Integer.parseInt(st.nextToken()));
			}
			
			ArraySpec as = arraySpecMap.get(arrayIdentifier);
			int phAddress= as.calculatePhysicalAddress(indexes);
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(arrayIdentifier);
			sb.append('[');
			sb.append(indexes.get(0));
			
			for(int j = 1; j < indexes.size() ; j++) {
				
				sb.append(", ");
				sb.append(indexes.get(j));
				
			}
			
			sb.append("] = ");
			sb.append(phAddress);
			
			System.out.println(sb.toString());
		}

	}

}
