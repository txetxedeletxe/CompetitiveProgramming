package uva482;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Main {

	public static void main(String[] args) {
		
		try {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String str = br.readLine();
			String[] splited;
			int cases = Integer.parseInt(str);
			
			
			for (int caseN = 0 ; caseN < cases ; caseN++) {
				
					if (caseN != 0)
						bw.newLine();
				
					br.readLine();
					str = br.readLine();
					
					splited = str.split(" ");
					
					ArrayList<Integer> permutationArray = new ArrayList<>();
					
					for (String s : splited) {
						
						int element = Integer.parseInt(s);
						permutationArray.add(element);
						
						
					}
					
					
					str = br.readLine();
					splited = str.split(" ");
					
					String[] permutedArray = new String[permutationArray.size()];
					
					for (int i = 0 ;  i < permutationArray.size() ; i++) {
						
						permutedArray[permutationArray.get(i) - 1] = splited[i];
					}
					
					for (String f:permutedArray) {
						bw.write(f + "\n");
					}
			}
			bw.flush();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
