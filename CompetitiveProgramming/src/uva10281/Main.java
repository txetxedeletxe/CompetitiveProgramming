package uva10281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static BufferedReader br;
	static String readline;
	static String printend;
	static float traveledDistance;
	static int lastTime;
	static int newTime;
	static float speed;
	static StringTokenizer st;
	static StringTokenizer st2;
	
	public static void main(String[] args) {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		traveledDistance = 0;
		speed = 0;
		lastTime = 0;
		try {
			while ((readline = br.readLine()) != null) {
				
				st = new StringTokenizer(readline);
				st2 = new StringTokenizer(st.nextToken(), ":");
				
				newTime = Integer.parseInt(st2.nextToken()) * 3600;
				newTime += Integer.parseInt(st2.nextToken()) * 60;
				newTime += Integer.parseInt(st2.nextToken());
				
				traveledDistance += (newTime - lastTime)*speed;
				lastTime = newTime;
				
				if (st.hasMoreTokens()) {
					
					speed = Integer.parseInt(st.nextToken()) / 3600.0f;
					
				}
				else {
					
					printend = String.format("%02d:%02d:%02d %.2f km", lastTime / 3600 , (lastTime % 3600) / 60 , lastTime % 60 , traveledDistance);
					System.out.println(printend);
				}
				
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
