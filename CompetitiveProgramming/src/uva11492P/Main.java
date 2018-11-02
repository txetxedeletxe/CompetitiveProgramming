package uva11492P;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
				
				List<List<Character>> listOfChar = new ArrayList<>();
				List<boolean[]> listOfCharSet = new ArrayList<>();
				
				str = br.readLine();
				splitend = str.split(" ");
				
				languageToNode.put(splitend[0], 0);
				languageToNode.put(splitend[1], 1);
				
				adjList.add(new ArrayList<Object[]>());
				adjList.add(new ArrayList<Object[]>());
				listOfChar.add(new ArrayList<Character>());
				listOfChar.add(new ArrayList<Character>());
				
				int nextNode = 0;
				
				int totalNodes = 0;
				
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
				
				List<Object[]> graph2 = new ArrayList<>(totalNodes);
				int[] limits = new int[adjList.size()];
				
				for (int i = 0 ; i < adjList.size() ; i++) {
					
					List<Character> chars = listOfChar.get(i);
					
					for (int j = 0 ; j < adjList.size() ; j++) {
						
						graph2.add(new Object[] {chars.get(j),new ArrayList<Object[]>()});
						
					}
					
					limits[i] = graph2.size();
				}
				

			}
			
			bw.flush();
			
			
		}catch(IOException e) {}
	}

}
