package uva661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		int seqNumber = 0;
		while (true) {

			seqNumber++;
			try {
				readLine = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			StringTokenizer st = new StringTokenizer(readLine);
			
			int deviceCount = Integer.parseInt(st.nextToken());
			int operationCount = Integer.parseInt(st.nextToken());
			int fuseCapacity = Integer.parseInt(st.nextToken());
			
			if (deviceCount == 0 && operationCount == 0 && fuseCapacity == 0)
				return;
			
			int[] devicePower = new int[deviceCount];
			boolean[] deviceState = new boolean[deviceCount];
			
			for (int i = 0 ; i < deviceCount ; i++) {
				
				try {
					readLine = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int tempPower = Integer.parseInt(readLine);
				devicePower[i] = tempPower;
			}
			
			int maxConsumption = 0;
			int currentConsumption = 0;
			for (int i = 0 ; i < operationCount ; i++) {
				
				try {
					readLine = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int switchIndex = Integer.parseInt(readLine) - 1;
				
				if (deviceState[switchIndex]) {
					deviceState[switchIndex] = false;
					currentConsumption -= devicePower[switchIndex];
				}
				else {
					deviceState[switchIndex] = true;
					currentConsumption += devicePower[switchIndex];
					
					if (currentConsumption > maxConsumption) {
						maxConsumption = currentConsumption;
						
					}
				}
				
			}
			
			System.out.println("Sequence " + seqNumber);
			if (maxConsumption > fuseCapacity) {
				System.out.println("Fuse was blown.");
			}
			else {
				System.out.println("Fuse was not blown.");
				System.out.println("Maximal power consumption was " + maxConsumption + " amperes.");
			}
			System.out.println();
			
				
		}
		

	}

}
