package uva11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	
	
	public static void main(String[] args) {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int cases = Integer.parseInt(str);
		int[] intsalaries = new int[3];
		int medium = 0;
		for (int i = 1; i <= cases ; i++) {
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[] salaries = str.split(" ");
			intsalaries[0] = Integer.parseInt(salaries[0]);
			intsalaries[1] = Integer.parseInt(salaries[1]);
			intsalaries[2] = Integer.parseInt(salaries[2]);
			
			
			
			if (intsalaries[0] > intsalaries[1]) {
				swap(intsalaries,0,1);
			}
				
			if (intsalaries[0] > intsalaries[2]) {
				medium = intsalaries[0];
			}
			else if (intsalaries[1] > intsalaries[2]){
				medium = intsalaries[2];
			}
			else {
				medium = intsalaries[1];
			}
			
			System.out.println("Case " + i + ": " + medium);
			
		}
		
}

	private static void swap(int[] intsalaries, int i, int j) {
		
		int temp = intsalaries[i];
		intsalaries[i] = intsalaries[j];
		intsalaries[j] = temp;
		
		
	}

}
