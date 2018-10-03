package uva11492;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str = br.readLine();
			String[] splitend;
			while (true) {
				
				int wordCount = Integer.parseInt(str);
				
				if (wordCount == 0)
					break;
				
				
				
				Map<String,Integer> languageToNode = new HashMap<>();
				List<List<Object[]>> adjList = new ArrayList<>();
				
				str = br.readLine();
				splitend = str.split(" ");
				
				languageToNode.put(splitend[0], 0);
				languageToNode.put(splitend[1], 1);
				adjList.add(new ArrayList<Object[]>());
				adjList.add(new ArrayList<Object[]>());
				int nextNode = 0;
				
				
				for (int wordIndex = 0 ; wordIndex < wordCount ; wordIndex++) {
					
					str = br.readLine();
					splitend = str.split(" ");
					
					if (!languageToNode.containsKey(splitend[0])) {
						languageToNode.put(splitend[0], nextNode++);
						adjList.add(new ArrayList<Object[]>());
					}
					if (!languageToNode.containsKey(splitend[1])) {
						languageToNode.put(splitend[1], nextNode++);
						adjList.add(new ArrayList<Object[]>());
					}
					
					int node0 = languageToNode.get(splitend[0]);
					int node1 = languageToNode.get(splitend[1]);
					
					String word = splitend[2];
					
					adjList.get(node0).add(new Object[] {node1, word.length(), word.charAt(0)});
					adjList.get(node1).add(new Object[] {node0, word.length(), word.charAt(0)});
				}
				
				List<Object[]> adjList2 = new ArrayList<>();
				int[] breakPointArray = new int[adjList.size()]; 
				for (int i = 0 ; i < adjList.size() ; i++) {
					
					boolean[] charset = new boolean[30];
					
					for (Object[] oarray : adjList.get(i)) {
						
						if (!charset[(char)oarray[2] - 'a']) {
							
							charset[(char)oarray[2] - 'a'] = true;
							adjList2.add(new Object[] {oarray[2],new ArrayList<int[]>()});
							
							
						}
					}
					
					breakPointArray[i] = adjList2.size();
				}
				
				for (int i = 0 ; i < adjList.size() ; i++) {
					
				}
			}
			
			bw.flush();
			
			
		}catch(IOException e) {}
	}

}
