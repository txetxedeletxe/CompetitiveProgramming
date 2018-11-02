package datastruct.graph;
import java.util.ArrayList;
import java.util.List;

public interface WeightedGraph extends Graph {

	
	public void addEdge(int node1, int node2, int weight);
	public int edgeWeight(int node1 , int node2);
	public List<int[]> weightAdjList(int node);
	
	@Override
	default void addEdge(int node1, int node2) {
		
		addEdge(node1, node2, 1);
		
	}
	
	@Override
	default List<Integer> adjList(int node) {
		
		List<int[]> wadj = weightAdjList(node);
		List<Integer> adjList = new ArrayList<>();
		
		for (int[] w : wadj) {
			adjList.add(w[0]);
		}
		
		return adjList;
	}
	
}
