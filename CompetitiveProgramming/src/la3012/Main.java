package la3012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int ncase = 0;
		while (true) {
			ncase++;
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String[] splited = str.split(" ");
			
			int nnum = Integer.parseInt(splited[0]);
			if (nnum == 0)
				break;
			
			try {
				bw.write("Case " + ncase +":\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int sum = 0;
			
			for (int i = 1 ; i <= nnum ; i++) {
				int aInt = Integer.parseInt(splited[i]);
				sum += aInt;
			}
			
			try {
				bw.write(fractionLikeAverage(sum,nnum) + "\n");
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

	private static String fractionLikeAverage(int sum, int nnum) {
		
		
		if (sum % nnum == 0) {
			if (sum < 0)
				return "- " + (-sum/nnum);
			else
				return String.valueOf(sum/nnum);
	
		}
		else if (Math.abs(sum) > nnum) {
			
			if (sum < 0) {
			
				int whole = (-sum) / nnum;
				int[] sumNnum = new int[] {(-sum) % nnum,nnum};
				reduce(sumNnum);
				return negativeFraction2(sumNnum,whole);
			}else {
				int whole = sum / nnum;
				int[] sumNnum = new int[] {sum % nnum,nnum};
				reduce(sumNnum);
				return Fraction2(sumNnum,whole);
			}
			
			
		}else {
			
			if (sum < 0) {
				int[] sumNnum = new int[] {-sum,nnum};
				reduce(sumNnum);
				return negativeFraction1(sumNnum);
				
				
			}else {
				int[] sumNnum = new int[] {sum,nnum};
				reduce(sumNnum);
				return Fraction1(sumNnum);
			}
		}
	}

	private static String Fraction2(int[] sumNnum, int whole) {
		int numChar = (int) Math.log10(sumNnum[1]) + 1;
		int numChar2 = (int) Math.log10(sumNnum[0]) + 1;
		int numChar3 = (int) Math.log10(whole) + 1;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < numChar-numChar2 + numChar3 ; i++) {
			sb.append(' ');
		}
		sb.append(sumNnum[0]);
		sb.append('\n');
		sb.append(whole);
		for (int i = 0 ; i < numChar ; i++) {
			sb.append('-');
		}
		sb.append('\n');
		for (int i = 0 ; i <  numChar3 ; i++) {
			sb.append(' ');
		}
		sb.append(sumNnum[1]);
		
		return sb.toString();
	}

	private static String negativeFraction2(int[] sumNnum, int whole) {
		int numChar = (int) Math.log10(sumNnum[1]) + 1;
		int numChar2 = (int) Math.log10(sumNnum[0]) + 1;
		int numChar3 = (int) Math.log10(whole) + 1;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < numChar-numChar2 + numChar3 +2; i++) {
			sb.append(' ');
		}
		sb.append(sumNnum[0]);
		sb.append('\n');
		sb.append("- ");
		sb.append(whole);
		for (int i = 0 ; i < numChar ; i++) {
			sb.append('-');
		}
		sb.append('\n');
		for (int i = 0 ; i <  numChar3 +2; i++) {
			sb.append(' ');
		}
		sb.append(sumNnum[1]);
		
		return sb.toString();
	}

	private static String Fraction1(int[] sumNnum) {
		
		int numChar = (int) Math.log10(sumNnum[1]) + 1;
		int numChar2 = (int) Math.log10(sumNnum[0]) + 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < numChar-numChar2 ; i++) {
			sb.append(' ');
		}
		sb.append(sumNnum[0]);
		sb.append('\n');
		for (int i = 0 ; i < numChar ; i++) {
			sb.append('-');
		}
		sb.append('\n');
		sb.append(sumNnum[1]);
		
		return sb.toString();
	}

	private static String negativeFraction1(int[] sumNnum) {
		int numChar = (int) Math.log10(sumNnum[1]) + 1;
		int numChar2 = (int) Math.log10(sumNnum[0]) + 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < numChar-numChar2 + 2  ; i++) {
			sb.append(' ');
		}
		sb.append(sumNnum[0]);
		sb.append('\n');
		sb.append("- ");
		for (int i = 0 ; i < numChar ; i++) {
			sb.append('-');
		}
		sb.append('\n');
		sb.append("  ");
		sb.append(sumNnum[1]);
		
		return sb.toString();
	}

	private static void reduce(int[] sumNnum) {
		
		while (true) {
			int igdc = gdc(sumNnum[0],sumNnum[1]);
			if (igdc == 1)
				break;
			
			int a = timesDivisible(sumNnum[0],igdc);
			int b = timesDivisible(sumNnum[1],igdc);
			
			if (a > b) {
				sumNnum[0] /= igdc*b;
				sumNnum[1] /= igdc*b;
			}
			else {
				sumNnum[0] /= igdc*a;
				sumNnum[1] /= igdc*a;
			}
		}
		
	}

	private static int timesDivisible(int i, int igdc) {
		
		int div = 0;
		int ii = i;
		while (ii % igdc == 0 ) {
			div++;
			ii /= igdc;
		}
		
		return div;
		
	}

	private static int gdc(int i, int j) {
		
		int a = j;
		int b = i;
		
		while (a % b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		
		return b;
	}

}
