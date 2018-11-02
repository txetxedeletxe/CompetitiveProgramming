package la3135;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			
			String str;
			int[] flist = new int[3000];
			int[] tlist = new int[3000];
			
			Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer arg0, Integer arg1) {
					// TODO Auto-generated method stub
					return tlist[arg0] - tlist[arg1];
				}
			});
			
			while (true) {
				
				str = br.readLine();
				//System.out.println(str);
				
				if (str.charAt(0) == '#')
					break;
				
				Scanner sc = new Scanner(str.substring(9));
				
				int id = sc.nextInt() - 1;
				int freq = sc.nextInt();
				
				
				flist[id] = freq;
				tlist[id] = freq;
				
				pq.add(id);
				
			}
			
			str = br.readLine();
			
			int ncases = Integer.parseInt(str);
			
			List<int[]> sol = new ArrayList<>();
			
			for (int i = 0 ; i < ncases ; i++) {
				
				int id = pq.poll();
				sol.add(new int[] {id,tlist[id]});
				
				tlist[id] += flist[id];
				
				pq.add(id);
			}
			
			while (true) {
				
				int id = pq.poll();
				
				if (tlist[id] != sol.get(sol.size()-1)[1])
					break;
				
				sol.add(new int[] {id,tlist[id]});
				
				
				
				
				
			}
			
			Collections.sort(sol, new Comparator<int[]>() {

				@Override
				public int compare(int[] arg0, int[] arg1) {
					
					return (arg0[1] == arg1[1]) ? arg0[0] - arg1[0] : arg0[1] - arg1[1];
				}
			});
			
			for (int i = 0 ; i < ncases ; i++) {
				bw.write(String.valueOf(sol.get(i)[0]+ 1));
				bw.write('\n');
			}
			
			bw.flush();
		}catch(IOException e) {}
	}

}
