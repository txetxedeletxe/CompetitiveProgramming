package uva336;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			Scanner sc = new Scanner(System.in);
			String str = null;
			
			int caseIndex = 1;
			
			while (true) {
				
				
				int nc = sc.nextInt();
				
				if (nc == 0)
					break;
				
				Map<Integer,ArrayList<Integer>> neighbourhoodMap = new HashMap<>();
				int nodeCount = 0;
				List<Integer> allValues = new ArrayList<>();
				
				for (int ci = 0 ; ci < nc ; ci++) {
					
					int node1 = sc.nextInt();
					int node2 = sc.nextInt();
					
					if (!neighbourhoodMap.containsKey(node1)) {
						neighbourhoodMap.put(node1, new ArrayList<>());
						nodeCount++;
						allValues.add(node1);
					}
					if (!neighbourhoodMap.containsKey(node2)) {
						neighbourhoodMap.put(node2, new ArrayList<>());
						nodeCount++;
						allValues.add(node2);
					}
					
					neighbourhoodMap.get(node1).add(node2);
					neighbourhoodMap.get(node2).add(node1);
				}
				
				while (true) {
					
					int startingNode = sc.nextInt();
					int ttl = sc.nextInt();
					
					if (startingNode == 0 && ttl == 0)
						break;
					
					
					Map<Integer,Integer> distanceMap = new HashMap<>();
					
					for (Integer i : allValues){
						distanceMap.put(i, -1);
					}
					distanceMap.put(startingNode, 0);
					int reachedNodes = 0;
					Queue<Integer> bfsQueue = new LinkedList<>();
					
					bfsQueue.add(startingNode);
					
					while (!bfsQueue.isEmpty()) {
						
						int nextNode = bfsQueue.poll();
						reachedNodes++;
						
						int atDistance = distanceMap.get(nextNode);
						
						if (ttl != atDistance) {
							
							List<Integer> neighbours = neighbourhoodMap.get(nextNode);
							
							for (Integer i : neighbours) {
								
								if (distanceMap.get(i) == -1) {
									distanceMap.put(i, atDistance+1);
									bfsQueue.add(i);
								}
							}
						} 
						
					}
					
					bw.write("Case " + (caseIndex++) + ": " + (nodeCount - reachedNodes) + " nodes not reachable from node " + startingNode + " with TTL = " + ttl + ".\n");
				}
			}
			
			bw.flush();
			
			
			
		}catch(IOException e) {}
	}

}
