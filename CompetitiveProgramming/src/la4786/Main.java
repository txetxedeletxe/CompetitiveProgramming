package la4786;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main {

	static int[] maskToCode;
	static int[] reverseMaskToCode;
	static int[] barWidth;

	static final int[][] intervals = new int[][] {{1,1,2,2},{2,2,4,4},{3,3,6,6},{4,4,8,8},
		{5,5,10,10},{6,6,12,12},{7,7,14,14},{8,8,16,16},{9,9,18,18},
		{10,10,19,21},{11,11,21,23},{12,12,23,25},{13,13,25,27},{14,14,27,29},
		{15,15,29,31},{16,16,31,33},{17,17,33,35},{18,18,35,37},{19,19,37,39},
		{19,21,38,42},{20,22,40,44},{21,23,42,46},{22,24,44,48},{23,25,46,50},
		{24,26,48,52},{25,27,50,54},{26,28,52,56},{27,29,54,58},{28,30,56,60},
		{29,31,57,63},{30,32,59,65},{31,33,61,67},{32,34,63,69},{33,35,65,71},
		{34,36,67,73},{35,37,69,75},{36,38,71,77},{37,39,73,79},{38,40,75,81},
		{38,42,76,84},{39,43,78,86},{40,44,80,88},{41,45,82,90},{42,46,84,92},
		{43,47,86,94},{44,48,88,96},{45,49,90,98},{46,50,92,100},{47,51,94,102},
		{48,52,95,105},{49,53,97,107},{50,54,99,109},{51,55,101,111},{52,56,103,113},
		{53,57,105,115},{54,58,107,117},{55,59,109,119},{56,60,111,121},{57,61,113,123},
		{57,63,114,126},{58,64,116,128},{59,65,118,130},{60,66,120,132},{61,67,122,134},
		{62,68,124,136},{63,69,126,138},{64,70,128,140},{65,71,130,142},{66,72,132,144},
		{67,73,133,147},{68,74,135,149},{69,75,137,151},{70,76,139,153},{71,77,141,155},
		{72,78,143,157},{73,79,145,159},{74,80,147,161},{75,81,149,163},{76,82,151,165},
		{76,84,152,168},{77,85,154,170},{78,86,156,172},{79,87,158,174},{80,88,160,176},
		{81,89,162,178},{82,90,164,180},{83,91,166,182},{84,92,168,184},{85,93,170,186},
		{86,94,171,189},{87,95,173,191},{88,96,175,193},{89,97,177,195},{90,98,179,197},
		{91,99,181,199},{92,100,183,201},{93,101,185,203},{94,102,187,205},{95,103,189,207},
		{95,105,190,210}};
		
	static Set<Integer> validIntervals;
	
	public static void main(String[] args) {
		
		build();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = null;
		int caseN = 1;
		
		int[] regionsDetectors = new int[149];
		int[] code = new int[25];
		int[] wideBars = new int[25];
		
		int regionN;
		int codeCount;
		
		String[] splited;
		while (true) {
			
			
			try {
				str = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			regionN = Integer.parseInt(str);
			
			if (regionN == 0)
				break;
			
			try {
				bw.write("Case " + caseN + ": ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			caseN++;
		
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (regionN <23 || (regionN-23) % 6 != 0) {
				try {
					bw.write("bad code\n");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			
			codeCount = regionN/6 +1;
			
			splited = str.split(" ");
			for (int i = 0 ; i < regionN ; i++) {
				
				regionsDetectors[i] = Integer.parseInt(splited[i]);
				
			}
			
			try {
				toWideBars(regionsDetectors,regionN,wideBars);
				
				if (wideBars[0] == 6 && wideBars[codeCount-1] == 6) {
					deco(wideBars,code,codeCount);
				}
				else if (wideBars[0] == 12 && wideBars[codeCount-1] == 12) {
					reversedeco(wideBars,code,codeCount);
				}
				else
					throw new RuntimeException();
			
			}catch (RuntimeException e) {
				try {
					bw.write("bad code\n");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				continue;
			}
			
			
			if (!checkC(code,codeCount)) 
			{
				try {
					bw.write("bad C\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			
			if (!checkK(code,codeCount)) 
			{
				try {
					bw.write("bad K\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			
			try {
				bw.write(decode(code,codeCount)+ "\n");
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

	private static void reversedeco(int[] wideBars, int[] code, int codeCount) {
		
		for (int i = 0 ; i < codeCount ; i++) {
			int c =  reverseMaskToCode[wideBars[i]];
			if (c == -1) {
				//System.out.println(wideBars[i]);
				throw new RuntimeException();
			}
			code[codeCount-i-1] = c;
		}
		
	}

	private static void deco(int[] wideBars, int[] code, int codeCount) {
		
		for (int i = 0 ; i < codeCount ; i++) {
			int c =  maskToCode[wideBars[i]];
			if (c == -1)
				throw new RuntimeException();
			code[i] = c;
		}
		
	}

	private static void build() {
		
		maskToCode = new int[32];
		Arrays.fill(maskToCode,-1);
		maskToCode[1] = 0;
		maskToCode[17] = 1;
		maskToCode[9] = 2;
		maskToCode[24] = 3;
		maskToCode[5] = 4;
		maskToCode[20] = 5;
		maskToCode[12] = 6;
		maskToCode[3] = 7;
		maskToCode[18] = 8;
		maskToCode[16] = 9;
		maskToCode[4] = 10;
		maskToCode[6] = 11;
		
		reverseMaskToCode = new int[32];
		Arrays.fill(reverseMaskToCode, -1);
		reverseMaskToCode[16] = 0;
		reverseMaskToCode[17] = 1;
		reverseMaskToCode[18] = 2;
		reverseMaskToCode[3] = 3;
		reverseMaskToCode[20] = 4;
		reverseMaskToCode[5] = 5;
		reverseMaskToCode[6] = 6;
		reverseMaskToCode[24] = 7;
		reverseMaskToCode[9] = 8;
		reverseMaskToCode[1] = 9;
		reverseMaskToCode[4] = 10;
		reverseMaskToCode[12] = 11;
		
		barWidth = new int[2];
	}

	private static String decode(int[] toCode, int codeCount) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1 ; i < codeCount-3 ; i++) {
			if (toCode[i] < 10)
				sb.append(toCode[i]);
			else
				sb.append("-");
		}
				
		return sb.toString();
	}

	private static boolean checkK(int[] toCode, int codeCount) {
		
		int calculatedK = 0;
		int codeK = toCode[codeCount-2];
		
		for (int i = 1 ; i < codeCount-2 ; i++) {
			calculatedK += (((codeCount-i-3) % 9)+1)*toCode[i];
		}
		
		calculatedK %= 11;
		
		return calculatedK == codeK;
		
	}

	private static boolean checkC(int[] toCode, int codeCount) {
		int calculatedC = 0;
		int codeC = toCode[codeCount-3];
		
		for (int i = 1 ; i < codeCount-3 ; i++) {
			calculatedC += (((codeCount-i-4) % 10)+1)*toCode[i];
		}
		
		calculatedC %= 11;
		
		return calculatedC == codeC;
	}


	private static void toWideBars(int[] regionsDetectors, int regionN, int[] wideBars){
		
			calculateBarWidths(regionsDetectors,regionN);
			
			int nextBarId = 0;
			for (int i = 0 ; i < regionN; i++) {
				
				if (i % 6 == 5) {
					if (isWide(regionsDetectors[i]))
						throw new RuntimeException();
					
					wideBars[i/6] = nextBarId;
					//System.out.println(nextBarId);
					nextBarId = 0;
				}
				else {
					nextBarId *=2;
					
					if (isWide(regionsDetectors[i])) {
						nextBarId += 1;
					}
				}
			}
			
			wideBars[regionN/6] = nextBarId;

	}

	private static boolean isWide(int i) {
		
		return barWidth[0] <= i && barWidth[1] >= i;
	}

	private static void calculateBarWidths(int[] regionsDetectors, int regionN) {

		validIntervals = new HashSet<Integer>();
		for (int i = 0 ; i < 100 ; i++) {
			validIntervals.add(i);
		}
		
		for (int i  = 0 ; i <  regionN ; i++) {
			
			ArrayList<Integer> toRemove = new ArrayList<>();
			//System.out.println(i +" " + validIntervals);
			for (Integer j : validIntervals) {
				
				if (!onInterval(regionsDetectors[i],j)) {
					toRemove.add(j);
				}
				
			}
			validIntervals.removeAll(toRemove);
			
			if (validIntervals.isEmpty())
				throw new RuntimeException();
		}
		
		for (Integer i : validIntervals) {
			barWidth[0] = intervals[i][2];
			barWidth[1] = intervals[i][3];
			break;
		}
	}

	private static boolean onInterval(int i, Integer j) {
		
		return (i >= intervals[j][0] &&  i <= intervals[j][1]) || (i >= intervals[j][2] &&  i <= intervals[j][3]);
	}


}
