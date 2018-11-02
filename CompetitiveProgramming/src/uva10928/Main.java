package uva10928;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str = br.readLine();
			
			int tcaseCount = Integer.parseInt(str);
			
			List<Integer> minNeigh = new ArrayList<>(1000);
			
			for (int i = 0 ; i < tcaseCount ; i++) {
				
				if (i != 0) {
					br.readLine();
				}
				str = br.readLine();
				
				int nodes = Integer.parseInt(str);
				int min = Integer.MAX_VALUE;
				
				
				for (int j = 0 ; j < nodes ; j++) {
					
					str = br.readLine();
					String[] splited = str.split(" ");
					
					int ncount = splited.length;
					
					if (ncount < min) {
						minNeigh.clear();
						min = ncount;
					}
					
					if (ncount == min) {
						minNeigh.add(j+1);
					}
				}
				
				bw.write(String.valueOf(minNeigh.get(0)));
				
				for (int j = 1 ; j < minNeigh.size() ; j++) {
					bw.write(' ');
					bw.write(String.valueOf(minNeigh.get(j)));
				}
				bw.write('\n');
				
			}
			
			bw.flush();
			
			
		}catch(IOException e) {}
	}

}
