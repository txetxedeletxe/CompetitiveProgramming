package uva10812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int testCases = Integer.parseInt(s);
		
		String[] splitedS;
		
		int sum;
		int difference;
		
		int sumNdifference;
		
		int a;
		int b;
		
		for (int i = 0 ; i < testCases ; i++) {
			
			try {
				s = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			splitedS = s.split(" ");
			sum = Integer.parseInt(splitedS[0]);
			difference = Integer.parseInt(splitedS[1]);
			
			sumNdifference = ( sum + difference );
			if (sumNdifference % 2 != 0 || difference > sum) {
				System.out.println("impossible");
				continue;
			}
			
			a = sumNdifference/ 2;
			b = sum - a;
			
			System.out.println(a + " " + b);
			
		}

	}

}
