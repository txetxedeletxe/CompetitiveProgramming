package uva11498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		int[] divisionPoint = new int[2];
		int[] queryCoord = new int[2];
		
		while (true) {
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int testCaseCount = Integer.parseInt(str);
			
			if (testCaseCount == 0)
				return;
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[] splited = str.split(" ");
			divisionPoint[0] = Integer.parseInt(splited[0]);
			divisionPoint[1] = Integer.parseInt(splited[1]);
			
			for (int i = 0 ; i < testCaseCount ; i++) {
				
				
				try {
					str = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				splited = str.split(" ");
				queryCoord[0] = Integer.parseInt(splited[0]);
				queryCoord[1] = Integer.parseInt(splited[1]);
				
				if (queryCoord[0] < divisionPoint[0]) {
					if (queryCoord[1] < divisionPoint[1]) {
						System.out.println("SO");
					} else if (queryCoord[1] > divisionPoint[1]) {
						System.out.println("NO");
					} else {
						System.out.println("divisa");
					}
				} else if (queryCoord[0] > divisionPoint[0]) {
					if (queryCoord[1] < divisionPoint[1]) {
						System.out.println("SE");
					} else if (queryCoord[1] > divisionPoint[1]) {
						System.out.println("NE");
					} else {
						System.out.println("divisa");
					}
				} else {
					System.out.println("divisa");
				}
			}
		}

	}

}
