package uva11034;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
				
				
				str = br.readLine();
				
				String[] splited = str.split(" ");
				
				int l = Integer.parseInt(splited[0])*100;
				int m = Integer.parseInt(splited[1]);
				
				
				Queue<Integer> leftQueue = new LinkedList<>();
				Queue<Integer> rightQueue = new LinkedList<>();
				
				for (int i = 0 ;  i < m ; i++) {
					
					str = br.readLine();
					splited = str.split(" ");
					
					if (splited[1].equals("left")) {
						leftQueue.add(Integer.parseInt(splited[0]));
					}
					else {
						rightQueue.add(Integer.parseInt(splited[0]));
					}
					
				}
				
				boolean isLeft = true;
				int crossedTimes = 0;
				
				while ((!leftQueue.isEmpty()) && (!rightQueue.isEmpty())) {
				
					int usedLength = 0;
					
					if (isLeft) {
						while ((!leftQueue.isEmpty()) && usedLength + leftQueue.peek() <= l) {
							usedLength += leftQueue.poll();
						}
					}
					else {
						while ((!rightQueue.isEmpty()) && usedLength + rightQueue.peek() <= l) {
							usedLength += rightQueue.poll();
						}
					}
					
					crossedTimes++;
					isLeft = ! isLeft;
				}
				
				if (leftQueue.isEmpty()) {
					
					if (isLeft) {
						
						crossedTimes++;
					}
					
					while (!rightQueue.isEmpty()) {
						int usedLength = 0;
						while (!rightQueue.isEmpty() && usedLength + rightQueue.peek() <= l) {
							usedLength += rightQueue.poll();
						}
						
						crossedTimes += 2;
					}
				}
				else {
					if (!isLeft) {
						crossedTimes++;
					}
					
					while (!leftQueue.isEmpty()) {
						int usedLength = 0;
						while (!leftQueue.isEmpty() && usedLength + leftQueue.peek() <= l) {
							usedLength += leftQueue.poll();
						}
						
						crossedTimes += 2;
					}
				}
				
				crossedTimes--;
				crossedTimes = (crossedTimes > 0)? crossedTimes: 0;
				
				bw.write(crossedTimes + "\n");
			}
			bw.flush();
			
		}catch(IOException e) {}
	}

}
