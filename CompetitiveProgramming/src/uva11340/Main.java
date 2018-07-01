package uva11340;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

		int tcases = Integer.parseInt(str);
		
		for (int i = 0 ;  i < tcases ; i++) {
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int paidChar = Integer.parseInt(str);
			Map<Character,Integer> payment = new HashMap<Character,Integer>();	
			
			for (int j = 0 ; j < paidChar ; j++) {
				
				try {
					str = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String[] splited = str.split(" ");
				char charIndex = splited[0].charAt(0);
				int pay = Integer.parseInt(splited[1]);
				
				payment.put(charIndex, pay);
			}
			
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int numArticle = Integer.parseInt(str);
			
			int sum = 0;
			Set<Character> payed = payment.keySet();
			for (int j = 0 ; j < numArticle ; j++) {
				
				try {
					str = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for (int k = 0 ; k < str.length() ; k++) {
					
					sum += (payed.contains(str.charAt(k))) ? payment.get(str.charAt(k)) : 0;
				}
			}
			
			String outend = String.format("%d.%02d$", sum/100 , sum %100);
			System.out.println(outend);
		}
	}

}
