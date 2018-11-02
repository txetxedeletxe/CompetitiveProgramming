package uva291;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Main {

	public static void main(String[] args) {
		
		
		List<List<Integer>> lli = new ArrayList<>(5);
		
		for (int i = 0 ; i < 5 ; i++) {
			lli.add(new ArrayList<>());
		}
		
		lli.get(0).add(1);
		lli.get(0).add(2);
		lli.get(0).add(4);
		
		lli.get(1).add(0);
		lli.get(1).add(2);
		lli.get(1).add(4);
		
		lli.get(2).add(0);
		lli.get(2).add(1);
		lli.get(2).add(3);
		lli.get(2).add(4);
		
		lli.get(3).add(2);
		lli.get(3).add(4);
		
		lli.get(4).add(0);
		lli.get(4).add(1);
		lli.get(4).add(2);
		lli.get(4).add(3);
		
		List<Integer> solutions = new ArrayList<>();
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			
			Stack<List<Integer>> st = new Stack<>();
			st.add(Arrays.asList(new Integer[] {0}));
			
			while (!st.isEmpty()) {
				
				List<Integer> sol = st.pop();
				
				if (sol.size() == 9) {
					int i = toInt(sol);
					solutions.add(i);
				}
				else {
					
					int last = sol.get(sol.size() - 1);
					
					List<Integer> ad = lli.get(last);
					
					for (Integer i : ad) {
						
						if (!tuple(sol,i,last)) {
							
							ArrayList<Integer> sol2 = new ArrayList<>(List.copyOf(sol));
							sol2.add(i);
							st.add(sol2);
						}
					}
					
				}
				
				
			}
			
			Collections.sort(solutions);
			
			for (Integer i : solutions) {
				bw.write(i + "\n");
				
			}
			
			bw.flush();
			
			
		}catch(IOException e) {}
	}

	private static boolean tuple(List<Integer> sol, int prev, int next) {
		
		for (int i = 0 ; i < sol.size()-1 ; i++) {
			
			if ((sol.get(i) == prev && sol.get(i+1) == next) || (sol.get(i) == next && sol.get(i+1) == prev))
				return true;
		}
		
		return false;
	}

	private static int toInt(List<Integer> sol) {
		
		int p = 0;
		
		for (Integer i : sol) {
			p *= 10;
			p += (i+1);
		}
		
		return p;
	}

}
