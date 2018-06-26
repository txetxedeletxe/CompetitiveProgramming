package uva10683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		
		try {
			while ((s = br.readLine())!= null) {
				
				
				int timeCs =  (int) Math.floor((Integer.parseInt(s.substring(0, 2))*360000 + 
						Integer.parseInt(s.substring(2, 4))*6000 + 
						Integer.parseInt(s.substring(4, 6))*100 + 
						Integer.parseInt(s.substring(6, 8)))*1.157407408	);
				
				String ret = String.format("%d%02d%02d%02d", 
						timeCs / 1000000 , (timeCs % 1000000) / 10000 , 
						(timeCs % 10000) / 100 , timeCs % 100);
				
				System.out.println(ret);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
