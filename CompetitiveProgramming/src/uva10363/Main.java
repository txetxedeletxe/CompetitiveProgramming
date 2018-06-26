package uva10363;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	static BufferedReader br;
	static String s;
	static int numCases;
	static int caseIndex;
	static int[] xCount;
	static int[] oCount;
	static int tttRow;
	static char[] cc;
	static int charIndex;
	static int difference;
	static boolean xWins;
	static boolean oWins;
	static int aX;
	static int aO;
	
	public static void main(String[] args) {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		numCases = Integer.parseInt(s);
		
		
		for (caseIndex = 0 ; caseIndex < numCases ; caseIndex++) {
			
			if (caseIndex != 0)
				try {
					br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			xCount = new int[6];
			oCount = new int[6];
			
			xWins = false;
			oWins = false;
			
			for (tttRow = 0 ; tttRow < 3 ; tttRow++) {
				
				try {
					s = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				cc = s.toCharArray();
				aX = xCount[0];
				aO = oCount[0];
				
				for (int i = 0 ; i < 3 ; i++) {
					
					if (cc[i] == 'X') {
						xCount[0]++;
						xCount[i+1]++;
						
						if (tttRow == i) {
							xCount[4]++;
						}
						
						if (tttRow + i == 4)
						{
							xCount[5]++;
						}
					}
					else if (cc[i] == 'O') {
						oCount[0]++;
						oCount[i+1]++;
						
						if (tttRow == i) {
							oCount[4]++;
						}
						
						if (tttRow + i == 4)
						{
							oCount[5]++;
						}
					}
					
					
				}
				
				if (aX + 3 == xCount[0])
					xWins = true;
				else if (aO + 3 == oCount[0])
					oWins = true;
				
			}
			
			for (int i = 1 ; i < 6 ; i++) {
				
				if (xCount[i] == 3) {
					xWins = true;
					break;
				}
			}
			
				
			for (int i = 1 ; i < 6 ; i++) {
				if (oCount[i] == 3) {
					oWins = true;
					break;
				}
			}
			
			
			
			difference = xCount[0] - oCount[0];
			if ((difference == 0 && !xWins)|| (difference == 1 && !oWins))  {
				System.out.println("yes");
			}
			else
				System.out.println("no");
			
		}
		
		

	}

}
