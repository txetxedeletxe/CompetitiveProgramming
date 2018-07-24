package uva594;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	public static void main(String[] args) {
		
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String str = null;
			
			while ((str = br.readLine()) != null) {
				
				int number = Integer.parseInt(str);
				bw.write(number + " converts to ");
					
				int otherint = ((number & 255)<<24) | (((number >> 8) & 255)<<16) | (((number >> 16) & 255) << 8) | ((number >> 24) & 255);
				bw.write(otherint + "\n");
				
			}
			
			bw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
