package la3996;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	private static final int[] digitsPerPower = new int[] {0,1,20,300,4000};
	private static final int[] substractFZ = new int[] {1,11,111,1111};
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = null;
		
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int cases = Integer.parseInt(str);
		
		for (int i = 0 ; i < cases ; i++) {
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			int topNum = Integer.parseInt(str);
			
			int[] numDigits = numDigits(topNum);
			
			for (int j = 0 ; j < 9 ; j++) {
				try {
					bw.write(numDigits[j] + " ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				bw.write(numDigits[9] + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private static int[] numDigits(int topNum) {
		
		int nDigits = (int) Math.log10(topNum);
		int[] nd = new int[10];
		int divisor = (int) Math.pow(10, nDigits);
		
		for (int i = nDigits ; i >= 0 ; i--) {
			
			int digit = ((topNum ) % (divisor*10))/ (divisor);
			
			
			sumAll(nd,digitsPerPower[i]*digit);
			
			for (int j = 0 ;  j < digit ; j++) {
				nd[j] += divisor;
			}
			nd[digit] += (topNum % divisor) + 1;
			divisor /= 10;
		}
		
		nd[0] -= substractFZ[nDigits];
		return nd;
	}

	private static void sumAll(int[] nd, int i) {
		
		for (int j = 0 ; j < nd.length ; j++)
			nd[j] += i;
		
	}

}
