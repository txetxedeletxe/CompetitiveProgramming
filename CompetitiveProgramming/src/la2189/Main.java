package la2189;

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
		int caseNum = 0;
		while (true) {
			
			if (caseNum != 0) {
				try {
					bw.write("\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			caseNum++;
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int nnum = Integer.parseInt(str);
			
			if (nnum == 0)
				break;
			
			
			
			try {
				bw.write("Case " + caseNum + ":\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			long intervalStart = -1;
			long lastItem = -1;
			
			for (int i = 0 ; i < nnum ; i++) {
				
				try {
					str = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				long num = Long.parseLong(str);
				if (num -1 == lastItem) {
					lastItem = num;
				}
				else {
					
					if (intervalStart != -1) {
						
						try {
							bw.write(intervalAsString(intervalStart,lastItem)+"\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					intervalStart = num;
					lastItem = num;
				}
			}
			
			try {
				bw.write(intervalAsString(intervalStart,lastItem)+"\n");
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

	private static String intervalAsString(long intervalStart, long lastItem) {
		
		
		if (intervalStart == lastItem)
			return "0" + intervalStart;
		
		int digitCountLast = (int) Math.log10(lastItem);
		int cuttingDigit = (int) Math.pow(10, digitCountLast);
		for (int i = digitCountLast ; i >= 0 ; i--) {
		
			if ((intervalStart / cuttingDigit) != (lastItem / cuttingDigit)) {
				cuttingDigit = cuttingDigit*10;
				break;
			}
			else {
				cuttingDigit /= 10;
			}
				
		}
		return ("0" + intervalStart + "-" + (lastItem % cuttingDigit));
	}

}
