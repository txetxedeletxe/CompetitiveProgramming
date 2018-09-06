package uva514;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str;
			while (true) {
				
				str = br.readLine();
				
				int coachCount = Integer.parseInt(str);
				
				if (coachCount ==  0)
					break;
				
				while (true) {

					str = br.readLine();
					
					if (str.charAt(0) == '0')
						break;
										
					String[] splited = str.split(" ");
					
					int next = 1;
					Stack<Integer> station = new Stack<>();
					
					boolean possible = true;
					
					for (String s : splited) {
						
						int coachI = Integer.parseInt(s);
						
						if (coachI >= next) {
							for (int i = next ; i < coachI ; i++) {
								station.push(i);
							}
							next = coachI+1;
						}
						else {
							
							if (coachI != station.pop()) {
								possible = false;
								break;
							}
						}
						
					}
					
					if (possible)
						bw.write("Yes\n");
					else
						bw.write("No\n");
					
				}
				bw.write('\n');
			}
			bw.flush();
			
		}catch(IOException e) {}
	}

}
