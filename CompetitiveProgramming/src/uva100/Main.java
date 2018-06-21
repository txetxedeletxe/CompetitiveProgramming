package uva100;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	
	public static void main(String[] args) {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine;
		
		
		
		try {
			while ((readLine = br.readLine()) != null) {
				
				StringTokenizer st = new StringTokenizer(readLine);
				
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				int max;
				int min;
				if (a > b) {
					max = a;
					min = b;
				}
				else {
					max = b;
					min = a;
				}
				
				int maxcycles = 1;
				for (int i = min; i <= max ; i++) {
					
					int cycles = collatzCycles(i);
					if (cycles > maxcycles)
						maxcycles = cycles;
				}
				
				System.out.println(String.format("%d %d %d", a, b, maxcycles));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	static int collatzCycles(int i) {
		
		int cycles = 1;
		
		while (i != 1) {
			
			if (i % 2 == 0)
				i /= 2;
			else
				i = 3*i + 1;
		
			cycles++;
		} 
		
		return cycles;
	}
}
