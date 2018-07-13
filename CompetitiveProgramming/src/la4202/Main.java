package la4202;

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
		String[] splited;
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int cases = Integer.parseInt(str);
		int[] timeBarriers = new int[4];
		for (int i = 1 ; i <= cases ; i++) {
			
			try {
				bw.write("Case " + i + ": ");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			splited = str.split(" ");
			
			timeBarriers[0] = toMin(splited[0]);
			timeBarriers[1] = toMin(splited[1]);
			
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			splited = str.split(" ");
			
			timeBarriers[2] = toMin(splited[0]);
			timeBarriers[3] = toMin(splited[1]);
			
			
			try {
				if (canMeet(timeBarriers)) {
					bw.write("Hits Meeting\n");
				}
				else {
					bw.write("Mrs Meeting\n");
				}
			}catch(Exception e) {
				
			}
		
		}
		try {
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static boolean canMeet(int[] timeBarriers) {
		
		if (timeBarriers[3] < timeBarriers[0])
			return true;
		else if (timeBarriers[2] > timeBarriers[1])
			return true;
		else
			return false;
	}

	private static int toMin(String string) {
		
		String[] s = string.split(":");
		int hour = Integer.parseInt(s[0]);
		int min = Integer.parseInt(s[1]);
		
		return hour*60 + min;
	}

}
