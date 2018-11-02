package datastruct.graph;
import java.util.ArrayList;
import java.util.List;

public class AdjListGraph implements DirectedWeightedGraph{

	
	List<List<int[]>> adjList;
	int edgeCount;
	public AdjListGraph(int nodeCount) {
		
		adjList = new ArrayList<>(nodeCount);
		
		for (int i = 0 ; i < nodeCount ; i++) {
			adjList.add(new ArrayList<>());
		}
		
		edgeCount = 0;
	}

	@Override
	public boolean hasEdge(int node1, int node2) {
		
		List<int[]> edges = adjList.get(node1);
		
		for (int[] edge : edges) {
			
			if (edge[0] == node2)
				return true;
		}
		
		return false;
	}

	@Override
	public void removeEdge(int node1, int node2) {

		List<int[]> edges = adjList.get(node1);
		
		for (int i = 0 ; i < edges.size() ; i++) {
			
			if (edges.get(i)[0] == node2) {
				edges.remove(i);
				edgeCount--;
				break;
			}
		}
		
		
	}

	@Override
	public int nodeCount() {
		
		return adjList.size();
	}

	@Override
	public int edgeCount() {
		
		return edgeCount;
	}


	@Override
	public void addEdge(int node1, int node2, int weight) {

		List<int[]> edges = adjList.get(node1);
		
		for (int i = 0 ; i < edges.size() ; i++) {
			
			if (edges.get(i)[0] == node2) {
				edges.get(i)[1] = weight;
				return;
			}
		}
		
		edges.add(new int[] {node2,weight});
		edgeCount++;
		
	}

	@Override
	public int edgeWeight(int node1, int node2) {

		List<int[]> edges = adjList.get(node1);
		
		for (int i = 0 ; i < edges.size() ; i++) {
			
			if (edges.get(i)[0] == node2) {
				
				return edges.get(i)[1];
			}
		}
		
		return Integer.MAX_VALUE;
	}

	@Override
	public int nodeInDegree(int node) {
		
		int psum = 0;
		
		for (int i = 0 ; i < node ; i++) {
			
			if (hasEdge(i, node))
				psum++;
		}
		for (int i = node+1 ; i < adjList.size() ; i++) {
			
			if (hasEdge(i, node))
				psum++;
		}
		
		return psum;
	}

	@Override
	public int nodeOutDegree(int node) {
		
		return adjList.get(node).size();
	}

	@Override
	public List<int[]> weightAdjList(int node) {
		
		return adjList.get(node);
	}
	
	
}
