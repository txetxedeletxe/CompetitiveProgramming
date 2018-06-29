package uva11150;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;

		try {
			while ((str = br.readLine()) != null) {
				
				int drunk = Integer.parseInt(str);
				
				
				
				
				
				System.out.println(drunk*3/2);
			
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
