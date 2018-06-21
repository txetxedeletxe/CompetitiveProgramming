package uva272;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	static boolean direction = false; //false=right , true=left
	
	public static void main(String[] args) {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] cbuf = new char[1024];
		int readLen;
		
		
		
		try {
			while ((readLen = br.read(cbuf)) != -1) {
				
				String s = makeBeautiful(cbuf,readLen);
				System.out.print(s);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	static String makeBeautiful(char[] cbuf, int readLen) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0 ; i < readLen; i++ ) {
			if (cbuf[i] == '\"') {
				
				if (direction) {
					sb.append("\'\'");
				}
				else {
					sb.append("``");
				}
				
				direction = !direction;
			}
			else {
				sb.append(cbuf[i]);
			}
		}
		
		return sb.toString();
		
	}

}
