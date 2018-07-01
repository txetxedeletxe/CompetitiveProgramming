package uva11547;

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
		
		int testCases = Integer.parseInt(str);
	
		for (int i = 0 ; i < testCases ; i++) {
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int n = Integer.parseInt(str);
			
			int result = (((n*567/9+7492)*235/47-498)/10)%10;
			result = (result >= 0) ? result : -result;
			System.out.println(result);
		}

	}

}
