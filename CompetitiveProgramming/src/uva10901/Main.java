package uva10901;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str = br.readLine();
			
			int caseCount = Integer.parseInt(str);
			
			for (int caseIndex = 0 ; caseIndex < caseCount ; caseIndex++) {
				
				if (caseIndex != 0)
					bw.write('\n');
				
				str = br.readLine();
				
				String[] splited = str.split(" ");
				
				int n = Integer.parseInt(splited[0]);
				int t = Integer.parseInt(splited[1]);
				int m = Integer.parseInt(splited[2]);
				
				Queue<int[]> leftQueue = new LinkedList<>();
				Queue<int[]> rightQueue = new LinkedList<>();
				int[] arrivalTime = new int[m];
				
				for (int i = 0 ;  i < m ; i++) {
					
					str = br.readLine();
					splited = str.split(" ");
					
					if (splited[1].equals("left")) {
						leftQueue.add(new int[]{Integer.parseInt(splited[0]),i});
					}
					else {
						rightQueue.add(new int[]{Integer.parseInt(splited[0]),i});
					}
					
				}
				
				boolean isLeft = true;
				int currentTime = 0;
				
				while (!(leftQueue.isEmpty() && rightQueue.isEmpty())) {
					
					int time = 0;
					boolean left = true;
					
					
					if (leftQueue.isEmpty()) {
						
						left = false;
						time = rightQueue.peek()[0];
					}
					else if (rightQueue.isEmpty()) {
						left = true;
						time = leftQueue.peek()[0];
					}
					else {
						
						if (isLeft) {
							
							if (leftQueue.peek()[0] <= currentTime) {
								left = true;
								time = currentTime;
							}else {
								
								if (leftQueue.peek()[0] <= rightQueue.peek()[0]) {
									left = true;
									time = leftQueue.peek()[0];
								}
								else {
									left = false;
									time = rightQueue.peek()[0];
								}
							}
						}
						else {
							
							if (rightQueue.peek()[0] <= currentTime) {
								left = false;
								time = currentTime;
							}else {
								
								if (leftQueue.peek()[0] >= rightQueue.peek()[0]) {
									left = false;
									time = rightQueue.peek()[0];
								}
								else {
									left = true;
									time = leftQueue.peek()[0];
								}
							}
							
						}
					}
					
					
					if (time > currentTime) {
						currentTime = time;
					}
					
					if (isLeft != left) {
						currentTime += t;
						isLeft = left;
					}
					
					ArrayList<Integer> mountedCars = new ArrayList<Integer>();
					if (left) {
						while (mountedCars.size() < n && !leftQueue.isEmpty() && leftQueue.peek()[0] <= currentTime) {
							mountedCars.add(leftQueue.poll()[1]);
							
							
						}
					}else {
						while (mountedCars.size() < n && !rightQueue.isEmpty() && rightQueue.peek()[0] <= currentTime) {
							
							mountedCars.add(rightQueue.poll()[1]);
						}
					}
					
					currentTime += t;
					isLeft = ! isLeft;
					
					for (Integer i : mountedCars) {
						arrivalTime[i] = currentTime;
					}
				}
				
				for (int i : arrivalTime) {
					bw.write(i + "\n");
				}
				
			}
			bw.flush();
			
		}catch(IOException e) {}
	}

}
