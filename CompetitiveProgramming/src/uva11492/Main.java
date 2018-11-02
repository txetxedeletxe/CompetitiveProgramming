package uva11492;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

	static class PQ {

		Comparator<Integer> comp;

		int[] vertexes;
		int[] vertexPosition;

		int nextItem;

		public PQ(int size, Comparator<Integer> comp) {

			this.comp = comp;

			vertexes = new int[size];
			vertexPosition = new int[size];
			nextItem = 0;
		}

		public void add(int v) {
			vertexes[nextItem] = v;
			vertexPosition[v] = nextItem;
			flotate(nextItem);
			nextItem++;
		}

		public boolean isEmpty() {
			return nextItem == 0;
		}

		private void flotate(int item) {

			if (item != 0) {

				int onTop = 0;

				if (item % 2 == 0)
					onTop = (item - 2) / 2;
				else
					onTop = (item - 1) / 2;

				if (comp.compare(vertexes[onTop], vertexes[item]) > 0) {

					int temp = vertexes[onTop];
					vertexes[onTop] = vertexes[item];
					vertexes[item] = temp;

					vertexPosition[vertexes[onTop]] = onTop;
					vertexPosition[vertexes[item]] = item;
					flotate(onTop);
				}

			}

		}

		public int poll() {

			int temp = vertexes[0];
			nextItem--;
			vertexes[0] = vertexes[nextItem];
			vertexPosition[vertexes[0]] = 0;
			sink(0);

			return temp;
		}

		private void sink(int item) {

			if (item * 2 + 1 < nextItem) {

				int bot = item * 2 + 1;

				if (item * 2 + 2 < nextItem && comp.compare(vertexes[bot], vertexes[item * 2 + 2]) > 0)
					bot += 1;

				if (comp.compare(vertexes[bot], vertexes[item]) < 0) {

					int temp = vertexes[bot];
					vertexes[bot] = vertexes[item];
					vertexes[item] = temp;

					vertexPosition[vertexes[bot]] = bot;
					vertexPosition[vertexes[item]] = item;

					sink(bot);
				}

			}

		}

		public void update(int visited) {

			flotate(vertexPosition[visited]);
		}
	}
	
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			
			String[] splitend;
			
			while (true) {
				String str = br.readLine();
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
				listOfCharSet.add(new boolean[27]);
				listOfCharSet.add(new boolean[27]);
				
				int nextNode = 2;
				int totalNodes = 0;
				
				for (int wordIndex = 0 ; wordIndex < wordCount ; wordIndex++) {
					
					str = br.readLine();
					splitend = str.split(" ");
					
					if (!languageToNode.containsKey(splitend[0])) {
						languageToNode.put(splitend[0], nextNode++);
						adjList.add(new ArrayList<Object[]>());
						listOfChar.add(new ArrayList<Character>());
						listOfCharSet.add(new boolean[27]);
					}
					if (!languageToNode.containsKey(splitend[1])) {
						languageToNode.put(splitend[1], nextNode++);
						adjList.add(new ArrayList<Object[]>());
						listOfChar.add(new ArrayList<Character>());
						listOfCharSet.add(new boolean[27]);
					}
					
					String word = splitend[2];
					
					int node0 = languageToNode.get(splitend[0]);
					int node1 = languageToNode.get(splitend[1]);
					
					char startChar = word.charAt(0);
					int wordLength = word.length();
					
					
					adjList.get(node0).add(new Object[] {node1, wordLength,startChar});
					adjList.get(node1).add(new Object[] {node0, wordLength, startChar});
					
					if (!listOfCharSet.get(node0)[(int)(startChar - 'a')]) {
						listOfCharSet.get(node0)[(int)(startChar - 'a')] = true;
						listOfChar.get(node0).add(startChar);
						totalNodes++;
					}
					
					if (!listOfCharSet.get(node1)[(int)(startChar - 'a')]) {
						listOfCharSet.get(node1)[(int)(startChar - 'a')] = true;
						listOfChar.get(node1).add(startChar);
						totalNodes++;
					}
				}
				
				totalNodes -= listOfChar.get(0).size();
				totalNodes++;
				
				//printG(adjList);
				
				List<List<int[]>> graph2 = new ArrayList<>(totalNodes);
				
				int[] limits = new int[adjList.size() + 1];
				
				List<Character> clist = new ArrayList<>(totalNodes);
				clist.add('-');
				limits[0] = 0;
				limits[1] = 1;
				
				graph2.add(new ArrayList<>());
				
				for (int i = 1 ; i < adjList.size() ; i++) {
					
					List<Character> chars = listOfChar.get(i);
					
					for (int j = 0 ; j < chars.size() ; j++) {
						
						graph2.add(new ArrayList<int[]>());
						clist.add(chars.get(j));
					}
					
					limits[i + 1] = graph2.size();
				}
				
				for (int i = 0 ; i < adjList.size() ; i++) {
					
					List<Object[]> neigh = adjList.get(i);
					
					for (int j = 0 ; j < neigh.size() ; j++) {
						
						Object[] nei = neigh.get(j);
						
						int tNode = (int)nei[0];
						int w = (int)nei[1];
						char c = (char)nei[2];
						
						int rtNode = 0;
						for (int k = limits[tNode]; k < limits[tNode+1];k++) {
							
							if (clist.get(k) == c)
							{
								rtNode = k;
								break;
							}
							
						}
						
						for (int k = limits[i] ; k < limits[i+1] ; k++) {
							
							List<int[]> g2 = graph2.get(k);
							
							if (clist.get(k) != c) {
								g2.add(new int[] {rtNode,w});
							}
						}
					}
				}
				
				
				List<int[]> np1 = new ArrayList<>(limits[1]);
				for (int i = limits[0] ; i < limits[1] ; i++) {
					np1.add(new int[] {i,0});
				}
				graph2.add(np1);
				graph2.add(new ArrayList<>());
				
				
				for (int i = limits[1] ; i < limits[2] ; i++) {
					List<int[]> tgn = graph2.get(i);
					tgn.add(new int[] {totalNodes+1,0});
				}
				
				
				
				int mindist = dijkstra(graph2,totalNodes,totalNodes+1);
			
				if (mindist == 1000000000) {
					bw.write("impossivel\n");
				}
				else {
					bw.write(String.valueOf(mindist));
					bw.write('\n');
				}

			}
			
			bw.flush();
			
			
		}catch(IOException e) {}
	}

	private static void printG(List<List<Object[]>> adjList) {
		
		for (int i = 0 ; i < adjList.size() ; i++) {
			List<Object[]> adjs = adjList.get(i);
			System.out.println(i);
			
			for (Object[] obja : adjs) {
				
				System.out.println(obja[0] + "," +obja[1] + "," + obja[2]);
			}
		}
		
	}

	private static int dijkstra(List<List<int[]>> graph2, int start, int end) {

		int[] pdist = new int[graph2.size()];
		
		for (int i = 0 ; i < pdist.length ; i++) {
			pdist[i] = 1000000000;
		}
		
		pdist[start] = 0;
		
		PQ pq = new PQ(graph2.size(),new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return pdist[arg0] - pdist[arg1];
			}

			
		});
		
		for (int i = 0 ; i < graph2.size() ; i++) {
			pq.add(i);
		}
		
		
		while (!pq.isEmpty()) {
			
			int nextNode = pq.poll();
			//System.out.println(nextNode +":" + pdist[nextNode]);
			if (nextNode == end) {
				break;
			}
			
			List<int[]> edges = graph2.get(nextNode);
			
			for (int[] edge : edges) {
				
				//System.out.println(edge[0] + ".." + edge[1]);
				
				 if (pdist[nextNode] + edge[1] < pdist[edge[0]]) {
					 pdist[edge[0]] = pdist[nextNode] + edge[1];
					 pq.update(edge[0]);
				 }
			}
			
		}
		/*
		System.out.println("-----------------");
		for (int d : pdist)
			System.out.println(d);
		
		System.out.println("-----------------");
		*/
		return pdist[end];
		
	}

}
