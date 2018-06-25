package uva10141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static BufferedReader br;
	
	public static void main(String[] args) {
		
		
		br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		int rfp = 0;
		while (true) {
			
			
			
			try {
				readLine = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			StringTokenizer st = new StringTokenizer(readLine);
			
			int reqNum = Integer.parseInt(st.nextToken());
			int propCount = Integer.parseInt(st.nextToken());
			
			if (reqNum == 0 && propCount == 0)
				return;
			
			if (rfp != 0)
				System.out.println();
			
			rfp++;
			
			skipLines(reqNum);
			
			String best = null;
			float bestPrice = Float.POSITIVE_INFINITY;
			int bestCompliance = -1;
			
			for (int i = 0 ; i < propCount ;  i++) {
				
				try {
					readLine = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String name = readLine;
				
				try {
					readLine = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				st = new StringTokenizer(readLine);
				
				float price = Float.parseFloat(st.nextToken());
				int compliance = Integer.parseInt(st.nextToken());
				
				if (compliance > bestCompliance) {
					best = name;
					bestPrice = price;
					bestCompliance = compliance;
				}
				else if (compliance == bestCompliance && bestPrice > price) {
					best = name;
					bestPrice = price;
				}
				
				skipLines(compliance);
			}
			
			System.out.println("RFP #"+rfp);
			System.out.println(best);
		}
		

	}

	private static void skipLines(int num) {
		
		for(int i = 0 ; i < num ; i++) {
			try {
				br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
