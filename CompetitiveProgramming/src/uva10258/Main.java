package uva10258;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

class Main {

	static final Comparator<Contestant> compContestant = new Comparator<Main.Contestant>() {
		
		@Override
		public int compare(Contestant o1, Contestant o2) {
			
			return o1.compareTo(o2);
		}
	};
	
	static class Contestant implements Comparable<Contestant>{

		int contestantIndex;
		int acceptedSubmissions;
		int[] problemFailures;
		int timePenalty;
		
		public Contestant(int contestantIndex) {
			this.contestantIndex = contestantIndex;
			this.acceptedSubmissions = 0;
			this.timePenalty = 0;
			this.problemFailures = new int[9];
		}

		public void addSubmition(int problemN, int subTime, char result) {
			
			if (problemFailures[problemN-1] == -1)
				return;
			
			if (result == 'I') {
				problemFailures[problemN-1]++;
			}
			else if (result == 'C') {
				acceptedSubmissions++;
				timePenalty += subTime + problemFailures[problemN-1]*20;
				problemFailures[problemN-1] = -1;
			}
		}

		@Override
		public int compareTo(Contestant o1) {
			
			
			if (this.acceptedSubmissions == o1.acceptedSubmissions) {
				
				if (this.timePenalty == o1.timePenalty) {
					
					return this.contestantIndex - o1.contestantIndex;
					
				}
				else{
					return this.timePenalty - o1.timePenalty;
				}
				
			}else {
				return o1.acceptedSubmissions - this.acceptedSubmissions;
			}
		}
		
		@Override
		public String toString() {
			
			return contestantIndex + " " + acceptedSubmissions + " " + timePenalty;
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			
			String str = br.readLine();
			
			int caseCount = Integer.parseInt(str);
			br.readLine();
			
			for (int caseIndex = 0 ; caseIndex < caseCount ; caseIndex++) {
			
				if (caseIndex != 0)
					bw.write('\n');
				
				int[] indexMap = new int[100];
				ArrayList<Contestant> contestantList = new ArrayList<>();
				
				
				while (true) {
					str = br.readLine();
					
					if (str == null || str.equals(""))
						break;
					
					String[] splited = str.split(" ");
					
					int contestantIndex = Integer.parseInt(splited[0]);
					
					if (indexMap[contestantIndex-1] == 0) {
						
						
						contestantList.add(new Contestant(contestantIndex));
						indexMap[contestantIndex-1] = contestantList.size();
						
					}
					
					int problemN = Integer.parseInt(splited[1]);
					int subTime = Integer.parseInt(splited[2]);
					char result = splited[3].charAt(0);
					contestantList.get(indexMap[contestantIndex-1]-1).addSubmition(problemN,subTime,result);
				}
				
				contestantList.sort(compContestant);
				
				for (Contestant contestant : contestantList) {
					bw.write(contestant.toString() + "\n");
					
				}	
				
			}
			bw.flush();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
