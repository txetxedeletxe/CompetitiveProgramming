package uva394;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

	static class ArraySpec{
		
		public String identifier;

		public ArraySpec(String stringSpec) {
			
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
			
			
			
		}

	}

}
