package datastruct.graph;
import java.util.List;

public class UndirectedGraph implements WeightedGraph{

	public DirectedWeightedGraph dwg;
	
	public UndirectedGraph(DirectedWeightedGraph dwg) {
		
		this.dwg = dwg;
	}

	@Override
	public boolean hasEdge(int node1, int node2) {
		
		return dwg.hasEdge(node1, node2);
	}

	@Override
	public void removeEdge(int node1, int node2) {
		dwg.removeEdge(node1, node2);
		dwg.removeEdge(node2, node1);
	}

	@Override
	public int nodeCount() {
		
		
		return dwg.nodeCount();
	}

	@Override
	public int edgeCount() {
		
		return dwg.edgeCount() / 2;
	}

	@Override
	public int nodeDegree(int node) {
		
		return dwg.nodeInDegree(node);
	}

	@Override
	public void addEdge(int node1, int node2, int weight) {
		
		dwg.addEdge(node1, node2, weight);
		dwg.addEdge(node2, node1, weight);
	}

	@Override
	public int edgeWeight(int node1, int node2) {
		
		return dwg.edgeWeight(node1, node2);
	}

	@Override
	public List<int[]> weightAdjList(int node) {
		
		return dwg.weightAdjList(node);
	}
	

	
}
