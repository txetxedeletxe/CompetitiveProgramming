package uva11044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int cases = Integer.parseInt(str);
		
		int width;
		int height;
		
		for (int i = 0 ; i < cases ; i++) {
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[] splited = str.split(" ");
			height = Integer.parseInt(splited[0]);
			width = Integer.parseInt(splited[1]);
			
			System.out.println((width/3)*(height/3));
			
		}

	}

}
