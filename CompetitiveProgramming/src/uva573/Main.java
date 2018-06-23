package uva573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) {
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		while (true) {
			
			try {
				readLine = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			StringTokenizer st = new StringTokenizer(readLine);
			
			int wellHeight = Integer.parseInt(st.nextToken());
			
			if (wellHeight == 0)
				return;
			
			int initialClimbRate = Integer.parseInt(st.nextToken());
			int nightUnclimb = Integer.parseInt(st.nextToken());
			int fatigueFactor = Integer.parseInt(st.nextToken());
			
			float fatigueHit = initialClimbRate*fatigueFactor/100.0f;
			
			int day = 0;
			float snailHeight = 0;
			while (true) {
				
				float climb = initialClimbRate - fatigueHit*day;
				if (climb > 0)
					snailHeight += climb;
				
				if (snailHeight > wellHeight) {
					System.out.println("success on day " + (day + 1));
					break;
				} 
				
				snailHeight -= nightUnclimb;
				
				if (snailHeight< 0) {
					System.out.println("failure on day " + (day + 1));
					break;
				}
				
				day++;
			}
			
			
		}

	}

}
