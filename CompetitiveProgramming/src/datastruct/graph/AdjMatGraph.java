package datastruct.graph;
import java.util.ArrayList;
import java.util.List;

public class AdjMatGraph implements DirectedWeightedGraph{

	int[][] adjMat;
	int edgeCount;
	
	public AdjMatGraph(int numNodes) {
		adjMat = new int[numNodes][numNodes];
		
		for (int i = 0 ; i < adjMat.length ; i++) {
			for (int j = 0 ; j < adjMat.length ; j++) {
				adjMat[i][j] = 0;
			}
		}
		
		edgeCount = 0;
	}
	
	public boolean hasEdge(int node1, int node2) {
		return adjMat[node1][node2] != 0;
	}
	
	public int edgeWeight(int node1, int node2) {
		return hasEdge(node1, node2) ? adjMat[node1][node2] : Integer.MAX_VALUE;
	}
	
	
	public void addEdge(int node1, int node2, int weight) {
		if (!hasEdge(node1, node2))
			edgeCount++;
		
		adjMat[node1][node2] = weight;
	}
	
	public void removeEdge(int node1, int node2) {
		if (hasEdge(node1, node2))
			edgeCount--;
		
		adjMat[node1][node2] = 0;
	}
	
	public int nodeCount() {
		return adjMat.length;
	}
	
	public int edgeCount() {
		return edgeCount;
	}
	
	public int nodeInDegree(int node) {
		
		int deg = 0;
		
		for (int i = 0 ; i < adjMat.length ; i++) {
			
			deg += (adjMat[i][node] != 0) ? 1 : 0;
		}
		
		return deg;
	}
	
	public int nodeOutDegree(int node) {
		
		int deg = 0;
		
		for (int i = 0 ; i < adjMat.length ; i++) {
			
			deg += (adjMat[node][i] != 0) ? 1 : 0;
		}
		
		return deg;
	}
	


	@Override
	public List<int[]> weightAdjList(int node) {
		
		List<int[]> wadj = new ArrayList<>();
		
		for (int i = 0 ; i < adjMat.length ; i++) {
			
			if (hasEdge(node, i)) {
				wadj.add(new int[] {i,edgeWeight(node, i)});
			}
				
		}
		
		return wadj;
	}
}
