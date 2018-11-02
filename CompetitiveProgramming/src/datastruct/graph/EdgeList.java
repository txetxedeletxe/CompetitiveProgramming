package datastruct.graph;
import java.util.ArrayList;
import java.util.List;

public class EdgeList implements DirectedWeightedGraph{

	List<int[]> edges;
	int maxNode;
	
	public EdgeList() {
		edges = new ArrayList<>();
		maxNode = 0;
	}

	@Override
	public boolean hasEdge(int node1, int node2) {
		
		
		for (int[] edge : edges) {
			
			if (edge[0] == node1 && edge[1] == node2)
				return true;
		}
		
		return false;
	}

	@Override
	public void removeEdge(int node1, int node2) {
		
		for (int i = 0 ; i < edges.size() ; i++) {
			int[] edge = edges.get(i);
			
			if (edge[0] == node1 && edge[1] == node2) {
				edges.remove(i);
				break;
			}
		}
		
	}

	@Override
	public int nodeCount() {
		
		return maxNode;
	}

	@Override
	public int edgeCount() {
		return edges.size();
	}

	@Override
	public void addEdge(int node1, int node2, int weight) {
		
		edges.add(new int[] {node1,node2,weight});
		
	}

	@Override
	public int edgeWeight(int node1, int node2) {
		
		
		for (int[] edge : edges) {
			
			if (edge[0] == node1 && edge[1] == node2)
				return edge[2];
		}
		
		return Integer.MAX_VALUE;
		
	}

	@Override
	public List<int[]> weightAdjList(int node) {
		
		List<int[]> wadj = new ArrayList<>();
		
		for (int[] edge : edges) {
			
			if (edge[0] == node)
				wadj.add(edge);
		}
		
		return wadj;
		
	}

	@Override
	public int nodeInDegree(int node) {
		
		int psum = 0;
		
		for (int[] edge : edges) {
			
			psum += (edge[1] == node) ? 1 : 0;
		}
		
		return psum;
	}

	@Override
	public int nodeOutDegree(int node) {

		int psum = 0;
		
		for (int[] edge : edges) {
			
			psum += (edge[0] == node) ? 1 : 0;
		}
		
		return psum;
	}
}
