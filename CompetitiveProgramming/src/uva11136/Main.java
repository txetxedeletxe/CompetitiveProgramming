package uva11136;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str = null;
			
			while (true) {
				
				str = br.readLine();
				int numDays = Integer.parseInt(str);
				
				if (numDays == 0)
					break;
				
				Queue<Integer> minMaxPQ = new PriorityQueue<>();
				Queue<Integer> maxMinPQ = new PriorityQueue<>(new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o2-o1;
					}
					
				});
				
				Map<Integer,Integer> multisetMap = new HashMap<>();
				
				
				long promotionCost = 0;
				
				for (int dayIndex = 0 ; dayIndex < numDays ; dayIndex++) {
					
					str = br.readLine();
					String[] splitend = str.split(" ");
					
					int billCount = Integer.parseInt(splitend[0]);
					
					for (int billIndex = 1 ; billIndex <= billCount ; billIndex++) {
				
						int billSize = Integer.parseInt(splitend[billIndex]);
						minMaxPQ.add(billSize);
						maxMinPQ.add(billSize);
					
						if (!multisetMap.containsKey(billSize))
							multisetMap.put(billSize, 0);
						
						multisetMap.put(billSize, multisetMap.get(billSize)+1);
						
						
					}
					
					int min = minMaxPQ.poll();
					
					while (multisetMap.get(min) == 0) {
						min = minMaxPQ.poll();
					}
					
					multisetMap.put(min, multisetMap.get(min)-1);
					
					int max = maxMinPQ.poll();
					
					while (multisetMap.get(max) == 0) {
						max =  maxMinPQ.poll();
					}
					
					multisetMap.put(max, multisetMap.get(max)-1);
					
					promotionCost += max-min;
				}
				bw.write(promotionCost+"\n");
			}
			bw.flush();
			
		}catch(IOException e) {}
	}

}
